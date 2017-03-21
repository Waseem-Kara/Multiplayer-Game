import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by 1406646 on 15/03/2017.
 */
public class Panel extends JPanel implements ActionListener {

    //Array of spaceships
    ImageIcon spaceShipIcon[];
    //Number of images
    int imageAmount = 16;
    //Current image index
    int currentImage = 0;

    public void getIcons()
    {
        spaceShipIcon = new ImageIcon[imageAmount];

        for (int i = 0; i < spaceShipIcon.length; i++)
            spaceShipIcon[i] = new ImageIcon(getClass().getResource(
                    "C:\\Users\\Waz\\Desktop\\ROcketimages\\rocket 1\\" + "R" + i + ".png"));

    }

    public void paintComponent(Graphics graphics)
    {
        super.paintComponent(graphics);

        spaceShipIcon [currentImage].paintIcon(this, graphics, 0, 0);
        currentImage = currentImage + 1;
    }

    public void Animation()
    {
        getIcons();
        currentImage = 0;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();
    }
}
