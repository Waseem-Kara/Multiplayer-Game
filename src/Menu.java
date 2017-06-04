import java.awt.*;

/**
 * Created by Waz on 01/05/2017.
 */
public class Menu {

    //Font used for main titles
    Font font = new Font ("arial", Font.BOLD, 50);

    //Title of game across panel
    public void MainTitle(Graphics g, String text)
    {
        g.setFont(font);
        g.setColor(Color.white);
        g.drawString(text, 20, 50 );
    }

    //Display laps
    public void Laps(Graphics g, int laps)
    {
        //Create new font for title
        Font font = new Font("arial", Font.BOLD, 50);
        g.setFont(font);
        g.setColor(Color.white);
        g.drawString( "Laps : " + laps, 80, 80 );
    }

    //Collision notifier
    public void CollisionScreen(Graphics g)
    {
        Color c1 = Color.black;
        g.setColor( c1 );
        g.fillRect( 50, 100, 750, 500 ); //surrounding space

    }
}
