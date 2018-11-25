package SystemDesign;

/**
 * Created by hadoop on 20/2/18.
 */
public class NumberOfNodesInSystem {
}
/*

// distributed system
// N1-> N2 N3 ...Nn-1-<-Nn

// N1 N2 N3 N4 N5


class  Node {
    int totalNodes;
    Integer leftRecieve;
    Integer rightRecieve;

    isLeft(){
        leftRecieve = 0;
    }
    isRight(){
        rightRecieve = 0;
    }
    receiveLeft(int count){
            sendLeft(count+1);
        synchronized(this){
            leftRecieve = count;
            if(rightInteger!=null){
                updateNodes();
            }
        }
    }
    synchronized receiveRight(int count){
        sendRight(count+1);
        synchronized(this){
            rightRcieve = count;
            if(leftInteger!=null){
               updateNodes();
            }
        }
    }
    updateNodes(){
        totalNodes = 1 + leftRecieve + rightRecieve;
        System.ext(0);
    }
}
 */