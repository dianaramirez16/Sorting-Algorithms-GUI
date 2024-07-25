import java.awt.*;
import javax.swing.JPanel;
import java.util.ArrayList;
import java.util.Random;
import java.awt.Font;

public class Screen extends JPanel {
    private ArrayList<Node> nodes;
    private ArrayList<Integer> unsorted;

    public Screen() {
        nodes = new ArrayList<>();
        unsorted = new ArrayList<>();
        fill_List(unsorted);

        int x1 = 20;
        int y1 = 20;

        for (int i = 1; i < 11; i++) {
            nodes.add(new Node(unsorted.get(i - 1), i, x1, y1));
            x1 += 40;
        }

        repaint();
    }

    public void paint(Graphics g) {
        g.setColor(Color.MAGENTA);
        g.setFont(new Font("Monospaced", Font.PLAIN, 20));

        for (Node n : nodes) {
            n.paint(g);
            System.out.println(n);
        }
    }

    public void fill_List(ArrayList<Integer> l) {
        Random rand = new Random();
        for (int i = 0; i < 10; i++) {
            int randomInt = rand.nextInt((50) + 1) + 1;
            l.add(randomInt);
            System.out.println(l);
        }

    }

}
