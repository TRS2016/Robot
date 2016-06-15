import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.*;

public class PanelEst {
	//Déclaraton des objets
	JPanel est = new JPanel();
 	JButton bNettoyeurToutDroit = new JButton("Nettoyeur Droit");
	static JButton bNettoyeurSmart = new JButton("Nettoyeur Smart");
	JButton bNettoyeurLibre = new JButton("Nettoyeur Libre");
	JButton bNettoyeurSauteur = new JButton("Nettoyeur Sauteur");
	int i, j;
	public PanelEst(Monde M){
	
		setPanelOuest();
		PolluerToutDroit(M);
		PollueurLibre(M);
		PollueurSauteur(M);
	}
	public void setPanelOuest(){
		est.setLayout(new GridBagLayout()); /* On ajoute un gridbagLauout au panel centre */
		GridBagConstraints gc = new GridBagConstraints(); //Définit la position et la taille des éléments
		gc.fill = GridBagConstraints.BOTH; //Permet d'occuper tout l'espace disponible Horizontalement et verticalement
		gc.insets = new Insets(1, 1, 1, 1); //Définit la marge entre les composants
		gc.ipady = gc.anchor = GridBagConstraints.CENTER;
		
		gc.weightx = 1; // Le nombrede cases en abscisse
		gc.weighty = 4; // Le nombre de cases en ordonné
	
		
		gc.gridx = 0;
		gc.gridy = 0;
		est.add(bNettoyeurToutDroit, gc);
		
		gc.gridx = 0;
		gc.gridy = 1;
		est.add(bNettoyeurSauteur, gc);
		
		gc.gridx = 0;
		gc.gridy = 2;
		est.add(bNettoyeurLibre, gc);
		
		gc.gridx = 0;
		gc.gridy = 3;
		est.add(bNettoyeurSmart, gc);
				
		Fenetre.fenetre.add(est, BorderLayout.EAST ); //On rajoute le panel est à  la fenêtre
	}
	public void PolluerToutDroit(Monde m){
		bNettoyeurToutDroit.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent PollueurTouutDroit){
				try {
					int colonne = Integer.parseInt(JOptionPane.showInputDialog("Colonne :"));
					while(colonne > 9)
						colonne = Integer.parseInt(JOptionPane.showInputDialog("Colonne :"));
					new RobotNettoyeurs(colonne,m);
				} catch (ajoutPapierException e) {
					e.printStackTrace();
				}
				MAS(m);
				est.repaint();
				est.revalidate();
			}});
	}
	public void PollueurLibre(Monde m){
		bNettoyeurLibre.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent PollueurAleatoire){
				try {
					new RobotNettoyeurs(m, 1);  /*Robot pollueur aléatoire */
				} catch (ajoutPapierException e) {
					e.printStackTrace();
				}
				MAS(m);
				est.repaint();
				est.revalidate();
			}});
	}
	public void PollueurSauteur(Monde m){
		bNettoyeurSauteur.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent PollueurSauteur){
				try {
					int LDebut = Integer.parseInt(JOptionPane.showInputDialog("Ligne de début :"));
					while(LDebut > 9)
						LDebut = Integer.parseInt(JOptionPane.showInputDialog("Ligne de début :"));
					int CDebut = Integer.parseInt(JOptionPane.showInputDialog("Colonne de début:"));
					while(CDebut > 9)
						CDebut = Integer.parseInt(JOptionPane.showInputDialog("Colonne de début:"));
					int pas = Integer.parseInt(JOptionPane.showInputDialog("Pas :"));
					while(pas > 9)
						pas = Integer.parseInt(JOptionPane.showInputDialog("Pas :"));
					new RobotNettoyeurs(m, pas, LDebut, CDebut);
				} catch (ajoutPapierException e) {
					e.printStackTrace();
				}
				MAS(m);
				est.repaint();
				est.revalidate();
			}});
	}
	public void MAS(Monde m){
		FonctionSmart PC = new FonctionSmart(m); 
		for(int i=0; i<10; i++)
			for(int j=0; j<10; j++){
				if(m.Mat[i][j])
					PC.tabCentre[i][j].setBackground(Color.black);
				else
					PC.tabCentre[i][j].setBackground(Color.blue);
			}
	}
}
