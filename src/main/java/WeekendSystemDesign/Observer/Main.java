package WeekendSystemDesign.Observer;

/**
 * Created by hadoop on 11/3/18.
 */
public class Main {
    public static void main(String[] args) {
        DataSource source = new DataSource();
        source.register(new HallwayDisplay(source));
        source.setPeopleInSpace(5);
    }

}
/*
http://blog.indrek.io/articles/design-patterns-observer-pattern-implementation-in-java/

 */