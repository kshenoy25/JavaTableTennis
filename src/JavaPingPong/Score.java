import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class Score extends Rectangle {
    static int GAME_WIDTH;
    static int GAME_HEIGHT;

    // holds score for players
    int player1;
    int player2;

    Score(int GAME_WIDTH, int GAME_HEIGHT){
        Score.GAME_WIDTH = GAME_WIDTH;
        Score.GAME_HEIGHT = GAME_HEIGHT;

    }
    public void draw(Graphics graphics){
        graphics.setColor(Color.white);
        graphics.setFont(new Font("Times New Roman", Font.PLAIN, 60));

        graphics.drawLine(GAME_WIDTH / 2, 0, GAME_WIDTH / 2, GAME_HEIGHT);

        // will output the score on the game display with a special addition for adding a tens place for the score
        graphics.drawString(String.valueOf(player1/10)+String.valueOf(player1 % 10),(GAME_WIDTH / 2) - 85, 50);
        graphics.drawString(String.valueOf(player2/10)+String.valueOf(player2 % 10),(GAME_WIDTH / 2) + 20, 50);
    }
}
