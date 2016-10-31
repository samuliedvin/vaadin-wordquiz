package my.vaadin.wordquiz;

import com.vaadin.ui.Button;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.NativeSelect;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;

public class AdminPage extends AdminPageLayout {

	/*
	public void initAdminPage() {
		

        
        for (String language : languageArray) {
        	originalLanguageSelector.addItem(language);
        	targetLanguageSelector.addItem(language);
        }

        
        // Useampi käännös?
        
        newTranslationButton = new Button("Add alternate translation");
        newTranslationButton.addClickListener(e -> {
        	if (translationStack.getComponent(translationStack.getComponentCount()-1) instanceof Button) {
        		translationStack.removeComponent(translationStack.getComponent(translationStack.getComponentCount()-1));
        	} 
        	TextField newTranslation = new TextField();
        	newTranslation.setInputPrompt("Alt. translation");
        	Button cancelButton = new Button("x");
        	cancelButton.addClickListener(event -> {
        		translationStack.removeComponent(translationStack.getComponent(translationStack.getComponentCount() -2));
        		
        		if (translationStack.getComponentCount() == 2) {
        			translationStack.removeComponent(cancelButton);
        		}
        		
        	});
        	
        	
        	translationStack.addComponents(newTranslation, cancelButton);
        });

        // Tallennuspainike
        saveButton = new Button("Save");
        
        saveButton.addClickListener(e -> {
        	if (this.getComponent(this.getComponentCount()-1) instanceof Label) {
        		this.removeComponent(this.getComponent(this.getComponentCount()-1));
        		this.removeComponent(this.getComponent(this.getComponentCount()-1));
        	}
            this.addComponents(new Label("Saving words " + originalWordInput.getValue() + " translations " + 
                    this.translations() + "thank you."), new Label("Original language was " + originalLanguageSelector.getValue() + 
                    		", target language was " + targetLanguageSelector.getValue() + "."));
        });
        
        
        
        // Let's add all components to this layout
        
        // First the sublayouts
        translationStack.addComponent(translationInput);
        
        languageSelectorRow.addComponents(originalLanguageSelector, targetLanguageSelector);
        languageSelectorRow.setSpacing(true);
        
        translationStack.setSpacing(true);
        translationStack.addStyleName("translationStack");
  
        textFieldRow.addComponents(originalWordInput, translationStack);
        textFieldRow.setSpacing(true);
        
        // Finally AdminPage layout
        this.addComponents(languageSelectorRow, textFieldRow, newTranslationButton, saveButton);
        this.setWidth("30%");
        this.setMargin(true);
        this.setSpacing(true);
	}
	
	*/
	
	
	public void initAdminPage() {
		
        addAlternateTranslationButton.addClickListener(e -> {
        	if (translationStack.getComponent(translationStack.getComponentCount()-1) instanceof Button) {
        		translationStack.removeComponent(translationStack.getComponent(translationStack.getComponentCount()-1));
        	} 
        	TextField newTranslation = new TextField();
        	newTranslation.setInputPrompt("Alt. translation");
        	Button cancelButton = new Button("x");
        	cancelButton.addClickListener(event -> {
        		translationStack.removeComponent(translationStack.getComponent(translationStack.getComponentCount() -2));
        		
        		if (translationStack.getComponentCount() == 2) {
        			translationStack.removeComponent(cancelButton);
        		}
        		
        	});	
        	translationStack.addComponents(newTranslation, cancelButton);
        });
		
		
		
		saveButton.addClickListener(event -> {
        	if (this.getComponent(this.getComponentCount()-1) instanceof Label) {
        		this.removeComponent(this.getComponent(this.getComponentCount()-1));
        		this.removeComponent(this.getComponent(this.getComponentCount()-1));
        	}
        	
            this.addComponents(new Label("Saving words " + originalWordInput.getValue() + " translations " + 
                    this.translations() + ",x thank you."), new Label("Original language was " + originalLanguageSelector.getValue() + 
                    		", target language was " + targetLanguageSelector.getValue() + "."));
		});
		
	}
	
	
	
	/*
	 * Getters
	 */
	

	/*
	 *  Returns string representation of form's translation inputs.
	 */
    protected StringBuilder translations() { 
        StringBuilder translations = new StringBuilder();
    	
        for (int i = 0; i < translationStack.getComponentCount(); i++) {
        	if (translationStack.getComponent(i) instanceof TextField) {
		    	String currentValue = ((TextField)translationStack.getComponent(i)).getValue();
		    	translations.append(currentValue);
        	}
        	if (i < translationStack.getComponentCount() -1) {
        		translations.append(", ");
        	}
        	
        }
		return translations;
    }
	
	
}
