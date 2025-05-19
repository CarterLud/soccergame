package Player;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.AffineTransform;
import Math.Vector;

public class Player extends Controllable {
    Image playerBase;
    Vector position;

    private final double baseMovementSpeed = 5;
    private final double sprintingMovementSpeed = 15;
    private double currentMovementSpeed = baseMovementSpeed;

    private double stamina = 1;
    private final double maxStamina = 2;
    private boolean isRegenerating = false;
    private double timeSinceRegen = 0;
    private final double maxTimeSinceRegen = 1;

    public Player(double x, double y, JPanel frame) {
/*        try {
            playerBase = ImageIO.read(new File(playerFile));
        } catch(IOException e) {
            System.out.println("Player Image Not Found");
        }*/

        position = new Vector(x, y);
        frame.addKeyListener(this);
    }

    public void checkSprinting(double deltaTime) {
        if (isSprinting && !isRegenerating) {
            currentMovementSpeed = sprintingMovementSpeed;
            timeSinceRegen = maxTimeSinceRegen;
            stamina -= deltaTime;
            if (stamina <= 0) {
                stamina = 0;
                isRegenerating = true;
            }
        } else {
            currentMovementSpeed = baseMovementSpeed;
            if (stamina <= maxStamina && timeSinceRegen <= 0) {
                stamina += deltaTime;
            }
            if (timeSinceRegen > 0) {
                timeSinceRegen -= deltaTime;
            }
        }
    }

    public void handleMovement(double deltaTime) {
        Vector movement = new Vector();
        checkSprinting(deltaTime);
        movement.x = (leftPressed ^ rightPressed) ? (leftPressed) ? -1 : 1 : 0;
        movement.y = (upPressed ^ downPressed) ? (upPressed) ?  -1 : 1 : 0;
        if (movement.x != 0 || movement.y != 0)
            movement.Normalize();

        position.translate(movement.x * currentMovementSpeed, movement.y * currentMovementSpeed);
    }

    public void update(double deltaTime) {
        handleMovement(deltaTime);
    }

    public void drawPlayer(Graphics2D g, JPanel frame) {
        AffineTransform pos = AffineTransform.getTranslateInstance(position.getX(), position.getY());
        //g.drawImage(playerBase, pos, frame);
        g.fillOval((int)position.getX(), (int)position.getY(), 50, 50);
    }


}
