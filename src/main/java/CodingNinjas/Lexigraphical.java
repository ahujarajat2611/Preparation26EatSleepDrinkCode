package CodingNinjas;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * Created by hadoop on 5/10/17.
 */
public class Lexigraphical {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<String> strings = new ArrayList<>();
        for(int i=1;i<=n;i++){
            strings.add(String.valueOf(i));
        }
        Collections.sort(strings);
        for(int i=0;i<strings.size();i++){
            System.out.print(strings.get(i));
            if(i!=strings.size()-1) {
                System.out.println();
            }
        }
    }
}
