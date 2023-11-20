// Diameter of a tree 
// Approach 1 O(n^2)
// Approach 2 O(n) 
// Subtree
// top view of Binary Tree

import java.util.LinkedList;
import java.util.Queue;
import java.util.HashMap;

public class BinaryTreeB {
    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public static int height(Node root) {   // O(n)
        if (root == null) {
            return 0;
        }
        int lh = height(root.left);
        int rh = height(root.right);

        int height = Math.max(lh, rh) + 1;

        return height;
    }

    public static int diameter2(Node root) { //O(n^2)
        if (root == null) {
            return 0;
        }
        int ldiam = diameter2(root.left);
        int rdiam = diameter2(root.right);

        int lh = height(root.left);
        int rh = height(root.right);

        int selfdiam = lh + rh + 1;

        return Math.max(selfdiam, Math.max(ldiam, rdiam));
    }

    static class Info {
        int diam;
        int ht;

        Info(int diam, int ht){
            this.diam=diam;
            this.ht=ht;
        }
    }
    public static Info diameter(Node root){ // O(n)
        if(root==null){
            return new Info(0, 0);
        }
        Info leftInfo=diameter(root.left);
        Info rigthInfo=diameter(root.right);

        int diam= Math.max(leftInfo.ht+rigthInfo.ht+1, Math.max(leftInfo.diam, rigthInfo.diam));
        int ht=Math.max(leftInfo.ht, rigthInfo.ht)+1;

        return new Info(diam, ht);
    }

    // subtree
    public static boolean isIdentical(Node node, Node subRoot){
        if(node==null && subRoot==null){
            return true;
        }else if(node==null || subRoot== null || node.data != subRoot.data){
            return false;
        }
        if(!isIdentical(node.left, subRoot.left)){
            return false;
        }
        if(!isIdentical(node.right, subRoot.right)){
            return false;
        }

        return true;
    }

    public static boolean isSubtree(Node root, Node subRoot){   // true -> if subtree exist 
        if(root==null){
            return false;
        }
        if(root.data==subRoot.data){
            if(isIdentical(root, subRoot)){
                return true;
            }
        }
        // boolean leftAns=isSubtree(root.left, subRoot);
        // boolean rightAns=isSubtree(root.right, subRoot);

        // return leftAns || rightAns;
        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    // Top View of Binary Tree
    static class Inform {
        Node node;
        int hd;

        Inform(Node node, int hd){
            this.node=node;
            this.hd=hd;
        }
    }

    public static void topView(Node root){
        Queue<Inform> q= new LinkedList<>();
        HashMap<Integer,Node> map= new HashMap<>();

        int min=0, max=0;
        q.add(new Inform(root, 0));
        q.add(null);

        while (! q.isEmpty()) {
            Inform curr =q.remove();

            if(curr==null){
                if(q.isEmpty()){
                    break;
                }
                q.add(null);
            }else{
                
                if(map.get(curr.hd)==null){
                    map.put(curr.hd, curr.node);
                }
    
                // if(!map.containsKey(curr.hd)){
                //     map.put(curr.hd, curr.node);
                // }
    
                if(curr.node.left != null){
                    q.add(new Inform(curr.node.left, curr.hd-1));
                    min=Math.min(min, curr.hd-1);
                }
                if(curr.node.right != null){
                    q.add(new Inform(curr.node.right, curr.hd+1));
                    max=Math.max(max, curr.hd+1);
                }
            }

        }

        for(int i=min; i<=max; i++){
            System.out.print(map.get(i).data +" ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        /*
                    1
                   / \
                  2   3
                 / \ / \
                4  5 6  7
         */

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        System.out.println(diameter2(root));

        Info treeInfo=diameter(root);
        System.out.println(treeInfo.diam);

        System.out.println(diameter(root).diam);
        System.out.println(diameter(root).ht);

        /*
         * Subtree
         *      2
         *     / \
         *    4   5
         */

        Node subRoot=new Node(2);
        subRoot.left=new Node(4);
        subRoot.right=new Node(5);

        System.out.println(isSubtree(root, subRoot));
        topView(root);
    }
}
