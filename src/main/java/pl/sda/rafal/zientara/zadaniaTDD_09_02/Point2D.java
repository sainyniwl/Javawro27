package pl.sda.rafal.zientara.zadaniaTDD_09_02;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Point2D {

    private double x;
    private double y;

    public Point2D(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public Point2D() {

    }


    @Override
    public String toString() {
        return "x= " + x + '\n' +
                "y= " + y;
    }
}
