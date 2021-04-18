/**
 * Sample Skeleton for 'Scene.fxml' Controller Class
 */

package it.polito.tdp.anagrammi;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.Set;

import it.polito.tdp.anagrammi.model.Model;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {

	Model model;
	
    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="txtParola"
    private TextField txtParola; // Value injected by FXMLLoader

    @FXML // fx:id="btnCalcola"
    private Button btnCalcola; // Value injected by FXMLLoader

    @FXML // fx:id="txtAnagrammiCorretti"
    private TextArea txtAnagrammiCorretti; // Value injected by FXMLLoader

    @FXML // fx:id="txtAnagrammiErrati"
    private TextArea txtAnagrammiErrati; // Value injected by FXMLLoader

    @FXML // fx:id="btnReset"
    private Button btnReset; // Value injected by FXMLLoader

    @FXML
    void doCalcolo(ActionEvent event) {

    	String parola;
    	txtAnagrammiCorretti.clear();
    	txtAnagrammiErrati.clear();
    	
    	parola=txtParola.getText();
    	
    	if(parola.length()<2) {
    		txtAnagrammiCorretti.appendText("Parola troppo corta");
    		txtAnagrammiErrati.appendText("Parola troppo corta");
    	    return;
    	}
    	
    	if(parola.length()>8) {
    		txtAnagrammiCorretti.appendText("Parola troppo lunga");
    		txtAnagrammiErrati.appendText("Parola troppo lunga");
    	    return;
    	}
    	
    	Set<String> anagrammi= this.model.calcolaAnagrammi(parola);
    	
    	for(String anagramma: anagrammi) {
    		if(this.model.isCorrect(anagramma))
    			txtAnagrammiCorretti.appendText(anagramma + "\n");
    		else
    			txtAnagrammiErrati.appendText(anagramma + "\n");
    	}
    }

    @FXML
    void doReset(ActionEvent event) {

    	txtAnagrammiCorretti.clear();
    	txtAnagrammiErrati.clear();
    	txtParola.clear();
    }
    public void setModel(Model model) {
    	this.model=model;
    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert txtParola != null : "fx:id=\"txtParola\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnCalcola != null : "fx:id=\"btnCalcola\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtAnagrammiCorretti != null : "fx:id=\"txtAnagrammiCorretti\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtAnagrammiErrati != null : "fx:id=\"txtAnagrammiErrati\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnReset != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'Scene.fxml'.";

    }
    
    
}
