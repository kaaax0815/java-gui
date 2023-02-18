package de.kaaaxcreators.swing;

import javax.swing.*;

public class Result extends JPanel {
    public Result() {
        init();
    }

    void init() {
        ImageIcon imageIcon = ImageUtils.ImageIconByPath("BMW-S1000RR.jpg");
        imageIcon.setImage(ImageUtils.resizeToHeight(imageIcon.getImage(), 200));
        JLabel jLabel = new JLabel(imageIcon);
        jLabel.setToolTipText("BMW-S1000RR.jpg");
        add(jLabel);
    }
}