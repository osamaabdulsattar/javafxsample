package com.test.controller;

import static org.testfx.api.FxAssert.verifyThat;
import static org.testfx.matcher.base.NodeMatchers.hasText;

import java.io.IOException;
import java.net.URL;

import org.junit.Test;
import org.loadui.testfx.GuiTest;
import org.testfx.framework.junit.ApplicationTest;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class LoginControllerTest extends ApplicationTest {

	private static final String RESOURCE_FILE_NAME = "login_form.fxml";

	private static final URL TEST_RESOURCE = LoginControllerTest.class.getClassLoader().getResource(RESOURCE_FILE_NAME);

	@Override
	public void start(Stage stage) throws IOException {

		Parent sceneRoot = FXMLLoader.load(TEST_RESOURCE);
		Scene scene = new Scene(sceneRoot, 500, 500);
		stage.setScene(scene);
		stage.show();
	}

	@Test
	public void should_contain_button() {
		// expect:
		verifyThat("#signIn", hasText("Sign In"));
	}

	@Test
	public void should_username_and_password_be_empty() {
		// expect:
		verifyThat("#userName", hasText(""));
		verifyThat("#password", hasText(""));
	}

	@Test
	public void should_fail_when_invalid_username() {

		String testUsername = "aaa";
		String testPassword = "123";

		// given:
		((TextField) GuiTest.find("#userName")).setText(testUsername);
		((TextField) GuiTest.find("#password")).setText(testPassword);

		// when:
		clickOn("#signIn");

		// then:
		verifyThat("#actiontarget", hasText("Invalid Username or Password"));

		// After Login failed, username, and password should be empty
		verifyThat("#userName", hasText(testUsername));
		verifyThat("#password", hasText(""));
	}

	@Test
	public void should_fail_when_invalid_password() {

		String testUsername = "osama";
		String testPassword = "cce2";

		// given:
		((TextField) GuiTest.find("#userName")).setText(testUsername);
		((TextField) GuiTest.find("#password")).setText(testPassword);

		// when:
		clickOn("#signIn");

		// then:
		verifyThat("#actiontarget", hasText("Invalid Username or Password"));

		// After Login failed, username, and password should be empty
		verifyThat("#userName", hasText(testUsername));
		verifyThat("#password", hasText(""));
	}

	@Test
	public void should_succeed_when_valid_username_and_password() {

		String testUsername = "osama";
		String testPassword = "123";

		// given:
		((TextField) GuiTest.find("#userName")).setText(testUsername);
		((TextField) GuiTest.find("#password")).setText(testPassword);

		// when:
		clickOn("#signIn");

		// then:
		verifyThat("#actiontarget", hasText("Welcome " + testUsername));

		// After Login failed, username, and password should be empty
		verifyThat("#userName", hasText(testUsername));
		verifyThat("#password", hasText(""));
	}
}
