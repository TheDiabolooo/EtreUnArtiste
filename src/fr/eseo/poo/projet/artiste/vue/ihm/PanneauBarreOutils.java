package fr.eseo.poo.projet.artiste.vue.ihm;

import javax.swing.JPanel;
import javax.swing.JSpinner;

import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JToggleButton;
import javax.swing.SpinnerNumberModel;
import javax.swing.ButtonGroup;

import fr.eseo.poo.projet.artiste.controleur.actions.ActionChoisirCouleur;
import fr.eseo.poo.projet.artiste.controleur.actions.ActionChoisirForme;
import fr.eseo.poo.projet.artiste.controleur.actions.ActionChoisirRemplissage;
import fr.eseo.poo.projet.artiste.controleur.actions.ActionEffacer;
import fr.eseo.poo.projet.artiste.controleur.actions.ActionSelectionner;
import fr.eseo.poo.projet.artiste.modele.formes.Etoile;

@SuppressWarnings("serial")
public class PanneauBarreOutils extends JPanel {
	
	private PanneauDessin panneauDessin;
	public static final String BRANCHE_SPINNER_NOM = "nb branches";
	public static final String LONGUEUR_SPINNER_NOM = "longueur branches";
	
	SpinnerNumberModel model1 = new SpinnerNumberModel(Etoile.NOMBRE_BRANCHES_PAR_DEFAUT, 3, 15, 1);
	JSpinner boutonNbbranches = new JSpinner(model1);

	SpinnerNumberModel model2 = new SpinnerNumberModel(Etoile.LONGUEUR_BRANCHE_PAR_DEFAUT, 0.00, 1.00, 0.01);
	JSpinner boutonLongueurbranches = new JSpinner(model2);

	
	public int getNbBranches() {
		return (int) boutonNbbranches.getValue();
	}
	
	public double getLongueurBranche() {
		return (double) boutonLongueurbranches.getValue();	
	}	
	
	public PanneauBarreOutils(PanneauDessin panneauDessin) {
		BoxLayout box = new BoxLayout(this, BoxLayout.Y_AXIS);
		this.panneauDessin = panneauDessin;
		this.initComponents();
		this.setLayout(box);
		this.setPreferredSize(new Dimension(210,100));
		this.setLayout(new GridLayout(15,5));
		
	}
	
	public void initComponents() {
		ButtonGroup boutonGroupe = new ButtonGroup();
		
		JButton boutonEffacett = new JButton(new ActionEffacer(panneauDessin));
		boutonEffacett.setName(ActionEffacer.NOM_ACTION);
		this.add(boutonEffacett);
		boutonGroupe.add(boutonEffacett);
		
		
		ActionChoisirForme choixLigne = new ActionChoisirForme(panneauDessin, this, "Ligne");
		ActionChoisirForme choixEllipse = new ActionChoisirForme(panneauDessin, this, "Ellipse");
		ActionChoisirForme choixCercle = new ActionChoisirForme(panneauDessin, this, "Cercle");
		ActionChoisirForme choixEtoile = new ActionChoisirForme(panneauDessin, this, "Etoile");
		
		
		JToggleButton boutonLigne = new JToggleButton(choixLigne);
		JToggleButton boutonEllipse = new JToggleButton(choixEllipse);
		JToggleButton boutonCercle = new JToggleButton(choixCercle);
		JToggleButton boutonEtoile = new JToggleButton(choixEtoile);
		
		boutonLigne.setName(ActionChoisirForme.NOM_ACTION_LIGNE);
		boutonEllipse.setName(ActionChoisirForme.NOM_ACTION_ELLIPSE);
		boutonCercle.setName(ActionChoisirForme.NOM_ACTION_CERCLE);
		boutonEtoile.setName(ActionChoisirForme.NOM_ACTION_ETOILE);
		
		this.add(boutonLigne);
		this.add(boutonEllipse);
		this.add(boutonCercle);
		this.add(boutonEtoile);
		
		boutonGroupe.add(boutonLigne);
		boutonGroupe.add(boutonEllipse);
		boutonGroupe.add(boutonCercle);
		boutonGroupe.add(boutonEtoile);
		
	
		ActionSelectionner choixSelection = new ActionSelectionner(panneauDessin);
		JToggleButton boutonSelectionner = new JToggleButton(choixSelection);
		boutonSelectionner.setName(ActionSelectionner.NOM_ACTION);
		this.add(boutonSelectionner);
		boutonGroupe.add(boutonSelectionner);
		
		
		ActionChoisirCouleur choixCouleur = new ActionChoisirCouleur(panneauDessin);
		JButton boutonCouleur = new JButton(choixCouleur);
		boutonCouleur.setName(ActionChoisirCouleur.NOM_ACTION);
		this.add(boutonCouleur);
		boutonGroupe.add(boutonCouleur);
		
		
		ActionChoisirRemplissage choixRemplissage = new ActionChoisirRemplissage(panneauDessin);
		JCheckBox checkRemplissage = new JCheckBox(choixRemplissage);
		checkRemplissage.setName(ActionChoisirRemplissage.NOM_ACTION);
		this.add(checkRemplissage);
		
		
		JLabel label1 = new JLabel(BRANCHE_SPINNER_NOM);
		this.add(label1);
		boutonNbbranches.setName(BRANCHE_SPINNER_NOM);
		this.add(boutonNbbranches);
		
		

		JLabel label2 = new JLabel(LONGUEUR_SPINNER_NOM);
		this.add(label2);
		boutonLongueurbranches.setName(LONGUEUR_SPINNER_NOM);
		this.add(boutonLongueurbranches);
		
	}
}
