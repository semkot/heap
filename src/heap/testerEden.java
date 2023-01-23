package heap;

import java.io.Console;

import heap.FibonacciHeap.HeapNode;

public class testerEden {

    public static void main(String[] args) {

        insertAndDelete((int)Math.pow(2,5));
        insertAndDelete((int)Math.pow(2,10));
        insertAndDelete((int)Math.pow(2,15));
        insertAndDelete((int)Math.pow(2,20));










    }
    public static void insertAndDelete(int m) {
        FibonacciHeap f = new FibonacciHeap();
        HeapNode[] nodes = new HeapNode[m];
        long startTime = System.currentTimeMillis();
        for (int k = m - 1; k >= 0; k--) {
            nodes[k] = f.insert(k);
        }
        f.deleteMin();
        for (int i = (int) (Math.log(m) / Math.log(2)); i >= 1; i--) {
            f.decreaseKey(nodes[(int) (m - Math.pow(2, i) + 1)], m + 1);
        }
        long endTime = System.currentTimeMillis();
        long runTime = endTime - startTime;
        int totalLinks = f.totalLinks();
        int totalCuts = f.totalCuts();
        int potential = f.size + f.marked - 1;
        System.out.println("m\tRun-Time (ms)\ttotalLinks\ttotalCuts\tPotential");
        System.out.println(m + "\t" + runTime + "\t" + totalLinks + "\t" + totalCuts + "\t" + potential);
    }


    static void printHeap(FibonacciHeap f) {
        if (f.isEmpty()) {
            System.out.println("Heap is empty!");
            return;
        }
        FibonacciHeap.HeapNode current = f.first;
        do {
            printNode(current, null, "", true);
            current = current.next;
        } while (current != f.first);
    }

    static void printNode(FibonacciHeap.HeapNode node, FibonacciHeap.HeapNode parent, String prefix, boolean isTail) {
        String parentString = "";
        if (parent != null) {
            parentString = " parent: " + parent.key;
        }
        System.out.println(prefix + (isTail ? "└── " : "├── ") + node.key + parentString  + " rank: " + node.rank);
        FibonacciHeap.HeapNode current = node.child;
        if (current != null) {
            printNode(current, node, prefix + (isTail ? "    " : "│   "), false);
            current = current.next;
            while (current != node.child) {
                printNode(current, node, prefix + (isTail ? "    " : "│   "), false);
                current = current.next;
            }
        }
    }






}



