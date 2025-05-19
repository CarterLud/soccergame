import javax.swing.*;

public class Game {
    public static void main(String[] args) {
        JFrame window = new JFrame();

        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.setTitle("Soccer");

        Window game = new Window();

        window.add(game);

        game.Start();

        window.pack(); // window size to be set to fit the preferred size and layouts of subcomponents (ie. gamepanel)

        window.setLocationRelativeTo(null);
        window.setVisible(true);
    }
}
