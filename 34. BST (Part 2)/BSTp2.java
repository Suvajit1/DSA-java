// Sorted array to balanced BST 

import java.util.LinkedList;
import java.util.Queue;
public class BSTp2 {
    
    static class Node {
        int data;
        Node left,right;

        Node(int data){
            this.data = data;
            this.left=this.right=null;
        }
    }

    public static Node balancedBST(int[] values, int si, int ei){
        if(ei < si){
            return null;
        }
        int mid = (int)(si+ei)/2;
        Node root=new Node(values[mid]);

        root.left= balancedBST(values, si, mid-1);
        root.right = balancedBST(values, mid+1, ei);

        return root;
    }

    public static void preorder(Node root){
        if(root == null){
            return ;
        }
        System.out.print(root.data+" ");
        preorder(root.left);
        preorder(root.right);
    }

    public static void levelorder(Node root){  // O(n)
        if(root==null){
            return;
        }

        Queue<Node> q= new LinkedList<>();
        q.add(root);
        q.add(null);

        while(!q.isEmpty()){
            Node currNode = q.remove();

            if(currNode==null){
                System.out.println();
                if(q.isEmpty()){
                    break;
                }else{
                    q.add(null);
                }
            }else{
                System.out.print(currNode.data+" ");
                if(currNode.left != null){
                    q.add(currNode.left);
                }
                if(currNode.right != null){
                    q.add(currNode.right);
                }
            }
        }
    }

    public static void main(String[] args) {
        int values[]={3,5,6,8,10,11,12};
        Node root = balancedBST(values, 0, values.length-1);
        preorder(root); 
        System.out.println();
        levelorder(root);
    }
}
