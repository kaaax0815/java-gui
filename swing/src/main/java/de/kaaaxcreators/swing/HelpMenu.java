package de.kaaaxcreators.swing;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.*;

public class HelpMenu extends JMenuBar {

    public HelpMenu() {
        JMenu menu = new JMenu("Hilfe");
        this.add(menu);
        
        JMenuItem menuItem = new JMenuItem("Über");
        menuItem.setMnemonic(KeyEvent.VK_H);
        menuItem.addActionListener((e) -> {new AboutMenu();});
        menu.add(menuItem);

        // when action is triggered -> open AboutMenu-Window
        Action buttonAction = new AbstractAction("Über") {
            @Override
            public void actionPerformed(ActionEvent evt) {
                new AboutMenu();
            }
        };         
        menuItem.setAction(buttonAction);
         
        // action is triggered when pressing h key and window is focused (application-wide hotkey)
        menuItem.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(
                KeyStroke.getKeyStroke(KeyEvent.VK_H, 0), "Über");
        menuItem.getActionMap().put("Über", buttonAction);
        
    }

    class AboutMenu extends JFrame {
        public AboutMenu() {
            setPreferredSize(new Dimension(300, 200));
            setTitle("Über");
            setLayout(new GridLayout(2, 1));
            
            JLabel heading = new JLabel("Swing-App", JLabel.CENTER);
            getContentPane().add(heading);

            JLabel info = new JLabel("<html>von Bernd Storath und Joshua Pfennig <br/> die Programmiergötter</html>", JLabel.CENTER);
            getContentPane().add(info);

            pack();
            setVisible(true);
        }
    }
}
