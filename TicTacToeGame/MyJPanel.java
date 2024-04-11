package TicTacToeGame;
import javax.swing.JPanel;
import java.awt.Graphics;

public class MyJPanel extends JPanel {

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawString("Hello World!", 0, 12);
        g.drawString("This is our Java Course", 1600, 100);
    }

}
