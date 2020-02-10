package pl.sda.rafal.zientara.zadaniaTDD_09_02;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Point2DTest {
    Point2D point;
    Point2D point2;


    @BeforeEach
    public void setup() {
        point = new Point2D();
        point2 = new Point2D();
    }

    @Test
    public void getDistanceFromZeroTest() {
        assertEquals(10, (int) new Point2D(0, 10).getDistanceFromCenter());
        assertEquals(14, (int) new Point2D(10, 10).getDistanceFromCenter());
        assertEquals(14, (int) new Point2D(-10, 10).getDistanceFromCenter());
        assertEquals(14, (int) new Point2D(10, -10).getDistanceFromCenter());
        assertEquals(0, (int) new Point2D(0, 0).getDistanceFromCenter());
        assertEquals(14, (int) new Point2D(-10, -10).getDistanceFromCenter());
    }


    @Test
    public void point2DMoveTest() {
        point.move(857.112, -78.11);
        assertEquals(857.112, point.getX());
        assertEquals(-78.11, point.getY());
        //next one
        point.move(0, 0);
        assertEquals(0, point.getX());
        assertEquals(0, point.getY());
        //
        point.move(-857.112, -78.11);
        assertEquals(-857.112, point.getX());
        assertEquals(-78.11, point.getY());
        //
        point.move(857.112, 78.11);
        assertEquals(857.112, point.getX());
        assertEquals(78.11, point.getY());
        //
        point.move(-857.112, 78.11);
        assertEquals(-857.112, point.getX());
        assertEquals(78.11, point.getY());
    }

    @Test
    public void fromPointToPointDistanceTest() {
        point.setY(0);
        point.setY(0);
        point2.setY(50);
        point2.setX(2);
        assertEquals(50, (int) point.getDistanceFromPoint2D(point2));
        //next one
        point.setX(11);
        point.setY(11);
        point2.setY(1);
        point2.setX(1);
        assertEquals(14, (int) point.getDistanceFromPoint2D(point2));
        //next one
        point.setX(-11);
        point.setY(-11);
        point2.setY(1);
        point2.setX(1);
        assertEquals(16, (int) point.getDistanceFromPoint2D(point2));
        //next one
        point.setX(-11);
        point.setY(-11);
        point2.setY(-1);
        point2.setX(-1);
        assertEquals(14, (int) point.getDistanceFromPoint2D(point2));
        //next one
        point.setX(-11);
        point.setY(11);
        point2.setY(-1);
        point2.setX(1);
        assertEquals(16, (int) point.getDistanceFromPoint2D(point2));
        //next one
        point.setX(0);
        point.setY(0);
        point2.setY(0);
        point2.setX(0);
        assertEquals(0, (int) point.getDistanceFromPoint2D(point2));

    }


}