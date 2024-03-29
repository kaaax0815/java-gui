package de.kaaaxcreators.awt;

import java.awt.*;
import java.awt.event.*;

/**
 * Entry point of the application.
 */
public class App extends Frame {
  public App() {
    setTitle("AWT App");
    setSize(900,450);

    AppMenu menu = new AppMenu();

    addWindowListener(new AppWindowListener());
    setMenuBar(menu.getMenubar());
    setLayout(new GridLayout(1,2));

    add(new Items());
    add(new Cart());

    setVisible(true);
  }

  class AppWindowListener extends WindowAdapter {
    public void windowClosing(WindowEvent e) {
      e.getWindow().dispose();
      System.exit(0);
    }    	
  }

  public static void main(String args[]) {
    new App();
  }
}
