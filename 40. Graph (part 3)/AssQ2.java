// Find Minimum Depth of a Binary Tree

import java.util.LinkedList;
import java.util.Queue;

public class AssQ2 {
    static class Node {
        int data;
        Node left, right;
        
        public Node(int d){
            this.data = d;
            this.left = this.right = null;
        }
    }

    static class Pair{
        Node n;
        int depth;

        public Pair(Node n, int d){
            this.n = n;
            this.depth = d;
        }
    }

    public static int minDepth(Node root){
        Queue<Pair> q =new LinkedList<>();
        q.add(new Pair(root, 0));

        while (!q.isEmpty()) {
            Pair curr = q.remove();
            Node left = curr.n.left;
            Node right = curr.n.right;

            if( left == null || right == null ){
                return curr.depth;
            }
            if(left != null){
                q.add(new Pair(left, curr.depth+1));
            }
            if(right != null){
                q.add(new Pair(right, curr.depth+1));
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left =  new Node(8);
        root.right = new Node(2);
        root.left.left = new Node(6);
        root.left.right = new Node(5);
        root.right.left = new Node(9);
        // root.right.right = new Node(3);
        // root.right.right.left = new Node(10);

        System.out.println(minDepth(root));
    }
}
