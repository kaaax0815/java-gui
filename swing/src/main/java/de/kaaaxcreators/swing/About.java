package de.kaaaxcreators.swing;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.*;

public class About extends JFrame {
    public About() {
        setPreferredSize(new Dimension(300, 200));
        setTitle("Über uns");
        setLayout(new GridLayout(2, 1));
        
        JLabel heading = new JLabel("Swing App", JLabel.CENTER);
        heading.setFont(new Font("Arial", Font.BOLD, 20));
        add(heading);

        JLabel info = new JLabel("<html><p style=\"text-align:center\">von Bernd Storath und Joshua Pfennig<br/>den Programmiergöttern</p></html>", JLabel.CENTER);
        add(info);

        pack();
        setVisible(true);
    }
}
