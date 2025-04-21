package org.example;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            TodoListFrame frame = new TodoListFrame();
            frame.setVisible(true);
        });
    }
}