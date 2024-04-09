import javax.swing.JFrame;

public class MyJFrame extends JFrame {

    public MyJFrame(String title) {
        super(title);
        MyJPanel panel = new MyJPanel();
        

        setSize(2100, 900);
        setLocation(200, 100);
        setVisible(true);

        setContentPane(panel);
    }

}
