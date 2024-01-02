// Merge two bst 
/*
 *      2         9              3
 *     / \       / \    -->    /   \
 *    1   4     3  12         1     9
 *                             \   / \
 *                              2 4  12
 */

import java.util.*;

public class MergeBST {
    static class Node {
        int data;
        Node left, right;
        
        public Node(int data){
            this.data=data;
            this.left=this.right=null;
        }
    }

    public static void inOrder(Node root, ArrayList<Integer> inorder){
        if(root==null){
            return;
        }

        inOrder(root.left, inorder);
        inorder.add(root.data);
        inOrder(root.right, inorder);
    }

    public static void merge(ArrayList<Integer> list1, ArrayList<Integer> list2, ArrayList<Integer> list){
        int i=0,j=0;
        while(i < list1.size() && j < list2.size()){
            if(list1.get(i)<list2.get(j)){
                list.add(list1.get(i));
                i++;
            }else{
                list.add(list2.get(j));
                j++;
            }
        }
        while (i<list1.size()) {
            list.add(list1.get(i));
            i++;
        }
        while(j<list2.size()){
            list.add(list2.get(j));
            j++;
        }
    }

    public static Node buildBST(ArrayList<Integer> list, int st, int end){
        if(end<st){
            return null;
        }

        int mid = (st+end)/2;

        Node root=new Node(list.get(mid));
        root.left=buildBST(list, st, mid-1);
        root.right=buildBST(list, mid+1, end);

        return root;
    }

    public static void preorder(Node root){
        if(root==null){
            return;
        }
        System.out.print(root.data+" ");
        preorder(root.left);
        preorder(root.right);
    }
    public static void main(String[] args) {
        Node root1 = new Node(2);
        root1.left = new Node(1);
        root1.right = new Node(4);

        Node root2 = new Node(9);
        root2.left = new Node(3);
        root2.right = new Node(12);

        ArrayList<Integer> inorder1 = new ArrayList<>();
        ArrayList<Integer> inorder2 = new ArrayList<>();
        ArrayList<Integer> inorder = new ArrayList<>();


        inOrder(root1, inorder1);
        inOrder(root2, inorder2);
        merge(inorder1, inorder2, inorder);
        System.out.println(inorder);


        Node root= buildBST(inorder, 0, inorder.size()-1);
        preorder(root);
    }
}
