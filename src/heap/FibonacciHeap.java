package heap;

/**
 * FibonacciHeap
 *
 * An implementation of a Fibonacci Heap over integers.
 */
public class FibonacciHeap
{

   /**
    * public boolean isEmpty()
    *
    * Returns true if and only if the heap is empty.
    *   
    */
	private HeapNode first;
	private HeapNode min;
    private int size;

    private static int totalCuts = 0;
    private static int totalLinks = 0;

	public FibonacciHeap() {
		this.first=null;
        this.min=null;
        this.size=0;
	
	}
	
    public boolean isEmpty()
    {
    	return this.min==0;
    }
		
   /**
    * public HeapNode insert(int key)
    *
    * Creates a node (of type HeapNode) which contains the given key, and inserts it into the heap.
    * The added key is assumed not to already belong to the heap.  
    * 
    * Returns the newly created node.
    */
    public HeapNode insert(int key)
    {
        HeapNode newNode = new HeapNode(key);
        if (this.min == null) {
            this.first = newNode;
            this.min = newNode;
        } else {
            newNode.prev = this.first;
            newNode.next = this.first.next;
            this.first.next.prev = newNode;
            this.first.next = newNode;
            if (key < this.min.key) {
                min = newNode;
            }
        }
        this.size++;
        return newNode;
    }

   /**
    * public void deleteMin()
    *
    * Deletes the node containing the minimum key.
    *
    */
    public void deleteMin()
    {
        if (this.min == null) {
            return;
        }
        HeapNode child = this.min.child;
        if (child != null) {
            HeapNode current = child;
            do {
                current.parent = null;
                current = current.next;
            } while (current != child);
            this.first.prev.next = child;
            child.prev.next = this.first;
            HeapNode temp = this.first.prev;
            this.first.prev = child.prev;
            child.prev = temp;
        }
        this.min.prev.next = min.next;
        this.min.next.prev = min.prev;
        if (min == min.next) {
            this.first = null;
        } else {
            this.first = min.next;
        }
        this.min = null;
        this.size--;
        if (size > 0) {
            consolidate();
        }
     	
    }

   /**
    * public HeapNode findMin()
    *
    * Returns the node of the heap whose key is minimal, or null if the heap is empty.
    *
    */
    public HeapNode findMin()
    {
    	return new HeapNode(678);// should be replaced by student code
    } 
    
   /**
    * public void meld (FibonacciHeap heap2)
    *
    * Melds heap2 with the current heap.
    *
    */
    public void meld (FibonacciHeap heap2)
    {
    	  return; // should be replaced by student code   		
    }

   /**
    * public int size()
    *
    * Returns the number of elements in the heap.
    *   
    */
    public int size()
    {
    	return -123; // should be replaced by student code
    }
    	
    /**
    * public int[] countersRep()
    *
    * Return an array of counters. The i-th entry contains the number of trees of order i in the heap.
    * (Note: The size of of the array depends on the maximum order of a tree.)  
    * 
    */
    public int[] countersRep()
    {
    	int[] arr = new int[100];
        return arr; //	 to be replaced by student code
    }
	
   /**
    * public void delete(HeapNode x)
    *
    * Deletes the node x from the heap.
	* It is assumed that x indeed belongs to the heap.
    *
    */
    public void delete(HeapNode x) 
    {    
    	return; // should be replaced by student code
    }

   /**
    * public void decreaseKey(HeapNode x, int delta)
    *
    * Decreases the key of the node x by a non-negative value delta. The structure of the heap should be updated
    * to reflect this change (for example, the cascading cuts procedure should be applied if needed).
    */
    public void cut(HeapNode x, HeapNode y) {
    	x.parent = null;
    	x.marked = false;
    	y.rank -= 1;
    	if (x.next == x)
    		y.child = null;
    	else {
    		y.child = x.next;
    		x.prev.next = x.next;
    		x.next.prev = x.prev;
    	}
    	totalCuts += 1;
    }
    
    public void cascadingCut(HeapNode x, HeapNode y) {
    	cut(x, y);
    	addToRootList(x);
    	if (y.parent != null) {
    		if (!y.marked)
    			y.marked = true;
    		else
    			cascadingCut(y, y.parent);
    	}
    }
    
    public void decreaseKey(HeapNode x, int delta)
    {    
    	x.key -= delta;
    	if (x.parent == null || x.key > x.parent.key) { // No structure change;
    		return;
    	}
    	cascadingCut(x, x.parent);
    	
    	
    	return; // should be replaced by student code
    }

   /**
    * public int nonMarked() 
    *
    * This function returns the current number of non-marked items in the heap
    */
    public int nonMarked() 
    {    
        return -232; // should be replaced by student code
    }

   /**
    * public int potential() 
    *
    * This function returns the current potential of the heap, which is:
    * Potential = #trees + 2*#marked
    * 
    * In words: The potential equals to the number of trees in the heap
    * plus twice the number of marked nodes in the heap. 
    */
    public int potential() 
    {    
        return -234; // should be replaced by student code
    }

   /**
    * public static int totalLinks() 
    *
    * This static function returns the total number of link operations made during the
    * run-time of the program. A link operation is the operation which gets as input two
    * trees of the same rank, and generates a tree of rank bigger by one, by hanging the
    * tree which has larger value in its root under the other tree.
    */
    public static int totalLinks()
    {    
    	return -345; // should be replaced by student code
    }

   /**
    * public static int totalCuts() 
    *
    * This static function returns the total number of cut operations made during the
    * run-time of the program. A cut operation is the operation which disconnects a subtree
    * from its parent (during decreaseKey/delete methods). 
    */
    public static int totalCuts()
    {    
    	return -456; // should be replaced by student code
    }

     /**
    * public static int[] kMin(FibonacciHeap H, int k) 
    *
    * This static function returns the k smallest elements in a Fibonacci heap that contains a single tree.
    * The function should run in O(k*deg(H)). (deg(H) is the degree of the only tree in H.)
    *  
    * ###CRITICAL### : you are NOT allowed to change H. 
    */
    public static int[] kMin(FibonacciHeap H, int k)
    {    
        int[] arr = new int[100];
        return arr; // should be replaced by student code
    }
    
   /**
    * public class HeapNode
    * 
    * If you wish to implement classes other than FibonacciHeap
    * (for example HeapNode), do it in this file, not in another file. 
    *  
    */
    public static class HeapNode{

    	public int key;
    	public HeapNode child; 
    	public HeapNode next;
    	public HeapNode prev;
    	public HeapNode parent; 
    	public boolean marked;
    	public int rank;

    	public HeapNode(int key) {
    		this.key = key;
    	}

    	public int getKey() {
    		return this.key;
    	}
    }
}
