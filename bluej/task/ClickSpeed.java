import javax.swing.*;
import java.awt.*;
import java.util.Timer;
import java.util.TimerTask;

public class ClickSpeed extends JFrame
{
    Number startTime;
    Number elapsedTime;
    Number timerLength = 15*1000;
    boolean running = false;
    Number clicks = 0;
    JLabel clickCount;
    JLabel clickTimer;
    Timer timer;
    
    ClickSpeed()
    {
        // Fenster einrichten
        setTitle("Click Speed");
        setPreferredSize(new Dimension(400,200));
        setLayout(new BorderLayout());
        // Anzeige einrichten
        this.clickCount = new JLabel("N/A", JLabel.CENTER);
        this.clickTimer = new JLabel("Press click!", JLabel.CENTER);
        JButton clickButton = new JButton("Click");
        clickButton.addActionListener((e) -> click());
        // Elemente hinzufügen
        add(clickCount, BorderLayout.NORTH);
        add(clickTimer, BorderLayout.CENTER);
        add(clickButton, BorderLayout.SOUTH);
        // Fenster anzeigen
        pack();
        setVisible(true);
    }
    
    private void click() {
        // When noch nicht läuft -> einrichten
        if (running == false) {
            init();
        }

        // Klicks um 1 erhöhen
        clicks = clicks.intValue() + 1;
        // Text aktualisieren
        clickCount.setText(clicks.toString());
    }
    
    private void tick() {
        // Wie viel Zeit seit erstem Klick vergangen ist
        elapsedTime = System.currentTimeMillis() - startTime.longValue();
        // Wie viel Zeit von den 15 Sekunden noch übrig ist
        Number remainingSeconds = (timerLength.floatValue()-elapsedTime.floatValue())/1000;
        clickTimer.setText(remainingSeconds.shortValue() + "s");
        // Zeit abgelaufen
        if (elapsedTime.floatValue() >= timerLength.floatValue()) {
            // Clickspeed ausrechnen
            Number clickSpeed = clicks.intValue()/15;
            // Clickspeed anzeigen
            JOptionPane.showMessageDialog(null, "Your click speed is:\n" + clickSpeed.toString()  + "cps");
            // Für neues Spiel vorbereiten
            reset();
        }
    }
    
    /**
     * Werte zurücksetzen
     */
    void reset() {
        startTime = 0;
        elapsedTime = 0;
        running = false;
        clicks = 0;
        clickCount.setText("N/A");
        clickTimer.setText("Press click!");
        timer.cancel();
    }
    
    /**
     * Timer einrichten
     */
    private void init() {
        startTime = System.currentTimeMillis();
        running = true;
        TimerTask task = new TimerTask() {
            public void run() {
                tick();
            }
        };
        timer = new Timer();
        timer.scheduleAtFixedRate(task,0,1000);
    }
}
