package application;

import java.util.Random;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class MainController{
  @FXML
  private Label label1 = new Label();
  @FXML
  private Label label2 = new Label();
  @FXML
  private TextField input = new TextField();
  @FXML
  private Label score = new Label();
  @FXML
  public Random generator = new Random();
  
  private int calc = 1;
  private int result = 0;
  private int score2 = 0;
  private int incorrect = 0;
  
  @FXML
  private void start(ActionEvent event)
  {
    if (this.calc == 1)
    {
      int number1 = this.generator.nextInt(9999);
      int number2 = this.generator.nextInt(9999);
      
      this.label1.setText(String.valueOf(number1));
      this.label2.setText("+   " + String.valueOf(number2));
      this.calc = 0;
      this.result = (number1 + number2);
    }
    else
    {
      int number1 = this.generator.nextInt(4999) + 5000;
      int number2 = this.generator.nextInt(5000);
      
      this.label1.setText(String.valueOf(number1));
      this.label2.setText("-   " + String.valueOf(number2));
      this.calc = 1;
      this.result = (number1 - number2);
    }
  }
  
  @FXML
  private void correction(ActionEvent event)
  {
    String text = this.input.getText();
    double secondNum = Double.parseDouble(text);
    if (secondNum == this.result)
    {
      this.label1.setText("GOOGJOB!!!");
      this.label2.setText("");
      this.score2 += 1;
      this.score.setText("correct: " + String.valueOf(this.score2) + "Incorrect: " + String.valueOf(this.incorrect));
    }
    else
    {
      this.label1.setText("The answer is");
      this.label2.setText(String.valueOf(this.result));
      this.incorrect += 1;
      this.score.setText("correct: " + String.valueOf(this.score2) + "    Incorrect: " + String.valueOf(this.incorrect));
    }
  }
  
  @FXML
  private void exit(ActionEvent event)
  {
    System.exit(0);
  }
}
