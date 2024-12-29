package org.core.views;

import org.core.bases.DefaultComponents;
import org.core.config.Register;
import org.core.models.StudentModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class DashboardView extends JFrame implements DefaultComponents {

    private final Font fontSubTitle;

    public DashboardView() {
        this.fontSubTitle = new Font("Consolas", Font.BOLD, 13);

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                if (Register.CACHEABLE) {
                    try {
                        ObjectOutputStream student = new ObjectOutputStream(new FileOutputStream("student.ser"));
                        ObjectOutputStream register = new ObjectOutputStream(new FileOutputStream("register.ser"));

                        student.writeObject(StudentModel.getInstance());
                        register.writeObject(new Register());

                    } catch (IOException ex) {
                        System.out.println(ex.getMessage());
                    }
                }
            }
        });

        initializeFrame();
        initializeComponents();
        setVisible(true);
    }

    @Override
    public void initializeFrame() {
        getContentPane().setBackground(Color.WHITE);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setSize(900, 600);
        setResizable(false);
        setTitle("Profile");
        setLayout(null);
    }

    @Override
    public void initializeComponents() {
        addComponents(this, containerSideBar());
    }

    public JPanel containerSideBar() {
        JPanel sideBar = createJPanel(0, 0, 200, 600);
        JButton profileButton = createButton("Perfil", 0, 50, 200, 25);
        ImageIcon imageIcon = new ImageIcon(getResource("images/user_4302027.png"));
        Image scaledImage = imageIcon.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);

        profileButton.setHorizontalTextPosition(SwingConstants.RIGHT);
        profileButton.setVerticalTextPosition(SwingConstants.CENTER);
        profileButton.setHorizontalAlignment(SwingConstants.LEFT);
        profileButton.setBackground(Color.decode("#eaf3ff"));
        profileButton.setIcon(new ImageIcon(scaledImage));
        profileButton.setBorderPainted(false);
        profileButton.setFocusPainted(false);
        profileButton.setFont(fontSubTitle);
        profileButton.setIconTextGap(10);

        profileButton.addActionListener(event -> handleProfile());

        sideBar.setBackground(Color.decode("#eaf3ff"));
        sideBar.add(profileButton);

        return sideBar;
    }

    public void handleProfile() {
        add(new ProfileView());
        repaint();
    }

    public void handleHistory() {}
}