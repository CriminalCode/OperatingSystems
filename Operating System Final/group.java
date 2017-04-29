public class group
{
    int numberArray[];
    int number;
    
    group(/*int n,*/ int[] array)
    {
        /*number = n;*/
        numberArray = array;
    }
    
    group(/*int n,*/ int n)
    {
        number = n;
    }
    
    @Override
    public String toString()
    { 
     String temp = "";
     
     for(int in : numberArray)
     {
        temp = temp + in;
     }
     return temp;
 }
 
}