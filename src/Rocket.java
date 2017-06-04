import sun.java2d.loops.DrawLine;

import javax.swing.*;
import java.awt.*;
import java.util.*;

/**
 * Created by G33 on 24/03/2017.
 */
public class Rocket{

    private float x;
    private float y;
    public float speed;
    public int laps = 0;
    public int currentImage = 0;
    public final float topSpeed = 10;
    public ImageIcon[] image;
    private ImageIcon currentIndex;
    public final int totalImages = 16;
    public int direction;
    //Flag to detect boundary
    private boolean isEdge;
    //use titles in Rocket class
    Menu menu = new Menu();

    //arena space colider
    Rectangle arena = new Rectangle(50, 100, 750, 500);
    //arena asteroid collider
    Rectangle asteroid = new Rectangle(150, 200, 550, 280);
    //Start line
    Rectangle startLine = new Rectangle(425, 480, 1, 30);


    //Default constructor
    public Rocket(int x, int y, String path){
        //Initialse rocket
       LoadRocket(path);

        //Set starting icon to 90 degrees
       currentIndex = image[4];
       direction = 4;
       //Starting speed is null
       speed = 0;
       this.x = x;
       this.y = y;
    }


    //Load Rocket into array
    public void LoadRocket(String path)
    {
        //Load rocket icons
        image = new ImageIcon[totalImages];
        for (int i = 0; i < image.length; i++){
            image[i] = new ImageIcon(path + "R" + i + ".png");
        }
    }

    //Set boundry of rocket 50 x 50
    public Rectangle GetBoundary() {
        return new Rectangle((int) x, (int) y, 50, 50);
    }

    //Decelerate rocket to a halt
    public void Decelerate(){
        if (speed > 0){this.speed -= 2;}
    }

    //Accelerate rocket to topSpeed
    public void Accelerate(){
        if (speed < topSpeed){this.speed += 2;}
    }

    //Rotate rocket anti-clockwise
    public void ShiftLeft(){

        if (Arrays.asList(image).indexOf(currentIndex) == 0){
            currentIndex = image[15];
        }

        currentIndex = image[Arrays.asList(image).indexOf(currentIndex) - 1];
        direction = Arrays.asList(image).indexOf(currentIndex);
        if (direction < 0) {
            direction = 16;
        }
    }

    //Rotate rocket clockwise
    public void ShiftRight(){

        //if image is at las index return 0
        if (Arrays.asList(image).indexOf(currentIndex) == 15){
            currentIndex = image[0];
        }
        currentIndex = image[Arrays.asList(image).indexOf(currentIndex) + 1];
        direction = Arrays.asList(image).indexOf(currentIndex);
        if (direction > 16) {
            direction = 0;
        }
    }

    //Paint Rocket with x and y position
    public void RenderRocket(Graphics g){

        //Detect edge of arena or asteriod
        if (IsEdge()){
            //When edge is true set speed to 0
            if (!isEdge){
                speed = 0;
                isEdge = true;
                //Notify on collision
                //menu.CollisionScreen(g);
            }
        }

        //if rocket is moving calculate new co-ordinates
        if (speed > 0){
            //IsStartLine(g);
            isEdge = false;
            double delta = speed * 0.4f;


            if (direction == 0){
                y -= 2 * delta;
            }
            else if (direction == 1){
                y -= 2 * delta;
                x += 1 * delta;
            }
            else if (direction == 2){
                x += 2 * delta;
                y -= 2 * delta;
            }
            else if (direction == 3){
                x += 2 * delta;
                y -= 1 * delta;
            }
            else if (direction == 4){
                x += 2 * delta;
            }
            else if(direction == 5){
                x += 2 * delta;
                y += 1 * delta;
            }
            else if(direction == 6){
                x += 2 * delta;
                y += 2 * delta;
            }
            else if(direction == 7){
                x += 1 * delta;
                y += 2 * delta;
            }
            else if(direction == 8){
                y += 2 * delta;
            }
            else if(direction == 9){
                x -= 1 * delta;
                y += 2 * delta;
            }
            else if(direction == 10){
                x -= 2 * delta;
                y += 2 * delta;
            }
            else if(direction == 11){
                x -= 2 * delta;
                y += 1 * delta;
            }
            else if(direction == 12){
                x -= 2 * delta;
            }
            else if(direction == 13){
                x -= 2 * delta;
                y -= 1 * delta;
            }
            else if(direction == 14){
                x -= 2 * delta;
                y -= 2 * delta;
            }
            else if(direction == 15){
                x -= 1 * delta;
                y -= 2 * delta;
            }
        }
        //Draw image even if speed is < 0
        g.drawImage(currentIndex.getImage(), (int) x, (int) y,null);

    }

    public boolean IsStartLine()
    {
        if (this.GetBoundary().intersects(startLine.getBounds()))
        {
            laps++;
            return true;
        }
        return false;
    }

    public boolean IsEdge() {

        //check for collision with asteroid
        if (this.GetBoundary().intersects(asteroid.getBounds()))
        {
            //isCollision
            return true;

        }
        //Detect edge of arena
        else if ( GetBoundary().getMaxX() >= arena.getMaxX() || GetBoundary().getMinX() <= arena.getMinX()
                ||GetBoundary().getMaxY() >= arena.getMaxY() || GetBoundary().getMinY() <= arena.getMinY()){
            //isCollision
            return true;
        }

        //no collision detected
        return false;
    }

    //Messagebox to display notifications
    public static void MessageBox(String infoMessage, String titleBar)
    {
        JOptionPane.showMessageDialog(null, infoMessage, titleBar, JOptionPane.INFORMATION_MESSAGE);
    }

    public float GetX()
    {
        return x;
    }

    public float GetY()
    {
        return y;
    }
}
