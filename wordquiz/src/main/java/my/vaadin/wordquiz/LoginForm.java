package my.vaadin.wordquiz;

import com.vaadin.ui.Button;
import com.vaadin.ui.CheckBox;
import com.vaadin.ui.Component;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.PopupDateField;
import com.vaadin.ui.TextField;

public class LoginForm extends FormLayout {
	
	public void initLoginForm() {
		
		this.setSizeFull();
		this.setSpacing(true);

        Label foo = new Label("Testing");
		
        this.addComponent(foo);
        
        Button button = new Button("Test");
        this.addComponent(button);
	}

}
