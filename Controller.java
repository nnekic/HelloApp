package application;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;

public class Controller {

	@FXML
	TextField UsernameTextField;
	@FXML
	PasswordField PasswordField;
	
	public void Login() throws Exception{
		String username = UsernameTextField.getText();
		String password = PasswordField.getText();
		String ip = IpAppRetrieve.getIp();
//		String ipInfo = ApiClient.sendGetRequest(ip); //ApiClient not needed. I'll use public IP
		String greeting = HelloSalut.Greeting(ip);
		
		
		if (username.isEmpty() || password.isEmpty()) {
            showAlert(Alert.AlertType.ERROR, "Error", "Please enter username and password");
        } else {
            showAlert(Alert.AlertType.INFORMATION, "Login Successful!", greeting + " " + username);
        }
    }
	
	public void Logout() {
		UsernameTextField.setText("");
		PasswordField.setText("");
	}
		
	
	
	private void showAlert(Alert.AlertType alertType, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
	
