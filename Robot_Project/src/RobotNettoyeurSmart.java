
import java.awt.Color;
import java.awt.event.*;
import javax.swing.*;

public class RobotNettoyeurSmart extends JPanel implements ActionListener{
	
		Monde M;
		int i, j = 1,o, p;
		final JButton bNettoyeurSmart = PanelEst.bNettoyeurSmart;
		Timer clock = new Timer(500, this);
		int papierGras ;
		
		
	public RobotNettoyeurSmart(Monde M1){
		M = M1;
		NettoyeurSmart();
	}
	
	public void NettoyeurSmart(){
		bNettoyeurSmart.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent PollueurAleatoire){
				clock.start();
			}});
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		    if(i==0 && j<9)
		    {
		    	M.Mat[i][j] = false;
			    j++;
			    if(j==9)
			    {
			    	i=1;
			    	j=0;
			    }
		    }
		    if(i==1 && j<10)
		    {
		    	M.Mat[i][j] = false;
			    j++;
			    if(j==10)
			    {
			    	i=2;
			    	j=0;
			    }
		    }
		    if(i==2 && j<10)
		    {
		    	M.Mat[i][j] = false;
			    j++;
			    if(j==10)
			    {
			    	i=3;
			    	j=0;
			    }
		    }
		    if(i==3 && j<10)
		    {
		    	M.Mat[i][j] = false;
			    j++;
			    if(j==10)
			    {
			    	i=4;
			    	j=1;
			    }
		    }
		    if(i==4 && j<9)
		    {
		    	M.Mat[i][j] = false;
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
		    		M.Mat[o][p] = false;
		    		o++;
				    if(o==9)
				    {
				    	o = 9;
				    	p = 1;
				    } 	
		    	}
		    	if(o==9 && p<9)
		    	{
		    		M.Mat[o][p] = false;
		    		p++;
				    if(p==9)
				    {
				    	o = 5;
				    	p = 9;
				    } 	
		    	}
		    	if(o<=9 && p==9)
		    	{
		    		M.Mat[o][p] = false;
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
		RobotPollueurSmart FC = new RobotPollueurSmart(m);
		for(int i=0; i<10; i++)
			for(int j=0; j<10; j++){
				if(m.Mat[i][j])
					FC.tabCentre[i][j].setBackground(Color.black);
				else
					FC.tabCentre[i][j].setBackground(Color.blue);
				
				PanelNord.papierGras = M.comptePapierGras();
				PanelNord.NombrepapierGras.setText("Nombre de papier gras : "+PanelNord.papierGras);
				PanelNord.NombrepapierGras.validate();
				PanelNord.NombrepapierGras.repaint();
			}
	}
}
