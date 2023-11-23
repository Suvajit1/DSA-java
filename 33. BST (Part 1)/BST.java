// Build a Binary Search Tree 
// Search for a key in BST 
// delete a Node from BST
// print in range
// print root to leaf path
// validate BST

import java.util.ArrayList;

public class BST {

    static class Node {
        int data;
        Node left;
        Node right;
        
        Node(int data){
            this.data=data;
            this.left=null;
            this.right=null;
        }
    }

    public static Node insert(Node root, int val){  // O(h)
        if(root==null){
            root=new Node(val);
            return root;
        }

        if(root.data > val){
            root.left=insert(root.left, val);
        }else{
            root.right= insert(root.right, val);
        }

        return root;
    }
    public static void inOrder(Node root){
        if(root==null){
            return;
        }
        inOrder(root.left);
        System.out.print(root.data+" ");
        inOrder(root.right);
    }

    public static boolean search(Node root, int key){   // O(h)
        if(root==null){
            return false;
        }
        if(root.data == key){
            return true;
        }
        
        if(key>root.data){
            return search(root.right, key);
        }else{
            return search(root.left, key);
        }
    }

    public static Node delete(Node root, int val){

        if(root.data>val){
            root.left = delete(root.left, val);
        }else if (root.data<val) {
            root.right = delete(root.right, val);
        }else{
            // case 1 : leaf node
            if(root.left == null && root.right == null){
                return null;
            }

            // case 2 : one child
            if(root.left == null){
                return root.right;
            }else if(root.right == null){
                return root.left;
            }

            // case 3 : two child
            Node IS = inOrderSuccessor(root.right);
            root.data=IS.data;
            root.right = delete(root.right, IS.data);
        }

        return root;
    }
    public static Node inOrderSuccessor(Node root){
        while (root.left != null) {
            root=root.left;
        }
        return root;
    }

    // print in range k1 and k2
    public static void printInRange(Node root, int k1, int k2){
        if(root==null){
            return ;
        }

        // case 1 k1 <= root <= k2
        if(k1 <= root.data && root.data <= k2){
            printInRange(root.left, k1, k2);
            System.out.print(root.data+" ");
            printInRange(root.right, k1, k2);
        }

        // case 2 root > k2  -> left 
        if(root.data > k2){
            printInRange(root.left, k1, k2);
        }

        // case 3 root < k1 -> right
        if(root.data < k1){
            printInRange(root.right, k1, k2);
        }
    }


    public static void leafPath(Node root, ArrayList<Integer> path){

        if(root==null){
            return;
        }
        
        path.add(root.data);

        if(root.left == null && root.right == null){
            System.out.println(path);
        }

        leafPath(root.left, path);
        leafPath(root.right, path);
        path.remove(path.size()-1);
    }

    public static Node inorderPredessor(Node root){
        while (root.right != null) {
            root = root.right;
        }
        return root;
    }

    public static void main(String[] args) {
        int values[]={8, 5, 3, 1, 4, 6, 7, 10, 11, 14};

        /*
         *           8
         *          / \
         *         5  10
         *        / \   \
         *       3   6  11
         *      / \   \   \
         *     1   4   7  14
        */
        Node root = null;

        for(int i=0; i<values.length; i++){
            root= insert(root, values[i]);
        }

        inOrder(root);
        System.out.println();

        System.out.println(search(root, 5));
        System.out.println(search(root, 9));

        // root=delete(root, 4);
        // inOrder(root);
        // System.out.println();

        // root=delete(root, 10);
        // inOrder(root);
        // System.out.println();

        // root=delete(root, 5);
        // inOrder(root);
        // System.out.println();

        printInRange(root, 5, 12);
        System.out.println();

        ArrayList<Integer> path=new ArrayList<>();
        leafPath(root, path);

        System.out.println(isBST(root));
    }
}
