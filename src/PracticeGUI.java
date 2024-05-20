import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class PracticeGUI extends Application {

    @Override
    public void start(Stage primaryStage) {

        primaryStage.setTitle("Practice #3: GUI Practice");

        // Create a GridPane with padding and spacing
        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(20));
        gridPane.setHgap(10);
        gridPane.setVgap(10);

        // Add a title at the top
        Text titleText = new Text("Milestone Calculator");
        titleText.setFont(Font.font("Arial", FontWeight.BOLD, 20));
        gridPane.add(titleText, 0, 0, 2, 1); // Add the title spanning two columns

        // Labels and text fields for milestone points
        Label milestone1Label = new Label("Milestone 1:");
        TextField milestone1Field = new TextField();
        milestone1Field.setPromptText("Enter points (max 25)");
        gridPane.addRow(1, milestone1Label, milestone1Field);

        Label milestone2Label = new Label("Milestone 2:");
        TextField milestone2Field = new TextField();
        milestone2Field.setPromptText("Enter points (max 40)");
        gridPane.addRow(2, milestone2Label, milestone2Field);

        Label terminalAssessmentLabel = new Label("Terminal Assessment:");
        TextField terminalAssessmentField = new TextField();
        terminalAssessmentField.setPromptText("Enter points (max 35)");
        gridPane.addRow(3, terminalAssessmentLabel, terminalAssessmentField);

        // Label to display result
        Label resultLabel = new Label();
        resultLabel.setFont(Font.font("Arial", FontWeight.BOLD, 14));
        Button calculateButton = new Button("Calculate");
        calculateButton.setOnAction(e -> {
            int milestone1Points = Integer.parseInt(milestone1Field.getText());
            int milestone2Points = Integer.parseInt(milestone2Field.getText());
            int terminalAssessmentPoints = Integer.parseInt(terminalAssessmentField.getText());

            // Check if entered points exceed maximum
            if (milestone1Points > 25 || milestone2Points > 40 || terminalAssessmentPoints > 35) {
                resultLabel.setText("Error: Points exceed maximum!");
            } else {
                // Calculate total grade
                double totalGrade = (milestone1Points / 25.0) * 0.3 +
                        (milestone2Points / 40.0) * 0.4 +
                        (terminalAssessmentPoints / 35.0) * 0.3;
                resultLabel.setText("Total Grade: " + (totalGrade * 100) + "%");
            }
        });

        // Add the Calculate button and result label
        HBox buttonBox = new HBox(10);
        buttonBox.getChildren().addAll(calculateButton, resultLabel);
        gridPane.add(buttonBox, 0, 4, 2, 1); // Add the button and result label spanning two columns

        // Create the scene and set it to the stage
        Scene scene = new Scene(gridPane, 400, 250);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
