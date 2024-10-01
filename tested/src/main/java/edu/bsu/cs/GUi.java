package edu.bsu.cs;


import javafx.application.Application;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import org.w3c.dom.Node;

import java.awt.*;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class GUi extends Application {

    private final ExecutorService executor = Executors.newSingleThreadExecutor();
    private TextField queryField;

    @Override
    public void start(Stage stage) throws Exception {
        TextArea textArea = createTextArea();
        Button searchButton = createSearchButton();
        Node queryArea = createQueryArea();
    }

    private Node createQueryArea() {
        Label queryFieldLabel = new Label("Page title: ");
        queryField = new TextField();
        queryField.setColumns(20);
        queryFieldLabel.setName(String.valueOf(queryField));
        return new HBox(queryFieldLabel, queryField);
    }

    private Button createSearchButton() {
        Button searchButton = createSearchButton("Search");
        searchButton.setDisabled(true);
        queryField.setOnKeyTyped(e -> {
            boolean isQueryFieldEmpty = queryField.getText().trim().isEmpty();
            searchButton.setDisable(isQueryFieldEmpty);
        });
        return searchButton;
    }

    private TextArea createTextArea() {
        TextArea resultArea = new TextArea();
        resultArea.setEditable(false);
        resultArea.setSize(400, 300);
        return resultArea;
    }
}
