import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Scanner;
/***
 * 
 * @author Pranav Kulkarni
 * 
 * Assumptions: 
 * 1. Number on same line are delimited by a tab only.
 *
 *For input : TestInput.txt
 *  sum= 47
 */

public class BalancedBinaryTree {
	TreeNode root;
	int maxSum;
	LinkedList<TreeNode> queue; 
	public BalancedBinaryTree() 
	{
		root=null;
		maxSum=0;
		queue= new LinkedList<TreeNode>();
	}
	public class TreeNode
	{
		int value;
		TreeNode left;
		TreeNode right;
		public TreeNode (int v)
		{
			this.value=v;
			left=right=null;
		}
		
	}

	public void addLevel(String[] lineArray)
	{
		for(String s :lineArray)
		{
			if(root==null)
			{
				root= new TreeNode(Integer.parseInt(s));
				queue.add(root);
			}else
			{
				TreeNode a = queue.peek();
				if(a.left==null)
				{
					a.left=new TreeNode(Integer.parseInt(s));
					queue.add(a.left);
				}else
				{
					a.right=new TreeNode(Integer.parseInt(s));
					queue.add(a.right);
					queue.remove();
				}
			}
		}
	}
	
	public int getSum(TreeNode root)
	{
		if(root==null)
		{
			return maxSum;
		}else
		{
			maxSum = maxSum + root.value;
			if(root.right!=null&&root.right.value>=root.left.value)
			{
				getSum(root.right);
			}
			else if(root.left!=null&&root.right.value<root.left.value)
			{
				getSum(root.left);	
			}
		}
		return maxSum;
	}

	public TreeNode populateBalancedTree()
	{
		String[] lineArray=null;
		try {
			
			Scanner scanner = new Scanner(new File("src/TestInput.txt"));
			while(scanner.hasNextLine())
			{
				String line = scanner.nextLine();
				lineArray= line.split("\\t");
				if(lineArray.length!=1&&(lineArray.length%2)!=0)
				{
					System.out.println("Input Tree not balanced");
					return null;
				}
				addLevel(lineArray);
			}
			return root;
			
		} catch (FileNotFoundException e) {
			System.out.println("File Not Found");
		}
		return root;
		
	}
	
	public static void main(String[] args) 
	{
		BalancedBinaryTree bTree = new BalancedBinaryTree();
		bTree.root = bTree.populateBalancedTree();
		int x = bTree.getSum(bTree.root);
		System.out.println("Sum= "+x);
	}
}
