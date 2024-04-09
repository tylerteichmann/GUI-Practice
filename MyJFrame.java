import javax.swing.JFrame;

public class MyJFrame extends JFrame {

    public MyJFrame(String title) {
        super(title);
        // MyJPanel panel = new MyJPanel();
        // setContentPane(panel);

        setSize(900, 900);
        setLocation(200, 100);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

}
