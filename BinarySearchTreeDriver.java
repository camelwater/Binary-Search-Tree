import java.util.*;
import static java.lang.System.*;
import java.io.*;

@SuppressWarnings("unchecked")
public class BinarySearchTreeDriver {
	public static void main(String args[])throws IOException
	{
		Scanner input = new Scanner(new File("BinarySearchTree.txt"));
		
		BinarySearchTree tree = new BinarySearchTree();
		int numLines = input.nextInt();
		input.nextLine();
		for(int i=0; i<numLines; i++)
		{
			String[] list = input.nextLine().split(" ");
			for(String k:list)
			{
				BinaryNode temp = new BinaryNode(k);
				tree.add(temp);
			}
		}
		
		out.print("Tree-->");
		out.print(tree+"\n");
		out.println("PRE ORDER");
		out.print(tree.preOrder()+"\n");
		out.println("POST ORDER");
		out.print(tree.postOrder()+"\n");
		out.println("IN ORDER");
		out.print(tree.inOrder()+"\n");
		out.println("REVERSE ORDER");
		out.print(tree.reverseOrder()+"\n");
		out.println("Number of leaves: "+tree.getNumLeaves());
		out.println("Number of levels: "+tree.getNumLevels());
		out.println("The Tree width: "+tree.getWidth());
		out.println("The Tree height: "+tree.getHeight());
		out.println("Number of nodes: "+tree.getNumNodes());
		if(tree.isFull())
			out.println("Tree is full");
		else
			out.println("Tree is not full.");
		
		numLines = input.nextInt();
		for(int i=0; i<numLines; i++)
		{
			String x = input.next();
			if(tree.contains(x))
				out.println("Tree contains "+x);
			else
				out.println("Tree does not contain "+x);
		}	
		
		out.println("Largest value: "+tree.getLargest());
		out.println("Smallest value: "+tree.getSmallest());
		out.print("Level order: ");
		out.print(tree.levelOrder()+"\n");
		
//		numLines = input.nextInt();
//		for(int i=0; i<numLines; i++)
//		{
//			String x = input.next();
//			BinaryNode k = tree.remove(x);
//			if(k!=null)
//			{
//				out.println("Level Order Tree after removing: "+k);
//				out.print("Level order: ");
//				out.print(tree.levelOrder()+"\n");
//			}
//			else
//				out.println("Cannot remove "+x+" from tree");
//		}
		
		out.println("Proper Tree Display");
		tree.printFullTree(Math.min(tree.getNumLevels(),6));
	}
}

