/**********************************************************************
 * A Memory Game GUI
 * 
 * Creates buttons for displaying strings and provides a UI for
 * gathering user input
 *
 * V1.0
 * 6/1/2019
 * Copyright(c) 2019 PLTW to present. All rights reserved
 **********************************************************************/
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * Class to play Memory Game.
 */
public class MemoryGameGUI extends JFrame 
{
  // used internally by the GUI
  private static final long serialVersionUID = 100L;

  // instance variables
  private JButton gameButtons[];


  
  private Boolean playRandom;

  /**
   * Class constructor for creating a GUI for the Memory Game. 
   * Create a game board with the createBoard method and play the game by
   * providing a sequence of strings to playSequence.
   */
  public MemoryGameGUI()
  {
    super();
    setResizable(false);
    setFocusable(true);
  }
 
  /**
   * Create a game board of buttons that will display strings from a given sequence.
   * After you create the board, you can play the game by calling the playSequence method.
   * <P>
   * Initial condition: The number of buttons should be positive and should not exceed the width of the screen
   * 
   * @param numButtons Number of buttons to display on a horizontal board
   * @param playRandom If true, during play, the buttons will display text in a random order,
   *          if false, they will show from left to right.
   */
  public void createBoard(int numButtons, Boolean playRandom)
  {
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setSize(500, 400);

    // create buttons
    gameButtons = new JButton[numButtons];
    JPanel panel1 = new JPanel();

  
    panel1.setLayout(new FlowLayout());
   

    for (int i = 0; i < numButtons; i++) {
      gameButtons[i] = new JButton();
      gameButtons[i].setPreferredSize(new Dimension(100,100));
      gameButtons[i].setBackground(Color.gray);
      panel1.add(gameButtons[i]);
     
    }
  
    
    // organize and size the GUI
    Container pane = getContentPane();
    pane.add(panel1,  BorderLayout.PAGE_START);

  
   
    Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
    setLocation(dim.width/2 - 100, dim.height/2 - 100);
    pack();
    setVisible(true);

    // specify random or not
    this.playRandom = playRandom;

    JOptionPane.showMessageDialog(this, "Welcome to the Memory Game", "Welcome", JOptionPane.PLAIN_MESSAGE);
  }

  
  /**
   * Play the game by showing buttons with the text from a randomly ordered sequcence
   * of strings. The button text may appear in order from left to right
   * or may appear on random buttons throughout the board.
   * <P>
   * Initial condition: sequence should be not empty/null and already radmondized 
   * 
   * @param sequence an array of strings to show as individual button text
   * @param delay how long the text will show, measured in tenths of a second
   * @return a string containing the users guess, or null if the user cancels
   */
  public String playSequence(String[] sequence, double delay)
  {
    delay *= 1000;
    JOptionPane.showMessageDialog(this, "Click when ready!", "Ready to Play?", JOptionPane.PLAIN_MESSAGE);

    // show each memory strings on a botton
    int buttonNum = -1; 
    for (int i = 0; i < sequence.length; i++ )
    {
      if (playRandom)
      {
        buttonNum = (int)(Math.random() * gameButtons.length);
      }
      else
      {
        buttonNum += 1;
        if (buttonNum > gameButtons.length-1)
        buttonNum = 0;
      }

      // wait a bit
      // a try is like an if statement, "throwing" an error if the body of the try fails
      try
      {
        Thread.sleep((int)delay);
      } catch (InterruptedException ie) { /* do nothing */ }

      // change button color and show the memory string
      gameButtons[buttonNum].setBackground(new Color(230, 204, 255));
      gameButtons[buttonNum].setText(sequence[i]);

      // wait a bit
      try
      {
        Thread.sleep((int)delay);
      } catch (InterruptedException ie) { /* do nothing */ }

      // show button as gray again and clear the memory string from it
      gameButtons[buttonNum].setBackground(Color.gray);
      gameButtons[buttonNum].setText("");
    }
    
    JFrame frame = new JFrame();
    String seq = JOptionPane.showInputDialog(frame, "What is the sequence?");

    return seq;
  }
  /**
   * Prompts the User on how many rounds they would like to play
   * @num stores the value of this and returns it back
   */
  public Integer numRounds(){
    JFrame frame = new JFrame();
    String seq = JOptionPane.showInputDialog(frame, "How many rounds would you like to play?");
    int num = Integer.parseInt(seq);
     return num;
  }
  public String additionalSet(){
    JFrame frame = new JFrame();
    String seq = JOptionPane.showInputDialog(frame, "Do you have an additional Data set?(y/n): ");
    //int num = Integer.parseInt(seq);
     return seq;
  }
  public String seeData(){
    JFrame frame = new JFrame();
    String seq = JOptionPane.showInputDialog(frame, "Do you have an additional Data set?(y/n): ");
    //int num = Integer.parseInt(seq);
     return seq;
  }
  public void stateCat(){
    JOptionPane.showMessageDialog(this, "Get data values ready to enter", "Speed Data Values", JOptionPane.PLAIN_MESSAGE);
  }
  public void SpeedmeterProject(){
    JOptionPane.showMessageDialog(this, "Welcome to the Speedomter Project", "Speedmeter Project", JOptionPane.PLAIN_MESSAGE);
  }
  public void stateCat2(){
    JOptionPane.showMessageDialog(this, "Get Speed Limit Data ready to enter", "Speed Limit Data Values", JOptionPane.PLAIN_MESSAGE);
  }
  public void stateCat3(){
    JOptionPane.showMessageDialog(this, "", "End result", JOptionPane.PLAIN_MESSAGE);
  }
  public void stateEndResult(String S){
    setSize(1000, 1000);
    JOptionPane.showMessageDialog(this, S, "End result", JOptionPane.PLAIN_MESSAGE);
  }
  public void finalResult(String S){
    setSize(1000, 1000);
    JOptionPane.showMessageDialog(this, S, "Final result", JOptionPane.PLAIN_MESSAGE);
  }
  public void DataDisplay(int n1, int n2, int n3){
    setSize(1000, 1000);
    JOptionPane.showMessageDialog(this, " Data value #"+n1+": "+"["+ n2 +","+ n3 +"]", "Data Values", JOptionPane.PLAIN_MESSAGE);
  }



  public Integer DriveDuration(){
    JFrame frame = new JFrame();
    //JOptionPane.showMessageDialog(this, "Speedomter Category", "Speed Data Values", JOptionPane.PLAIN_MESSAGE);
    String seq = JOptionPane.showInputDialog(frame, "How long was your drive (minutes):  ");
    int num = Integer.parseInt(seq);
     return num;
  }

  public Integer GasStationVists(){
    JFrame frame = new JFrame();
    //JOptionPane.showMessageDialog(this, "Speedomter Category", "Speed Data Values", JOptionPane.PLAIN_MESSAGE);
    String seq = JOptionPane.showInputDialog(frame, "How many times do you visit a gas station every week:  ");
    int num = Integer.parseInt(seq);
     return num;
  }






  public Integer dataValSpeedAmount(){
    JFrame frame = new JFrame();
    //JOptionPane.showMessageDialog(this, "Speedomter Category", "Speed Data Values", JOptionPane.PLAIN_MESSAGE);
    String seq = JOptionPane.showInputDialog(frame, "How many changes in speed limits where there: ");
    int num = Integer.parseInt(seq);
     return num;
  }
  public Integer dataValSpeed(){
    JFrame frame = new JFrame();
    //JOptionPane.showMessageDialog(this, "Speedomter Category", "Speed Data Values", JOptionPane.PLAIN_MESSAGE);
    String seq = JOptionPane.showInputDialog(frame, "Enter the speed limit(mph): ");
    int num = Integer.parseInt(seq);
     return num;
  }
  public Integer dataValSpeedDuration(){
    JFrame frame = new JFrame();
    //JOptionPane.showMessageDialog(this, "Speedomter Category", "Speed Data Values", JOptionPane.PLAIN_MESSAGE);
    String seq = JOptionPane.showInputDialog(frame, "Enter the speed limit duration(min): ");
    int num = Integer.parseInt(seq);
     return num;
  }
  public Integer dataVal(int n){
    JFrame frame = new JFrame();
    //JOptionPane.showMessageDialog(this, "Speedomter Category", "Speed Data Values", JOptionPane.PLAIN_MESSAGE);
    String seq = JOptionPane.showInputDialog(frame, "Enter data Value #: "+ n);
    int num = Integer.parseInt(seq);
     return num;
  }
  /**
   * Shows a message that the user matched the sequence
   */
  public void matched()
  { 
    JOptionPane.showMessageDialog(this, "You matched!", "Congratulations", JOptionPane.PLAIN_MESSAGE);
  }
    
  /**
   * Asks the user if they want to play another round of the game.
   * 
   * @return true to continue playing, false to quit 
   * 
   */
  public boolean playAgain()
  {
    int n = JOptionPane.showConfirmDialog(this, "Do you want to play again?", "Memory Game", JOptionPane.YES_NO_OPTION);
    if (n == JOptionPane.YES_OPTION )
      return true;
    return false;
  }
  /**
   * Prompts the player whether or not they want to play the Hard verision of the Memory Game
   */
  public boolean Easy_Hard()
  {
    int n = JOptionPane.showConfirmDialog(this, "Do you want to play the hard mode of this game?", "Memory Game", JOptionPane.YES_NO_OPTION);
    if (n == JOptionPane.YES_OPTION )
      return true;
    return false;
  }/**
   * Prompts User to choose on whether they would like the time to decrease as the individual Rounds between the games progress
   */
  public boolean ChangeTime()
  {
    int n = JOptionPane.showConfirmDialog(this, "Do you want to have a shorter amount of time as the game progresses?", "Memory Game", JOptionPane.YES_NO_OPTION);
    if (n == JOptionPane.YES_OPTION )
      return true;
    return false;
  }
  /**
   * Prompts User on whether they would like to have the times randomized, this is the boolean input that the createboard function will take
   */
  public boolean isRand()
  {
    int n = JOptionPane.showConfirmDialog(this, "Do you want to have the tiles randomized for this game??", "Memory Game", JOptionPane.YES_NO_OPTION);
    if (n == JOptionPane.YES_OPTION )
      return true;
    return false;
  }
  /**
   * Prompts User on whether thyw want the letters themselves changed so that they could have a more randomized and non-patternistic expirience as they continue playing
   */
  public boolean isRand2()
  {
    int n = JOptionPane.showConfirmDialog(this, "Do you want to have the WORDS randomized for this game??", "Memory Game", JOptionPane.YES_NO_OPTION);
    if (n == JOptionPane.YES_OPTION )
      return true;
    return false;
  }
  

  /**
   * Show the current score and the number of times the game was played.
   * 
   * @param score number of correct guesses
   * @param rounds number of times game was played
   */
  public void showScore(int score, int rounds)
  {
    JOptionPane.showMessageDialog(this, "You scored " + score + " out of " + rounds, "Score Summary", JOptionPane.PLAIN_MESSAGE);
  }
  
  /**
   * Shows the end message where it will interate through all the games that you played over time and it will determine which game was the best based on the percent accuracy that the player had
   *   the parameters are Double arr[][], int n
   */
  

  public void conclusion(Double arr[][], int n)
  {
    JOptionPane.showMessageDialog(this, "int total, you completed " + n + " different games " , "Game Report", JOptionPane.PLAIN_MESSAGE);

   Double bestAcc = 0.0;
    for(int i = 0; i < n; i++){
      Double q = 100*(arr[i][0]/arr[i][1]); 
      
      JOptionPane.showMessageDialog(this, "GAME #" + (i+1) + ": Score was "+arr[i][0]+", Total Rounds were "+arr[i][1]+". Accuracy was "+String.format("%.2f", q) , "", JOptionPane.PLAIN_MESSAGE);
   }
   for(int i = 0; i < n; i++){
    Double q = 100*(arr[i][0]/arr[i][1]); 
      
   if(bestAcc < q){
     
     bestAcc = q;
   }
 }
 JOptionPane.showMessageDialog(this, "Best Game Accuracy was "+String.format("%.2f", bestAcc)  ,"", JOptionPane.PLAIN_MESSAGE);
  }
  public void tryAgain()
  { 
    JOptionPane.showMessageDialog(this, "Try again...", "Oops", JOptionPane.PLAIN_MESSAGE);
  }

  /**
   * Close the board, ending the game.
   */
  public void quit()
  {
    this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
  }
  


}
