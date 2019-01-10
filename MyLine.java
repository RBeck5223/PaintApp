package practice;

import java.awt.*;

//Line inherited from 

public class MyLine extends MyShape
{
    public MyLine(int x1, int y1, Paint paint, boolean filled, boolean dashed, int width,
           float dashWidth)
    {
       super(x1, y1, paint, filled, dashed, width, dashWidth );
    }
    
    @Override                               //Overridden draw method
    public void draw(Graphics2D g)
    {
        g.setPaint(this.getPaint());
        
        Stroke stroke;
        
        if (this.isDashed())
        {
            stroke = new BasicStroke(this.getWidth(), BasicStroke.CAP_ROUND, BasicStroke.JOIN_BEVEL,
            10, this.getDashWidth(), 0);
        }
        
        else
        {
            stroke = new BasicStroke(this.getWidth(), BasicStroke.CAP_ROUND, BasicStroke.JOIN_BEVEL);
        }
        
        g.setStroke(stroke);
        g.drawLine(this.getX1(), this.getY1(), this.getX2(), this.getY2());
    }    
}
