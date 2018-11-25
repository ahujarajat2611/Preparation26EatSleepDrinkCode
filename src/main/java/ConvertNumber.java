/**
 * Created by hadoop on 24/1/18.
 */
public class ConvertNumber {
    public static String getValue( long input) {
        if ( input == 0)
            return "0";
        else if ( input == 1)
            return "a";
        else if( input == 2)
            return "t";
        else if ( input == 3)
            return "l";
        else if ( input == 4)
            return "s";
        else if ( input == 5)
            return "i";
        else
            return "n";
    }

    public static String convert(long input) {
        if ( input < 7 ){
            return getValue(input);
        }
        String res = new String();
        while ( input > 0 ) {
            res = getValue(input % 7) + res;
            input /= 7;
        }
        return res;
    }


    public static void main(String[] args) {

        long number =  6;

        System.out.println(convert(number));

    }
}
