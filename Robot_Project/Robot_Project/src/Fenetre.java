import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Fenetre {
	static JFrame fenetre = new JFrame();
	boolean mode2 = FonctionSmart.mode;
	
	public Fenetre(Monde M1){
		fenetre.setSize(800, 600);
		fenetre.setLocationRelativeTo(null);
		fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fenetre.setVisible(true);
		
		new FonctionSmart(M1);
		//new PanelCentre(M1);
		
		new PanelNord(M1);
		new PanelEst(M1);
		new PanelOuest(M1);
	}
}
