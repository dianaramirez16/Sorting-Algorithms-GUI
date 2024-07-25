import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Driver extends JFrame {
    private JButton bubbleSortButton, selectionSortButton, insertionSortButton;
    Screen s = new Screen();

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Driver().setVisible(true));
    }

    public Driver() {
        setTitle("Sorting Algorithms");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 300);
        initComponents();
    }

    private void initComponents() {

        bubbleSortButton = new JButton("BubbleSort");
        selectionSortButton = new JButton("Selection Sort");
        insertionSortButton = new JButton("Insertion Sort");

        setLayout(new BorderLayout());
        JPanel aPan = new JPanel();
        aPan.setLayout(new GridLayout(1, 1, 0, 0));

        JPanel controlPanel = new JPanel(new FlowLayout());

        controlPanel.add(bubbleSortButton);
        controlPanel.add(selectionSortButton);
        controlPanel.add(insertionSortButton);

        add(aPan, BorderLayout.NORTH);
        add(controlPanel, BorderLayout.SOUTH);

        bubbleSortButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("bubble sort button pressed");

            }
        });

        selectionSortButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("selection sort button pressed");

            }
        });

        insertionSortButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("insertion sort button pressed");

            }
        });

        s = new Screen();
        add(s);
    }
}