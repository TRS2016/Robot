public class RobotNettoyeurs extends Robot{
    int  numRobot;
    int numColonne;
    
    
    public RobotNettoyeurs(Monde M) throws ajoutPapierException{  //Nettoie tout le Monde
 	    	super(0,0,M);
 	    	for(int i=0; i<m.nbL; i++)
 				for(int j=0; j<m.nbC; j++)
 					m.Mat[i][j] = false;
    }
    public RobotNettoyeurs(int nC, Monde M1) throws ajoutPapierException{ //Nettoyeur tout droit
        	super(0,nC,M1);
        	numColonne = nC;
        	for(int i=0; i<m.nbL; i++)
    			m.Mat[i][numColonne] = false;
    }
    public RobotNettoyeurs(Monde M2, int unused) throws ajoutPapierException{ //Nettoyeur Aléatoire
    	super(M2);
    	m.Mat[posx][posy] = false;    				
    }
    public RobotNettoyeurs(Monde M3, int pas, int LDebut, int CDebut) throws ajoutPapierException{ //Nettoyeur sauteur
    	super(M3);
    	for(int i=LDebut; i<m.nbL; i= i+pas)
				for(int j=CDebut; j<m.nbC; j=j+pas)
					m.Mat[i][j] = false;    				
    }
    public void parcourir(){} 
}