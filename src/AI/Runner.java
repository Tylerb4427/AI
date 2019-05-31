package AI;

//(c) A+ Computer Science
//www.apluscompsci.com
//Name -
import javax.swing.JFrame;
import java.awt.Component;
import java.io.IOException;

public class Runner extends JFrame {

    private static final int WIDTH = 800;
    private static final int HEIGHT = 600;
    public static boolean canStart = false;
    public static int cars =100;

    public Runner(int cars) throws IOException {

        super("Racing");
        setSize(WIDTH, HEIGHT);

        Racer theGame = new Racer(cars);
        ((Component) theGame).setFocusable(true);

        getContentPane().add(theGame);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String args[]) throws IOException {
        Init.main(args);
        while (!canStart) {System.out.println("");}
        Runner run = new Runner(cars);
    }
}
