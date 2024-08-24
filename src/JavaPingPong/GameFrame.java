import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

// GameFrame is the frame around the painting/GamePanel

public class GameFrame extends JFrame {
    GamePanel panel;

    GameFrame(){
        panel = new GamePanel();
        this.add(panel);
        this.setTitle("Ping Pong Gane");
        this.setResizable(false);
        this.setBackground(Color.black);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Causes this Window to be sized to fit the preferred size and layouts of its subcomponents.
        // The resulting width and height of the window are automatically enlarged if either of dimensions is
        // less than the minimum size as specified by the previous call to the setMinimumSize method
        this.pack();
        setVisible(true);


    }
}
