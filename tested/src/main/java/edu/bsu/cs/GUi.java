package edu.bsu.cs;

import javafx.application.Application;
import javafx.stage.Stage;

import javax.swing.*;


public class GUi extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        JTextArea textArea = createJTextArea();
        JButton searchButton = createJButton();
    }

    private JButton createJButton() {
        JButton searchButton = createJButton();
        searchButton.setEnabled(true);
        return searchButton;
    }

    private JTextArea createJTextArea() {
        JTextArea resultArea = new JTextArea();
        resultArea.setEditable(false);
        resultArea.setSize(400, 300);
        return resultArea;
    }
}
