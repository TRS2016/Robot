public class RobotPollueurs extends Robot{
    int  numRobot;
    int numColonne;
    
    
    public RobotPollueurs(Monde M) throws ajoutPapierException{  //Pollue tout le Monde
 	    	super(0,0,M);
 	    	for(int i=0; i<m.nbL; i++)
 				for(int j=0; j<m.nbC; j++)
 					m.Mat[i][j] = true;
    }
    public RobotPollueurs(int nC, Monde M1) throws ajoutPapierException{ //Robot pollueur tout droit
        	super(0,nC,M1);
        	numColonne = nC;
        	for(int i=0; i<m.nbL; i++)
    			m.Mat[i][numColonne] = true;
    }
    public RobotPollueurs(Monde M2, int unused) throws ajoutPapierException{ //Pollueur Aléatoire
    	super(M2); // Appel le construucteur qui définit des positions aléatoires 
    	m.Mat[posx][posy] = true;    				
    }
    public RobotPollueurs(Monde M3, int pas, int LDebut, int CDebut) throws ajoutPapierException{ //Robot Pollueur sauteur
    	super(M3);
    	for(int i=LDebut; i<m.nbL; i= i+pas)
				for(int j=CDebut; j<m.nbC; j=j+pas)
					m.Mat[i][j] = true;    				
    }
    public void parcourir(){} 
}