package OldAttemptLearning.shirleyisnotageek;

import java.util.ArrayList;
import java.util.Arrays;
 
/*
 Missing Ranges
Given a sorted integer array where the range of elements are [0, 99] inclusive, return its missing ranges.
For example, given [0, 1, 3, 50, 75], return [“2”, “4->49”, “51->74”, “76->99”]

My code is based on an unsorted array and any given range.
  */
public class MissingRange {
 public ArrayList<String> findRange(int[] vals, int start, int end)
 {
  ArrayList<String> rst = new ArrayList<String>();
  if (vals == null || vals.length == 0)
   return rst;
  Arrays.sort(vals);
  int index = 0;
  while (vals[index] <= start)
   index++;
  rst.add(buildRange(start, vals[index] - 1));
  index++;
  while(vals[index] < end)
  {
   if (vals[index] - vals[index - 1] > 1)
    rst.add(buildRange(vals[index - 1] + 1, vals[index] - 1));
   index++;
  }
  index--;
  rst.add(buildRange(vals[index] + 1, end));
  return rst;
 }
 private String buildRange(int start, int end)
 {
  if (start == end)
   return String.valueOf(start);
  return start + " -> " + end;
 }
 
}