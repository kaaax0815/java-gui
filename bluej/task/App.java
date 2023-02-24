import javax.swing.*;
import java.awt.*;

public class App
{
    // Fenster erstellen
    JFrame frame = new JFrame();
    // Zähler Variable einrichten
    JLabel zaehler;
    // Zählerwert einrichten
    int zaehlerWert = 0;
    public App()
    {
        // Fenster einrichten
        frame.setPreferredSize(new Dimension(200,200));
        frame.setTitle("Swing Beispiel");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLayout(new BorderLayout());
        
        // Elemente hinzufügen
        titelHinzufuegen();
        zaehlerHinzufuegen();
        operationenHinzufuegen();
        
        // Fenster anzeigen
        frame.pack();
        frame.setVisible(true);
    }
    
    /**
     * Fügt den Titel ins Fenster ein
     */
    void titelHinzufuegen() {
        JLabel titel = new JLabel("Zähler", JLabel.CENTER);
        frame.add(titel, BorderLayout.NORTH);
    }
    
    /**
     * Fügt Zähler ins Fenster ein
     */
    void zaehlerHinzufuegen() {
        zaehler = new JLabel(Integer.toString(zaehlerWert), JLabel.CENTER);
        frame.add(zaehler, BorderLayout.CENTER);
    }
    
    /**
     * Fügt Operationen +/- ins Fenster ein
     */
    void operationenHinzufuegen() {
        JPanel feld = operationenFeldErstellen();
        // Plus Operation
        JButton plusOperation = new JButton("+");
        plusOperation.addActionListener((e) -> updateCounter(plusOperation()));
        feld.add(plusOperation);
        // TODO: Minus Button erstellen und hinzufügen
    }
    
    /**
     * Erhöht den Zähler
     */
    int plusOperation() {
        zaehlerWert++;
        return zaehlerWert;
    }
    
    /**
     * Verringert den Zähler
     */
    int minusOperation() {
        // TODO: Minus Operation ergänzen (s. plusOperation)
    }
    
    // Ignorieren
    JPanel operationenFeldErstellen() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(1,3));
        frame.add(panel, BorderLayout.SOUTH);
        return panel;
    }
    
    void updateCounter(int count) {
        zaehler.setText(Integer.toString(count));
    }
}
