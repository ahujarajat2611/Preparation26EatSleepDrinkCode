package OldAttemptLearning.shirleyisnotageek;

/**
 * Created by hadoop on 21/1/18.
 */
/*
Given an API ReadFromDisk() which returns a block of 256 bytes from disk. Implement the API Read(SizeInBytes) which reads SizeInBytes bytes from the disk by calling only ReadFromDisk. Notice that every call to ReadFromDisk() will read the next 256 bytes from disk.
Update 2015 - 03 - 30
I realize that I understood the ReadN problem wrong, the char[] buff is the output array. Here is the updated version. I updated the ReadN too.

 */
public class ReadBytes {
    public int read2(byte[] buff, int sizeInBytes){
        int index = 0, next = 0;
        //assume return -1 if reach the end of the file
        byte[] tmp = new byte[256];
        while(index < sizeInBytes && (next = readFromDisk(tmp))!= -1)
            for(int i = 0; i< next && index < sizeInBytes; buff[index++] = tmp[i++]);
        return index;
    }
    public int readFromDisk(byte[] buff){
        return 256;
    }
}
