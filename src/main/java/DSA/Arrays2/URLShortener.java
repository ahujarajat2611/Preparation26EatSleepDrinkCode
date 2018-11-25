/**
 * 
 */
package DSA.Arrays2;

import java.util.HashMap;

/**
 * @author Raj
 *
 *
 */
public class URLShortener {
// Given an array of n elements which contains elements from 0 to n-1

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		URLShortener obj = new URLShortener();
		int id = 12345;
		String url = null;
		int _id = 0;
		url = obj.idToShortUrl(999999999);
		System.out.println(url);
		_id = obj.shortUrlToId("baba");
		System.out.println(_id);


		url = obj.idToShortUrlMine(999999999);
		System.out.println(url);
		_id = obj.shortUrlToIdMine("baba");
		System.out.println(_id);
	}

	char a[] = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't',
			'u', 'v', 'w', 'x', 'y', 'z', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O',
			'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', };

	private int shortUrlToId(String url) {
		int id = 0;
		char ch;
		for (int i = 0; i < url.length(); i++) {
			ch = url.charAt(i);
			if (ch >= 'a' && ch <= 'z') {
				id = (id * 62) + (ch - 'a');
			} else if (ch >= 'A' && ch <= 'Z') {
				id = (id * 62) + (ch - 'A' + 26);
			} else if (ch >= '0' && ch <= '9') {
				id = (id * 62) + (ch - '0' + 52);
			}
		}
		return id;
	}
	public static HashMap<Integer,Character> inttochar = new HashMap<>();
	public static HashMap<Character,Integer> chartoint = new HashMap<>();
	static {
		
		for(int i=0;i<62;i++){
			if(i>=0&& i<26) {
				inttochar.put(i,(char) ('a' + i));
				chartoint.put((char) ('a' + i),i);
			}
			if(i>=26 && i<52){
				inttochar.put(i,(char)('A'+i-26));
				chartoint.put((char)('A'+i-26),i);
			}
			if(i>=52 && i<62){
				inttochar.put(i,(char)('0' + i-52));
				chartoint.put((char)('0' + i-52),i);
			}
		}
	}

	public String idToShortUrl(int id) {
		StringBuilder sb = new StringBuilder();
		while (id > 0) {
			sb.append(a[id % 62]);
			id = id / 62;
		}
		sb.reverse();
		return sb.toString();
	}
	public String idToShortUrlMine(int id) {
		StringBuilder sb = new StringBuilder();
		while (id > 0) {
			sb.append(inttochar.get(id % 62));
			id = id / 62;
		}
		sb.reverse();
		return sb.toString();
	}
	private int shortUrlToIdMine(String url) {
		int id = 0;
		char ch;
		for (int i = 0; i < url.length(); i++) {
			ch = url.charAt(i);
			id = id*62 + chartoint.get(ch);
		}
		return id;
	}

}
