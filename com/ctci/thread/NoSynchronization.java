package com.ctci.thread;

// https://www.javaworld.com/article/2074318/java-concurrency/java-101--understanding-java-threads--part-2--thread-synchronization.html?page=2

class NoSynchronizationDemo
{
   public static void main (String [] args)
   {
      FinTrans2 ft = new FinTrans2 ();
      TransThread2 tt1 = new TransThread2 (ft, "Deposit Thread");
      TransThread2 tt2 = new TransThread2 (ft, "Withdrawal Thread");
      tt1.start ();
      tt2.start ();
   }
}
class FinTrans2
{
   public String transName;
   public double amount;
}
class TransThread2 extends Thread
{
   private FinTrans2 ft;
   TransThread2 (FinTrans2 ft, String name)
   {
      super (name); // Save thread's name
      this.ft = ft; // Save reference to financial transaction object
   }
   public void run ()
   {
      for (int i = 0; i < 100; i++)
      {
           if (getName ().equals ("Deposit Thread"))
           {
               synchronized (this)
               {
                  ft.transName = "Deposit";
                  try
                  {
                     Thread.sleep ((int) (Math.random () * 1000));
                  }
                  catch (InterruptedException e)
                  {
                  }
                  ft.amount = 2000.0;
                  System.out.println (ft.transName + " " + ft.amount);
               }
           }
           else
           {
               synchronized (this)
               {
                  ft.transName = "Withdrawal";
                  try
                  {
                     Thread.sleep ((int) (Math.random () * 1000));
                  }
                  catch (InterruptedException e)
                  {
                  }
                  ft.amount = 250.0;
                  System.out.println (ft.transName + " " + ft.amount);
               }
           }
      }
   }
}
