import javax.swing.*;

/**
 * Created by 1406646 on 15/03/2017.
 */
public class Frame extends JFrame {

    private Frame()
    {
        /*// Sets the title for this frame.
        this.setTitle("Space Race");

        // Size of the frame.
        this.setSize(900, 700);
        // Puts frame to center of the screen.
        this.setLocationRelativeTo(null);
        // So that frame cannot be resizable by the user.
        this.setResizable(false);

        // Exit the application when user close frame.
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.setVisible(true);*/

        Panel panel = new Panel();
        JFrame frame = new JFrame("Space Race");

        frame.add(panel);
        frame.setSize(900, 700);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        panel.Animation();
    }

    public static void main(String[] args)
    {
        new Frame();
    }
}

