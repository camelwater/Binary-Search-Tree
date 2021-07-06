import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;

public class GraphicTreeRunner 
{
	public static void main(String args[])throws IOException
	{
		Scanner input = new Scanner(new File("graphictree.txt"));
		BinarySearchTree t = new BinarySearchTree();
		ArrayList<String>list = new ArrayList<String>();
		while(input.hasNext())
		{
			String x = input.next();
			list.add(x);
			t.add(new BinaryNode(x));
		}
		t.computeNodePositions();
		GraphicTree g = new GraphicTree(t, list);
	}
}
