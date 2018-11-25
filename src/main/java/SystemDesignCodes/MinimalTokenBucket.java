package SystemDesignCodes;

import java.util.LinkedList;

/**
 * Created by hadoop on 8/10/17.
 */
public class MinimalTokenBucket {
    private long availableTokens;
    private  long perioidMilliSeconds;
    private LinkedList<Issue> issuedTokens = new LinkedList<>();
    public MinimalTokenBucket(long tokens,long perioidMilliSeconds){
        this.availableTokens = tokens;
        this.perioidMilliSeconds = perioidMilliSeconds;
    }
    private class Issue{
        long tokens;
        long timeStampMillis;

        public Issue(long tokens, long timeStampMillis) {
            this.tokens = tokens;
            this.timeStampMillis = timeStampMillis;
        }
    }

    synchronized boolean tryConsume(int numberOfTokens){
        long now = System.currentTimeMillis();
        clearObseleteIssues(now);
        if(availableTokens>=numberOfTokens){
            availableTokens-=numberOfTokens;
            issuedTokens.addLast(new Issue(numberOfTokens,now));
            return true;
        }
        else {
            return false;
        }
    }

    private void clearObseleteIssues(long now) {
        while (!issuedTokens.isEmpty()){
            Issue issue = issuedTokens.getFirst();
            if(now-issue.timeStampMillis >perioidMilliSeconds){
                availableTokens +=issue.tokens;
                issuedTokens.removeFirst();
            }
            else {
                break;
            }
        }
    }

}
//https://github.com/vladimir-bukhtoyarov/bucket4j/blob/2.1/doc-pages/token-bucket-brief-overview.md#example-of-basic-java-token-bucket-implementation
