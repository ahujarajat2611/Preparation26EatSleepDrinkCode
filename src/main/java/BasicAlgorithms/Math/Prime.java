package BasicAlgorithms.Math;

public class Prime {

    public static void main(String[] args) {
        long begin = System.currentTimeMillis();
        System.out.println(begin);
        runEratosthenesSieve(100000000);
        System.out.println();
        System.out.println(System.currentTimeMillis() - begin);
    }

    public static void runEratosthenesSieve(int upperBound) {

        // Math.sqrt
        // Math.sqrt
        int upperBoundSquareRoot = (int) Math.sqrt(upperBound);

        boolean[] isComposite = new boolean[upperBound + 1];

        for (int m = 2; m <= upperBoundSquareRoot; m++) {
            if (!isComposite[m]) {
                System.out.print(m + " ");
                for (int k = m * m; k <= upperBound; k += m)
                    isComposite[k] = true;
            }
        }

        for (int m = upperBoundSquareRoot; m <= upperBound; m++)
            if (!isComposite[m])
                System.out.print(m + " ");

    }
}
