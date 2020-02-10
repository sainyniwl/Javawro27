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

    public double getDistanceFromCenter() {
        return Math.sqrt((x * x) + (y * y));
    }

    public double getDistanceFromPoint2D(Point2D point) {
        double dx = point.getX() - x;
        double dy = point.getY() - y;
        return Math.sqrt(((dx * dx) + (dy * dy)));
    }

    public void move(double deltaX, double deltaY) {
        setX(deltaX);
        setY(deltaY);
    }


    @Override
    public String toString() {
        return "x = " + x + '\n' +
                "y = " + y;
    }
}
