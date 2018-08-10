package demo;

import javafx.application.Application;
import javafx.beans.property.SimpleObjectProperty;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.util.Arrays;
import java.util.List;

public class Hello extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    private SimpleObjectProperty<Button> currentButton = new SimpleObjectProperty<>();

    private List<Button> buttons = Arrays.asList(
            new Button("hello 1"),
            new Button("hello 2"),
            new Button("hello 3")
    );

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Hello");
        HBox root = new HBox() {{
            getStylesheets().add("hello.css");
            for (Button button : buttons) {
                button.setOnAction(event -> {
                    currentButton.setValue(button);
                });
                currentButton.addListener((a, b, value) -> {
                    if (value == button) {
                        button.getStyleClass().add("current");
                    } else {
                        button.getStyleClass().remove("current");
                    }
                });
            }
            getChildren().addAll(buttons);
        }};
        primaryStage.setScene(new Scene(root, 300, 250));
        primaryStage.show();
    }

}