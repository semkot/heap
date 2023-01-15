package heap;

import static heap.tester.printHeap;

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
	public HeapNode first;
	public HeapNode min;
    public int size;

    private static int totalCuts = 0;
    private static int totalLinks = 0;

	public FibonacciHeap() {
		this.first=null;
        this.min=null;
        this.size=0;
	
	}
    public int getSize(){
        return this.size;
    }
	
    public boolean isEmpty()
    {
    	return (this.size==0);
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
        newNode.rank=0;
        this.addToRootList(newNode);
        this.size++;
        return newNode;
    }


//     adds a node to the 'List' of trees of the heap
    private void addToRootList(HeapNode node) {

        if (this.first == null) {
            this.first = node;
            node.prev = node;
            node.next = node;
        } else {
            node.prev = this.first.prev;
            node.next = this.first;
            this.first.prev.next = node;
            this.first.prev = node;
        }
        if (this.min==null || node.key < this.min.key) {
            this.min = node;
        }
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
            HeapNode current = child;//22
            do {
                current.parent = null;
                current = current.next;//22

            } while (current != child);
            this.first.prev.next = child;
            child.prev.next = this.first;
            HeapNode temp = this.first.prev;
            this.first.prev = child.prev;
            child.prev = temp;
        }
        if (this.min == this.first) {
            this.first = this.first.next;
        }
        this.min.prev.next = this.min.next;
        this.min.next.prev = this.min.prev;
        this.min = null;
        this.size--;
        this.min = this.first;
        if (this.size > 0) {
            consolidate();
            HeapNode current = this.first;
            this.min = current;
            do {
                if (current.key < this.min.key) {
                    this.min = current;
                }
                current = current.next;
            } while (current != this.first);
        }

        if (this.isEmpty()){
            this.min=null;
            this.first=null;
        }


    }


    private void consolidate() {
        int maxRank = (int) Math.floor(Math.log(this.size)) + 2;
        HeapNode[] bucketsList = new HeapNode[maxRank];
        for (int i = 0; i < maxRank; i++) {
            bucketsList[i] = null;
        }

        // Create an array to store the roots of the heap
        HeapNode[] roots = new HeapNode[this.size];
        int numRoots = 0;
        HeapNode current = this.first;
        do {
            roots[numRoots] = current;
            current = current.next;
            numRoots++;
        } while (current != this.first);

        for (int i = 0; i < numRoots; i++) {
            HeapNode x = roots[i];
            int rank = x.rank;
            while (bucketsList[rank] != null) {
                HeapNode y = bucketsList[rank];
                if (x.key > y.key) {
                    HeapNode temp = x;
                    x = y;
                    y = temp;
                }
                if (y == this.first) {
                    this.first = y.next;
                }
                if (y == this.min) {
                    this.min = x;
                }
                y.prev.next = y.next;
                y.next.prev = y.prev;
                x.addChild(y);
                bucketsList[rank] = null;
                rank++;
            }
            bucketsList[rank] = x;
        }

        this.first = null;
        this.min = this.first;
        for (int i = 0; i < maxRank; i++) {
            if (bucketsList[i] != null) {
                if (this.min==null || bucketsList[i].key < this.min.key) {
                    this.min = bucketsList[i];
                }
                if (this.first == null) {
                    this.first = bucketsList[i];
                    bucketsList[i].prev = bucketsList[i];
                    bucketsList[i].next = bucketsList[i];
                } else {
                    bucketsList[i].prev = this.first.prev;
                    bucketsList[i].next = this.first;
                    this.first.prev.next = bucketsList[i];
                    this.first.prev = bucketsList[i];
                }
            }
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
    	return this.min;// should be replaced by student code
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
    public void decreaseKey(HeapNode x, int delta)
    {    
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



//        addchild: a function to add a child to a node and include all the pointers
       public void addChild(HeapNode existingTree) {
           if(existingTree.parent != null) {
               existingTree.parent.removeChild(existingTree);
           }
           existingTree.parent = this;
           existingTree.prev = existingTree;
           existingTree.next = existingTree;
           if(this.child == null) {
               this.child = existingTree;
           } else {
               existingTree.prev = this.child.prev;
               existingTree.next = this.child;
               this.child.prev.next = existingTree;
               this.child.prev = existingTree;
           }
           this.rank++;
       }
       //removeChild: a function to remove a child from a node and remove all the needed pointers
       private void removeChild(HeapNode child) {
           if (this.child == this.child.next) {
               this.child = null;
           } else {
               child.prev.next = child.next;
               child.next.prev = child.prev;
               if (this.child == child) {
                   this.child = child.next;
               }
           }
           child.parent = null;
           this.rank--;
       }

   }
}
