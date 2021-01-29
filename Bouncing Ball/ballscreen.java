import java.awt.*;
import javax.swing.*;

public class ballscreen extends JFrame {

    JButton lrbutton = new JButton("Left-Right");
    JButton udbutton = new JButton("Up-Down");
    JButton exitbutton = new JButton("Exit");
    JButton startbutton = new JButton("Start");
    JButton stopbutton = new JButton("Stop");
    JPanel ballpanel;
    JPanel controlpanel; 

    balllistener listener; 

    public ballscreen()
    { 
        setSize(300, 300);
        setTitle("Lab 8, Ball Mover"); 
        setLocation(500, 500); 

        Container content = getContentPane(); 
        content.setLayout(new BorderLayout(3, 0)); 

        content.add(ballpanel, BorderLayout.CENTER);
        content.add(controlpanel, BorderLayout.EAST);

        ballpanel.setSize(100, 100); 

        controlpanel.setLayout(new FlowLayout()); 
        controlpanel.add(lrbutton);
        controlpanel.add(udbutton);
        controlpanel.add(startbutton);
        controlpanel.add(stopbutton);
        controlpanel.add(exitbutton); 

        Dimension dim = new Dimension(100, 50);

        lrbutton.setPreferredSize(dim); 
        udbutton.setPreferredSize(dim);
        exitbutton.setPreferredSize(dim);
        startbutton.setPreferredSize(dim);
        stopbutton.setPreferredSize(dim);

         ((JFrame) content).setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setVisible(true);

    }
    public void putlistener(balllistener l)
    {
        listener = l;

        lrbutton.addActionListener(l);
        udbutton.addActionListener(l);
        exitbutton.addActionListener(l);
        startbutton.addActionListener(l);
        stopbutton.addActionListener(l);

    }

}
