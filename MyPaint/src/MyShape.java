import java.awt.*;
import java.io.Serializable;

public class MyShape implements Serializable {

    protected Shape shape;
    protected Color color;

    public MyShape(Shape shape, Color color) {
        this.shape = shape;
        this.color = color;
    }

}