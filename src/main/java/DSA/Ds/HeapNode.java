package DSA.Ds;

/**
 * Created by hadoop on 11/2/18.
 */
public class HeapNode<T> {
    T data;
    int weight;
    public HeapNode(int weight, T data){
        this.weight = weight;
        this.data = data;
    }
}
