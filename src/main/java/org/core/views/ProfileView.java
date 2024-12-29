package org.core.views;

import org.core.bases.DefaultComponents;
import org.core.models.StudentModel;

import javax.swing.*;
import java.awt.*;

public class ProfileView extends JPanel implements DefaultComponents {

    private final Font fontSubTitle;
    private final Font fontSubSubTitle;
    private final Font fontSubSubSubTitle;
    private final Font fontTitle;


    public ProfileView() {
        this.fontSubTitle = new Font("Consolas", Font.BOLD, 17);
        this.fontSubSubTitle = new Font("Consolas", Font.BOLD, 15);
        this.fontSubSubSubTitle = new Font("Consolas", Font.ITALIC, 13);
        this.fontTitle = new Font("Consolas", Font.BOLD, 21);

        initializeFrame();
        initializeComponents();
        setVisible(true);
    }

    @Override
    public void initializeFrame() {
        setBounds(200, 0, 700, 600);
        setBackground(Color.WHITE);
        setLayout(null);
    }

    @Override
    public void initializeComponents() {
        JLabel title = createLabel("Perfil", 14, 30, 150, 30, fontSubTitle);

        addComponents(this, title, containerLabels());
    }

    public JPanel containerLabels() {
        JPanel container = createJPanel(15, 65, 655, 450);
        container.setBorder(BorderFactory.createLineBorder(Color.gray));
        container.setBackground(Color.WHITE);
        StudentModel student = StudentModel.getInstance();

        JLabel schoolName = createLabel("COLEGIO DE BACHILLERES DE CHIAPAS No. 217", 100, 15, 470, 30, fontTitle);
        JLabel federalEntity = createLabel("SOCONUSCO, CHIAPAS", 250, 33, 200, 30, fontSubTitle);
        JLabel userIcon = createImageLabel(getResource("images/user_1144760.png"), 100, 150, 150, 150);

        JLabel fullNamesLabel = createLabel("Nombre:", 400, 150, 100, 20, fontSubSubTitle);
        String fullName = student.getNames() + " " + student.getLastNames();
        JLabel fullNameValue = createLabel(fullName, 340, 165, 260, 20, fontSubSubSubTitle);

        JLabel enrollmentLabel = createLabel("Matrícula:", 390, 200, 100, 20, fontSubSubTitle);
        JLabel enrollmentValue = createLabel(student.getEnrollment(), 373, 215, 200, 20, fontSubSubSubTitle);

        JLabel statusLabel = createLabel("Estatus Académico:", 360, 250, 150, 20, fontSubSubTitle);
        String status = student.getStatus() + " (Regular)";
        JLabel statusValue = createLabel(status, 390, 265, 200, 20, fontSubSubSubTitle);

        JLabel dniLabel = createLabel("CURP:", 410, 300, 150, 20, fontSubSubTitle);
        JLabel dniValue = createLabel(student.getDni(), 367, 315, 200, 20, fontSubSubSubTitle);

        JLabel semesterLabel = createLabel("Semestre:", 140, 310, 100, 20, fontSubSubTitle);
        student.setGrade("5");
        JLabel semesterValue = createLabel(student.getGrade(), 213, 311, 20, 20, fontSubSubSubTitle);

        JLabel groupLabel = createLabel("Grupo:", 155, 330, 80, 20, fontSubSubTitle);
        JLabel groupValue = createLabel(student.getGroup(), 205, 331, 20, 20, fontSubSubSubTitle);

        addComponents(container, schoolName, federalEntity, userIcon, fullNamesLabel, fullNameValue,
                enrollmentLabel, enrollmentValue, statusLabel, statusValue, dniLabel, dniValue, semesterLabel,
                semesterValue, groupLabel, groupValue);
        return container;
    }
}
