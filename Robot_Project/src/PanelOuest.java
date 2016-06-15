import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.*;

public class PanelOuest {
	//Déclaraton des objets
	JPanel ouest = new JPanel();
 	JButton bPollueurToutDroit = new JButton("Pollueur Droit");
	static JButton bPollueurSmart = new JButton("Pollueur Smart");
	JButton bPollueurLibre = new JButton("Pollueur Libre");
	JButton bPollueurSauteur = new JButton("Pollueur Sauteur");
	int i, j;
	int colonne;
	public PanelOuest(Monde M){
	
		setPanelOuest();
		PolluerToutDroit(M);
		PollueurLibre(M);
		PollueurSauteur(M);
	}
	public void setPanelOuest(){
		ouest.setLayout(new GridBagLayout()); /* On ajoute un gridbagLauout au panel centre */
		GridBagConstraints gc = new GridBagConstraints(); //Définit la position et la taille des éléments
		gc.fill = GridBagConstraints.BOTH; //Permet d'occuper tout l'espace disponible Horizontalement et verticalement
		gc.insets = new Insets(1, 1, 1, 1); //Définit la marge entre les composants
		gc.ipady = gc.anchor = GridBagConstraints.CENTER;
		
		gc.weightx = 1; // Le nombrede cases en abscisse
		gc.weighty = 4; // Le nombre de cases en ordonné
	
		
		gc.gridx = 0;
		gc.gridy = 0;
		ouest.add(bPollueurToutDroit, gc);
		
		gc.gridx = 0;
		gc.gridy = 1;
		ouest.add(bPollueurSauteur, gc);
		
		gc.gridx = 0;
		gc.gridy = 2;
		ouest.add(bPollueurLibre, gc);
		
		gc.gridx = 0;
		gc.gridy = 3;
		ouest.add(bPollueurSmart, gc);
				
		Fenetre.fenetre.add(ouest, BorderLayout.WEST ); //On rajoute le panel est à  la fenêtre
	}
	public void PolluerToutDroit(Monde m){
		bPollueurToutDroit.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent PollueurTouutDroit){
				
					try {
						colonne = Integer.parseInt(JOptionPane.showInputDialog("Colonne :"));
						while(colonne > 9)
							colonne = Integer.parseInt(JOptionPane.showInputDialog("Colonne :"));
						new RobotPollueurs(colonne,m);
						
					} catch (ajoutPapierException e) {
					e.printStackTrace();
					}
			
				
				MAS(m);
				ouest.repaint();
				ouest.revalidate();
			}});
	}
	public void PollueurLibre(Monde m){
		bPollueurLibre.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent PollueurAleatoire){
				try {
					new RobotPollueurs(m, 1);  /*Robot pollueur aléatoire */
				} catch (ajoutPapierException e) {
					e.printStackTrace();
				}
				MAS(m);
				ouest.repaint();
				ouest.revalidate();
			}});
	}
	public void PollueurSauteur(Monde m){
		bPollueurSauteur.addActionListener(new ActionListener(){
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
					new RobotPollueurs(m, pas, LDebut, CDebut);
				} catch (ajoutPapierException e) {
					e.printStackTrace();
				}
				MAS(m);
				ouest.repaint();
				ouest.revalidate();
			}});
	}
	public void MAS(Monde m){
		RobotPollueurSmart FC = new RobotPollueurSmart(m);  //On instancie la classe Fonction Smart afin d'uliser ses attributs
		for(int i=0; i<10; i++)
			for(int j=0; j<10; j++){
				if(m.Mat[i][j])
					FC.tabCentre[i][j].setBackground(Color.black);
				else
					FC.tabCentre[i][j].setBackground(Color.blue);
				
				PanelNord.papierGras = m.comptePapierGras();
				PanelNord.NombrepapierGras.setText("Nombre de papier gras : "+PanelNord.papierGras);
				PanelNord.NombrepapierGras.validate();
				PanelNord.NombrepapierGras.repaint();
			}
	}
}
