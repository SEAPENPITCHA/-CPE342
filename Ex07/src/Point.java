
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;

   public class Point extends JPanel
    {
      public Color color;
      public Point() {
        this(Color.blue);
        setLocation(0,0);
        setSize(1,1);
      }

      public Point(Color c) {
        color = c;
        setLocation(0,0);
        setSize(1,1);
      }

      public Point(int s) {
         this(Color.blue);
         setSize(s,s);
      }

      public Point(int x, int y) {
         this(Color.blue);
         setLocation(x,y);
      }

     public Point(int x, int y,int s) {
        this(x, y);
        setSize(s, s);
      }

     public Point(int x,int y,int s,Color c) {
        this(x, y,s);
        color = c;
     }

     
     @Override
     public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
    
        g2d.setColor(this.color);
        g2d.fillRect(0, 0,1,1);
    }
}