package edu.bsu.cs;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.List;

public class WikipediaRevisionApp extends Application {

    private final WikipediaRevisionReader revisionReader = new WikipediaRevisionReader();

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        // Create the behaviors
        TextField articleTitleField = new TextField();
        articleTitleField.setPromptText("Enter Wikipedia article title");

        Button fetchRevisionsButton = new Button("Fetch Revisions");

        TableView<Revision> revisionsTable = new TableView<>();

        TableColumn<Revision, String> userColumn = new TableColumn<>("User");
        userColumn.setCellValueFactory(cellData -> cellData.getValue().userProperty());

        TableColumn<Revision, String> timestampColumn = new TableColumn<>("Timestamp");
        timestampColumn.setCellValueFactory(cellData -> cellData.getValue().timestampProperty());

        revisionsTable.getColumns().addAll(userColumn, timestampColumn);

        // Shows the Users and Timestamp of edits
        fetchRevisionsButton.setOnAction(event -> {
            String articleTitle = articleTitleField.getText();
            if (!articleTitle.isEmpty()) {
                try {
                    List<Revision> revisions = revisionReader.getRecentRevisionsOf(articleTitle);
                    revisionsTable.getItems().setAll(revisions);
                } catch (IOException e) {
                    showError("Error fetching revisions: " + e.getMessage());
                }
            } else {
                showError("Please enter a valid article title.");
            }
        });

        // Shows the layout
        VBox layout = new VBox(10, articleTitleField, fetchRevisionsButton, revisionsTable);
        Scene scene = new Scene(layout, 600, 400);

        primaryStage.setScene(scene);
        primaryStage.setTitle("Wikipedia Revisions Viewer");
        primaryStage.show();
    }

    private void showError(String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setContentText(message);
        alert.showAndWait();
    }


}
