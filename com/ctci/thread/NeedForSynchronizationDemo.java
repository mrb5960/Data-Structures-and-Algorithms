package com.ctci.thread;

class NeedForSynchronizationDemo
{
   public static void main (String [] args)
   {
      FinTrans1 ft = new FinTrans1 ();
      TransThread1 tt1 = new TransThread1 (ft, "Deposit Thread");
      TransThread1 tt2 = new TransThread1 (ft, "Withdrawal Thread");
      tt1.start ();
      tt2.start ();
   }
}
class FinTrans1
{
   public String transName;
   public double amount;
}
class TransThread1 extends Thread
{
   private FinTrans1 ft;
   TransThread1 (FinTrans1 ft, String name)
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
               // Start of deposit thread's critical code section
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
               // End of deposit thread's critical code section
           }
           else
           {
               // Start of withdrawal thread's critical code section
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
               // End of withdrawal thread's critical code section
           }
      }
   }
}
