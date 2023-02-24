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
        setTitle("Click Speed");
        setPreferredSize(new Dimension(400,200));
        setLayout(new BorderLayout());
        this.clickCount = new JLabel("N/A", JLabel.CENTER);
        this.clickTimer = new JLabel("Press click!", JLabel.CENTER);
        JButton clickButton = new JButton("Click");
        clickButton.addActionListener((e) -> click());
        add(clickCount, BorderLayout.NORTH);
        add(clickTimer, BorderLayout.CENTER);
        add(clickButton, BorderLayout.SOUTH);
        pack();
        setVisible(true);
    }
    
    private void click() {
        if (running == false) {
            init();
        }

        clicks = clicks.intValue() + 1;
        clickCount.setText(clicks.toString());
    }
    
    private void tick() {
        elapsedTime = System.currentTimeMillis() - startTime.longValue();
        
        Number remainingSeconds = (timerLength.floatValue()-elapsedTime.floatValue())/1000;
        clickTimer.setText(remainingSeconds.shortValue() + "s");
        
        if (elapsedTime.floatValue() >= timerLength.floatValue()) {
            Number clickSpeed = clicks.intValue()/15;
            JOptionPane.showMessageDialog(null, "Your click speed is:\n" + clickSpeed.toString()  + "cps");
            reset();
        }
    }
    
    private void reset() {
        startTime = 0;
        elapsedTime = 0;
        running = false;
        clicks = 0;
        clickCount.setText("N/A");
        clickTimer.setText("Press click!");
        timer.cancel();
    }
    
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
