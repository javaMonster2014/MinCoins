
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {

    private int coinTotal; //stores the minimal number of coins
    private int coinTotal_fromFile; //stores the values from file
    private int temp; //used as a temporary container for computation
    
    //Main default constructor
    public Main(int c)
    {
        //init coinTotal_fromFile to the integer read from file
        this.coinTotal_fromFile=c;
        
        //initi coinTotal
        this.coinTotal=0;
        
        //prints the minimal number of coins: calls numberOfCoins()
        printCoinTotal(); 
    } //Coins::coin() end
    
    private int numberOfCoins()
    {
        //recurse on the coinTotal_fromFile, until coinTotal_fromFile==0
        while (coinTotal_fromFile>0)
        {
            //test to see how many fives can be used
            if(coinTotal_fromFile>=5) 
            {
                temp=coinTotal_fromFile/5; //maximal number of fives
                coinTotal+=temp; //increment running coinTotal by temp
                //subtract the prodcut from to total read from file
                coinTotal_fromFile=coinTotal_fromFile-(temp*5);
                
            }
            if(coinTotal_fromFile<5 && coinTotal_fromFile>=3)
            {
                temp=coinTotal_fromFile/3;
                coinTotal+=temp;
                coinTotal_fromFile=coinTotal_fromFile-(temp*3);
            }
            if(coinTotal_fromFile<3 && coinTotal_fromFile>=1) 
            {
                coinTotal+=1;
                coinTotal_fromFile=coinTotal_fromFile-1;
            }   
        }
        
        return coinTotal; //return the minimal number of coins 
    }//Coins::numberOfCoins() end
    
    //prints the minimal number of coins, calculated by
    //int numberOfCoins()
    private void  printCoinTotal(){ System.out.println(numberOfCoins());}
    
    
    
    public static void main(String[] args)
    {
        BufferedReader cin = null; //used to buffer the file input
        String line; //stores the line read from file
        Main coins;

        try {
                File file = new File (args[0]); //open file from arg[0]
                cin = new BufferedReader(new FileReader(file)); //start new buffer
                
                //retrieve data from file: stop on null
                while((line=cin.readLine())!=null)
                {
                    //calculate the minimal number of coins, per line
                    coins= new Main(Integer.parseInt(line));
                }
                
                cin.close(); //done with file; done with buffer.
            }//end try
   
            catch (IOException ex) 
            {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }//end catch

     }//Coins::main end

}//Class Coins end
