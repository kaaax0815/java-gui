package de.kaaaxcreators.swing;

import java.awt.Color;
import java.io.File;


import javax.swing.*;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;

public class App extends JFrame {
    static Result result = new Result();
    static Select select = new Select();
    JLabel dragAndDrop;
    static File filePath;
   
    public App() {
        setTitle("Swing App");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

        HelpMenu helpMenu = new HelpMenu();
        setJMenuBar(helpMenu);

        getContentPane().add(select);
        getContentPane().add(result);

        pack();
        setVisible(true);
    }

    

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                 new App();
            }
        });
    }
}
