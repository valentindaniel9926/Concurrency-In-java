package sample;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Task;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;

import java.util.Observable;

public class Controller {
    private Task<ObservableList<String>> task;
    @FXML
    private ListView listView;
    public void initialize() {
        task = new Task<ObservableList<String>>() {
            @Override
            protected ObservableList<String> call() throws Exception {
                Thread.sleep(1000);
                ObservableList<String> employees= FXCollections.observableArrayList(
                        "Valentin Daniel",
                        "Steve Jobs",
                        "Elon Musk",
                        "Jack Ma",
                        "Robert Kiyosaki",
                        "Daniel Johnson");
                return employees;
            }
        };
        listView.itemsProperty().bind(task.valueProperty());

    }
    @FXML
    public void buttonPressed() {
        new Thread(task).start();
    }

}
