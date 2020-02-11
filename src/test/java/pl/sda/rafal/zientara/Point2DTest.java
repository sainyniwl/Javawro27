package pl.sda.rafal.zientara;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Point2DTest {

    @Test
    public void isDistanceFromCenterRight(){
        //given
        Point2D point2D = new Point2D(3, 4);

        //when
        double distance = point2D.getDistanceFromCenter();

        //then
        assertEquals(5, distance);
    }

    @Test
    public void isDistanceFromCenterRight2(){
        //given
        Point2D point2D = new Point2D(10, 10);

        //when
        double distance = point2D.getDistanceFromCenter();

        //then
        assertEquals(Math.sqrt(200), distance);
    }

    @Test
    public void isDistanceFromCenterRight3(){
        //given
        Point2D point2D = new Point2D(1000, 1000);

        //when
        double distance = point2D.getDistanceFromCenter();

        //then
        assertEquals(Math.sqrt(2000000), distance);
    }

    @Test
    public void idDistanceFromAnotherPointIsRight(){
        //given
        Point2D point2D = new Point2D(2, 5);
        Point2D point2D1 = new Point2D(5, 9);

        //when
        double distance = point2D.getDistanceFromPoint2D(point2D1);

        //then
        assertEquals(5, distance);
    }

    @Test
    public void idDistanceFromAnotherPointIsRight2(){
        //given
        Point2D point2D = new Point2D(7, 21);
        Point2D point2D1 = new Point2D(10, 25);

        //when
        double distance = point2D.getDistanceFromPoint2D(point2D1);

        //then
        assertEquals(5, distance);
    }
    @Test
    public void idDistanceFromAnotherPointIsRight3(){
        //given
        Point2D point2D = new Point2D(297, 396);
        Point2D point2D1 = new Point2D(300, 400);

        //when
        double distance = point2D.getDistanceFromPoint2D(point2D1);

        //then
        assertEquals(5, distance);
    }

    @Test
    public void doesStringIsShowingRightPoint(){
        //given
        Point2D point2D = new Point2D(3, 4);

        //when
        String point = point2D.toString();
        double x = point2D.getX();
        double y = point2D.getY();

        //then
        assertEquals(3, x);
        assertEquals(4, y);
    }

    @Test
    public void isMovingPointWorksFine(){
        //given
        Point2D point2D = new Point2D(10, 10);

        //when
        point2D.move(2, 3);
        double x = point2D.getX();
        double y = point2D.getY();

        //then
        assertEquals(12, x);
        assertEquals(13, y);
    }


}