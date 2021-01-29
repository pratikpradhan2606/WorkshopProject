import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ballanimator implements ActionListener {   


    int radius = 10; 
    int x = 50;
    int y = 50;
    int speedx;
    int speedy;
    int width = 100;
    int height = 100; 

    public void paintComponent(Graphics2D g)
    {
         super.paintComponent(g);
         g.setColor(Color.red);
         g.fillOval(50, 50, 10, 10);
    } 

    boolean animate = false; 
    boolean animateleftright = false;
    boolean animateupdown = false; 

    public void actionPerformed(ActionEvent arg0)
    {
        System.out.println("Animator pinged");

            if (animate)
            {
                if(animateleftright)
                {
                    if( x > (x-width) )  
                    {
                        x-=5;
                    }     
                    else if ( x == 0 ) 
                    {
                        x+=5;
                    }                           
                        x=x+x;

                        repaint(g); 
                }
                if(animateupdown)
                {
                    if( y > (y-height) ) 
                    {
                        y-=5;
                    }     
                    else if ( y == 0 )
                    {
                        y+=5;
                    }                           
                        y=y+y;

                        repaint(g);
               }
            }
    }

    public void putwindow()
    {

    }

}