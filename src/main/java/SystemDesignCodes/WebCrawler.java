package SystemDesignCodes;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by hadoop on 7/10/17.
 */
public class WebCrawler {
    Set<String> visitedUrls;
    Queue<String> urlPool;

    ReentrantLock lock;
    private static AtomicLong finished = new AtomicLong(0);

    List<String> crawler(String url){
        urlPool.offer(url);
        CrawlerThread [] threads = new CrawlerThread[16];
        for(int i=0;i<16;i++){
            threads[i].start();
        }
        while (!(urlPool.size() == 0 && finished.get() ==0l)){
            continue;
        }
        return new ArrayList<>(visitedUrls);
    }


}
class CrawlerThread extends Thread{
    Set<String> visitedUrls;
    Queue<String> urlPool;
    ReentrantLock lock;
    AtomicLong finished;
    HtmlParser htmlParser = new HtmlParser();

    CrawlerThread(Set<String>visitedUrls,Queue<String>urlPool,ReentrantLock lock,AtomicLong finished){
        this.visitedUrls = visitedUrls;
        this.urlPool = urlPool;
        this.lock = lock;
        this.finished = finished;
    }
    public void run() {
        while (true) { // imp condtion while(true) gets used in many problems
            if(urlPool.size() == 0 && finished.get() ==0l){
                break;
            }
            lock.lock();
            String polledUrl = urlPool.poll();
            if(visitedUrls.contains(polledUrl)){
                continue;
            }
            lock.unlock();
            if(polledUrl!=null){
                finished.incrementAndGet();
                visitedUrls.add(polledUrl);
                // Parsing takes lot of time so doing it outside the lock
                //maintain two sets queue for bfs
                // implementing BFS in each craweler just that multithread
                // so we put while(true) condition and also using lock structure
                // we could have used blocking queue ..
                // to make it simpler we could have used blocking queue
                // basically abstract out the all threading code
                // its simple produicer consumer problem
                // useed reentrant lock becure it can enter again and again
                // many threads using same lock since its the same shared resource
                // can you think of some other logic so that we donot need to use fininshed
                // state variable .. some sort of counter requered shared counter kind of concept
                // when queue size becomes zero then all other threads should not stoppppp
                // since running thread might end up putting
                // even if we had used blocking queue since we required one counter to tell its stopped now
                //almost impossible to solve this problem without finished counter to manage all thread
                // in live state
                List<String> parsedUrls = htmlParser.parsedUrls(polledUrl);

                lock.lock();
                urlPool.addAll(new ArrayList<>(parsedUrls));
                lock.unlock();
                finished.decrementAndGet();
            }
        }

    }
}

class HtmlParser{
    List<String> parsedUrls(String url){
        return new ArrayList<>();
    }
}
