package BasicAlgorithms.Math;

public class checkPowerOf2 {
    /*
     * @param n: An integer
     * @return: True or false
     */
	//1:1, 2: 10, 4: 100, 8: 1000由此可知2的幂最右位为1其他位为0. (x-1)&x = 0
	//考虑coner case, n = 0 和 n = Integer.MIN_VALUE的情况


        // take care of base cases like 0 andd int max ....
   public boolean checkPowerOf2(int n) {
    	return (n==0||n==Integer.MIN_VALUE)?false:((n-1)&n) == 0;
    }
}