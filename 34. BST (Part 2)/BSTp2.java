// Sorted array to balanced BST 
// Conver BST to Bananced BST
/*
 *               8                      8
 *              / \                    / \
 *             6  10                  5   11
 *            /     \      -->       / \  / \
 *           5      11              3  6 10 12
 *          /        \
 *         3         12
 */

import java.util.ArrayList;
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

    public static void inOrderArray(Node root, ArrayList<Integer> inOrder){
        if(root==null){
            return;
        }
        inOrderArray(root.left, inOrder);
        inOrder.add(root.data);
        inOrderArray(root.right, inOrder);
    }

    public static Node balancedBST(ArrayList<Integer> inOrder, int st, int end){
        if(end<st){
            return null;
        }

        int mid= (st+end)/2;

        Node root = new Node(inOrder.get(mid));
        root.left = balancedBST(inOrder, st, mid-1);
        root.right = balancedBST(inOrder, mid+1, end);

        return root;
    }
    public static void main(String[] args) {
        int values[]={3,5,6,8,10,11,12};
        Node root = balancedBST(values, 0, values.length-1);
        preorder(root); 
        System.out.println();
        levelorder(root);

        Node rootu=new Node(8);
        rootu.left = new Node(6);
        rootu.left.left = new Node(5);
        rootu.left.left.left =new Node(3);
        rootu.right = new Node(10);
        rootu.right.right = new Node(11);
        rootu.right.right.right =new Node(12);

        levelorder(rootu);

        ArrayList<Integer> inOrder=new ArrayList<>();
        inOrderArray(rootu, inOrder);
        rootu=balancedBST(inOrder, 0, inOrder.size()-1);
        preorder(rootu);
        System.out.println();
        levelorder(rootu);

    }
}
