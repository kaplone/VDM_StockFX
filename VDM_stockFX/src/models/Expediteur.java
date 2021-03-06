package models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import controllers.Centre_ajout_controller;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import utils.MongoAccess;

/**
 * Modèle lié au formulaire {@link controllers.Ajout_expediteur_controller}
 * @see Classes_ajout_bloc
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Expediteur extends Commun implements Enregistrable {

	
	
	
	@Override
	public void save() {	
		MongoAccess.save("expediteur",this);	
		Centre_ajout_controller.fire0();
	}

	@SuppressWarnings("unchecked")
	@Override
	public void setForm(VBox form) {
		this.setNom(((ComboBox<String>) 
                     ((HBox) form.getChildren().get(0))
                     .getChildren().get(1))
                   .editorProperty().get().getText());

		this.setCommentaire(((TextArea) 
                             ((HBox) form.getChildren().get(1))
                             .getChildren().get(1))
                           .getText()) ;
		
	}
}
