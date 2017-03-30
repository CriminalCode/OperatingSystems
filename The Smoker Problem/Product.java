public class Product
 {
     int Type = 0;
     private boolean m_taken;

     
     // create randomness in waiter/Dealer
     public Product(int productType)
     {
         Type = productType;
         m_taken = false;
         //USE SEMAPHORE
         // 1 = paper
         // 2 = tabbaco
         // and 3 = match
     }
     
     public int getType()
     {
         return Type;
     }
     

	public synchronized boolean grab()
	{
		if (m_taken)
			return false;
		else
			m_taken = true;
		return m_taken;
	}

	public synchronized void release()
	{
		m_taken = false;
	}
 }