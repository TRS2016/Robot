
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.*;
import javax.swing.*;

public class RobotPollueurSmart extends JPanel implements ActionListener{
	
		Monde M;
		int i, j = 1,o, p;
		final JButton bPollueurSmart = PanelOuest.bPollueurSmart;
		final JButton bNettoyeurSmart = PanelEst.bNettoyeurSmart;
		Timer clock = new Timer(1000, this);
		Timer clock2 = new Timer(1000, this);
		JPanel tabCentre[][] = new JPanel[10][10];
		JPanel centreS = new JPanel();
		JPanel nord = new JPanel();
		int papierGras ;
		
		
	public RobotPollueurSmart(Monde M1){
		M = M1;
		PollueurSmart();  //Appel de la fonction Pollueur Smart
		centreS.setLayout(new GridLayout(10,10));
		for(int i=0; i<10; i++)
			for(int j=0; j<10; j++){
				tabCentre[i][j] = new JPanel();
				if(M.Mat[i][j] )
					tabCentre[i][j].setBackground(Color.black);
				else
					tabCentre[i][j].setBackground(Color.blue);
				centreS.add(tabCentre[i][j]);
				tabCentre[i][j].setBorder(BorderFactory.createLineBorder(Color.white));
			}
		Fenetre.fenetre.add(centreS, BorderLayout.CENTER );
	}
	
	public void PollueurSmart(){
		bPollueurSmart.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent PollueurAleatoire){
				clock.start();
			}});
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		    if(i==0 && j<9)
		    {
		    	M.Mat[i][j] = true;
			    j++;
			    if(j==9)
			    {
			    	i=1;
			    	j=0;
			    }
		    }
		    if(i==1 && j<10)
		    {
		    	M.Mat[i][j] = true;
			    j++;
			    if(j==10)
			    {
			    	i=2;
			    	j=0;
			    }
		    }
		    if(i==2 && j<10)
		    {
		    	M.Mat[i][j] = true;
			    j++;
			    if(j==10)
			    {
			    	i=3;
			    	j=0;
			    }
		    }
		    if(i==3 && j<10)
		    {
		    	M.Mat[i][j] = true;
			    j++;
			    if(j==10)
			    {
			    	i=4;
			    	j=1;
			    }
		    }
		    if(i==4 && j<9)
		    {
		    	M.Mat[i][j] = true;
			    j++;
			    if(j==9)
			    {
			    	i=5;
			    	j=0;
			    	o = 1;
			    	p = 1;
			    }
		    }
		    if(i==5 && j<10)
		    {
		    	if(o==1 && p<9)
		    	{
		    		M.Mat[o][p] = false;
				    p++;
				    if(p==9)
				    {
				    	o = 2;
				    	p = 1;
				    }  	
		    	}
		    	if(o==2 && p<9)
		    	{
		    		M.Mat[o][p] = false;
				    p++;
				    if(p==9)
				    {
				    	o = 3;
				    	p = 1;
				    } 	
		    	}
		    	if(o==3 && p<9)
		    	{
		    		M.Mat[o][p] = false;
				    p++;
				    if(p==9)
				    {
				    	o = 5;
				    	p = 0;
				    } 	
		    	}
		    	if(o<=9 && p==0)
		    	{
		    		M.Mat[o][p] = true;
		    		o++;
				    if(o==9)
				    {
				    	o = 9;
				    	p = 1;
				    } 	
		    	}
		    	if(o==9 && p<9)
		    	{
		    		M.Mat[o][p] = true;
		    		p++;
				    if(p==9)
				    {
				    	o = 5;
				    	p = 9;
				    } 	
		    	}
		    	if(o<=9 && p==9)
		    	{
		    		M.Mat[o][p] = true;
		    		o++;
				    if(o==9)
				    {
				    	o = 6;
				    	p = 6;
				    } 	
		    	}
		    	
		    }
			MAS(M);
			revalidate();
			repaint();
	}	
	public void MAS(Monde m){
		for(int i=0; i<10; i++)
			for(int j=0; j<10; j++){
				if(m.Mat[i][j])
					tabCentre[i][j].setBackground(Color.black);
				else
					tabCentre[i][j].setBackground(Color.blue);
				
				PanelNord.papierGras = M.comptePapierGras();
				PanelNord.NombrepapierGras.setText("Nombre de papier gras : "+PanelNord.papierGras);
				PanelNord.NombrepapierGras.validate();
				PanelNord.NombrepapierGras.repaint();
			}
	}
}
