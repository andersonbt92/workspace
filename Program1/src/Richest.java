import java.io.*;
import java.util.Scanner;

public class Richest {

	public static void main(String[] args) throws FileNotFoundException 
	{
		FileReader readFile = new FileReader("testdata.txt");
		MinHeap heap = readInNumbers(readFile);
		//outputToFile(heap);
		System.out.println("all done!");
	}

	private static MinHeap readInNumbers(FileReader readFile) throws FileNotFoundException
	{
		//FileReader readFile = new FileReader("data.txt");
		int[] buffer = new int [10];
		Scanner input = new Scanner(readFile);
		MinHeap heap = null;

		while (input.hasNext()) //while there are still numbers in the file
		{
			int i=1;
			try {
				while(input.hasNext() && i<10) //input 10,000 numbers into the buffer
				{
					buffer[i] = input.nextInt();
					i++;
				}
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}

			if(heap == null)
			{
				heap = new MinHeap(buffer);
			}
			compareWithBuffer(buffer,heap);	
		}
		input.close();

		return heap;
	}

	private static MinHeap compareWithBuffer(int[] buffer, MinHeap heap)
	{
		for(int i =0; i<buffer.length;i++)
		{
			if(buffer[i]>= heap.getRoot())
			{
				heap.replaceRoot(buffer[i]);
			}
		}
		return heap;
	}

	
	/*private static void outputToFile(MinHeap minHeap)
	{
		int[] output = minHeap.returnArray();
		try {

			BufferedWriter writer = new BufferedWriter(new FileWriter("richest.output.txt"));
			for ( int i=output.length-1; i > 0; i--)
			{      
				writer.write(output[i]);
				writer.newLine();
				System.out.println(output[i]);
			}
			writer.close();
		} catch(IOException ex) {
			ex.printStackTrace();
		}
	} */
}
