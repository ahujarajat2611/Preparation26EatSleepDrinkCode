//package BasicAlgorithms.Cache;
//
///**
// * Created by hadoop on 27/1/18.
// */
////public class BloomFilter {
////    //http://pages.cs.wisc.edu/~cao/papers/summary-cache/node8.html
////
////}
//import java.util.BitSet;
//
//        public class BloomFilter
//        {
//    /* BitSet初始分配2^24个bit */
//        private static finalint DEFAULT_SIZE =1<<25;
//    /* 不同哈希函数的种子，一般应取质数 */
//        private static final int[] seeds =newint[] { 5, 7, 11, 13, 31, 37, 61 };
//private BitSet bits =new BitSet(DEFAULT_SIZE);
//    /* 哈希函数对象 */
//private SimpleHash[] func =new SimpleHash[seeds.length];
//
//public BloomFilter()
//        {
//        for (int i =0; i < seeds.length; i++)
//        {
//        func[i] =new SimpleHash(DEFAULT_SIZE, seeds[i]);
//        }
//        }
//
//        // 将字符串标记到bits中
//        public void add(String value)
//        {
//        for (SimpleHash f : func)
//        {
//        bits.set(f.hash(value), true);
//        }
//        }
//
//        //判断字符串是否已经被bits标记
//        publicboolean contains(String value)
//        {
//        if (value ==null)
//        {
//        returnfalse;
//        }
//        boolean ret =true;
//        for (SimpleHash f : func)
//        {
//        ret = ret && bits.get(f.hash(value));
//        }
//        return ret;
//        }
//
//    /* 哈希函数类 */
//        publicstaticclass SimpleHash
//        {
//        privateint cap;
//        privateint seed;
//
//public SimpleHash(int cap, int seed)
//        {
//        this.cap = cap;
//        this.seed = seed;
//        }
//
//        //hash函数，采用简单的加权和hash
//        publicint hash(String value)
//        {
//        int result =0;
//        int len = value.length();
//        for (int i =0; i < len; i++)
//        {
//        result = seed * result + value.charAt(i);
//        }
//        return (cap -1) & result;
//        }
//        }
//        }
