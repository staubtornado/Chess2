import javax.swing.*;
import java.awt.*;

public class GUI {
    private JFrame frame;
    private Game game;

    public GUI(Player player) {
        frame = new JFrame("Chess");
        game = new Game(new Player[]{player, new Player(Color.BLACK, "Computer", 1900, "192", 9928, 0, 0, 0, 0)});

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setSize(800, 829);
        frame.setResizable(false);
        frame.setLayout(null);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                JButton button = new JButton();
                button.setBounds(i * 100, j * 100, 100, 100);
                if (game.getBoard().getField(i, j) != null) {
                    button.setText(game.getBoard().getField(i, j).toString());
                    button.setFont(new Font("Arial", Font.PLAIN, 80));
                }
                frame.add(button);
            }
        }


    }


}
