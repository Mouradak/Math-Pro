package application;

import java.util.Random;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class MainController{
  @FXML
  private Label label1 = new Label();                         //First Number label
  @FXML
  private Label label2 = new Label();                         //Second Number label
  @FXML
  private TextField input = new TextField();                  //Field for answer
  @FXML
  private Label score = new Label();                          //Score 
  @FXML
  public Random generator = new Random();
  
  private int calc = 1;                                       //Variable decides addition or subtraction
  private int result = 0;
  private int score2 = 0;
  private int incorrect = 0;
  
  @FXML
  private void start(ActionEvent event)                             //Event -> activated when "Next Number" button is pressed
  {
    if (this.calc == 1)
    {
      int number1 = this.generator.nextInt(9999);                   //1st number randomly generated
      int number2 = this.generator.nextInt(9999);                   //2nd number randomly generated       
      
      this.label1.setText(String.valueOf(number1));                 //display 1st number
      this.label2.setText("+   " + String.valueOf(number2));        //display '+' and 2nd number
      this.calc = 0;
      this.result = (number1 + number2);                            //Sets 'result' = sum of 1st and 2nd numbers
    }
    else
    {
      int number1 = this.generator.nextInt(4999) + 5000;            //1st number randomly generated  (1st number must be larger than 2nd)
      int number2 = this.generator.nextInt(5000);                   //2nd number randomly generated
      
      this.label1.setText(String.valueOf(number1));                 //display 1st number
      this.label2.setText("-   " + String.valueOf(number2));        //display '-' and 2nd number
      this.calc = 1;
      this.result = (number1 - number2);                            //Sets 'result' = 1st - 2nd numbers
    }
  }
  
  @FXML
  private void correction(ActionEvent event)                        //Event -> activated when "Correct me" button is pressed
  {
    String text = this.input.getText();                             //Gets inputed result
    double secondNum = Double.parseDouble(text);
    if (secondNum == this.result)                                   //Checks if correct 'result' is equal to inputted result
    {                                                               //This case is for correct result
      this.label1.setText("GOODJOB!!!");
      this.label2.setText("");
      this.score2 += 1;                                             //Sets positive score
      this.score.setText("correct: " + String.valueOf(this.score2) + "Incorrect: " + String.valueOf(this.incorrect));
    }
    else
    {                                                               //This case is for correct result
      this.label1.setText("The answer is");
      this.label2.setText(String.valueOf(this.result));
      this.incorrect += 1;
      this.score.setText("correct: " + String.valueOf(this.score2) + "    Incorrect: " + String.valueOf(this.incorrect));
    }
  }
  
  @FXML
  private void exit(ActionEvent event)                              //Event -> Exit button is pressed
  {
    System.exit(0);
  }
}
