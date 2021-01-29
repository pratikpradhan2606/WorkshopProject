import java.awt.*;
import javax.swing.*;
import java.util.*;
public class canvas extends JComponent
{
    //display details   
    private final int width=512;
    private final int height=384;
     
    //ball array
    final private ArrayList<ball> ball_array;
     
    canvas()
    {
        ball_array=new ArrayList<ball>();
         
        setPreferredSize(new Dimension(width,height));
        setBorder(BorderFactory.createEtchedBorder(1));
    }
     
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        g.setColor(Color.BLACK);
         
        //fill rect
        g.fillRect(0,0,getWidth(),getHeight());
        try
        {
            //draw balls from ball_array
            for(int i=0;i<ball_array.size();i++)
            {
                ball_array.get(i).drawBall(g);
                //System.out.println("Drawing ball");
            }
            Thread.sleep(5);//to control animation speed
 
        }catch(InterruptedException e)
        {
            System.out.println("cannot control the paint thread!!");
        }
        repaint();//calls the paint method 
    }
     
    //to add a ball
    public void addBall(int size)
    {
        ball_array.add(new ball(size));
    }
     
    //to remove a ball
    public void removeBall()
    {
        if(!ball_array.isEmpty())
        {
            ball_array.remove(ball_array.size()-1);
        }
         
    }
     
    //return total balls from the array
    public int countBall()
    {
        return ball_array.size();
    }
     
    //Ball inner-class
    class ball
    {
        private int x_pos=0;
        private int y_pos=0;
        private int dir_x=1;
        private int dir_y=1;
        private int size;
         
        ball(int size)
        {
            this.size=size;
        }
         
        private void calculate_direction()
        {
            //move the ball
            x_pos=x_pos-dir_x;
            y_pos=y_pos-dir_y;
             
            //for X-direction
            if(x_pos<0)
            {
                x_pos=0;
                dir_x=-1;//incr
            }
            else
            if(x_pos+size>getWidth())
            {
                dir_x=1;//decr
            }
             
            //for Y-direction
            if(y_pos<0)
            {
                y_pos=0;
                dir_y=-1;//incr
            }else
            if(y_pos+size>getHeight())
            {
                dir_y=1;//decr
            }
        }
         
        public void drawBall(Graphics g)
        {
            calculate_direction();
            g.setColor(Color.WHITE);
            g.drawOval(x_pos,y_pos,size,size);
        }
    }
}