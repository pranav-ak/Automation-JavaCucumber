
public class BinarySearchTree {

	public static void main1(String[] args) {
		// TODO Auto-generated method stub

	}
    class Node {
        int data;
        Node left;
        Node right;
     }
    boolean checkBST(Node root) {
    	if(root.left.data==root.data||root.right.data==root.data)
    	{
    		return false;
    	}
        if(root.left!=null)
        {
        	checkBST(root.left);
        }
        if(root.right!=null)
        {
        	checkBST(root.right);
        }
        return true;
    }
    

}
