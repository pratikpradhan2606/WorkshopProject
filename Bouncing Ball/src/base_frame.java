import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
public class base_frame extends JFrame
{
     
    Container c;
     
    //our components
    JPanel b_panel;
    JButton b_add,b_sub;
    JLabel l_counter,l_ballsize;
    JTextField t_ballsize;
     
    //Actionlistener class instance
    handler handle;
     
    //class which contains drawing surface "JComponent"
    canvas ballcanvas;
     
    base_frame()
    {
        super("Ball Simulator");
        c=getContentPane();
         
        //setting to "flowlayout"
        c.setLayout(new FlowLayout());
         
        //all components
        t_ballsize=new JTextField(2);
        l_counter=new JLabel("Ball Count:  ");
        l_ballsize=new JLabel("Ball Size:  ");
        l_counter.setBorder(BorderFactory.createBevelBorder(1));
        b_add=new JButton("Add");
        b_sub=new JButton("Remove");
        handle=new handler();
        //adding actionlistener to buttons
        b_add.addActionListener(handle);
        b_sub.addActionListener(handle);
         
        //button panel 
        b_panel=new JPanel();//panel to hold buttons,textfields..
        b_panel.add(l_ballsize);//label
        b_panel.add(t_ballsize);//textfield to input ball size
        b_panel.add(b_add);//button to add a ball
        b_panel.add(b_sub);//button to del a ball (the most recent one)
        b_panel.add(l_counter);//label displaying total balls being rendered
         
        //ball canvas
        ballcanvas=new canvas(); 
         
        //container details
        c.add(ballcanvas);//adding drawing surface(ballcanvas) to main jframe
        c.add(b_panel);//adding the panel along with its smaller components
         
        //set visuals
        setSize(640,480);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
     
    }
    public static void main(String[] args)
    {
        new base_frame();//creating main jframe instance
    }
     
    //an inner class to take care of button events
    class handler implements ActionListener
    {
        public void actionPerformed(ActionEvent ae)
        {
            //if "Add" button clicked
            if(ae.getSource()==b_add)
            {
                if(!t_ballsize.getText().equals(""))
                {
                     
                    try{
                        ballcanvas.addBall(Integer.parseInt(t_ballsize.getText()));
                         
                        //updates the counter label
                        l_counter.setText("Ball Count:"+ballcanvas.countBall());
                    }catch(NumberFormatException e)
                    {
                        System.out.println(e);
                        JOptionPane.showMessageDialog(null,"Enter only numbers!","Invalid Input",JOptionPane.INFORMATION_MESSAGE);
                         
                    }
                     
                }
                else
                {
                    JOptionPane.showMessageDialog(null,"Enter the ball size!","Input needed",JOptionPane.INFORMATION_MESSAGE);
                }
            }//b_add
             
            //if "Sub" button clicked
            if(ae.getSource()==b_sub)
            {
                ballcanvas.removeBall();
                //updates the counter label
                l_counter.setText("Ball Count:"+ballcanvas.countBall());
            }
        }
    }
}