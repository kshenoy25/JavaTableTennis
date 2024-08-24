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
    static final int GAME_HEIGHT = (int) (GAME_WIDTH * (5.0/9.0));
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
        newPaddles();
        newBall();
        // finish initializing
        score = new Score(GAME_WIDTH, GAME_HEIGHT);
        this.setFocusable(true);
        this.addKeyListener(new AL());
        this.setPreferredSize(SCREEN_SIZE);
        this.setBackground(Color.black);

        // this = implementing the runnable interface
        gameThread = new Thread(this);
        gameThread.start();

    }
    public void newBall(){
        //random = new Random();
        ball = new Ball((GAME_WIDTH/2) - (BALL_DIAMETER/2), (GAME_HEIGHT/2) - (BALL_DIAMETER/2), BALL_DIAMETER, BALL_DIAMETER);


    }
    public void newPaddles(){
        paddle1 = new Paddle(0, (GAME_HEIGHT/2) - (PADDLE_HEIGHT/2), PADDLE_WIDTH,PADDLE_HEIGHT, 1);
        paddle2 = new Paddle(GAME_WIDTH-PADDLE_WIDTH, (GAME_HEIGHT/2) - (PADDLE_HEIGHT/2), PADDLE_WIDTH,PADDLE_HEIGHT, 2);


    }
    @Override
    public void paint(Graphics graphics){
        //image = createImage(getWidth(), getHeight());
        //graphics = image.getGraphics();
        super.paint(graphics);
        draw(graphics);
        //graphics.drawImage(image, 0, 0, this);

    }
    public void draw(Graphics graphics){
        paddle1.draw(graphics);
        paddle2.draw(graphics);



    }
    public void move(){
        paddle1.move();
        paddle2.move();
        //ball.move();

    }
    public void checkCollision(){
        // stops paddles at window edges
        if (paddle1.y <= 0)
            paddle1.y = 0;
        if (paddle1.y >= (GAME_HEIGHT-PADDLE_HEIGHT))
            paddle1.y = GAME_HEIGHT-PADDLE_HEIGHT;
        if (paddle2.y <= 0)
            paddle2.y = 0;
        if (paddle2.y >= (GAME_HEIGHT-PADDLE_HEIGHT))
            paddle2.y = GAME_HEIGHT-PADDLE_HEIGHT;


        }


    public void run(){
        // game loop


        long lastTime = System.nanoTime();
        double amountOfTicks = 60.0;
        double ns = 1000000000 / amountOfTicks;
        double delta = 0;
        while (true) {
            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;
            if (delta >= 1) {
                move();
                checkCollision();
                repaint();
                delta--;
                //System.out.println("Test");
            }

        }

    }
    // AL = Action Listener
    public class AL extends KeyAdapter{
        public void keyPressed(KeyEvent e){
            paddle1.keyPressed(e);
            paddle2.keyPressed(e);

        }
        public void keyReleased(KeyEvent e){
            paddle1.keyReleased(e);
            paddle2.keyReleased(e);

        }
    }
}
