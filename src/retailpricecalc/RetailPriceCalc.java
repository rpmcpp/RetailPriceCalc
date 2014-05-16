/********************************************************
 *      Robert McGirr                                   *
 *      CSC-262                                         *
 *      Week 10     PC1, pg. 798                        *
 ********************************************************/
package retailpricecalc;

import javax.swing.*;
import java.awt.event.*;

/**
  * @author RPM
 */
public class RetailPriceCalc extends JFrame
{
   private JPanel panel;                    // A panel container
   private JLabel messageLabelCost;         // A message to prompt for cost
   private JLabel messageLabelMarkup;       // A message to prompt for markup
   private JTextField costTextField;        // To enter cost
   private JTextField markupTextField;      // To enter markup
   private JButton calcButton;              // Performs calculation
   private final int WINDOW_WIDTH = 400;    // Window width
   private final int WINDOW_HEIGHT = 150;   // Window height
    
    
    public RetailPriceCalc()
   {
      // Call the JFrame constructor and pass the title.
      super("Retail Price Calculator");

      // Set the size of this window.
      setSize(WINDOW_WIDTH, WINDOW_HEIGHT);

      // Specify what happens when the close button is clicked.
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      
      // Build the panel and add it to the frame.
      buildPanel();

      // Add the panel to the frame's content pane.
      add(panel);

      // Display the window.
      setVisible(true);
   }
    
   // Method to build panel 
    private void buildPanel()
   {
      // Create the label, text field, and button components.
      messageLabelCost = new JLabel("Enter the wholesale cost:");
      costTextField = new JTextField(10);
      messageLabelMarkup = new JLabel("Enter the markup percentage:");
      markupTextField = new JTextField(10);
      calcButton = new JButton("Calculate Retail Price");

      // Add an action listener to the button.
      calcButton.addActionListener(new CalcButtonListener());

      // Create a panel to hold the components.
      panel = new JPanel();
      
      // Add the labels, text fields, and button to the panel.
      panel.add(messageLabelCost);
      panel.add(costTextField);
      panel.add(messageLabelMarkup);
      panel.add(markupTextField);
      panel.add(calcButton);
   }
    
   // Inside class for Calculate button listener 
    private class CalcButtonListener implements ActionListener
   {
      @Override
      public void actionPerformed(ActionEvent e)
      {
         double wholesaleCost;      // To hold wholesale cost
         double markupPercentage;   // To hold markup percentage
         double retailPrice;        // To hold retail price

         // Get the wholesale cost entered in the
         // text field, convert to double
         wholesaleCost = Double.parseDouble(costTextField.getText());
         
         // Get the markup percentage entered in the
         // text field, convert to double
         markupPercentage = Double.parseDouble(markupTextField.getText());
         
         // Calculate retail price
         retailPrice = wholesaleCost * (1 + markupPercentage);

         // Display a message dialog showing the retail price
         JOptionPane.showMessageDialog(null, String.format("The retail price is $%.2f", retailPrice));

      }
   }
    
}
