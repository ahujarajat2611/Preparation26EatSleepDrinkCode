/**
 *
 */
package BasicAlgorithms.String;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Raj
 *
 *
 *         Given an array of words and a length L,
 *         format the text such that
 *         each line has exactly L characters and is fully (left and right)
 *         justified.
 *
 *         You should pack your words in a greedy approach; that is, pack as
 *         many words as you can in each line. Pad extra spaces ' ' when
 *         necessary so that each line has exactly L characters.
 *
 *
 *         Extra spaces between words should be distributed as evenly as
 *         possible.
 *         If the number of spaces on a line do not divide evenly
 *         between words, the empty slots on the left will be assigned more
 *         spaces than the slots on the right.
 *
 *         For the last line of text, it should be left justified and no extra
 *         space is inserted between words.
 *
 *         For example, words: ["This", "is", "an", "example", "of", "text",
 *         "justification."] L: 16.
 *
 *         Return the formatted lines as: [ "This    is    an",
 *         "example  of text", "justification.  " ] Note: Each word is
 *         guaranteed not to exceed L in length.
 */
public class TextJustification {

    public List<String> fullJustify(String[] words, int L) {
        List<String> lines = new ArrayList<String>();

        int start = 0;
        while (start < words.length) {
            int lenSoFar = words[start].length();
            int end = start + 1;
            while (end < words.length) {
                if (lenSoFar + 1 + words[end].length() > L)
                    break;
                lenSoFar += 1 + words[end].length();
                end++;
            }

            StringBuilder sb = new StringBuilder();
            int count = end - start;
            // if last line or number of words in the line is 1, left-justified
            if (end == words.length || count == 1) {
                for (int i = start; i < end; i++) {
                    sb.append(words[i] + " ");
                }
                sb.deleteCharAt(sb.length() - 1);
                sb.append(getNSpaces(L - sb.length()));
            } else {

                int reqSpaces = L - lenSoFar;

                int r = reqSpaces % (count - 1);
                // middle justified
                for (int i = start; i < end; i++, r--) {
                    sb.append(words[i]);
                    if (i != end - 1) {
                        // below it's n+1,extra +1 comes from 'default counted
                        // space from above'
                        int n = (reqSpaces / (count - 1)) + (r > 0 ? 1 : 0);
                        sb.append(getNSpaces(1 + n));
                    }
                }
            }
            lines.add(sb.toString());
            start = end;
        }

        return lines;
    }

    public List<String> fullJustify2(String[] words, int L) {
        List<String> lines = new ArrayList<String>();

        int start = 0;
        while (start < words.length) {
            int lenSoFar = words[start].length();
            int end = start + 1;
            while (end < words.length) {
                if (lenSoFar + 1 + words[end].length() > L)
                    break;
                lenSoFar += 1 + words[end].length();
                end++;
            }

            StringBuilder sb = new StringBuilder();
            int count = end - start;
            String x="";
            // if last line or number of words in the line is 1, left-justified
            if (end == words.length || count == 1) {
                prettylast(words,start,end,count,L);
//				for (int i = publish; i < end; i++) {
//					sb.append(words[i] + " ");
//				}
//				sb.deleteCharAt(sb.length() - 1);
//				sb.append(getNSpaces(L - sb.length()));
            } else {
                x = prettybetween(words,start,end,count,L);
//				int reqSpaces = L - lenSoFar;
//
//				// middle justified
//				for (int i = publish; i < end; i++) {
//					sb.append(words[i]);
//
//					if (i != end - 1) {
//						int r = reqSpaces % (count - 1);
//						int n = (r == 0) ? (reqSpaces / (count - 1)) : (reqSpaces / (count - 1)) + 1;
//						// below it's n+1,extra +1 comes from 'default counted
//						// space from above'
//						sb.append(getNSpaces(n + 1));
//						reqSpaces -= n;
//						count--;
//					}
//				}
            }
            lines.add(x);
            start = end;
        }

        return lines;
    }

    private String getNSpaces(int n) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(" ");
        }
        return sb.toString();
    }

    private String prettybetween(String[] words, int start, int end, int length, int maxWidth) {
        int numberwords = end-start+1;
        String result = "";
        int i=0;
        int freespace = maxWidth - length;
        if(numberwords == 1){
            return words[start]+addspacenew(maxWidth-words[start].length());
        }
        int slots = numberwords-1;
        int each = freespace/slots;
        int remaininginleft = freespace%slots;
        while (i<numberwords-1){
            result = result + words[start+i];
            if(i<remaininginleft){
                result = result +" ";
            }
            result = result+ addspacenew(each);
            i++;
        }
        result  = result + words[end];
        return result;
    }
    private String prettylast(String[] words, int start, int end, int length, int maxWidth) {
        int numberwords = end-start+1;
        String result = "";
        int i=0;
        int freespaceintheend = maxWidth - length -numberwords+1;
        while (i<numberwords-1){
            result = result + words[start+i];
            result = result +" ";
            i++;
        }
        result  = result + words[end];
        result = result + addspacenew(freespaceintheend);
        return result;
    }
    public static void main(String[] args) {
        TextJustification obj = new TextJustification();
        String sentence[] = { "This", "is", "an", "example", "of", "text", "justification." };
        List<String> res = null;
        int maxWidth = 16;
        res = obj.fullJustify(sentence, maxWidth);
        System.out.println(res);
        String a[] = { "a", "b", "c", "d", "e" };
        res = obj.fullJustify(a, 3);
        System.out.println(res);

        String b[] = { "Here", "is", "an", "example", "of", "text", "justification." };
        res = obj.fullJustify(b, 16);
        System.out.println(res);

    }
    private String addspacenew(int wid){
        String space = "";
        for(int i=0;i<wid;i++){
            space = space+" ";
        }
        return space;
    }

}
/*
package BasicAlgorithms.String;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by hadoop on 15/10/17.
 */
/*public class TextJustification {
	public List<String> fullJustify(String[] words, int maxWidth) {
		List<String> list = new ArrayList<>();
		if(words == null || words.length ==0){
			return list;
		}
		int publish=0;
		int end=0;
		boolean newline  = true;
		int currentlen =0;
		int currentcount =0;
		int counter = 0;
		if(maxWidth == 0){
			list.addAll(Arrays.asList(words));
			return list;
		}
		boolean lastlineadded = false;
		while (end<words.length){
			System.out.println("end"+end);
			if(newline){
				currentcount=1;
				currentlen =words[end].length();
				System.out.println("lenn"+currentlen);
				System.out.println("counn"+currentcount);
			}
			else {
				currentlen+=words[end].length();
				currentcount++;
				System.out.println("len"+currentlen);
				System.out.println("coun"+currentcount);
			}
			if(currentlen+currentcount-1>maxWidth){

				System.out.println("publish"+publish);
				System.out.println("end"+end);
				list.add(prettybetween(words, publish, end - 1, currentlen - words[end].length(), maxWidth));
				publish = end;
				newline = true;

			}
			else if(currentlen+currentcount-1==maxWidth){
				System.out.println("enterting");
				list.add(prettybetween(words, publish, end, currentlen, maxWidth));
				publish = end+1 ;
				end = end +1;
				if(end>=words.length){
					lastlineadded = true;
				}
				newline = true;
			}
			else {
				end++;
				newline = false;
			}
			counter++;
			if(counter>50){
				System.exit(1);
			}
		}
		if(!lastlineadded) {
			list.add(prettylast(words, publish, end - 1, currentlen, maxWidth));
		}
		return list;
	}

	private String prettybetween(String[] words, int publish, int end, int length, int maxWidth) {
		int numberwords = end-publish+1;
		String result = "";
		int i=0;
		int freespace = maxWidth - length;
		if(numberwords == 1){
			return words[publish]+addspacenew(maxWidth-words[publish].length());
		}
		int slots = numberwords-1;
		int each = freespace/slots;
		int remaininginleft = freespace%slots;
		while (i<numberwords-1){
			result = result + words[publish+i];
			if(i<remaininginleft){
				result = result +" ";
			}
			result = result+ addspacenew(each);
			i++;
		}
		result  = result + words[end];
		return result;
	}
	private String prettylast(String[] words, int publish, int end, int length, int maxWidth) {
		int numberwords = end-publish+1;
		String result = "";
		int i=0;
		int freespaceintheend = maxWidth - length -numberwords+1;
		while (i<numberwords-1){
			result = result + words[publish+i];
			result = result +" ";
			i++;
		}
		result  = result + words[end];
		result = result + addspacenew(freespaceintheend);
		return result;
	}
	private String addspacenew(int wid){
		String space = "";
		for(int i=0;i<wid;i++){
			space = space+" ";
		}
		return space;
	}
	public static void main(String args[]){
		BasicAlgorithms.String.TextJustification textJustification = new BasicAlgorithms.String.TextJustification();
		String[] words = new String[]{"This", "is", "an", "example", "of", "text", "justification."};
		int l=3;
		int L = 16;
		String word[] ={"a","b","c","d","e"};
		List<String> list = textJustification.fullJustify(word,l);
		System.out.println(list);
	}
}
 */
