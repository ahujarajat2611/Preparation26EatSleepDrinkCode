package SystemDesignCodes.Threading;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class Manager {
    static final int N = 3;
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch start = new CountDownLatch(1);
        CountDownLatch done = new CountDownLatch(N); 
        ExecutorService service = Executors.newFixedThreadPool(N);
        service.execute(new Downloader(start,done,"http://www.google.com","google.txt"));
        service.execute(new Downloader(start,done,"http://www.southwest.com","southwest.txt"));
        service.execute(new Downloader(start,done,"http://www.learnquest.com","learnquest.txt"));
        System.out.println("Manager should give a go signal");
        start.countDown(); // go ahead threads, download stuff
        done.await();
        System.out.println("all tasks done, now do something");
        
    }
   private static class Downloader implements Runnable{
        CountDownLatch start;
        CountDownLatch done ;
        private String site;
        private String file; 
        
        private Downloader(CountDownLatch start, CountDownLatch done, String site,String file) {
            this.start = start;
            this.done = done;
            this.site = site;
            this.file = file;
        }

        @Override
        public void run() {
            try {
                start.await();
                URL url = new URL(site);
                InputStream inputStream = url.openConnection().getInputStream();
                BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
                FileWriter writer = new FileWriter("c:/temp/"+file);
                char[] buffer = new char[8096];
                int counter = -1;
                while((counter = reader.read(buffer)) != -1){
                    writer.write(buffer,0,counter);
                }
                writer.flush();
                writer.close();
                System.out.println("Finished dowloading "+site);
                done.countDown();
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } 
        }
        
    }
}