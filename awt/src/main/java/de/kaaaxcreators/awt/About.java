package de.kaaaxcreators.awt;

import java.awt.*;
import java.awt.event.*;

public class About extends Frame {
    public About() {
        setTitle("Über uns");
        addWindowListener(new AboutWindowListener());
        setSize(254,195);
        setLayout(new GridLayout(3,1));

        Label title = new Label("AWT App", Label.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 20));

        Label version = new Label("Version 1.0", Label.CENTER);
        version.setFont(new Font("Arial", Font.ITALIC, 12));

        Label author = new Label("von Bernd Storath und Joshua Pfennig", Label.CENTER);
        author.setFont(new Font("Arial", Font.PLAIN, 12));

        add(title);
        add(version);
        add(author);

        setVisible(true);
    }

    class AboutWindowListener extends WindowAdapter {
        public void windowClosing(WindowEvent e) {
          e.getWindow().dispose();
        }
    }

    static void open() {
        new About();
    }
}
