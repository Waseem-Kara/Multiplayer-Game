/**
 * Created by Waz on 30/04/2017.
 */
import java.awt.*;

public class Arena {

    //Draw arena as given within assinment description
    public void SetArena(Graphics g)
    {
        Color c1 = Color.white;
        g.setColor( c1 );
        g.fillRect( 50, 100, 750, 500 ); //surrounding space
        Color c2 = new Color(210, 105, 30); // RGB brown mix
        g.setColor( c2 );
        g.fillRect(150, 200, 550, 280); // asteroid
        Color c3 = Color.black;
        g.setColor( c3 );
        g.drawLine( 425, 480, 425, 600 ); // start line

    }
}
