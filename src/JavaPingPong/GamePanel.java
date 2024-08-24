import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

// GamePanel is the canvas on which we are painting

public class GamePanel extends JPanel implements Runnable {
    // using static due to any multiple instances of GamePanel class. they would share one variable
    // using final gives us security for the GAME_WIDTH variable and run a little faster
    static final int GAME_WIDTH = 1000;
    // Copying dimensions of a ping pong table
    static final int GAME_HEIGHT = (int) (GAME_WIDTH * (5/9));
    static final Dimension SCREEN_SIZE = new Dimension(GAME_WIDTH, GAME_HEIGHT);
    static final int BALL_DIAMETER = 20;
    static final int PADDLE_WIDTH = 25;
    static final int PADDLE_HEIGHT = 100;

    // declare a few instances
    Thread gameThread;
    Image image;
    Graphics graphics;
    Random random;
    Paddle paddle1;
    Paddle paddle2;
    Ball ball;
    Score score;

    GamePanel(){

    }
    public void newBall(){

    }
    public void newPaddles(){

    }
    public void paint(Graphics graphics){

    }
    public void draw(Graphics graphics){

    }
    public void move(){

    }
    public void checkCollission(){

    }
    public void run(){

    }
    // AL = Action Listener
    public class AL extends KeyAdapter{
        public void keyPressed(KeyEvent e){

        }
        public void keyReleased(KeyEvent e){

        }
    }
}
