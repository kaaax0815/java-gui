package de.kaaaxcreators.swing;

import java.awt.Image;

import javax.swing.*;

public class App extends JFrame {
    public App() {
        
        JFrame frame = new JFrame("Swing App");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));
 
        JLabel label = new JLabel("Hello World");
        frame.getContentPane().add(label);

        JButton carButton = new JButton("Cars");
        JButton motorcycleButton = new JButton("Motorcycle");

        frame.getContentPane().add(carButton);

        JPanel jPanel = new JPanel();    
        ImageIcon imageIcon = new ImageIcon(getClass().getClassLoader().getResource("BMW-S1000RR.jpg"));
        Image image = imageIcon.getImage(); // transform it 
        Image newimg = image.getScaledInstance(120, 80,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
        imageIcon = new ImageIcon(newimg);
        JLabel jLabel = new JLabel(imageIcon);
        jLabel.setToolTipText("BMW-S1000RR.jpg");
        jPanel.add(jLabel);
        frame.getContentPane().add(jPanel);

        frame.pack();
        frame.setVisible(true);
    }
    public static void main( String[] args ) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new App();
            }
        });
    }
}
