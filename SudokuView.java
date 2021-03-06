package csc143.sudoku;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.Observable;
import java.util.Observer;


/**
 * This is the primary graphic output component of the SudokuBoard
 * Takes a sudoku base and registers the sudoku view with the model
 * 
 * @author Amir Ali
 * @version July 31 2016
 *
 */
public class SudokuView extends SudokuBoard implements Observer, NumericSupport{

 //keeps track is view is in numberic mode
 private boolean numericFlag;
 
 /**
  * Constructor takes a sudoku base and passes it to sudoku board
  * also sets the flag for the givens and registers the sudoku view with the model
  * 
  * @param b SudokuBase to be passed to super class sudoku board
  */
 public SudokuView(SudokuBase b){
  super(b);
  //register the view with the model 
  b.addObserver(this);
  setFlagForGivens(); 
 }//end constructor
  
 /**
  * This method is called when the observed object(SudokuBase) is changed
  * 
  * @param o An observable object
  * @param arg Objects passed to method for notifying observers 
  */
 public void update(Observable o, Object arg) {
  setFlagForGivens(); 
  //when a change occurs repaint
  repaint();  
 }//end method update 
 
 /** Paint component method to draw the board from view*/
 public void paintComponent(Graphics g){
  super.paintComponent(g);
  super.numericFlag(numericFlag);
  setValuesAndFocus();
 }//end method paintComponent 
 
 /**
  * Method used to set the boolean field "isGiven" to true for correct cells
  */
 public void setFlagForGivens(){
  for(int row = 0; row < getBase().getSize(); row++){
   for(int col = 0; col < getBase().getSize(); col++){
    if(getBase().isGiven(row, col)) sudokuGrid[row][col].isGiven = true;
   }  
  }  
 }//end method setFlagGivens
 
 /** Method to set values and set Focus for appropriate squares, 
  * iterates through all squares on board 
  */
 public void setValuesAndFocus(){
  for(int row = 0; row < getBase().getSize(); row++){
   for(int col = 0; col < getBase().getSize(); col++){
    //set the value for each square
    sudokuGrid[row][col].value = getBase().getValue(row,col);
       if(sudokuGrid[row][col].selected) sudokuGrid[row][col].requestFocusInWindow();
   }  
  }   
 }//end method setValues

 /**
  * Method for numeric support
  * Sets mode to numbers
  */
 public void setNumeric(boolean flag) {
  numericFlag = flag; 
 }
 /** Method to see if view is in numeric mode*/
 public boolean showsNumeric() {
  return numericFlag;
 }
}//end class SudokuView

/**
 * This package private class is for practicing drawing. 
 * This class has drawing implementations for 13 symbols.
 * Mix of Arabic alphabet, numbers and Amharic alphabet
 * 
 * @author Amir Ali
 * @version HW5 
 *
 */
class PrimarySymbols implements SymbolRenderer {
 /**Default constructor with no parameters*/
 public PrimarySymbols(){}

 /**
     * Renders a single symbol for the Sudoku game
     * @param x The x-coordinate for the upper-left corner 
     * of the symbol area (40x40 pixels)
     * @param y The y-coordinate for the upper-left corner 
     * of the symbol area (40x40 pixels)
     * @param g The Graphics object used to draw the symbol
     * @param value The value to be drawn, between 0 and 12,
     * inclusive
     */
 public void drawSymbol(Graphics g, int x, int y, int value) {
  //To draw thick lines cast formal parameter g to type Graphics2D
  if(g instanceof Graphics2D){
   Graphics2D g2;
      g2 = (Graphics2D) g;
      //set the stroke thickness
      java.awt.Stroke s = new java.awt.BasicStroke(5);
      g2.setStroke(s);
  }  
  //Zeroth symbol, will be set to blank
  if(value == 0){}  
  //first symbol 
  if(value == 1){
   //x coordinates of symbol drawn as a polyline
   int[] xP = {x+5, x+5, x+35, x+35};
   //y coordinates of symbol drawn as a polyline
   int[] yP = {y+12, y+25, y+25, y+12};
   g.drawPolyline(xP,yP,4);
   //single point
   g.drawLine(x+20, y+32, x+20, y+32);
  }  
  //second symbol 
  if(value == 2){
   //x coordinates of symbol drawn as a polyline
   int[] xP = {x+5, x+5, x+35, x+35};
   //y coordinates of symbol drawn as a polyline
   int[] yP = {y+12, y+25, y+25, y+12};
   g.drawPolyline(xP,yP,4);
   //single points
   g.drawLine(x+25, y+15, x+25, y+15);
   g.drawLine(x+15, y+15, x+15, y+15);
   g.drawLine(x+20, y+8, x+20, y+8);
  }  
  //third symbol 
  if(value == 3){
   g.drawLine(x+8, y+6, x+31, y+6);
   g.drawArc(x+10, y+7, 37, 30, 90, 180);
   //single point
   g.drawLine(x+25, y+22, x+25, y+22);
  } 
  //fourth symbol
  if(value == 4){
   //x coordinates of symbol drawn as a polyline
   int[] xP = {x+32, x+9,x+9};
   //y coordinates of symbol drawn as a polyline
   int[] yP = {y+6, y+6,y+35};
   g.drawPolyline(xP,yP,3);        
  }  
  //fifth symbol
  if(value == 5){
   g.drawOval(x+5, y+5, 30, 30);   
  }  
  //sixth symbol
  if(value == 6){
   //line one
   g.drawLine(x+18, y+5, x+18, y+35);  
   //x coordinates of symbol drawn as a polyline
   int[] xP = {x+18, x+35,x+35,x+5};
   //y coordinates of symbol drawn as a polyline
   int[] yP = {y+23, y+23,y+35,y+35};
   g.drawPolyline(xP,yP,4);     
  }  
  //seventh symbol
  if(value == 7){
   //x coordinates of symbol drawn as a polyline
   int[] xP = {x+30, x+30,x+10,x+10};
   //y coordinates of symbol drawn as a polyline
   int[] yP = {y+5, y+33,y+33,y+25};
   g.drawPolyline(xP,yP,4);     
  }  
  //Eighth  symbol
  if(value == 8){
   //x coordinates of symbol drawn as a polyline
   int[] xP = {x+5, x+20,x+35};
   //y coordinates of symbol drawn as a polyline
   int[] yP = {y+35, y+5,y+35};
   g.drawPolyline(xP,yP,3); 
  }  
  //Ninth  symbol
  if(value == 9){
   //x coordinates of symbol drawn as a polyline
   int[] xP = {x+5, x+20,x+35};
   //y coordinates of symbol drawn as a polyline
   int[] yP = {y+5, y+35,y+5};
   g.drawPolyline(xP,yP,3); 
  }  
  //Tenth  symbol
  if(value == 10){
   //x coordinates of symbol drawn as a polyline
   int[] xP = {x+35, x+35,x+5,x+5};
   //y coordinates of symbol drawn as a polyline
   int[] yP = {y+5, y+35,y+35, y+5};
   g.drawPolyline(xP,yP,4);
   g.drawLine(x+20, y+5, x+20, y+35);
  } 
  //Eleventh  symbol
  if(value == 11){
   g.drawOval(x+5, y+5, 30, 18);
   g.drawLine(x+20, y+5, x+20, y+35);
  }
  //Twelfth  symbol
  if(value == 12){
   g.drawArc(x+5, y+20, 30, 30, 0, 180);
   g.drawLine(x+20, y+5, x+20, y+35);
  } 
 }//end method drawSymbol
}//end class PrimarySymbols

/**
 * This package private class is for numberic support 
 * Draws large font numbers onto each square
 * 
 * @author Amir Ali
 * @version HW5
 *
 */
class NumericSymbols implements SymbolRenderer {
 //font for displaying numbers that fill the sudoku square
 public static final Font largeFont = new Font ("Courier New", 1, 46);
 public static final Font mediumFont = new Font ("Courier New", 1, 38);
 
 /**Default constructor with no parameters*/
 public NumericSymbols(){}

 /**
     * Renders a single symbol for the Sudoku game
     * @param x The x-coordinate for the upper-left corner 
     * of the symbol area (40x40 pixels)
     * @param y The y-coordinate for the upper-left corner 
     * of the symbol area (40x40 pixels)
     * @param g The Graphics object used to draw the symbol
     * @param value The value to be drawn, between 0 and 12,
     * inclusive
     */
 public void drawSymbol(Graphics g, int x, int y, int value) {
  //To draw thick lines cast formal parameter g to type Graphics2D
  if(g instanceof Graphics2D){
   Graphics2D g2;
      g2 = (Graphics2D) g;
      //set the stroke thickness
      java.awt.Stroke s = new java.awt.BasicStroke(5);
      g2.setStroke(s);
  } 
  //do nothing for value of 0, default blank square
  if(value == 0){}  
  if(value == 1){
   g.setFont(largeFont);
   g.drawString("1", x+7, y+35);
  }  
  if(value == 2){
   g.setFont(largeFont);
   g.drawString("2", x+7, y+35);
  }  
  if(value == 3){
   g.setFont(largeFont);
   g.drawString("3", x+7, y+35); 
  } 
  if(value == 4){
   g.setFont(largeFont);
   g.drawString("4", x+7, y+35); 
  }  
  if(value == 5){
   g.setFont(largeFont);
   g.drawString("5", x+7, y+35);
  }  
  if(value == 6){
   g.setFont(largeFont);
   g.drawString("6", x+7, y+35);  
  }  
  if(value == 7){
   g.setFont(largeFont);
   g.drawString("7", x+7, y+35);   
  }  
  if(value == 8){
   g.setFont(largeFont);
   g.drawString("8", x+7, y+35);
  }  
  if(value == 9){
   g.setFont(largeFont);
   g.drawString("9", x+7, y+35);
  }  
  if(value == 10){
   g.setFont(mediumFont);
   g.drawString("10", x, y+35);
  } 
  if(value == 11){
   g.setFont(mediumFont);
   g.drawString("11", x, y+35);
  }
  if(value == 12){
   g.setFont(mediumFont);
   g.drawString("12", x, y+35);
  } 
 }//end method drawSymbol
}//end class NumericSymbol
