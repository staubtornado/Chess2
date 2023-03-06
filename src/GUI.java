import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class GUI {
    private final JFrame frame;
    private final ArrayList<JButton> changedButtons;
    private final JButton[][] buttons;
    private final Game game;

    public GUI(Player player) {
        frame = new JFrame("Chess");
        changedButtons = new ArrayList<>();
        buttons = new JButton[8][8];

        game = new Game(new Player[]{player, new Player(PlayerColor.BLACK, "Computer", 1900, "192", 9928, 0, 0, 0, 0)});

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setSize(800, 829);
        frame.setResizable(false);
        frame.setLayout(null);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        ImageIcon img = new ImageIcon("./schach.png");
        frame.setIconImage(img.getImage());

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                JButton button = new JButton();
                buttons[i][j] = button;

                button.setBounds(i * 100, j * 100, 100, 100);
                if (game.getBoard().getField(i, j) != null) {
                    button.setText(game.getBoard().getField(i, j).toString());
                    button.setActionCommand(i + ":" + j + ":" + game.getBoard().getField(i, j).getIdentifier());

                    button.setFont(new Font("Arial", Font.PLAIN, 80));
                    button.setForeground(Color.WHITE);

                    button.addActionListener(e -> {
//        for (JButton changedButton : this.changedButtons) {
////                            this.resetButton(changedButton, changedButton.getX() / 100, changedButton.getY() / 100);
//        }

                        String[] split = e.getActionCommand().split(":");
                        int x = Integer.parseInt(split[0]);
                        int y = Integer.parseInt(split[1]);
                        ArrayList<Integer[]> moves = game.getMoves(x, y);

                        if (moves.size() == 0) {
                            return;
                        }
                        JButton source = (JButton) e.getSource();
                        source.setBackground(Color.decode("#83637D"));
                        changedButtons.add(source);

                        for (Integer[] move : moves) {
                            buttons[move[0]][move[1]].setBackground(Color.decode("#638363"));
                            changedButtons.add(buttons[move[0]][move[1]]);
                        }
                    });
                }
                button.setFocusPainted(false);
                button.setFocusable(false);
                button.setContentAreaFilled(false);
                button.setOpaque(true);
                this.resetButton(button, i, j);

                frame.add(button);
            }
        }
    }

    private void onClickEvent(ActiveEvent e) {

    }



    private void resetButton(JButton button, int x, int y) {
        if (y % 2 == 0) {
            if (x % 2 == 0) {
                button.setBackground(Color.decode("#636D83"));
            } else {
                button.setBackground(Color.decode("#2F343F"));
            }
        } else {
            if (x % 2 == 0) {
                button.setBackground(Color.decode("#2F343F"));
            } else {
                button.setBackground(Color.decode("#636D83"));
            }
        }
    }
}
