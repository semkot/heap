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


		f.deleteMin();
		System.out.println(f.findMin().key);
		f.deleteMin();
		System.out.println(f.findMin().key);
		f.deleteMin();
		System.out.println(f.findMin().key);
		f.deleteMin();
		System.out.println(f.findMin().key);
		f.deleteMin();
		System.out.println(f.findMin().key);
		f.deleteMin();
		System.out.println(f.findMin().key);
		f.deleteMin();
		System.out.println(f.findMin().key);



	}
}



