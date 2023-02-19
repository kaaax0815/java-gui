package de.kaaaxcreators.swing;

import java.awt.event.*;

import javax.swing.*;

public class AppMenu extends JMenuBar {

    public AppMenu() {
        JMenu menu = new JMenu("Hilfe");
        menu.setMnemonic(KeyEvent.VK_H);
        
        JMenuItem aboutItem = new JMenuItem();

        // when action is triggered -> open About-Window
        Action buttonAction = new AbstractAction("Über") {
            public void actionPerformed(ActionEvent evt) {
                new About();
            }
        };
        aboutItem.setAction(buttonAction);
         
        // action is triggered when pressing ctrl+a and window is focused (application-wide hotkey)
        aboutItem.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(
                KeyStroke.getKeyStroke(KeyEvent.VK_A, InputEvent.CTRL_DOWN_MASK), "Über");
        aboutItem.getActionMap().put("Über", buttonAction);
        
        menu.add(aboutItem);
        
        add(menu);
    }
}
