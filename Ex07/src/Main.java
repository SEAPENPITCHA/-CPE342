
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


    public class Main {
         public static void main(String[] args) {
             TestSWT();
         }

        public static void TestSWT() {
             initialize();
         }

        public static void initialize() 
        {
            JFrame frame = new JFrame();
            frame.setBounds(100,100,450,300);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.getContentPane().setLayout(null);

            final JTextField textField = new JTextField();
        
            final JInternalFrame internalFrame = new JInternalFrame("New JInternalFrame");
            internalFrame.getContentPane().addMouseListener(new MouseAdapter() 
            
            {
        	
        	
            @Override
            
            public void mouseClicked(MouseEvent arg0) {
                textField.setText(internalFrame.toString());
            }
            
            });
            internalFrame.setBounds(10,55,420,200);
            frame.getContentPane().add(internalFrame);
            internalFrame.getContentPane().setLayout(null);
            
            Point p = new Point(10,10,2, Color.red);
            p.setBounds(p.getX(), p.getY(), p.getSize().height, p.getSize().width);
            internalFrame.getContentPane().add(p);
            
            final Circle cir = new Circle(0,0,20,Color.blue);
            cir.setBounds(cir.getX(), cir.getY(), cir.getDiameter(), cir.getDiameter());
            internalFrame.getContentPane().add(cir);
            internalFrame.setVisible(true);
            frame.setVisible(true);

            JPanel panel = new JPanel();
            panel.setBounds(10,0,414,54);
            frame.getContentPane().add(panel);
            
            JLabel lblNewLabel = new JLabel("New label");
            panel.add(lblNewLabel);
            
         
            
            panel.add(textField);
            textField.setColumns(25);
            textField.setText("here " + p.getLocation());
            

            ActionListener listener = new ActionListener() {
            	
                  int dx=5; //horizontal
                  int dy=5; //vertical 

            
            @Override
            
              public void actionPerformed(ActionEvent e) {
            	
                   Dimension size = internalFrame.getSize();
                   
                   Insets insets = internalFrame.getInsets();
                   int x = cir.getX() + dx;
                   int y = cir.getY() + dy;
                   int w = size.width - insets.left - insets.right;
                   int h = size.height - insets.top - insets.bottom;
                 

                
                   if (x < 0 || x + cir.getDiameter() > w) { //collision with left or right 
                      dx = -dx ; 
                   }

                
                   if (y < 0 || y + cir.getDiameter() > h) { //collision with top or bottom 
                     dy = -dy ; 
                  }

                     cir.setLocation(x, y);
                  }
            
                  };
                  
                     cir.setLocation(0,0);
                  
                     Timer displayTimer = new Timer (50,listener);
                  
                      displayTimer.start();
                      
    }
}