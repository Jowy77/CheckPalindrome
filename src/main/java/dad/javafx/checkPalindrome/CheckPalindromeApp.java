package dad.javafx.checkPalindrome;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class CheckPalindromeApp extends Application {

	private TextField nombreText;
	private Button comprobarButton;
	private Label resultadoLabel;

	public void start(Stage primaryStage) throws Exception {
		nombreText = new TextField();
		nombreText.setPromptText("Introduce una Sentencia");
		nombreText.setMaxWidth(150);

		resultadoLabel = new Label("resultado");

		comprobarButton = new Button("Comprobar");
		comprobarButton.setDefaultButton(true);
		comprobarButton.setOnAction(e -> onCheckPalindromeAction(e));

		VBox root = new VBox();
		root.setSpacing(25);
		root.setAlignment(Pos.CENTER);
		root.getChildren().addAll(nombreText, comprobarButton, resultadoLabel);

		Scene scene = new Scene(root, 320, 200);

		primaryStage.setTitle("CheckPalindrome");
		primaryStage.setScene(scene);
		primaryStage.show();

	}

	private void onCheckPalindromeAction(ActionEvent e) {

		String word = nombreText.getText();

		if (checkPalindrome(word)) {
			resultadoLabel.setText("Es un palindromo!!!");
			resultadoLabel.setStyle("-fx-text-fill: green;-fx-font: Italic bold 20 consolas;");
		}
		else {
		resultadoLabel.setText("No es palindromo");
		resultadoLabel.setStyle("-fx-text-fill: red;-fx-font: Italic bold 20 consolas;");
		}

	}

	public static void main(String[] args) {
		Application.launch(args);

	}

	boolean checkPalindrome(String inputString) {
		return inputString.equals(new StringBuilder(inputString).reverse().toString());
	}
}
