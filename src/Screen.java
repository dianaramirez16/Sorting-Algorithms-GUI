import java.awt.*;
import javax.swing.JPanel;
import java.util.ArrayList;
import java.util.Random;

public class Screen extends JPanel {
    
    private ArrayList<Node> printlist;

    public Screen() {
        ArrayList<Integer> unsorted = new ArrayList<>();
        fill_List(unsorted); //set random values
        printlist = formatNodes(unsorted);
        
        System.out.println("unsorted list: " + unsorted);
        System.out.println("printlist: " + printlist);


    }

    public ArrayList<Node> formatNodes(ArrayList<Integer> a){
        ArrayList<Node> nodes = new ArrayList<>();
        int x1 = 20;
        int y1 = a.size()%5*20;

        for (int i = 1; i < 6; i++) {
            nodes.add(new Node(a.get(i - 1), i, x1, y1));
            x1 += 40;
        }
        
        return nodes;
    }

    public void paintComponent(Graphics g) {
        g.setColor(Color.MAGENTA);
        g.setFont(new Font("Monospaced", Font.PLAIN, 20));

        
        //add event listener for sorting method picked??

        for (Node n : printlist) {
            n.paint(g);
            System.out.print(n.value +" ");
            
        }
    }

    public void fill_List(ArrayList<Integer> l) {
        Random rand = new Random();
        for (int i = 0; i < 5; i++) {
            int randomInt = rand.nextInt((20) + 1) + 1;
            l.add(randomInt);
            
        }

    }

    public void bubbleSort(ArrayList<Node> nodes) {
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

    public void selectionSort(ArrayList<Node> nodes) {
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

    public void insertionSort(ArrayList<Node> nodes) {
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
