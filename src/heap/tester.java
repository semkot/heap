package heap;

import java.io.Console;

public class tester {

	public static void main(String[] args) {
		FibonacciHeap f = new FibonacciHeap();
		f.insert(22);
		f.insert(13);
		f.insert(12);
		f.insert(10);
		f.insert(15);
		f.insert(17);
		f.insert(18);
		f.insert(19);
		f.insert(24);

		FibonacciHeap g = new FibonacciHeap();
		g.insert(2);
		g.insert(1);
		g.insert(122);
		g.insert(101);
		g.insert(155);
		g.insert(176);
		g.insert(5);
		g.insert(11);
		g.insert(16);

		g.deleteMin();
		f.deleteMin();
		printHeap(f);
		System.out.println();
		printHeap(g);
		f.meld(g);
		System.out.println();
		printHeap(f);
		System.out.println();
		f.deleteMin();
		System.out.println("last");
		printHeap(f);
		System.out.println(f.min.key);











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
		System.out.println(prefix + (isTail ? "└── " : "├── ") + node.key + parentString);
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



