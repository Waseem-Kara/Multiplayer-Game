import javax.swing.*;
import java.awt.*;

/**
 * Created by 1406646 on 15/03/2017.
 */
public class Frame extends JFrame {


    public Frame()
    {
        Panel panel = new Panel();
        JFrame frame = new JFrame("Racing game");
        panel.setBackground(Color.black);
        frame.add(panel);
        frame.setSize(850, 650);

        //Frame set to one size
        frame.setResizable(false);

        //Allow X to exit program
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Set frame to visible
        frame.setVisible(true);

        //Allow keyboard input
        frame.addKeyListener(panel);

        //Set frame to middle of the screen
        frame.setLocationRelativeTo(null);

        panel.RocketBoundary(frame);
    }

    public static void main(String[] args)
    {
        //Calls frame default constructor
        Frame frame = new Frame();

    }
}

