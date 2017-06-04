import javax.sound.sampled.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;

/**
 * Created by 1406646 on 15/03/2017.
 */

public class Panel extends JPanel implements ActionListener, KeyListener {
    //Create player 1 rocket
    Rocket rocket1 = new Rocket(350, 480, "ROcketimages\\rocket 1\\");

    //Create player 2 rocket
    Rocket rocket2 = new Rocket(350, 540, "ROcketimages\\rocket 2\\");
    public int currentImage = 0;
    Menu menu = new Menu();
    Arena arena = new Arena();

    //Default constructor
    public Panel() {

        //Start animation timer to refresh screen on delay
        Timer animationTimer = new Timer(40, this);
        animationTimer.start();
    }

    //Overide paintComponant method to draw objects to panel
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        //Draw arena
        arena.SetArena(g);
        //Draw ships
        InitialiseRocket(g);

        //Calculate laps
        if (rocket1.IsStartLine())
        {
            menu.Laps(g, rocket1.laps);
        } else if (rocket2.IsStartLine())
        {
            menu.Laps(g, rocket2.laps);
        }
    }

    //Draw rockets
    public void InitialiseRocket(Graphics g)
    {
        //Part 1 spin Rockets
        SpinRockets(g);
        //Render rockets
        rocket1.RenderRocket(g);
        rocket2.RenderRocket(g);

        //Display collision status
        if (rocket1.IsEdge() == true)
        {
            menu.MainTitle(g,"ROCKET 1 COLLISION DETECTED");
            //Sound("usat-bomb.wav\\");
        }
        else if (rocket2.IsEdge() == true)
        {
            menu.MainTitle(g,"ROCKET 2 COLLISION DETECTED");
            //Sound("usat-bomb.wav\\");
        }
        else if (rocket1.IsEdge() == false || rocket2.IsEdge() == false)
        //Draw game title
        {
            menu.MainTitle(g, "MULTIPLAYER RACE GAME");
        }

    }
    //Part 1 Spin ships
    public void SpinRockets(Graphics g)
    {
        //Wait until image is loaded
        if (rocket1.image[currentImage].getImageLoadStatus() == MediaTracker.COMPLETE) {
            //Draw rockets at specific locations
            rocket1.image[currentImage].paintIcon(null, g, 350,300);
            rocket2.image[currentImage].paintIcon(null, g, 450, 300);
            //Set current image to next
            currentImage = (currentImage + 1) % rocket1.totalImages;
        }
    }

    //Check rocket collision then end game
    public void RocketBoundary(javax.swing.JFrame frame)
    {
        if (rocket1.GetBoundary() == rocket2.GetBoundary())
        {
            System.err.println("it works");
            frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
        }
    }

    //Overide on key release
    public void keyReleased(KeyEvent e)
    {
        int key = e.getKeyCode();

        if (key == KeyEvent.VK_W)
        {
            //Play engine sound when accelerating
            Sound("engine-loop.wav\\");

        } else if (key == KeyEvent.VK_UP)
        {
            //Play engine sound when accelerating
            Sound("engine-loop.wav\\");
        }

    }
    //Overide method on key press
    public void keyPressed (KeyEvent e)
    {
        //Rocket 2 uses WASD
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_D)
        {
            //Rotate rocket clockwise
            rocket2.ShiftRight();;
        } else if(key == KeyEvent.VK_A)
        {
            //Rotate rocket anti-clockwise
            rocket2.ShiftLeft();

        } else if (key == KeyEvent.VK_S)
        {
            //Decrease speed
            rocket2.Decelerate();

        } else if (key == KeyEvent.VK_W)
        {
            //Increase speed
            rocket2.Accelerate();
        }

        //Rocket 1 uses arrow keys
        if (key == KeyEvent.VK_RIGHT)
        {
            //Rotate rocket clockwise
            rocket1.ShiftRight();
        } else if(key == KeyEvent.VK_LEFT)
        {
            //Rotate rocket anti-clockwise
            rocket1.ShiftLeft();

        } else if (key == KeyEvent.VK_DOWN)
        {
            //Decrease speed
           rocket1.Decelerate();

        } else if (key == KeyEvent.VK_UP)
        {
            rocket1.Accelerate();
        }
    }

    //Overide method on Key typed
    public void keyTyped (KeyEvent e)
    {

    }


    //Repaint screen on any action performed
    public void actionPerformed(ActionEvent e) {
        repaint();
    }

    //Create new sound stream
    public void Sound(String path)
    {
        try {
            AudioInputStream audio = AudioSystem.getAudioInputStream(new File("sounds\\" + path));
            AudioFormat format = audio.getFormat();
            DataLine.Info info = new DataLine.Info(Clip.class, format);
            Clip clip = (Clip) AudioSystem.getLine(info);
            clip.open(audio);
            clip.start();
        }

        //Print error message to console
        catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    }

