package com.example.myapplication;

import com.vaadin.ui.Button;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;


public class LoginPage extends VerticalLayout {
	
    private TextField userNameInput;
    private TextField passwordInput;
    private Button loginButton;
    private Button signupButton;	
    private Window loginForm;
	

	
	public void initLoginPage () {

        userNameInput = new TextField();
        passwordInput = new TextField();
        loginButton = new Button("Login");
        signupButton = new Button("Sign Up");
        loginForm = new Window();
		
		
        // User name and password inputs
        userNameInput.setImmediate(true);
        userNameInput.setInputPrompt("Username"); 
       
        passwordInput.setImmediate(true);
        passwordInput.setInputPrompt("Password");
        	
        	// Add input text fields to layout
        	HorizontalLayout textfields = new HorizontalLayout();
        	textfields.addComponents(userNameInput, passwordInput);
        	textfields.setSpacing(true);
        	this.addComponent(textfields);
        	
        	
        // Login and sign up buttons
        loginButton.addClickListener(e -> {
        	//connector.checkLogin();
        	UI.getCurrent().setContent(new AddWordsPage());
        });
        
        signupButton.addClickListener(e -> {
        	
        	
        	
        });
		    // Add buttons to layout
		    HorizontalLayout buttons = new HorizontalLayout();
			buttons.addComponents(loginButton, signupButton);
			buttons.setSpacing(true);
			this.addComponent(buttons);
        
        // Layout
    	this.setWidth("30%");
        this.setMargin(true);
        this.setSpacing(true);
	}
}
