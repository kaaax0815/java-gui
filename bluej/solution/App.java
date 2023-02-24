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
    
    void titelHinzufuegen() {
        JLabel titel = new JLabel("Zähler", JLabel.CENTER);
        frame.add(titel, BorderLayout.NORTH);
    }
    
    void zaehlerHinzufuegen() {
        JLabel zaehler = new JLabel(Integer.toString(zaehlerWert), JLabel.CENTER);
        frame.add(zaehler, BorderLayout.CENTER);
        this.zaehler = zaehler;
    }
    
    void operationenHinzufuegen() {
        JPanel feld = operationenFeldErstellen();
        JButton plusOperation = new JButton("+");
        plusOperation.addActionListener((e) -> updateCounter(plusOperation()));
        JButton minusOperation = new JButton("-");
        minusOperation.addActionListener((e) -> updateCounter(minusOperation()));
        feld.add(plusOperation);
        feld.add(minusOperation);
    }
    
    int plusOperation() {
        // TODO: Zählerwert um 1 erhöhen
        zaehlerWert++;
        return zaehlerWert;
    }
    
    int minusOperation() {
        // TODO: Zählerwert um 1 verringern
        zaehlerWert--;
        return zaehlerWert;
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
