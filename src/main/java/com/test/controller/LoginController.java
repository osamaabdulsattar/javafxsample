package com.test.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class LoginController {

	@FXML
	private Text actiontarget;

	@FXML
	private TextField userName;

	@FXML
	private TextField password;

	@FXML
	protected void loginAction(ActionEvent event) {

		String userNameStr = userName.getText();
		String passwordStr = password.getText();

		if (userNameStr.equals("osama") && passwordStr.equals("123")) {
			actiontarget.setText("Welcome " + userNameStr);
			loadHome(event);
		} else {
			actiontarget.setText("Invalid Username or Password");
		}

		// Clear Password
		password.setText("");
	}

	private void loadHome(ActionEvent event) {
		Stage stage = (Stage) userName.getScene().getWindow();
		System.out.println("Setting stage:" + stage);
		// OR
		// Stage stageTheLabelBelongs = (Stage) label.getScene().getWindow();
		// these two of them return the same stage
		// Swap screen
		stage.setScene(new Scene(new Pane()));
	}

}