package org.core.bases;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.net.URL;

public interface DefaultComponents {

    void initializeFrame();
    void initializeComponents();

    default URL getResource(String path) {
        return getClass().getClassLoader().getResource(path);
    }

    default JPanel createJPanel(int x, int y, int width, int height) {
        JPanel panel = new JPanel();
        panel.setBounds(x, y, width, height);
        panel.setLayout(null);
        return panel;
    }

    default JLabel createLabel(String text, int x, int y, int width, int height, Font font) {
        JLabel label = new JLabel(text);
        label.setBounds(x, y, width, height);
        if (font != null) {
            label.setFont(font);
        }
        return label;
    }

    default JLabel createImageLabel(URL imagePath, int x, int y, int width, int height) {
        JLabel label = new JLabel();
        label.setBounds(x, y, width, height);
        label.setIcon(new ImageIcon(imagePath));
        return label;
    }

    default JTextField createTextField(int x, int y, int width, int height) {
        JTextField textField = new JTextField();
        textField.setBounds(x, y, width, height);
        textField.setBackground(Color.LIGHT_GRAY);
        return textField;
    }

    default JPasswordField createPasswordField(int x, int y, int width, int height) {
        JPasswordField passwordField = new JPasswordField();
        passwordField.setBounds(x, y, width, height);
        passwordField.setBackground(Color.LIGHT_GRAY);
        return passwordField;
    }

    default JCheckBox createCheckBox(int x, int y, int width, int height) {
        JCheckBox checkBox = new JCheckBox();
        checkBox.setBounds(x, y, width, height);
        checkBox.setBackground(Color.WHITE);
        return checkBox;
    }

    default JButton createButton(String text, int x, int y, int width, int height) {
        JButton button = new JButton(text);
        button.setBounds(x, y, width, height);
        return button;
    }

    default void addComponents(JFrame container, JComponent... components) {
        for (JComponent component : components) {
            container.add(component);
        }
    }

    default void addComponents(JPanel container, JComponent... components) {
        for (JComponent component : components) {
            container.add(component);
        }
    }

    default void showErrorDialog(JFrame context, Exception ex) {
        String message = ex instanceof IOException ? "El servidor no responde" : ex.getMessage();
        JOptionPane.showMessageDialog(context, message, "Error", JOptionPane.ERROR_MESSAGE);
    }
}
