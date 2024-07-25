import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class driver extends JFrame {

    private List<Event> events = new ArrayList<>();
    private JList<Event> eventList;
    private DefaultListModel<Event> listModel;
    private JButton addButton, editButton, deleteButton;
    Screen s = new Screen();

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new driver().setVisible(true));
    }

    public driver() {
        setTitle("Sorting Algorithms");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 700);
        initComponents();
    }

    private void initComponents() {
        
        // Icon myImgIcon = new ImageIcon(this.getClass().getResource("d40.gif"));
        // JLabel imageLbl = new JLabel(myImgIcon);
        // imageLbl.setBounds(0, 0, 500,500); // You can use your own values
        listModel = new DefaultListModel<>();
        eventList = new JList<>(listModel);
        addButton = new JButton("Add Event");
        editButton = new JButton("Edit Event");
        deleteButton = new JButton("Delete Event");

        setLayout(new BorderLayout());
        JPanel aPan = new JPanel();
        aPan.setLayout(new GridLayout(1, 1, 0, 0));

        JPanel controlPanel = new JPanel(new FlowLayout());

        controlPanel.add(addButton);
        controlPanel.add(editButton);
        controlPanel.add(deleteButton);

        add(aPan, BorderLayout.NORTH);
        //add(new JScrollPane(eventList), BorderLayout.SOUTH);
        add(controlPanel, BorderLayout.SOUTH);

        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Event newEvent = createNewEvent();
                if (newEvent != null) {
                    events.add(newEvent);
                    updateEventList();

                }
            }
        });

        editButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Event selectedEvent = eventList.getSelectedValue();
                if (selectedEvent != null) {
                    editEvent(selectedEvent);
                    updateEventList();
                }
            }
        });

        deleteButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Event selectedEvent = eventList.getSelectedValue();
                if (selectedEvent != null) {
                    events.remove(selectedEvent);
                    updateEventList();
                }
            }
        });

        s = new Screen();
        add(s);

    }

    private Event createNewEvent() {
        String name = JOptionPane.showInputDialog(this, "Enter event name:");
        if (name != null && !name.trim().isEmpty()) {
            String dateStr = JOptionPane.showInputDialog(this, "Enter event date (yyyy-MM-dd):");
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            try {
                Date date = dateFormat.parse(dateStr);
                return new Event(name, date);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Invalid date format. Event not added.");
            }
        }
        return null;
    }

    private void editEvent(Event event) {
        String newName = JOptionPane.showInputDialog(this, "Enter new event name:", event.getName());
        if (newName != null && !newName.trim().isEmpty()) {
            String newDateStr = JOptionPane.showInputDialog(this, "Enter new event date (yyyy-MM-dd):",
                    event.getDateStr());
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            try {
                Date newDate = dateFormat.parse(newDateStr);
                event.setName(newName);
                event.setDate(newDate);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Invalid date format. Event not edited.");
            }
        }
    }

    private void updateEventList() {
        listModel.clear();
        for (Event event : events) {
            listModel.addElement(event);
        }
    }
}

class Event {
    private String name;
    private Date date;

    public Event(String name, Date date) {
        this.name = name;
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getDateStr() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return dateFormat.format(date);
    }

    @Override
    public String toString() {
        return "Event: " + name + " Date: " + getDateStr();
    }
}