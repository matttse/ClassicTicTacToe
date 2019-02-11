package view;

import controller.*;
import mainGame.Main;
import model.*;

import javax.swing.*;
import java.awt.*;

public class Window extends JFrame {

    private final Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    private final Dimension windowSize = new Dimension(500, 550);

    private JPanel control = new JPanel();
    private JLabel turn = new JLabel();
    private Font font = new Font("SANS_SERIF", Font.BOLD, 25);
    private Canvas canvas = new Canvas();

    private CurrentMove currentMoveController = new CurrentMove();
    private Winner winnerController = new Winner();
    private Move moveController = new Move();
    private Player[] players = Main.game.getPlayers();

    private int heightAdjust = 21;

    public Window() {
        setLocation((int) (screenSize.getWidth()/2-windowSize.getWidth()/2), (int) (screenSize.getHeight()/2-windowSize.getHeight()/2));
        setTitle("XO");
        setSize(windowSize.width, windowSize.height + heightAdjust);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setResizable(false);
        setFocusable(true);
        addKeyListener(new KeyboardInput());

        turn.setFont(font);
        turn.setText("Hello");

        control.setBackground(Color.GRAY);
        control.add(turn);
        control.setSize(500,50);
        control.setLocation(0, 500);

        add(control);
        add(canvas);
    }

    public void loop() {
        final Field field = Main.game.getField();
        final Figure currentFigure = currentMoveController.currentMove(field);

        if (currentFigure == null) {
            final Player winner = winnerController.getWinner(players);
            if (winner != null) {
                JOptionPane.showMessageDialog(null, "Winner is - " + winner.getName());
            } else {
                JOptionPane.showMessageDialog(null, "The Game is a Draw!");
            }
            Main.game.isEnd = false;
            System.exit(1);
        }

        Player player = searchPlayer(Main.game, currentFigure);
        turn.setText("Turn is - " + player.getName() + " - " + player.getScore() );
    }

    private Player searchPlayer(Game game, Figure figure) {
        final Player[] players = game.getPlayers();
        for(int i = 0; i < players.length ; i++) {
            if(players[i].getFigure().equals(figure)) {
                return players[i];
            }
        }
        return  null;
    }
}