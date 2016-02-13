import java.io.*;
import java.util.Scanner;


public class richestTest {
	
	static final int  MAX_NUM_IN_RAM = 100;

		public static void main(String[] args) throws FileNotFoundException 
		{
			minimumHeap heap = readInNumbers(new FileReader("num.txt"));
			heap.heapSort();
			outputToFile(heap);
			System.out.println("all done!");
		}

		private static minimumHeap readInNumbers(FileReader readFile) throws FileNotFoundException
		{
			int[] initalHeap = new int [(MAX_NUM_IN_RAM+1)];
			Scanner input = new Scanner(readFile);
			minimumHeap heap = null;
			if(input.hasNext()) //There is at least one number in the file
			{
				int i=1;
				try {
					while(input.hasNext() && i<((MAX_NUM_IN_RAM+1))) //input 10 numbers into the heap
						{
								initalHeap[i] = input.nextInt();
								i++;
						}

					if(heap == null) //we haven't created a heap yet
						heap = new minimumHeap(initalHeap); //create the initalHeap

					while(input.hasNext())	//While there are numbers in the file
						{
							heap.compareWithRoot(input.nextInt()); //Compare them with the root	
						}
				}
					catch(Exception e)
					{
						e.printStackTrace();
					}
					input.close();
					
				}
			return heap;
			}


			private static void outputToFile(minimumHeap heap)
			{
				int[] output = heap.getHeapArray();
				
				try {

					BufferedWriter writer = new BufferedWriter(new FileWriter("numoutput"));
					for ( int i=1;i<output.length;i++)
					{      
						writer.write(output[i] + "\n");
						System.out.println(output[i]);
					}
					writer.close();
				} catch(IOException ex) {
					ex.printStackTrace();
				}
			}
		}
