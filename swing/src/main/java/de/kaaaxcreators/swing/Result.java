package de.kaaaxcreators.swing;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.*;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;

public class Result extends JPanel {
    public Result() {
        init();
    }

    void init() {
        JLabel jLabel;
        if(Select.isSelected == Selectable.motorcycle) {
            ImageIcon imageIcon = ImageUtils.ImageIconByResourcePath("BMW-S1000RR.jpg");
            imageIcon.setImage(ImageUtils.resizeToHeight(imageIcon.getImage(), 200));
            jLabel = new JLabel(imageIcon);
            jLabel.setToolTipText("BMW S1000RR");
        }
        else if (Select.isSelected == Selectable.own) {
            if(App.filePath != null) {
                ImageIcon imageIcon = ImageUtils.ImageIconByAbsolutePath(App.filePath.toString());
                imageIcon.setImage(ImageUtils.resizeToHeight(imageIcon.getImage(), 200));
                jLabel = new JLabel(imageIcon);
                jLabel.setToolTipText("Eigenes Bild");
                DragAndDropHandler.handleDragAndDrop(jLabel);
            }
            else {
                jLabel = new JLabel("Drag and Drop", JLabel.CENTER);
                jLabel.setBorder(new CompoundBorder(BorderFactory.createLineBorder(Color.BLACK, 5), new EmptyBorder(80, 80, 80, 80)));
                DragAndDropHandler.handleDragAndDrop(jLabel);
            }
        }
        else {
            ImageIcon imageIcon = ImageUtils.ImageIconByResourcePath("TESLA-MODELX.jpeg");
            imageIcon.setImage(ImageUtils.resizeToHeight(imageIcon.getImage(), 200));
            jLabel = new JLabel(imageIcon);
            jLabel.setToolTipText("Tesla Model X");
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