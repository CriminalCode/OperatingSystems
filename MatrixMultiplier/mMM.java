import java.util.*;
import java.io.*;
import java.util.concurrent.*;

public class mMM
{
    
    public static void main(String [] args) throws Exception
    {
        (new mMM()).go();
    }
    
    private void go() throws Exception
    {

       //File A = new File("A1.txt");
       //File B = new File("B1.txt");
     
       //String s2 = "A1.txt";
       //String s = "B1.txt";
       
       Scanner key = new Scanner(System.in);
       
       System.out.println("Welome to THE Matrix \n Please enter the name of the file to multiply by. (You must keep in mind that in the case \n of matrix multiplication order matters)");
       
       //String s = "A-Big.txt";  //second
       //String s2 = "B-Big.txt"; //this is the first file the user imputs
       String s2 = key.nextLine();
       System.out.println("Please enter the full name of your second file");
       String s = key.nextLine();
       
       Matrix a = new Matrix(s);
       Matrix b = new Matrix(s2);
       
       int cRow = a.getColumns();
       int cColumn = b.getRows();
       int c1 = b.getColumns();
       //System.out.println("Columns "+cColumn);
       //System.out.println("Rows "+cRow);
       
       //System.out.println(cRouj nw);
       
       Matrix c = new Matrix(cRow,cColumn);
       
       
       List<Callable<Boolean>> tasks = new ArrayList<Callable<Boolean>>();
       
       for(int i = 0; i < cRow; i++)
       {
         for(int j = 0; j < cColumn; j++)
         {
            int row = i;
            int column = j;
            Callable<Boolean> task = new MyThread(row, column, c, a, b, cColumn, c1);
		    tasks.add(task);
         }
       }
    
       //
       ExecutorService executor = Executors.newFixedThreadPool(50);
		List<Future<Boolean>> futures = executor.invokeAll(tasks);

		/*for (Future<Boolean> f : futures)
		{
			if (!f.get())
			  throw new Exception("Thread completion error!");
		}*/
		executor.shutdown();
       //
     
        
         System.out.println(c.toString());
        
         System.out.println(c.getCellTotal());
    }
    
    public class MyThread implements Callable<Boolean>
	 {
		private int m_rowat;
		private int m_columnat;
		private Matrix m_Matrix;
		private int rLength;
		private Matrix a;
		private Matrix b;
		int cLength;
		int m_c1;
		                              //Matricies that we are passing in to our internal class
		public MyThread(int r, int c, Matrix matrix, Matrix a1, Matrix b1, int cl, int c1)
		{
			m_rowat = r;
			m_columnat = c;
			m_Matrix = matrix;
			b = b1;
			a = a1;
			m_c1 = c1;
			
			cLength = cl;
		
		}
		
		@Override
		public 	Boolean call()
		{
		    int cellVal = 0;
		    
		   
		   // i< .. this will be  c1 or r2 of matrix a or b
	      for (int i = 0; i < m_c1; i++)
	      {                 
	        int cellA = a.getCell(m_rowat, i);  
	        
	        int cellB = b.getCell(i, m_columnat);
	        
	        int temp = cellA * cellB;
	        
	        cellVal = cellVal + temp;
	        
	      }
	        String cellValueInt = cellVal +""; 
	      
	      m_Matrix.setCell(m_rowat, m_columnat, cellValueInt);
		  return true;
		}	
		
	 }
 
    public static int getBiggestRowSize(int aRow, int bRow)
    {  
        int newMatrixRowLength = 0;
        
        if(aRow>bRow)
           newMatrixRowLength = bRow;
        else
        newMatrixRowLength = aRow;
        
        return newMatrixRowLength;
    }
    
    public static int getBiggestColumnSize(int aColumb, int bColumb)
    {
        int MatrixColumbLength;
        
        if(aColumb>bColumb)
           MatrixColumbLength = bColumb;
        else
        MatrixColumbLength = aColumb;
        
        return MatrixColumbLength;
    }
    
    
}









