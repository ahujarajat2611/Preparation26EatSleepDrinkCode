package OldAttemptLearning.shirleyisnotageek;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
/*
Valid words

You are given a string 's'
and you are given a dictionary of english words.
 You goal is to write an algorithm that returns
 all words from the dictionary the can be formed by
  characters from that string 's'.
Example:
s = "ogeg"
following words can be formed from 's': go egg ego . . .
Further it is given that string 's' always consists of
four lower case characters.
 Lets say that the dictionary is contained in a file and
 can be fitted in the memory.
 It is up to you which data structure you use to represent the dictionary.
How would you design an efficient algorithm?
Follow up: What if the dictionary file can not be fitted in the memory?


This is a very interesting question. The problem statement is kind confusing.
Here is a question, why do we need to put the whole dictionary
into the memory?
 The goal is to output all words that can be formed from s.
 From the example,
 we know that the order doesn't matter.
 So we only need to construct a hash map and
  store all four characters of s in it.
  And then read the dict
  from the stream and compare it
  with the characters in the hash map.
   I used another hash map.
   Since there are at most four characters
   for both strings,
    we don't need much extra space, do we?

If the question is,
 how to store the output words in an efficient way,
  I guess Trie would be a good one.
 */
/**
 * Created by hadoop on 21/1/18.
 */
public class ValidWords {
    public static void validWords(String s, String dict) throws FileNotFoundException, IOException {
        BufferedReader br = new BufferedReader(new FileReader(dict));
        String currLine;
        Map<Character,Integer> sMap = new HashMap<Character,Integer>();
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(!sMap.containsKey(c))
                sMap.put(c, 1);
            else
                sMap.put(c, sMap.get(c) + 1);
        }
        // better create two hashmaps rather than modifycing and copying it agian and agian
        //
        Map<Character,Integer> word = new HashMap<Character,Integer>();
        while((currLine = br.readLine()) != null){
            if(currLine.length() > 4)
                continue;
            word.clear();
            boolean valid = true;
            for(int i = 0; i < currLine.length(); i++){
                char c = currLine.charAt(i);
                if(!sMap.containsKey(c)){
                    valid = false;
                    break;
                }
                if(!word.containsKey(c))
                    word.put(c, 1);
                else
                    word.put(c, word.get(c) + 1);
                if(word.get(c) > sMap.get(c)){
                    valid = false;
                    break;
                }
            }
            if(valid)
                System.out.println(currLine);
        }
        br.close();
    }
}
