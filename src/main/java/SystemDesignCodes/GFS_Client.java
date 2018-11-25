package SystemDesignCodes;

import java.util.Map;

/**
 * Created by hadoop on 7/10/17.
 */
class BaseGFSClient {
     private Map<String, String> chunk_list;
     public BaseGFSClient() {}
      public String readChunk(String filename, int chunkIndex) {
          // Read a chunk from GFS
          return null;
      }
      public void writeChunk(String filename, int chunkIndex,
                             String content) {
          // Write a chunk to GFS
      }
  }
public class GFS_Client extends BaseGFSClient{
    Map<String,Integer> nameToChunkSize;
    int chunkSize; // 64mb 128 mb
    GFS_Client(int chunkSize){
        this.chunkSize = chunkSize;
    }
    public void writeFile(String filename,String content){
        int partitions = content.length()/chunkSize;
        if(content.length()%chunkSize != 0){
            partitions+=1;
        }
        nameToChunkSize.put(filename,partitions);
        for(int i=0;i<=partitions;i++){
            int startpointer = i*chunkSize;
            int endpointer = Math.min(content.length(),(i+1)*chunkSize);
            writeChunk(filename,i,content.substring(startpointer,endpointer));
        }

    }
    public String readFile(String filename){
        int partitions = nameToChunkSize.get(filename);
        String content = "";
        for(int i=0;i<=partitions;i++){
            content = content +readChunk(filename,i);
        }
        return content;
    }
}
