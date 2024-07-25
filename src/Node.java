import java.awt.Color;
import java.awt.Graphics;

public class Node {
    int value;
    int placement = 0;
    int size;
    int center_x;
    int center_y;
    int x, y;
    String name;

    public Node(int value, int placement, int x, int y) {
        this.value = value;
        this.size = 30;
        this.placement = placement;
        this.center_x = x + 4;
        this.x = x;
        this.y = y;
        this.center_y = y + 20;
        this.name = "" + value;
    }

    public void paint(Graphics g) {
        g.setColor(Color.MAGENTA);
        g.drawRect(x, y, size, size);
        g.drawString(name, center_x, center_y);

    }

    public String toString() {
        return "Num: " + this.value + " placement: " + this.placement;
    }

    public String getName() {
        return this.name;

    }

    public void setName(String s) {
        this.name = s;
    }

    public int getValue(Node n){
        return this.value;
    }

    public boolean equals(Node n2){
        if (this.value == getValue(n2)){
            return true;
        } 
        return false;

    }
}