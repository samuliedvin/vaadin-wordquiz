package my.vaadin.wordquiz;

import com.vaadin.ui.Button;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.PasswordField;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;


public class LoginPage extends VerticalLayout {
	
	protected TextField userNameInput;
    protected PasswordField passwordInput;
    protected Button loginButton;
    protected Button signupButton;	
    protected Window signupWindow;
    


    
	public void initLoginPage () {

        userNameInput = new TextField();
        passwordInput = new PasswordField();
        loginButton = new Button("Login");
        signupButton = new Button("Sign Up");
		
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
        	
        	String foo = userNameInput.getValue();
        	String bar = passwordInput.getValue();
        	UI.getCurrent().setContent(buildUserPage(foo, bar));
        	
        });
        
        
        
        signupButton.addClickListener(e -> {
        	SignUpForm signUpForm = new SignUpForm(); 
        	signUpForm.setSizeFull();
        	signUpForm.setMargin(true);
        	
        	// Sign up window's styling.
            signupWindow = new Window("Sign up");                	
        	signupWindow.center();
        	signupWindow.setWidth(300.0f, Unit.PIXELS);
        	signupWindow.setHeight("200px");
        	signupWindow.setResizable(false);
        	signupWindow.setModal(true);
        	signupWindow.setDraggable(false);
        	signupWindow.setContent(signUpForm);
        	

            UI.getCurrent().addWindow(signupWindow);
        });
        
		    // Add buttons to LoginPage layout
		    HorizontalLayout buttons = new HorizontalLayout();
			buttons.addComponents(loginButton, signupButton);
			buttons.setSpacing(true);
			
			this.addComponent(buttons);
        
        // Layout
    	this.setWidth("30%");
        this.setMargin(true);
        this.setSpacing(true);
	}
	
	protected VerticalLayout buildUserPage(String username, String password) {
		//connector.checkLogin(username);
		
		if (username.equals("admin") && password.equals("admin")) {
			AdminPage adminPage = new AdminPage();
        	adminPage.initAdminPage();
			return adminPage;
		} else {
			ProfilePage profilePage = new ProfilePage();
			profilePage.initChart();
			return profilePage;
		}
	}
	
	
}
