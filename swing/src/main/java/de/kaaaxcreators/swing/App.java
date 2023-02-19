package de.kaaaxcreators.swing;

import javax.swing.*;

public class App extends JFrame {
    static Select select = new Select();
    static Result result = new Result();
   
    public App() {
        setTitle("Swing App");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

        AppMenu helpMenu = new AppMenu();
        setJMenuBar(helpMenu);

        add(select);
        add(result);

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
