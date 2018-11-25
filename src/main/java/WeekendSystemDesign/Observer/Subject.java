package WeekendSystemDesign.Observer;

public interface Subject {
    void register(Observer observer);
    void remove(Observer observer);
    void notifyObservers();
    int getState();
}