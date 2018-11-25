package AwangDevLintCode;

/**
 * Created by hadoop on 6/2/18.
 */
import java.util.*;
public class WordExist {
    int dirx[]={1,-1,0,0};
    int diry[]={0,0,1,-1};
    public List<String> findWords(char[][] board, String[] words) {
        AutoComplete autoComplete = new AutoComplete();

        for(String word:words) {
            autoComplete.insertWord(word);
        }

        List<String> foundWords = new ArrayList<>();
        findWordsAgain(board,foundWords,autoComplete);
        return foundWords;
    }

    private void findWordsAgain(char[][] board, List<String> foundWords, AutoComplete autoComplete) {
        int r = board.length;
        int c = board[0].length;
        boolean [][]visited = new boolean[r][c];
        for(int i=0;i<r;i++){
            for(int j =0;j<c;j++){
                visited[i][j] = true;
                dfsHelper(i,j,autoComplete.root,foundWords,board,visited);
                visited = new boolean[r][c];
            }
        }
    }

    private void dfsHelper(int i, int j, TrieNode current, List<String> foundWords, char[][] board, boolean[][] visited) {

        char c = board[i][j];
        System.out.println("char =>" +c);
        // ideally this check should have been in child recursion step
        // thats the way you have to go forward !!!
        if(!current.children.containsKey(c)){
            return;
        }
        current = current.children.get(c);
        if(current.isWord){
            if(!foundWords.contains(current.prefix)){
                foundWords.add(current.prefix);
            }
        }
        for(int k=0;k<4;k++){
            int newi = i+ dirx[k];
            int newj = j+ diry[k];
            if(!isValid(newi,newj,board.length,board[0].length) ){
                continue;
            }
            if(visited[newi][newj]){
                continue;
            }
            // have to find all possible paths hence backtracking required
            visited[newi][newj] = true;
            dfsHelper(newi,newj,current,foundWords,board,visited);
            visited[newi][newj] = false;
        }

    }

    private boolean isValid(int newi, int newj,int r,int c) {
        if(newi>=0 && newi<r && newj>=0 && newj<c){
            return true;
        }
        return false;
    }
    public static void main(String args[]){
        WordExist findWords = new WordExist();
        char [][]board = {
                {'o', 'a', 'a', 'n'},
                {'e', 't', 'a', 'e'},
                {'i', 'h', 'k', 'r'},
                {'i', 'f', 'l', 'v'}
        };
        char [][]board1 = {
                {'a', 'b'},
                {'c', 'd'}
        };

        String []words = {"eat","oath"};
        String words1[] ={"cdba"};
        System.out.println(findWords.findWords(board1,words1));
    }
}
