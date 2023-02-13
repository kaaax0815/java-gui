package de.kaaaxcreators.awt;

import java.awt.*;

public class AppMenu {
  static Menu FileMenu() {
    Menu file = new Menu("Datei");
    MenuItem closeItem = new MenuItem("Beenden");
    closeItem.addActionListener((l) -> System.exit(0));
    file.add(closeItem);
    return file;
  }

  static Menu HelpMenu() {
    Menu about = new Menu("Hilfe");
    MenuItem aboutItem = new MenuItem("Über");
    aboutItem.addActionListener((l) -> About.open());
    about.add(aboutItem);
    return about;
  }

  static MenuBar getMenubar () {
    MenuBar menuBar = new MenuBar ();
    
    menuBar.add(FileMenu());
    menuBar.add(HelpMenu());

    return menuBar;
  }
}
