package TicTacToeGame;
import javax.swing.JButton;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
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
    Color currentPlayerColor = Color.RED;
    Font font;
    JMenuBar menuBar;
    JMenu menu;
    JMenuItem resetGameItem;

    public TicTacToeGame() {
        super("Tic Tac Toe Game");

        menuBar = new JMenuBar(); // create the menu bar
        menu = new JMenu("Game Options"); // create the menu
        resetGameItem = new JMenuItem("Reset Game"); // 
        resetGameItem.addActionListener(e -> ResetGame()); // Sets a listener and 

        menu.add(resetGameItem); // add the menu item to the menu
        menuBar.add(menu); // add the menu to the menu bar
        setJMenuBar(menuBar); 

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
    }

    public void ResetGame() {
        currentPlayer = "X";
        currentPlayerColor = Color.RED;

        for (int i = 0; i < buttons.size(); i++) {
            JButton btn = buttons.get(i);
            btn.setText("");
            btn.setBackground(null);
            btn.setEnabled(true);
        }
    }

    public void ButtonClicked(ActionEvent e) {

        JButton btnClicked = (JButton)(e.getSource());

        btnClicked.setText(currentPlayer);
        btnClicked.setBackground(currentPlayerColor);
        btnClicked.setEnabled(false);

        CheckWinner();

        SwitchPlayer();
    }

    public void SwitchPlayer() {
        if (currentPlayer == "X") {
            currentPlayer = "O";
            currentPlayerColor = Color.BLUE;
        } else {
            currentPlayer = "X";
            currentPlayerColor = Color.RED;
        }
    }

    public void CheckWinner() {
        boolean winnerFound;

        if (
            buttons.get(0).getText().equals(currentPlayer) &&
            buttons.get(1).getText().equals(currentPlayer) &&
            buttons.get(2).getText().equals(currentPlayer)) {
                winnerFound = true;
        } else if (
            buttons.get(3).getText().equals(currentPlayer) &&
            buttons.get(4).getText().equals(currentPlayer) &&
            buttons.get(5).getText().equals(currentPlayer)) {
                winnerFound = true;
        } else if (
            buttons.get(6).getText().equals(currentPlayer) &&
            buttons.get(7).getText().equals(currentPlayer) &&
            buttons.get(8).getText().equals(currentPlayer)){
                winnerFound = true;
        } else if (
            buttons.get(0).getText().equals(currentPlayer) &&
            buttons.get(4).getText().equals(currentPlayer) &&
            buttons.get(8).getText().equals(currentPlayer)){
                winnerFound = true;
        } else if (
            buttons.get(2).getText().equals(currentPlayer) &&
            buttons.get(4).getText().equals(currentPlayer) &&
            buttons.get(6).getText().equals(currentPlayer)){
                winnerFound = true;
        } else if (
            buttons.get(0).getText().equals(currentPlayer) &&
            buttons.get(3).getText().equals(currentPlayer) &&
            buttons.get(6).getText().equals(currentPlayer)){
                winnerFound = true;
        } else if (
            buttons.get(1).getText().equals(currentPlayer) &&
            buttons.get(4).getText().equals(currentPlayer) &&
            buttons.get(7).getText().equals(currentPlayer)){
                winnerFound = true;
        } else if (
            buttons.get(2).getText().equals(currentPlayer) &&
            buttons.get(5).getText().equals(currentPlayer) &&
            buttons.get(8).getText().equals(currentPlayer)){
                winnerFound = true;
        } else {
            winnerFound = false;
        }

        if (winnerFound) {
            JOptionPane.showMessageDialog(null, currentPlayer + " has won the game!");

            for (int i = 0; i < buttons.size(); i++) {
                buttons.get(i).setEnabled(false);
            }
        }
    }
}