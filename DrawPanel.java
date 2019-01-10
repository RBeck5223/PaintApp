package practice;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

//Panel for the GUI components of the application

public class DrawPanel extends JPanel
{
    private ArrayList<MyShape> shapes;
    private int shapeType;
    private JLabel statusLabel;
    private Paint currentPaint;
    private Paint paint;
    private boolean filled;
    private boolean dashed;
    private int lineWidth;
    private float dashWidth;
    
    public DrawPanel(JLabel statusLabel)  //constructor
    {
       this.statusLabel = statusLabel;
        addMouseMotionListener(new MouseHandler());
        addMouseListener(new MouseHandler());
        this.shapeType = 0;
        this.paint = Color.BLACK;
        shapes = new ArrayList<MyShape>();
        this.filled = false;
        this.dashed = false;
        this.dashWidth = 5;
        this.lineWidth = 5;
    }
    
        @Override
        public void paintComponent(Graphics g)  //calls each shape's draw method
        {
            super.paintComponent(g);
            
             Graphics2D g2d = (Graphics2D) g;
            
            for (MyShape shape : shapes)
                shape.draw(g2d);
        }
        
        public int getLineWidth()                   //setters and getters
        {
            return this.lineWidth;
        }
        
        public void setShapeType(int shapeType)
        {
            this.shapeType = shapeType;
        }
        
        public void setFilled(boolean filled)
        {
            this.filled = filled;
        }
        
        public void setDashed(boolean dashed)
        {
            this.dashed = dashed;
        }
        
        public void setLineWidth(int lineWidth)
        {
            this.lineWidth = lineWidth;
        }
        
        public void setDashWidth(float dashWidth)
        {
            this.dashWidth = dashWidth;
        }
        
        public void setPaint(Color color1, Color color2, boolean gradient)
        {
            if (gradient)
            {
                this.paint = new GradientPaint(0, 0, color1, 50, 50, color2, true);
            }
            
            else
            {
                this.paint = color1;
            }
        }
        
        public void undo()
        {
            shapes.remove(shapes.size() - 1);
            repaint();
        }
        
        public void clear()
        {
            shapes.clear();
            repaint();
        }
        
        private class MouseHandler extends MouseAdapter implements MouseMotionListener       //event handling for using the mouse 
        { 
            MyShape shape;
            
            @Override
            public void mousePressed(MouseEvent event)
            {
                switch (shapeType)
                {
                    case 0 : shape = new MyLine(event.getX(), event.getY(), paint, filled, dashed, lineWidth, dashWidth);
                    break;
                    
                    case 1 : shape = new MyRectangle(event.getX(), event.getY(), paint, filled, dashed, lineWidth, dashWidth);
                    break;
                    
                    case 2 : shape = new MyOval(event.getX(), event.getY(), paint, filled, dashed, lineWidth, dashWidth);
                    break;
                }
               
                shapes.add(shape);
            }
            
            @Override
            public void mouseReleased(MouseEvent event)
            {
                repaint();
            }
            
            @Override
            public void mouseMoved(MouseEvent event)
            {
                statusLabel.setText("(" + Integer.toString(event.getX()) + "," + Integer.toString(event.getY()) + ")");
            }
            
            @Override
            public void mouseDragged(MouseEvent event)
            {
               shapes.get(shapes.size() - 1).setX2(event.getX());
               shapes.get(shapes.size() - 1).setY2(event.getY());
               repaint();

               statusLabel.setText("(" + Integer.toString(event.getX()) + "," + Integer.toString(event.getY()) + ")");
            }
        }
}
