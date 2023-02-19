package de.kaaaxcreators.swing;

import java.awt.Image;

import javax.swing.ImageIcon;

public class ImageUtils {
    static Image resizeToHeight(Image image, Number height) {
        int oldWidth = image.getWidth(null);
        int oldHeight = image.getHeight(null);

        int newHeight = height.intValue();
        int newWidth =  (newHeight * oldWidth) / oldHeight;

        Image newImage = image.getScaledInstance(newWidth, newHeight, Image.SCALE_SMOOTH);

        return newImage;
    }

    static ImageIcon ImageIconByResourcePath(String path) {
        return new ImageIcon(ImageUtils.class.getClassLoader().getResource(path));
    }

    static ImageIcon ImageIconByAbsolutePath(String path) {
        return new ImageIcon(path);
    }
}
