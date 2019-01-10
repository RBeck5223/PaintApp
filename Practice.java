
package practice;

import javax.swing.JFrame;

public class Practice 
{
    public static void main(String[] args) //main function, instantiates a DrawFrame
    {
       DrawFrame drawFrame = new DrawFrame();
       drawFrame.setVisible(true);
       drawFrame.setSize(750, 500);
       drawFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
