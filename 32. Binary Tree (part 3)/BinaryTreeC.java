// Kth level of a tree
// lowest common ancestors (Approach 1)
// lowest common ancestors (Approach 2)
// min distance between two nodes

import java.util.ArrayList;

public class BinaryTreeC {
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

    // Kth level of a tree
    public static void klevel(Node root, int level, int k){ // O(n)
        if(root==null){
            return ;
        }
        if(level==k){
            System.out.print(root.data+" ");
            return;
        }
        klevel(root.left, level+1, k);
        klevel(root.right, level+1, k);
    }

    // lowest common ancestors (Approach 1) TC-O(n) and SC-O(n)
    public static boolean getPath(Node root, int n, ArrayList<Node> path){  // O(n)
        if(root==null){
            return false;
        }

        path.add(root);

        if(root.data==n){
            return true;
        }

        // boolean foundLeft=getPath(root.left, n, path);
        // boolean founfRight= getPath(root.right, n, path);

        // if(foundLeft || founfRight){
        //     return true;
        // }

        if( getPath(root.left, n, path) || getPath(root.right, n, path) ){
            return true;
        }

        path.remove(path.size()-1);
        return false;
    }
    public static Node lca(Node root, int n1, int n2){
        ArrayList<Node> path1= new ArrayList<>();   // space complexity - O(n)
        ArrayList<Node> path2= new ArrayList<>();

        getPath(root, n1, path1);
        getPath(root, n2, path2);

        int i;
        for(i=0; i<path1.size() && i<path2.size(); i++){    // O(n)
            if(path1.get(i) != path2.get(i)){
                break;
            }
        }
        // last common ancestor - i-1th index
        Node lca = path1.get(i-1);
        return lca;
    }

    // lowest common ancestors (Approach 2)
    public static Node lca2(Node root, int n1, int n2){ // TC - O(n)
        if( root == null || root.data == n1 || root.data == n2){
            return root;
        }

        Node ledtLca = lca2(root.left, n1, n2);
        Node rightLca = lca2(root.right, n1, n2);

        if(ledtLca == null){
            return rightLca;
        }
        if(rightLca == null){
            return ledtLca;
        }

        return root;
    }

    // min distance between two nodes
    public static int distance(Node root, int n){
        if(root==null){
            return -1;
        }
        if(root.data==n){
            return 0;
        }
        int left = distance(root.left, n);
        int right = distance(root.right, n);

        if(left == -1 && right == -1){
            return -1;
        }
        if(left==-1){
            return right+1;
        }
        else{   // right ==-1
            return left+1;
        }
    }

    public static int minDistance(Node root, int n1, int n2){   // O(n)
        Node lca= lca2(root, n1, n2);

        return distance(lca, n1)+distance(lca, n2);
    }
    public static void main(String[] args) {
        /*
                    1
                   / \
                  2   3
                 / \ / \
                4  5 6  7
         */

        Node root= new Node(1);
        root.left =new Node(2);
        root.right= new Node(3);
        root.left.left= new Node(4);
        root.left.right= new Node(5);
        root.right.left= new Node(6);
        root.right.right= new Node(7);

        klevel(root, 1, 3);
        System.out.println();

        Node lca1=lca(root, 4, 6);
        Node lca2=lca(root, 4, 5);
        System.out.println(lca1.data);        
        System.out.println(lca2.data);

        int n1=4, n2=5;
        System.out.println(lca2(root, n1, n2).data);
        
        System.out.println(minDistance(root, 4, 6));
        System.out.println(minDistance(root, 4, 5));

    }
}
