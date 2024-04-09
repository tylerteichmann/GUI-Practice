import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

/**
 * TicTacToe Game
 */
public class TicTacToeGame extends MyJFrame {

    JPanel jPanel = new JPanel();
    ArrayList<JButton> buttons = new ArrayList<JButton>();
    final int ROWS = 3, COLUMNS = 3;
    String currentPlayer = "X";
    Font font;

    public TicTacToeGame() {
        super("Tic Tac Toe Game");

        // jPanel = new JPanel();
        // jPanel.setLayout(new BorderLayout());

        // jPanel.add(new JButton("OK"), BorderLayout.SOUTH);
        // jPanel.add(new JButton("Cancel"), BorderLayout.NORTH);
        jPanel.setLayout(new GridLayout(ROWS, COLUMNS));

        font = new Font(Font.SANS_SERIF, Font.BOLD, 200);

        for (int i = 0; i < ROWS * COLUMNS; i++) {
            JButton btn = new JButton();
            btn.setFont(font);
            btn.addActionListener(e -> ButtonClicked(e));
            buttons.add(btn);
            jPanel.add(btn);
        }

        setContentPane(this.jPanel);
        setVisible(true);
    }

    public void ButtonClicked(ActionEvent e) {

        JButton btnClicked = (JButton)(e.getSource());
        btnClicked.setText(currentPlayer);
        btnClicked.setEnabled(false);

        if (currentPlayer == "X") {
            btnClicked.setBackground(Color.RED);
            currentPlayer = "O";
        } else {
            btnClicked.setBackground(Color.BLUE);
            currentPlayer = "X";
        }
    }

    public boolean CheckWinner() {
        if (
            buttons.get(0).getText().equals(currentPlayer) &&
            buttons.get(1).getText().equals(currentPlayer) &&
            buttons.get(2).getText().equals(currentPlayer)) {
            return true;
        } else if (
            buttons.get(3).getText().equals(currentPlayer) &&
            buttons.get(4).getText().equals(currentPlayer) &&
            buttons.get(5).getText().equals(currentPlayer)) {
            return true;
        } else if (
            buttons.get(6).getText().equals(currentPlayer) &&
            buttons.get(7).getText().equals(currentPlayer) &&
            buttons.get(8).getText().equals(currentPlayer)){
            return true;
        } else if (
            buttons.get(0).getText().equals(currentPlayer) &&
            buttons.get(4).getText().equals(currentPlayer) &&
            buttons.get(8).getText().equals(currentPlayer)){
            return true;
        } else if (
            buttons.get(2).getText().equals(currentPlayer) &&
            buttons.get(4).getText().equals(currentPlayer) &&
            buttons.get(6).getText().equals(currentPlayer)){
            return true;
        } else if (
            buttons.get(0).getText().equals(currentPlayer) &&
            buttons.get(3).getText().equals(currentPlayer) &&
            buttons.get(6).getText().equals(currentPlayer)){
            return true;
        } else if (
            buttons.get(1).getText().equals(currentPlayer) &&
            buttons.get(4).getText().equals(currentPlayer) &&
            buttons.get(7).getText().equals(currentPlayer)){
            return true;
        } else if (
            buttons.get(2).getText().equals(currentPlayer) &&
            buttons.get(5).getText().equals(currentPlayer) &&
            buttons.get(8).getText().equals(currentPlayer)){
            return true;
        } else {
            return false;
        }
    }



}