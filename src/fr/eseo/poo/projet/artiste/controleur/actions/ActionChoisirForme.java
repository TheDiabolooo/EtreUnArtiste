package fr.eseo.poo.projet.artiste.controleur.actions;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;


import fr.eseo.poo.projet.artiste.controleur.outils.OutilCercle;
import fr.eseo.poo.projet.artiste.controleur.outils.OutilEllipse;
import fr.eseo.poo.projet.artiste.controleur.outils.OutilEtoile;
import fr.eseo.poo.projet.artiste.controleur.outils.OutilLigne;
import fr.eseo.poo.projet.artiste.vue.ihm.PanneauBarreOutils;
import fr.eseo.poo.projet.artiste.vue.ihm.PanneauDessin;

@SuppressWarnings("serial")
public class ActionChoisirForme extends AbstractAction{
	
	public static final String NOM_ACTION_LIGNE = "Ligne";
	public static final String NOM_ACTION_ELLIPSE = "Ellipse";
	public static final String NOM_ACTION_CERCLE = "Cercle";
	public static final String NOM_ACTION_ETOILE = "Etoile";
	
	
	private PanneauDessin panneauDessin;
	private PanneauBarreOutils panneauOutils;
	
	public ActionChoisirForme (PanneauDessin panneauDessin, PanneauBarreOutils panneauOutils, String nomAction) {
		super(nomAction);
		this.panneauDessin = panneauDessin;
		this.panneauOutils = panneauOutils;	
	}
	
	public void actionPerformed(ActionEvent event) {
		if(event.getActionCommand().equals(NOM_ACTION_LIGNE)) {
			OutilLigne outilLigne = new OutilLigne();
			this.panneauDessin.associerOutil(outilLigne);
		}
		
		if(event.getActionCommand().equals(NOM_ACTION_ELLIPSE)) {
			OutilEllipse outilEllipse = new OutilEllipse();
			this.panneauDessin.associerOutil(outilEllipse);
		}
		
		if(event.getActionCommand().equals(NOM_ACTION_CERCLE)) {
			OutilCercle outilCercle = new OutilCercle();
			this.panneauDessin.associerOutil(outilCercle);	
		}
		
		if(event.getActionCommand().equals(NOM_ACTION_ETOILE)) {
			OutilEtoile outilEtoile = new OutilEtoile(this.panneauOutils);
			this.panneauDessin.associerOutil(outilEtoile);	
		}
	}
}
