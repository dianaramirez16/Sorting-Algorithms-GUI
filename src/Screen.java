import java.awt.*;
import javax.swing.JPanel;
import java.util.ArrayList;
import java.util.Random;

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

    }

    public void paintComponent(Graphics g) {
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

    public void bubbleSort() {
        int n = nodes.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (nodes.get(j).value > nodes.get(j + 1).value) {
                    // Swap nodes
                    Node temp = nodes.get(j);
                    nodes.set(j, nodes.get(j + 1));
                    nodes.set(j + 1, temp);
                }
            }
        }
    }

    public void selectionSort() {
        int n = nodes.size();
        for (int i = 0; i < n - 1; i++) {
            int minIdx = i;
            for (int j = i + 1; j < n; j++) {
                if (nodes.get(j).value < nodes.get(minIdx).value) {
                    minIdx = j;
                }
            }
            // Swap nodes
            Node temp = nodes.get(minIdx);
            nodes.set(minIdx, nodes.get(i));
            nodes.set(i, temp);
        }
    }

    public void insertionSort() {
        int n = nodes.size();
        for (int i = 1; i < n; i++) {
            Node key = nodes.get(i);
            int j = i - 1;
            while (j >= 0 && nodes.get(j).value > key.value) {
                nodes.set(j + 1, nodes.get(j));
                j = j - 1;
            }
            nodes.set(j + 1, key);
        }
    }

}
