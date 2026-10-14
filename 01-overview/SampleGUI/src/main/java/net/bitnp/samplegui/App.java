package net.bitnp.samplegui;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

/**
 * Minimal JavaFX example: open a window that contains a single multi-line text
 * area. The text shown in the text area is hard-coded in this file.
 */
public class App extends Application {
  private static final String TEXT_STYLE = "-fx-font-size: 72px;";

  /** Called by JavaFX once the toolkit is ready; the user interface is built here. */
  @Override
  public void start(Stage stage) {
    TextArea textArea = new TextArea("Hello");
    textArea.setStyle(TEXT_STYLE);

    Scene scene = new Scene(textArea, 640, 400);

    stage.setTitle("SampleGUI");
    stage.setScene(scene);
    stage.show();
  }

  public static void main(String[] args) {
    launch(args);
  }
}
