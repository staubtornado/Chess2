import javax.swing.*;

public class GUI {
    private JFrame frame;
    private Game game;

    public GUI(Player player) {
        frame = new JFrame("Chess");
        game = null;

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setSize(800, 800);
        frame.setVisible(true);
    }


}
