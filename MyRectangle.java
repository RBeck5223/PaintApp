package practice;

import java.awt.*;

//Rectangle inherited from Shape

public class MyRectangle extends MyShape
{
    public MyRectangle(int x1, int y1, Paint paint, boolean filled, boolean dashed, int width,
           float dashWidth)
    {
       super(x1, y1, paint, filled, dashed, width, dashWidth );
    }
    
    @Override                           //Overridden draw method
    public void draw(Graphics2D g)
    {
        int width = Math.abs(this.getX1() - this.getX2());
        int height = Math.abs(this.getY1() - this.getY2());
        int minX = this.getX1() < this.getX2() ? this.getX1() : this.getX2();
        int minY = this.getY1() < this.getY2() ? this.getY1() : this.getY2();
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
        
        if (this.isFilled())
        {
            g.fillRect(minX, minY, width, height);
        }
        else
        {
            g.drawRect(minX, minY, width, height);
        }
    }    
}