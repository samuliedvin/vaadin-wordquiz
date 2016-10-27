package my.vaadin.wordquiz;

import java.io.IOException;
import java.util.Collection;
import java.util.List;
import java.util.Locale;

import org.jsoup.nodes.Element;

import com.vaadin.server.ClientMethodInvocation;
import com.vaadin.server.ErrorHandler;
import com.vaadin.server.Extension;
import com.vaadin.server.Resource;
import com.vaadin.server.ServerRpcManager;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinResponse;
import com.vaadin.shared.communication.SharedState;
import com.vaadin.ui.Button;
import com.vaadin.ui.Component;
import com.vaadin.ui.HasComponents;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.NativeSelect;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.declarative.DesignContext;

import elemental.json.JsonObject;

public class AddWordsPage extends VerticalLayout {
	
    final HorizontalLayout yla = new HorizontalLayout();
    final HorizontalLayout keskipalkki = new HorizontalLayout();
    final VerticalLayout translationStack = new VerticalLayout();	
    
    NativeSelect targetLanguageSelector;
    NativeSelect originalLanguageSelector;
    TextField originalWordInput;
    TextField translationInput;
    Button newTranslationButton;
    Button saveButton;
    
	private String[] languageArray = {
			"Suomi",
	        "Englanti",
	        "Ruotsi"
	};
	
	public AddWordsPage() {
		// Kielen valinta
        
        originalLanguageSelector = new NativeSelect("Lähtökieli");
        originalLanguageSelector.setNullSelectionAllowed(false);
        originalLanguageSelector.setImmediate(true);

        // Kohdekielen valinta
        
        targetLanguageSelector = new NativeSelect("Kohdekieli");
        targetLanguageSelector.setNullSelectionAllowed(false);
        targetLanguageSelector.setImmediate(true);
        
        for (String language : languageArray) {
        	originalLanguageSelector.addItem(language);
        	targetLanguageSelector.addItem(language);
        }
        
        // Alkuperäisen sanan syöttö: 
        
        originalWordInput = new TextField();
        originalWordInput.setImmediate(true);
        originalWordInput.setInputPrompt("Kirjoita sana");
        
        // Käännöksen syöttö:
        
        translationInput = new TextField();
        translationInput.setImmediate(true);
        translationInput.setInputPrompt("Kirjoita käännös");
        
        // Useampi käännös?
        
        newTranslationButton = new Button("Lisää vaihtoehtoinen käännös");
        newTranslationButton.addClickListener(e -> {
        	if (translationStack.getComponent(translationStack.getComponentCount()-1) instanceof Button) {
        		translationStack.removeComponent(translationStack.getComponent(translationStack.getComponentCount()-1));
        	} 
        	TextField newTranslation = new TextField();
        	newTranslation.setInputPrompt("Kirjoita vaihtoehtoinen käännös");
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
        
        saveButton = new Button("Tallenna");
        
        saveButton.addClickListener(e -> {
        	if (this.getComponent(this.getComponentCount()-1) instanceof Label) {
        		this.removeComponent(this.getComponent(this.getComponentCount()-1));
        		this.removeComponent(this.getComponent(this.getComponentCount()-1));
        	}
            this.addComponents(new Label("Tallennetaan sanan " + originalWordInput.getValue() + " käännökset " + 
                    this.translations() + ", kiitos."), new Label("Lähtökieli oli " + originalLanguageSelector.getValue() + 
                    		", kohdekieli oli " + targetLanguageSelector.getValue() + "."));
        });
        
        

        // this
        
        translationStack.addComponent(translationInput);
        
        yla.addComponents(originalLanguageSelector, targetLanguageSelector);
        yla.setSpacing(true);
        
        translationStack.setSpacing(true);
        translationStack.addStyleName("translationStack");
        
        
        keskipalkki.addComponents(originalWordInput, translationStack);
        keskipalkki.setSpacing(true);
        
        this.addComponents(yla, keskipalkki, newTranslationButton, saveButton);
        this.setWidth("30%");
        this.setMargin(true);
        this.setSpacing(true);
        
		
	}
	
	
	/*
	 *  Palauttaa, mitä formiin on kirjoitettu.
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
