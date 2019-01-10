package practice;

import java.awt.*;

// General Shape class, the superclass that Line, Oval and Rectangle inherit from

public abstract class MyShape 
{
    private int x1,x2,y1,y2, width;
    private float[] dashLength; 
    private float dashWidth[] = {5};
    private boolean filled, dashed;
    private Paint paint;
    
    public MyShape(int x1, int y1, Paint paint, boolean filled, boolean dashed, int width, float dashWidth)  //constructor
    {
        this.x1 = x1;
        this.x2 = x1;
        this.y1 = y1;
        this.y2 = y1;
        this.width = width;
        this.paint = paint;
        this.filled = filled;
        this.dashed = dashed;
        this.dashWidth[0] = dashWidth;
    }
   
    public abstract void draw(Graphics2D g); //abstract method draw
    
    //setters and getters
   
    public boolean isFilled()
    {
        return filled;
    }
    
    public void setFilled(boolean filled)
    {
        this.filled = filled;
    }
    
    public boolean isDashed()
    {
        return dashed;
    }
    
    public void setDashed(boolean dashed)
    {
        this.dashed = dashed;
    }
    
    public int getWidth()
    {
        return this.width;
    }
    
    public int getX1()
    {
        return x1;
    }
    
    public void setX1(int x1)
    {
        this.x1 = x1;
    }
    
    public int getY1()
    {
        return y1;
    }
    
    public void setY1(int y1)
    {
       this.y1 = y1;
    }
    
    public int getX2()
    {
        return x2;
    }
    
    public void setX2(int x2)
    {
      this.x2 = x2;
    }
    
    public int getY2()
    {
        return y2;
    }
    
    public void setY2(int y2)
    {
        this.y2 = y2;
    }
    
    public float[] getDashWidth()
    {
        return dashWidth;
    }
    
    public Paint getPaint()
    {
        return this.paint;
    }
}


