import java.awt.*;
import java.io.Serializable;
import java.util.ArrayList;

public class MyLine implements Serializable {

    protected ArrayList<Point> points;
    protected Color color;

    public MyLine(Color color) {
        this.points = new ArrayList<>();
        this.color = color;
    }

    public void addPoint(Point p) {
        this.points.add(p);
    }

    protected ArrayList<Point> getPoints() {
        return this.points;
    }

    protected Point getIndex(int i) {
        return this.points.get(i);
    }

    protected Color getColor() {
        return color;
    }

    protected void clear() {
        this.points.clear();
    }

}