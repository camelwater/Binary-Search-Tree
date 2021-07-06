import java.util.LinkedList;
import java.util.Queue;

@SuppressWarnings("unchecked")
public class BinarySearchTree
{
	public BinaryNode root;
	private static int maximum = 0;
	private static int minimum = 0;
	Queue<String>queue = new LinkedList<String>();
	public int width = 0;
	public int totalnodes = 0;
	
	public BinarySearchTree()
	{
		root = new BinaryNode();
	}
	public void computeNodePositions() 
	{
		int depth = 1;
		inorder_traversal(root, depth);
	}
	public void inorder_traversal(BinaryNode t, int depth) 
	{ 
		if (t != null) 
		{
			inorder_traversal(t.getLeft(), depth + 1); //add 1 to depth (y coordinate) 
			t.xpos = totalnodes++; //x coord is node number in inorder traversal
			t.ypos = depth; // mark y coord as depth
			inorder_traversal(t.getRight(), depth + 1);
		}
	}	
	public void add(BinaryNode n)
	{
		addRecursive(root, n.getValue());
		//System.out.println(root);
	}
	private void addRecursive(BinaryNode current, String x)
	{
		if(root.getValue() == null)
		{
			root = new BinaryNode(x);
			return;
		}
		int c = x.compareTo(current.getValue());
		//System.out.println(c);
		if(c>0 || c==0)
		{
			if(current.getRight().getValue() == null)
			{
				//current = current.getRight();
				current.setRight(new BinaryNode(x));
				return;
			}
			else
				addRecursive(current.getRight(), x);
		}
		else if(c<0)
		{
			//current = current.getLeft();
			if(current.getLeft().getValue() == null)
			{
				//current = current.getLeft();
				current.setLeft(new BinaryNode(x));
				return;
			}
			else
				addRecursive(current.getLeft(), x);
		}
		
	}

	public BinaryNode remove(String x) 
    { 
		if(!contains(x))
			return null;
        root = removeRec(this.root, x);
        return new BinaryNode(x);
    } 
  
    private BinaryNode removeRec(BinaryNode root, String key) 
    { 
    	//BinaryNode x = null;
        if (root == null || !contains(key))  
        	return root; 
        //recur down tree
        if (key.compareTo(root.getValue())<0) 
           root.setLeft( removeRec(root.getLeft(), key)); 
        else if (key.compareTo(root.getValue())>0) 
            root.setRight(removeRec(root.getRight(), key)); 
        else
        { 
        	//x = new BinaryNode(key);
        	//System.out.println(x);
            // node with only one child or none
            if (root.left == null) 
            {
            	return root.right;
                //System.out.println(root+" leftnull");
                
            }
            else if (root.right == null)
            {
                return root.left;
                //System.out.println(root+" rightnull");
            }
            else
            {
                BinaryNode j = getLargestRec(root.getLeft());
                j.right = root.right;
                root.right = null;
                return root.left;
            }
        }
        return root;
    } 
    public BinaryNode getRoot()
    {
    	return root;
    }
	public String preOrder()
	{
		String s = "";
		return preOrderRec(root, s); 
	}
	public String preOrderRec(BinaryNode x, String s)
	{
		
		if(x!= null)
		   {
		       //s+=x.getValue()+ " ";
			   System.out.print(x.getValue()+" ");
		       preOrderRec(x.getLeft(), s);
		       preOrderRec(x.getRight(), s);
		   }
		return s;
	}
	public String postOrder()
	{
		String s = "";
		return postOrderRec(root, s);
	}
	public String postOrderRec(BinaryNode x, String s)
	{
		if(x!= null)
		{
		    postOrderRec(x.getLeft(), s);
		    postOrderRec(x.getRight(), s);
		    //s+=x.getValue()+ " ";
		    System.out.print(x.getValue()+" ");
		} 
		return s;
	}
	public String inOrder()
	{
		String s = "";
		return inOrderRec(root, s);
	}
	public String inOrderRec(BinaryNode x, String s)
	{
		if(x!= null)
		{
		    inOrderRec(x.getLeft(), s);
		    //s+=x.getValue()+ " ";
		    System.out.print(x.getValue()+" ");
		    inOrderRec(x.getRight(), s);
		 }  
		return s;
	}
	public String reverseOrder()
	{
		String s = "";
		s = reverseOrderRec(root, s);
		return s;
	}
	public String reverseOrderRec(BinaryNode x, String s)
	{
		if(x!= null)
		{
			reverseOrderRec(x.getRight(), s);
		    //s+=x.getValue()+ " ";
			System.out.print(x.getValue()+" ");
		    reverseOrderRec(x.getLeft(), s);
		}  
		return s;
	}
	public void printFullTree(int x)
	{
		String s = fullLevelOrder(x);
		System.out.print(s);
	}
	public String fullLevelOrder(int h)
	{
		String s = "";
		//h = getNumLevels();  
		for(int i=0; i<h; i++) 
		{
			s+=fullLevelOrderRec(root, i); 
			s+="\n";
		}
		return s;
	}
	public String fullLevelOrderRec(BinaryNode node ,int level) 
    { 
        if (node == null && level > 0)
        {
            return fullLevelOrderRec(null, level-1)+fullLevelOrderRec(null, level-1);
        }
        else if(node == null && level == 0)
        	return "null|";
        if(level == 0)
        	return node.getValue()+"|";
        return fullLevelOrderRec(node.getLeft(), level-1)+fullLevelOrderRec(node.getRight(), level-1);
    }
	public String levelOrder() 
	{ 
		queue = new LinkedList<String>();
		int h = getNumLevels();  
		for(int i=1; i<=h; i++) 
			levelOrderRec(root, i); 
		return queue.toString();
	    } 
	public void levelOrderRec(BinaryNode node ,int level) 
    { 
        if (node == null) 
            return;
        if (level == 1)
            queue.offer(node.getValue()); 
        else if (level > 1)
        { 
            levelOrderRec(node.getLeft(), level-1); 
            levelOrderRec(node.getRight(), level-1); 
        }
    } 
	public String getLargest()
	{
		String x = getLargestRec(root).getValue();
		return x;
	}
	public BinaryNode getLargestRec(BinaryNode n)
	{
		BinaryNode l = n;
		if(l.getRight()!=null)
			l = getLargestRec(l.getRight());
		return l;
	}
	public String getSmallest()
	{
		String x = getSmallestRec(root).getValue();
		return x;
	}
	public BinaryNode getSmallestRec(BinaryNode n)
	{
		BinaryNode s = n;
		if(s.getLeft()!=null)
			s = getSmallestRec(s.getLeft());
		return s;
	}
	public int getNumLeaves()  
    { 
        return getNumLeavesRec(root); 
    }
    private int getNumLeavesRec(BinaryNode node)  
    { 
        if (node == null) 
            return 0; 
        if (node.getLeft() == null && node.getRight() == null) 
            return 1; 
        else
            return getNumLeavesRec(node.getLeft()) + getNumLeavesRec(node.getRight()); 
    } 
	public int getNumLevels()
	{
		return getHeightRec(root);
	}
	public int getWidth()
	{
		width = 0;
		return getWidthRec(root)-1;
	}
	public int getWidthRec(BinaryNode n)
	{
		if(n.getLeft()==null && n.getRight()==null)
			return 1;
		else if(n.getLeft()==null)
			return 1+getWidthRec(n.getRight());
		else if(n.getRight()==null)
			return 1+getWidthRec(n.getLeft());
		else
		{
			int lWidth = 1+getWidthRec(n.getLeft());
			int rWidth = 1+getWidthRec(n.getRight());
			int cWidth = 1+rWidth+lWidth;
			if(cWidth>width)
				width = cWidth;
			return Math.max(lWidth, rWidth)+1;
		}
		
	}
	public int getHeight()
	{
		return getHeightRec(root)-1;
	}
    int getHeightRec(BinaryNode node)  
    { 
        if (node == null) 
            return 0; 
//        int lh = getHeightRec(node.getLeft()); 
//        int rh = getHeightRec(node.getRight()); 
//   
//        if(lh > rh) 
//        	return (lh + 1); 
//        else 
//        	return (rh + 1); 
        return 1+ Math.max(getHeightRec(node.getLeft()), getHeightRec(node.getRight()));
    } 
	public int getNumNodes()
	{
		return nodesRec(root);
	}
	public int nodesRec(BinaryNode node)
	{
		if(node == null)
			return 0;
		return 1 + nodesRec(node.getRight()) + nodesRec(node.getLeft());
	}
	public boolean isFull()
	{
		return isFullRec(root);
	}
	private boolean isFullRec(BinaryNode node) 
    { 
//        if(node == null) 
//        return true; 
//
//        if(node.getLeft() == null && node.getRight() == null ) 
//            return true; 
//        if((node.getLeft()!=null) && (node.getRight()!=null)) 
//            return (isFullRec(node.getLeft()) && isFullRec(node.getRight())); 
//        return false; 
        int level = getNumLevels();
        int nodes = getNumNodes();
        return nodes==Math.pow(2, level)-1;
        
    }
	public boolean contains(String x)
	{
		return containsRec(root, x);
	}
	private boolean containsRec(BinaryNode current, String x) 
	{
		if (current == null) 
			return false;
		if(x.equals(current.getValue()))
				return true; 
		if(x.compareTo(current.getValue())<0)
			return containsRec(current.getLeft(), x);
		else
			return containsRec(current.getRight(), x);
		
	}
	public String toString()
	{
		return inOrder();
	}
	
}
