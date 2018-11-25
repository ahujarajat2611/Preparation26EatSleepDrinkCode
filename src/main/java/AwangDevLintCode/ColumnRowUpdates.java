package AwangDevLintCode;

/**
 * Created by hadoop on 3/2/18.
 */
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
/*
 Store info into class Cell {int x;  boolean isRow; long value}
    Save to arraylist. Later need to call list.remove(object)
    Use hash map to store the appearance <String, Cell>
    process the final data:
        keep track of curr single row cell sum = rowSum; also colSum
        during process: add up n*colorValue.
                        if row, minus rowSum
                        if col, minus colSum
 */
public class ColumnRowUpdates {
    class Cell {
        int x;
        boolean isRow;
        long value;
        public Cell(String s) {
            String[] ss = s.split(" ");
            this.isRow = ss[0].charAt(0) == 'R';
            this.x = Integer.parseInt(ss[1]);
            this.value = Long.parseLong(ss[2]);
        }
    }
    public static void main(String[] args) {
        ColumnRowUpdates sol = new ColumnRowUpdates();

        Scanner in = new Scanner(System.in);
        String[] ss = in.nextLine().split(" ");
        int N = Integer.parseInt(ss[0]);
        int P = Integer.parseInt(ss[1]);

        //Storage
        HashMap<String, Cell> map = new HashMap<String, Cell>();
        ArrayList<Cell> list = new ArrayList<Cell>();

        while (P != 0) {//O(P)
            //create Cell
            String s = in.nextLine();
            Cell cell = sol.new Cell(s);
            //add into list
            list.add(cell);
            //Check if cell exist in map.
            //if exist in map, replace it with current cell, and remove old cell from list
            String key = s.substring(0, s.lastIndexOf(" "));
            if (!map.containsKey(key)) {
                map.put(key, cell);
            } else {
                Cell oldCell = map.get(key);
                map.put(key, cell);
                list.remove(oldCell);
            }
            P--;
        }

        /*


        Take total sum variable .. once you update row or column
        // sum = row * rowlength but it will override columns which have been updated to we need to subtraect that
        // which we need to maitain in columnsum whenever there is columnudate
        // likewise we need to keep track oft row sum as well if we go for column update we need to subtract row sum as well !
        !!frmo total sum !!!
        rowsum
        colsum
        total sum
        sum = sum + updateedvalue * rowlength/collength - rowsum/colsum
        rowsum
        colsum needs to be update as well !!!!!!!
        //
         */
        //Process final results
        int sumCol = 0;
        int sumRow = 0;
        long sum = 0;
        for (int i = 0; i < list.size(); i++) {//O(P)
            Cell cell = list.get(i);
            sum += cell.value * N;
            if (cell.isRow) {
                // subtracing all cols value as well since all colms update will get vanished from sum
                //
                sum -= sumCol;
                //  addding if to row if its rrow update
                sumRow += cell.value;
            } else {
                sum -= sumRow;
                sumCol += cell.value;
            }
        }

        System.out.println(sum);
    }
}
