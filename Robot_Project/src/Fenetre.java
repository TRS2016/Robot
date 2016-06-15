import javax.swing.*;

public class Fenetre {
	static JFrame fenetre = new JFrame();
	
	public Fenetre(Monde M1){
		fenetre.setSize(800, 600);
		fenetre.setLocationRelativeTo(null);
		fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fenetre.setVisible(true);
		
		new RobotPollueurSmart(M1);
		new RobotNettoyeurSmart(M1);
		//new PanelCentre(M1);
		new PanelNord(M1);
		new PanelEst(M1);
		new PanelOuest(M1);
	}
}
