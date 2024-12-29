package org.core.views;

import org.core.adapters.AuthAdapter;
import org.core.adapters.exceptions.IncorrectPassword;
import org.core.adapters.exceptions.InvalidRequest;
import org.core.adapters.exceptions.NotFound;
import org.core.bases.DefaultComponents;
import org.core.config.Register;
import org.core.models.StudentModel;
import org.core.services.AuthService;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class LoginView extends JFrame implements DefaultComponents {

    private final AuthService authService;
    private final Font fontSubTitle;
    private final Font fontTitle;

    public LoginView() {
        this.authService = new AuthService(new AuthAdapter());
        this.fontSubTitle = new Font("Consolas", Font.BOLD, 12);
        this.fontTitle = new Font("Consolas", Font.BOLD, 20);

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowOpened(WindowEvent e) {
                try {
                    ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("student.ser"));
                    StudentModel.setInstance((StudentModel) objectInputStream.readObject());

                    if (StudentModel.getInstance().isAccessed()) { wakeUp(); }

                } catch (IOException | ClassNotFoundException ex) {
                    ex.getStackTrace();
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
        setSize(315, 450);
        setResizable(false);
        setTitle("Login");
        setLayout(null);
    }

    @Override
    public void initializeComponents() {
        JLabel logoLabel = createImageLabel(getResource("images/cobach1.png"), 98, 5, 130, 130);
        JLabel loginLabel = createLabel("Iniciar Sesión", 70, 145, 180, 50, fontTitle);
        JLabel legendLabel = createLabel("Accede con tu CURP y MATRÍCULA para continuar.", 5, 175, 300, 30, fontSubTitle);
        JLabel usernameLabel = createLabel("CURP", 130, 220, 100, 25, fontSubTitle);
        JLabel passwordLabel = createLabel("MATRICULA", 114, 270, 100, 25, fontSubTitle);
        JLabel rememberMeLabel = createLabel("Recuérdame", 75, 327, 80, 20, fontSubTitle);

        JTextField usernameField = createTextField(50, 240, 200, 25);
        JPasswordField passwordField = createPasswordField(50, 290, 200, 25);
        JCheckBox rememberMe = createCheckBox(50, 325, 20, 20);
        JButton sendButton = createButton("Login", 114, 360, 70, 30);

        sendButton.addActionListener(event -> handleLogin(usernameField, passwordField, rememberMe));

        addComponents(this, usernameLabel, passwordLabel, rememberMeLabel, loginLabel, legendLabel,
                logoLabel, usernameField, passwordField, rememberMe, sendButton);
    }

    private void handleLogin(JTextField usernameField, JPasswordField passwordField, JCheckBox rememberMe) {
        try {
            boolean response = authService.login(usernameField.getText(), new String(passwordField.getPassword()));

            if (response) {
                if (rememberMe.isSelected()) { Register.CACHEABLE = true; }
            }
            wakeUp();

        } catch (InvalidRequest | IOException | InterruptedException | IncorrectPassword | NotFound ex) {
            showErrorDialog(this, ex);
        }
    }

    public void wakeUp() {
        dispose();
        new DashboardView();
    }
}
