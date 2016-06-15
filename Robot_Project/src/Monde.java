public class Monde{
    int nbL;
    int nbC;
    boolean Mat[][];
    
    public Monde(){
        nbL = 10;
        nbC = 10;
        Mat = new boolean[nbL][nbC];
    }
    public void ajoutPapier(int nL, int nC)
        throws ajoutPapierException
        {
            if(nL > nbL || nC > nbC)
                throw new ajoutPapierException();
            else
                Mat[nL][nC] = true;
        }
    public void LirePapier(int nL, int nC)
        throws ajoutPapierException
        {
            if(nL > nbL || nC > nbC)
                throw new ajoutPapierException();
            else
            {
                if(Mat[nL][nC] == true)
                    System.out.println(Mat[nL][nC]);
                else
                    System.out.println("Cette case n'a pas de papier gras !!!");
            }
                
        }
    public boolean testPapierGras(int nL, int nC)
        throws ajoutPapierException
        {
            if(nL > nbL || nC > nbC)
                throw new ajoutPapierException();
            else
            {
                if(Mat[nL][nC] == true)
                    return true;
                else
                    return false;
            }
        }
    public int comptePapierGras(){
        int compte=0;
        for(int i=0; i<Mat.length; i++)
            for(int j=0; j<Mat.length; j++)
                if(Mat[i][j] == true)
                    compte++;
        
        return compte;
        
    }
}