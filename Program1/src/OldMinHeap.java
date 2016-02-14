
public class OldMinHeap {

	private int[] heap;
	private int size; //number of items in the heap
	private int heapStart;
	/*
	 * array is an array with index 0 empty
	 */
	public OldMinHeap(int[] array) 
	{
		heap=array;
		//heap = new int[(array.length+1)]; //make an array that is one bigger than the input for 1 based indexing
		//System.arraycopy(array, 0, heap, 1, array.length);
		//for(int i=0;i<array.length;i++) //for every int in the array
			//heap[(i+1)] = array[i];	//put each in into the heap with indexing 1
		this.size = heap.length-1;
		heapStart = 1;
		buildMinHeap();
		
		/*
		System.out.println("PRINTING THE BUILD MIN HEAP");
		for(int i=1;i<=size;i++)
		{
			System.out.println(heap[i]);
		}
		System.out.println("DONE");	
		*/
	}
	

	
/*	public MinHeap(int maxSize, int[] array) 
	{
		this.size=0;
		heap = new int[(maxSize+1)]; //make an array that is one bigger than the input for 1 based indexing
		heap[0] = Integer.MIN_VALUE;
		for(int i=0;i<array.length;i++) //for every int in the array
			{
			heap[(i+1)] = array[i];	//put each in into the heap with indexing 1
			this.size++;
			}
		
		buildMinHeap();
		System.out.println("PRINTING THE BUILD MIN HEAP");
		for(int i=1;i<=size;i++)
		{
			System.out.println(heap[i]);
		}
		System.out.println("DONE");
		
	}*/

	public void buildMinHeap()
	{
		for(int seat=(size/2); seat>=heapStart; seat--)
		{
			minHeapify(seat);
		}
	}
	 
	public int[] getHeapArray()
	{
		return heap;
	}
	
	public void heapSort()
	{
		for(int i= size; i > 1; i--)
		{
			swap(1,i);
			size --;
			//buildMinHeap();
			minHeapify(1);
			}
	}
	
	public int getRoot()
	{
		return heap[1];
	}

	public void replaceRoot(int value)
	{
		heap[heapStart]=value;
		heapify(heapStart);
	}
	
	public void removeRootInPlace()
	{
		for(int i= 1;i<(heap.length-1); i++)
		{
		size--;
		heapStart++;
		buildMinHeap();
		}
	}

	public int removeRoot()
	{
		int root = heap[1];
		size--;
		int[] newArray = new int[(size+1)];
		for(int i = 1; i<newArray.length;i++)
		{
			newArray[i]= heap[i+1];
		}
		heap=newArray;
		buildMinHeap();
		return root;
	}

	
	/*
	private void minHeapifyWithout(int seat){
        int left = lChild(seat);
        int right = rChild(seat);
        int min;
        if(size >= left && heap[left] < heap[seat]){
            min = left;
        }else{
            min = seat;
        }

        if(size >= right && heap[right] < heap[min]){
            min = right;
        }

        if(min != seat){
            swap(seat, min);
            minHeapify(lChild(seat));
            minHeapify(rChild(seat));
        }
    }
	
	private int lChild(int pos)
	{
		return (pos * 2);
	}
	private int rChild(int pos)
	{
		return ((pos * 2) + 1);
	}
	
	*/
 private void minHeapify(int seat)
 {
        int left = leftChild(seat);
        int right = rightChild(seat);
        int min;
        if(left != -1 && heap[left] < heap[seat]){
            min = left;
        }else
        {
            min = seat;
        }

        if(right != -1 && heap[right] < heap[min]){
            min = right;
        }

        if(min != seat){
            swap(seat, min);
            if(left !=-1)
            	minHeapify(left);
            if(right !=-1)
            	minHeapify(right);
        }
    }
		
	private void heapify(int seat) {
		int leftChildIndex = leftChild(seat);
		int rightChildIndex = rightChild(seat);
		//int min;

		if (!isLeaf(seat)) //If it is not a leaf
		{
			if(leftChildIndex != -1 && rightChildIndex != -1) //Both children exist
			{
				if(heap[leftChildIndex] < heap[seat]|| heap[rightChildIndex] < heap[seat]) //If either of the children are smaller
				{
					if(heap[leftChildIndex] < heap[rightChildIndex]) // Left child is the smallest
					{
						swap(seat,leftChildIndex);
						//buildMinHeap();
						heapify(leftChildIndex);
						heapify(rightChildIndex);
					}

					else if (heap[rightChildIndex] < heap[leftChildIndex]) // Right child is the smallest
					{
						swap(seat,rightChildIndex);
						//buildMinHeap();
						heapify(rightChildIndex);
						heapify(leftChildIndex);
					}
				}
			}
			
			else if(leftChildIndex != -1) //Left child exists
				{
					if(heap[leftChildIndex]< heap[seat]) //if the left child is smaller
					{
							swap(seat,leftChildIndex);
							//buildMinHeap();
							heapify(leftChildIndex);
							//heapify(seat);
					}
				}
			}
		}

	private boolean isLeaf(int seat) {
		if (leftChild(seat) == -1) // The left child doesn't exist
		return true;
		else
		return false;
	}

	private void swap(int seat1, int seat2)
	{
		int tmp;
		tmp = heap[seat1];
		heap[seat1] = heap[seat2];
		heap[seat2] = tmp;
	}

	/*
	 * Return the seat of left child node. Returns -1 if the left child does not
	 * exist.
	 */
	private int leftChild(int seat) {
		int LChildSeat = (seat * 2);
		if (LChildSeat > size)
			return -1; // There is no leftChild
		else
			return LChildSeat;
	}

	/*
	 * Return the seat of right child node. Returns -1 if the right child does
	 * not exist.
	 */
	private int rightChild(int seat) {
		int RChildSeat = ((seat * 2) + 1);
		if (RChildSeat > size)
			return -1; // There is no rightChild
		else
			return RChildSeat;
	}


}