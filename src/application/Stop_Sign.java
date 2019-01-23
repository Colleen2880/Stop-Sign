package application;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class Stop_Sign extends Application {
	
		  @Override // Override the start method in the Application class
		  public void start(Stage primaryStage) {    
		    // create a new stackpane, set the scene to pane, and create our pop up window
		    Pane stackpane = new StackPane();
		    Scene scene = new Scene(stackpane,444,444);
		    primaryStage.setTitle("Stop Sign"); // Set the stage title
		    primaryStage.setScene(scene); // Place the scene in the stage
		    primaryStage.show(); // Display the stage

			// Create a label named text and set its properties
		    //used label instead of text, because text shows as a shape, this I could stack on top of the 
		    //polygon
		    Label stop = new Label("STOP");
		   
		    //make our STOP text white
		    stop.setTextFill(Color.WHITE);
		    
		    //create the font style, made the text bold, and determined how big the text will be
		    stop.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.REGULAR,128));
		    
		    //create a polygon named polygon
		    Polygon polygon = new Polygon();

		    //set the fill color to red, and we get our points
		    //we create constants width and height, and give formulas for center and radius
		    //we create an array that we will add points to our array below
			polygon.setFill(Color.RED);
			ObservableList<Double> points = polygon.getPoints();
			double width = 200, height = 200;
			double centerX = width/ 2, centerY = height/2; 
			double radius = Math.min(width, height);
			
			//for loop to add points to our polygon, we add the points to the array
			//we rotate our polygon, so our polygon has it's horizontal side up
			for(int i = 0; i < 8; i++){
				points.add(centerX + radius * Math.cos(2 * i * Math.PI/8));
				points.add(centerY - radius * Math.sin(2 * i* Math.PI/8));
				polygon.setRotate(i * 180/8);
			}
		    
			//we use addall to both our polygon and text to our stack pane, and the stack pane will print 
			//the two objects on top of each other creating the stop sign
		    stackpane.getChildren().addAll(polygon, stop);
		  }
		  
		  //launch the program
		  public static void main(String[] args) {
		    launch(args);
		  }
		}
		
