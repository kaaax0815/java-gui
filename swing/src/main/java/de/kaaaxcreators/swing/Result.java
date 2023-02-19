package de.kaaaxcreators.swing;

import java.awt.Component;

import javax.swing.*;

public class Result extends JPanel {
    DragAndDropHandler dndHandler;
    public Result() {
        init();
    }

    void init() {
        Component jLabel;
        switch (App.select.selectItem) {
            case CAR:
                ImageIcon carIcon = ImageUtils.ImageIconByResourcePath("TESLA-MODELX.jpeg");
                carIcon.setImage(ImageUtils.resizeToHeight(carIcon.getImage(), 200));
                JLabel carLabel = new JLabel(carIcon);
                carLabel.setToolTipText("Tesla Model X");
                jLabel = carLabel;
                break;
            case MOTORCYCLE:
                ImageIcon motorIcon = ImageUtils.ImageIconByResourcePath("BMW-S1000RR.jpg");
                motorIcon.setImage(ImageUtils.resizeToHeight(motorIcon.getImage(), 200));
                JLabel motorLabel = new JLabel(motorIcon);
                motorLabel.setToolTipText("BMW S1000RR");
                jLabel = motorLabel;
                break;
            case OWN:
                if (dndHandler == null) {
                    dndHandler = new DragAndDropHandler();
                }
                jLabel = dndHandler;
                break;
            default:
                jLabel = new JLabel("Error");
                break;
        }
        add(jLabel);
    }

    void update() {
        removeAll();
        init();
        revalidate();
        repaint();
    }
}