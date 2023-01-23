package heap;

public class experiment2 {

    public static void main(String[] args) {
        insertAndDelete2((int) Math.pow(3, 6) - 1);
        insertAndDelete2((int) Math.pow(3, 8) - 1);
        insertAndDelete2((int) Math.pow(3, 10) - 1);
        insertAndDelete2((int) Math.pow(3, 12) - 1);
        insertAndDelete2((int) Math.pow(3, 14) - 1);

    }





    public static void insertAndDelete2(int m) {
        FibonacciHeap f = new FibonacciHeap();
        long startTime = System.currentTimeMillis();
        for (int k = 0; k <= m; k++) {
            f.insert(k);
        }
        for (int i = 1; i <= (3*m)/4; i++) {
            f.deleteMin();
        }
        long endTime = System.currentTimeMillis();
        long runTime = endTime - startTime;
        int totalLinks = f.totalLinks();
        int totalCuts = f.totalCuts();
        int potential = f.size + f.marked - 1;
        System.out.println("m\tRun-Time (ms)\ttotalLinks\ttotalCuts\tPotential");
        System.out.println(m + "\t" + runTime + "\t" + totalLinks + "\t" + totalCuts + "\t" + potential);
    }

}
