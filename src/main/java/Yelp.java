import BasicAlgorithms.utils.ConsoleWriter;
import java.io.*;
import java.util.*;

/**
 * Created by hadoop on 19/12/17.
 */

public class Yelp {
    public static void main(String[] args) {
        FastReader fastReader = new FastReader();
        //int a = fastReader.nextInt();
        //System.out.println(a);
        ConsoleWriter.printIntArray(new int[]{1,2});
        System.out.println("ANs");
        Yelp yelp = new Yelp();
        List<List<String>> list = new LinkedList<>();
        list.add(new LinkedList<>());
        list.add(new LinkedList<>());
        list.add(new LinkedList<>());
        list.get(0).add("red");
        list.get(0).add("green");
        list.get(0).add("red");
        list.get(1).add("black");
        list.get(1).add("red");
        list.get(1).add("green");
        list.get(2).add("yellow");
        list.get(2).add("yellow");
        list.get(2).add("yellow");
        List<String> addd = new LinkedList<>();
        addd.add("why");
        addd.add("why");
        addd.add("why");
        addd.add("why");
        addd.add("why");
        List<String> againcolor = new LinkedList<>();
        againcolor.add("self");
        againcolor.add("self");
        againcolor.add("self");
        againcolor.add("self");
        againcolor.add("self");

        list.add(addd);
        list.add(againcolor);
        System.out.println(yelp.topColor(list));
    }


    // take away
    // frequency to TreeSet map (GOod approach)
    public List<String> topColor(List<List<String>> image) {
        System.out.println("ans");
        TreeMap<Integer,TreeSet<String>> set = new TreeMap<>(Collections.reverseOrder());
        HashMap<String,Integer> freq = new HashMap<>();
        for(List<String> row: image){
            for(String color: row ){
                if(!freq.containsKey(color)){
                    freq.put(color,0);
                }
                freq.put(color,freq.get(color)+1);
            }
        }

        for(Map.Entry<String,Integer> entry:freq.entrySet()) {
            if (!set.containsKey(entry.getValue())) {
                set.put(entry.getValue(), new TreeSet<>());
            }
            set.get(entry.getValue()).add(entry.getKey());
        }
        return new LinkedList<>(set.firstEntry().getValue());
    }

    static class FastReader
    {
        BufferedReader br;
        StringTokenizer st;

        public FastReader()
        {
            br = new BufferedReader(new
                    InputStreamReader(System.in));
        }

        String next()
        {
            while (st == null || !st.hasMoreElements())
            {
                try
                {
                    st = new StringTokenizer(br.readLine());
                }
                catch (IOException  e)
                {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt()
        {
            return Integer.parseInt(next());
        }

        long nextLong()
        {
            return Long.parseLong(next());
        }

        double nextDouble()
        {
            return Double.parseDouble(next());
        }

        String nextLine()
        {
            String str = "";
            try
            {
                str = br.readLine();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
            return str;
        }
    }
}
