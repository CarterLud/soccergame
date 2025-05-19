import Player.Player;
import Player.PlayerManager;
import javax.swing.*;
import Math.Physics;

import java.awt.*;
import java.nio.channels.DatagramChannel;

import static java.lang.Thread.sleep;

public class Window extends JPanel implements Runnable {

    Thread gameThread;
    private double targetFPS = 60;

    Window() {
        this.setPreferredSize(new Dimension(1000, 1000));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true); // all drawing from this component will be done in an off screen painting buffer
        this.setFocusable(true);
    }

    /**
     * Called when the program starts up
     */
    public void Start() {
        gameThread = new Thread(this);
        gameThread.start();
    }

    public void update(double deltaTime) {
        for (Player p : PlayerManager.players) {
            p.update(deltaTime);
        }
    }
    public void paintComponent(Graphics g) {

        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        g2d.setBackground(Color.black);

        for (Player p : PlayerManager.players) {
            g2d.setColor(Color.white);
            p.drawPlayer(g2d, this);
        }

        g2d.dispose();
    }


    public void run() {
        Player currentPlayer = new Player(50, 50, this);
        PlayerManager pm = new PlayerManager(currentPlayer);

        Long then, now = 0L;
        double deltaTime;
        then = System.nanoTime();

        while(gameThread != null) {
            now = System.nanoTime();
            deltaTime = Physics.deltaTime(then, now, Math.pow(10, 9) / targetFPS);
            if (deltaTime >= 1) {
                then = System.nanoTime(); // reset
                update(deltaTime/ 100);
                repaint();
            }
        }
    }

}
