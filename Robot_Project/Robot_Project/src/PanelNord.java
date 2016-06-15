import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class PanelNord {
	//Déclaraton des objets
	JPanel nord = new JPanel();
	JButton bNettoyer = new JButton("Nettoyer");
	JButton bPolluerTout = new JButton("Polluer Tout");
	JButton b3 = new JButton("RAZ");
	JButton bQuitter = new JButton("Quitter");
	JButton b5 = new JButton("Papier gras");
	
	public PanelNord(Monde M1){
		seTPanelNord();
		PolluerTout(M1);
		Nettoyeur(M1);
		Quitter();
	}
	public void seTPanelNord(){
		nord.setLayout(new GridBagLayout()); /* On ajoute un gridbagLauout au panel centre */
		GridBagConstraints gc = new GridBagConstraints(); //Définit la position et la taille des éléments
		gc.fill = GridBagConstraints.BOTH; //Permet d'occuper tout l'espace disponible Horizontalement et verticalement
		gc.insets = new Insets(1, 1, 1, 1); //Définit la marge entre les composants
		
		/* ipady permet de savoir où on place le composant s'il n'occupe pas la totalité de l'espace disponnible */
		gc.ipady = gc.anchor = GridBagConstraints.CENTER;
		gc.weightx = 4; // Le nombrede cases en abscisse
		gc.weighty = 2; // Le nombre de cases en ordonné
		
		gc.gridx = 0;
		gc.gridy = 0;
		nord.add(bNettoyer, gc); //On rajoute le bouton Nettoyer au panel nord
		
		gc.gridx = 1;
		gc.gridy = 0;
		nord.add(bPolluerTout, gc); //On rajoute le bouton Polluer au panel nord
		
		gc.gridx = 2;
		gc.gridy = 0;
		nord.add(b3, gc); //On rajoute le bouton RAZ au panel nord
		
		gc.gridx = 3;
		gc.gridy = 0;
		nord.add(bQuitter, gc); //On rajoute le bouton Quitter au panel nord
		
		gc.gridx = 0;
		gc.gridy = 1;
		gc.gridwidth = 4;
		nord.add(b5, gc); //On rajoute le bouton Papier gras au panel nord
		
		Fenetre.fenetre.add(nord, BorderLayout.NORTH ); //On rajoute le panel nord   à la fenêtre
	}
	public void PolluerTout(Monde m){
		bPolluerTout.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent Polluer){
				try {
					new RobotPollueurs(m); //Pollue toutes les cases du Monde
				} catch (ajoutPapierException e) {
					e.printStackTrace();
				}
				MAS(m);
				nord.repaint();
				nord.revalidate();
			}});
	}
	public void Nettoyeur(Monde m){
		bNettoyer.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent Nettoyer){
				try {
					new RobotNettoyeurs(m);
				} catch (ajoutPapierException e) {
					e.printStackTrace();
				}
				MAS(m);
				nord.repaint();
				nord.revalidate();
			}});
	}
	public void Quitter(){
		bQuitter.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent Nettoyer){
				System.exit(0); 
			}});
	}
	public void MAS(Monde m){
		PanelCentre PC = new PanelCentre(m); 
		for(int i=0; i<10; i++)
			for(int j=0; j<10; j++){
				if(m.Mat[i][j])
					PC.tabCentre[i][j].setBackground(Color.black);
				else
					PC.tabCentre[i][j].setBackground(Color.blue);
			}
	}
}
