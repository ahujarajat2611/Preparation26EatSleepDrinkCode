/*

Observer Design pattern is generic than
how it is implemented in Java.
You are free to choose java.util.Observable
 or java.util.Observer or writing your own Subject
 and Observer interface. I prefer having my own
 Subject and Observer interface and this is how
 I am going to write my Code Example of Observer design
  Pattern in java. Mine Example is very Simple you have a
  Loan on which interest rate is subject to change and
  when it changes, Loan notifies to Newspaper or Internet media to display new loan interest rate. To implement this we have a Subject interface which contains methods for adding, removing and notifying Observers and an Observer interface which contains update(int interest) method which will be called by Subject implementation when interest rate changes.


Read more: http://javarevisited.blogspot.com/2011/12/observer-design-pattern-java-example.html#ixzz5AI4hBmBm

 */


package WeekendSystemDesign.ObserverBest;

import java.util.ArrayList;

interface Observer {
       public void update(float interest);
}

interface Subject {
       public void registerObserver(Observer observer);

       public void removeObserver(Observer observer);

       public void notifyObservers();
}

class Loan implements Subject {
       private ArrayList<Observer> observers = new ArrayList<Observer>();
       private String type;
       private float interest;
       private String bank;

       public Loan(String type, float interest, String bank) {
              this.type = type;
              this.interest = interest;
              this.bank = bank;
       }

       public float getInterest() {
              return interest;
       }

       public void setInterest(float interest) {
              this.interest = interest;
              notifyObservers();
       }

       public String getBank() {
              return this.bank;
       }

       public String getType() {
              return this.type;
       }

       @Override
       public void registerObserver(Observer observer) {
              observers.add(observer);

       }

       @Override
       public void removeObserver(Observer observer) {
              observers.remove(observer);

       }

       @Override
       public void notifyObservers() {
              for (Observer ob : observers) {
                     System.out
                                  .println("Notifying Observers on change in Loan interest rate");
                     ob.update(this.interest);
              }

       }

}

class Newspaper implements Observer {
       @Override
       public void update(float interest) {
              System.out.println("Newspaper: Interest Rate updated, new Rate is: "
                           + interest);
       }
}

class Internet implements Observer {
       @Override
       public void update(float interest) {
              System.out.println("Internet: Interest Rate updated, new Rate is: "
                           + interest);
       }
}

public class ObserverTest {

       public static void main(String args[]) {
              // this will maintain all loans information
              Newspaper printMedia = new Newspaper();
              Internet onlineMedia = new Internet();

              Loan personalLoan = new Loan("Personal Loan", 12.5f,
                           "Standard Charterd");
              personalLoan.registerObserver(printMedia);
              personalLoan.registerObserver(onlineMedia);
              personalLoan.setInterest(3.5f);

       }
}


//Read more: http://javarevisited.blogspot.com/2011/12/observer-design-pattern-java-example.html#ixzz5AI4BVejv