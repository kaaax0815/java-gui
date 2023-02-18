package de.kaaaxcreators.swing;

import javax.swing.*;

public class App extends JFrame {
    public App() {
        setTitle("Swing App");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

        Select select = new Select();
        getContentPane().add(select);

        Result result = new Result();
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
