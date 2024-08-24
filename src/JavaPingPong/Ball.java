import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;


public class Ball extends Rectangle{
    Random random;
    int xVelocity;
    int yVelocity;
    Ball(int x, int y, int width, int height){
        super(x,y,width,height);
        random = new Random();
        // local variable for the ball constructor

        int randomXDirection = random.nextInt(2);
        if(randomXDirection == 0)
            randomXDirection--;
        setXDirection(randomXDirection);


        int randomYDirection = random.nextInt(2);
        if(randomYDirection == 0)
            randomYDirection--;
        setXDirection(randomYDirection);



    }
    public void setXDirection(int randomXDirection){

    }
    public void setYDirection(int randomYDirection){

    }
    public void move(){

    }
    public void draw(Graphics graphics){

    }

}
