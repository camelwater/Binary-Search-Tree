
public class BinaryNode 
{
	private String data;
	public BinaryNode left;
	public BinaryNode right;
	public int xpos;
	public int ypos;
	public BinaryNode(String data)
	{
		this.data = data;
		right = new BinaryNode();
		left = new BinaryNode();
	}
	public BinaryNode()
	{
		data = null;
		right = null;
		left = null;
	}
	public BinaryNode getLeft()
	{
		return left;
	}
	public BinaryNode getRight()
	{
		return right;
	}
	public String getValue()
	{
		return data;
	}
	public void setValue(String x)
	{
		data = x;
	}
	public void setRight(BinaryNode x)
	{
		right = x;
	}
	public void setLeft(BinaryNode x)
	{
		left = x;
	}
	public String toString()
	{
		return "Value:"+data+", "+"Left:null, Right:null";
	}
	
	
}

