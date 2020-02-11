package pl.sda.rafal.zientara;

public class Point2D {

    private double x;
    private double y;

    public Point2D(){

    }

    public Point2D(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    @Override
    public String toString() {
        return "Point2D{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }

    public double getDistanceFromCenter() {
        return Math.sqrt((Math.pow(x, 2) + Math.pow(y, 2)));
    }

    public double getDistanceFromPoint2D(Point2D point) {
        return Math.sqrt((Math.pow(point.x - x, 2)) + (Math.pow(point.y - y, 2)));
    }

    public void move(double deltaX, double deltaY) {
        this.x += deltaX;
        this.y += deltaY;
    }

    public static void main(String[] args) {

        Point2D point2D = new Point2D(10, 2);

        System.out.println(point2D.toString());
        point2D.move(3, 4);
        System.out.println(point2D.toString());

    }
}
