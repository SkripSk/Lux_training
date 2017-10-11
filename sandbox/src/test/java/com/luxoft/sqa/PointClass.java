package com.luxoft.sqa;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Random;

public class PointClass {

    @Test
    public void testDistanceX(){
        Point t = new Point(0,0);
        Assert.assertEquals(t.distance(0,-10),10.0);
    }

    @Test
    public void testDistanceY(){
        Point t = new Point(0,0);
        Assert.assertEquals(t.distance(-10,0),10.0);
    }

    @Test
    public void testDistance0(){
        Random randomGenerator = new Random();
        int i = randomGenerator.nextInt();

        Point t = new Point(i,i);

        Assert.assertEquals(t.distance(i,i),0.0);
    }
}
