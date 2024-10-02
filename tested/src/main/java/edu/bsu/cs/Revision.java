package edu.bsu.cs;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Revision {
    private final StringProperty user;
    private final StringProperty timestamp;

    public Revision(String user, String timestamp) {
        this.user = new SimpleStringProperty(user);
        this.timestamp = new SimpleStringProperty(timestamp);
    }

    public StringProperty userProperty() {
        return user;
    }

    public StringProperty timestampProperty() {
        return timestamp;
    }

}
