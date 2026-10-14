package net.bitnp.samplegui;

/**
 * Program entry point.
 *
 * <p>This class deliberately does not extend {@code Application}. When JavaFX is
 * loaded from the classpath (this project does not use the module system), the
 * JDK refuses to launch a main class that extends
 * {@code javafx.application.Application} directly and fails with "JavaFX
 * runtime components are missing". Delegating from a plain class avoids that
 * without adding a {@code module-info.java}.
 */
public class Launcher {

  public static void main(String[] args) {
    App.main(args);
  }
}
