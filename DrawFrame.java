
package practice;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

//this class creates a JFrame for GUI component panel and provides event handling

public class DrawFrame extends JFrame
{
    private final JPanel wholePanel;
    private JButton undoButton; 
    private JButton clearButton;
    private JComboBox<String> shapeOptions;
    private JCheckBox filledBox;
    private JCheckBox gradientBox;
    private JCheckBox dashedBox;
    private JButton color1Button;
    private JButton color2Button;
    private JColorChooser color1Chooser;
    private JColorChooser color2Chooser;
    private JTextField lineWidth;
    private JTextField dashLength;
    private Color color1 = Color.BLACK;
    private Color color2 = Color.BLACK;
    private DrawPanel drawPanel;
    
    public DrawFrame()
    {
        wholePanel = new JPanel();
        JPanel menu1 = new JPanel();
        JPanel menu2 = new JPanel();
        
        undoButton = new JButton("Undo");
        menu1.add(undoButton);
        undoButton.addActionListener(new UndoButtonHandler());
        
        clearButton = new JButton ("Clear");
        menu1.add(clearButton);
        clearButton.addActionListener(new ClearButtonHandler());
        
      
        
        String[] shapeChoices = {"Line", "Rectangle", "Oval"};
        shapeOptions = new JComboBox<String>(shapeChoices);
        menu1.add(shapeOptions);
        shapeOptions.addActionListener(new ShapeChoiceHandler());
        
        filledBox = new JCheckBox("Filled");
        menu1.add(filledBox);
        filledBox.addActionListener(new FilledBoxListener());
        
        gradientBox = new JCheckBox("Gradient");
        gradientBox.addActionListener(new GradientBoxListener());
        menu2.add(gradientBox);
        
        color1Button = new JButton("Color 1");
        color2Button = new JButton("Color 2");
        color1Button.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
                color1 = JColorChooser.showDialog(DrawFrame.this, "Choose a color", color1);
                drawPanel.setPaint(color1, color2, gradientBox.isSelected());
            }
        });
        
        color2Button.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
                color2 = JColorChooser.showDialog(DrawFrame.this, "Choose a color", color1);
                drawPanel.setPaint(color1, color2, gradientBox.isSelected());
            }
        });
        
        menu2.add(color1Button);
        menu2.add(color2Button);
        
        lineWidth = new JTextField();
        lineWidth.setColumns(2);
        lineWidth.addActionListener(new WidthUpdateListener());
        menu2.add(new JLabel("Line Width: "));
        menu2.add(lineWidth);
        
        dashLength = new JTextField();
        dashLength.setColumns(2);
        dashLength.addActionListener(new DashWidthUpdateListener());
        menu2.add(new JLabel("Dash Length: "));
        menu2.add(dashLength);
        
        dashedBox = new JCheckBox("Dashed");
        dashedBox.addActionListener(new DashedBoxListener());
        menu2.add(dashedBox);
        
        JLabel coordinates = new JLabel();
        drawPanel = new DrawPanel(coordinates);
        drawPanel.setBackground(Color.WHITE);
        
        JPanel menu = new JPanel();
        menu.setLayout(new BorderLayout());
       
        menu.add(menu1, BorderLayout.NORTH);
        menu.add(menu2, BorderLayout.SOUTH);
        
        wholePanel.setLayout(new BorderLayout());
        wholePanel.add(menu, BorderLayout.NORTH);
        wholePanel.add(drawPanel, BorderLayout.CENTER);
        wholePanel.add(coordinates, BorderLayout.SOUTH);
        add(wholePanel);
        }
    
    private class UndoButtonHandler implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent event)
        {
            drawPanel.undo();
        }
    }
    
    private class ClearButtonHandler implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent event)
        {
            drawPanel.clear();
        }       
    }
    

    
    private class ShapeChoiceHandler implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent event)
        {
            drawPanel.setShapeType(shapeOptions.getSelectedIndex());
        }
    }
        
    private class FilledBoxListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent event)
        {
            drawPanel.setFilled(filledBox.isSelected());
        }
    }   
    
    private class DashedBoxListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            drawPanel.setDashed(dashedBox.isSelected());
        }
    }
    
    private class WidthUpdateListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            drawPanel.setLineWidth(Integer.parseInt(lineWidth.getText()));
        }
    }
    
    private class DashWidthUpdateListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            drawPanel.setDashWidth(Float.parseFloat(dashLength.getText()));
        }
    }
    
    private class GradientBoxListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            drawPanel.setPaint(color1, color2, gradientBox.isSelected());
        }
    }
}
    

