import java.util.*;

public class d
{
    public static void main(String[] args)
    {
        Scanner key = new Scanner(System.in);
         System.out.println("Please enter n");
        /* int n = key.nextInt();*/
         int n = 8;
         group[] gArray = new group[n];
         int numberOfGroups = n;
         int[] firstNumber = new int[1];
         Random random = new Random();
         
         
         for(int i = 0; i < n; i++)
         {
             firstNumber = new int[1];
             firstNumber[0] = random.nextInt(15) + 1;
             
             System.out.println("Random Number = " + firstNumber[0]);
             
             group tempGroup = new group(firstNumber); 
             
             System.out.println(tempGroup.toString());
             
             gArray[i] = tempGroup; 
             
        
         }
        
          for(group g : gArray)
            System.out.println(g.toString());
            
    }
}