package com.test;

import java.io.IOException;
import java.net.URL;

import com.test.controller.LoginControllerTest;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainApplication extends Application {

	private static final String RESOURCE_FILE_NAME = "login_form.fxml";

	private static final URL RESOURCE = MainApplication.class.getClassLoader().getResource(RESOURCE_FILE_NAME);

	@Override
	public void start(Stage stage) throws IOException {

		Parent root = FXMLLoader.load(RESOURCE);

		Scene scene = new Scene(root, 300, 275);

		stage.setTitle("Welcome");
		stage.setScene(scene);
		stage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}

}