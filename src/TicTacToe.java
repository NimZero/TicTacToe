import javax.swing.*;
import java.awt.event.ActionEvent;

public class TicTacToe extends JDialog {
    private JPanel contentPane;
    private JButton replayBtn;
    private JButton quitBtn;
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JButton button4;
    private JButton button5;
    private JButton button6;
    private JButton button7;
    private JButton button8;
    private JButton button9;
    private JPanel gameBoard;
    private JLabel gameLabel;
    private JLabel nullLabel;
    private JLabel xLabel;
    private JLabel oLabel;
    private JPanel infoBoard;
    private JLabel endInfo;
    private Integer round, game, nul, lastFirst;
    private final Board board;
    private final Player[] players;

    public TicTacToe() {
        board = new Board();
        players = new Player[]{new Player("Player X", 'X'), new Player("Player O", 'O')};
        round = 0;
        game = 1;
        nul = 0;
        lastFirst = 0;

        setContentPane(contentPane);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        getRootPane().setDefaultButton(replayBtn);
        pack();
        setMinimumSize(getSize());
        setLocationRelativeTo(null);
        setModal(true);

        initBtns();
        resetBtn();
        labels();
        board.reset();
        setTitle("Tic-Tac-Toe");

        setVisible(true);
    }

    private void replay() {
        board.reset();
        game++;

        gameBoard.setVisible(true);
        infoBoard.setVisible(true);
        endInfo.setVisible(false);

        if(lastFirst == 0) {
            round = 1;
            lastFirst = 1;
        }else {
            round = 0;
            lastFirst = 0;
        }

        resetBtn();
        labels();
    }

    private void play(ActionEvent e, int index) {
        Player player = players[round%2];
        board.play(index, player.getSymbol());

        JButton src = (JButton) e.getSource();
        src.setEnabled(false);
        src.setText(player.getSymbol().toString());
        this.round++;
        if(board.testVictory() || round>(8+lastFirst)) end();
    }

    private void end() {
        this.round--;
        gameBoard.setVisible(false);
        infoBoard.setVisible(false);
        endInfo.setVisible(true);

        replayBtn.setEnabled(true);
        if(board.testVictory()) {
            players[round%2].addVictory();
            endInfo.setText(players[round%2].getName()+" you win !");
        }else {
            endInfo.setText("It's a tie !");
            nul++;
        }
    }

    private void resetBtn() {
        replayBtn.setEnabled(false);

        button1.setText("");
        button1.setEnabled(true);

        button2.setText("");
        button2.setEnabled(true);

        button3.setText("");
        button3.setEnabled(true);

        button4.setText("");
        button4.setEnabled(true);

        button5.setText("");
        button5.setEnabled(true);

        button6.setText("");
        button6.setEnabled(true);

        button7.setText("");
        button7.setEnabled(true);

        button8.setText("");
        button8.setEnabled(true);

        button9.setText("");
        button9.setEnabled(true);
    }

    private void initBtns() {
        quitBtn.addActionListener(e -> dispose());
        replayBtn.addActionListener(e -> replay());
        button1.addActionListener(e -> play(e, 0));
        button1.setMinimumSize(button1.getSize());

        button2.addActionListener(e -> play(e, 1));
        button2.setMinimumSize(button2.getSize());

        button3.addActionListener(e -> play(e, 2));
        button3.setMinimumSize(button3.getSize());

        button4.addActionListener(e -> play(e, 3));
        button4.setMinimumSize(button4.getSize());

        button5.addActionListener(e -> play(e, 4));
        button5.setMinimumSize(button5.getSize());

        button6.addActionListener(e -> play(e, 5));
        button6.setMinimumSize(button6.getSize());

        button7.addActionListener(e -> play(e, 6));
        button7.setMinimumSize(button7.getSize());

        button8.addActionListener(e -> play(e, 7));
        button8.setMinimumSize(button8.getSize());

        button9.addActionListener(e -> play(e, 8));
        button9.setMinimumSize(button9.getSize());

    }

    private void labels() {
        gameLabel.setText(game.toString());
        nullLabel.setText(nul.toString());
        xLabel.setText(players[0].getVictories().toString());
        oLabel.setText(players[1].getVictories().toString());
    }
}
