public class AVL {
    static class Node {
        int data, height;
        Node left, right;
        
        Node(int data){
            this.height = 1;
            this.data = data;
            this.left = this.right = null;
        }
    }

    public static Node root;

    public static int height(Node root){
        if(root == null){
            return 0;
        }

        return root.height;
    }

    public static int getBalanceFactor(Node root){
        if(root == null){
            return 0;
        }
        return height(root.left) - height(root.right);
    }

    // left rotate subtree rooted with x
    public static Node leftRotate(Node x){
        Node y = x.right;
        Node z = y.left;

        // perform rotation
        y.left=x;
        x.right=z;

        // update height
        x.height = Math.max(height(x.left), height(x.right))+1;
        y.height = Math.max(height(y.left), height(y.right))+1;

        //return new root
        return y;
    }

    // right rotate subtree rooted with x
    public static Node righrRotate(Node x){
        Node y= x.left;
        Node z= y.right;

        // perform rotation
        y.right=x;
        x.left=z;

        // update height
        x.height = Math.max(height(x.left), height(x.right))+1;
        y.height = Math.max(height(y.left), height(y.right))+1;

        //return new root
        return y;
    }

    public static Node insert(Node root, int key){
        if(root==null){
            return new Node(key);
        }

        if(key < root.data){
            root.left = insert(root.left, key);
        }
        else if(key > root.data){
            root.right = insert(root.right, key);
        }
        else{
            return root;    // to avoide duplicate keys
        }

        // update root height
        root.height = Math.max(height(root.left), height(root.right)) + 1;

        // Get root's balance factor
        int bf= getBalanceFactor(root);

        //AVL configuration
        // LL case
        if(bf>1 && key<root.left.data){
            return righrRotate(root);
        }
        // LR case
        if(bf>1 && key >root.left.data){
            root.left = leftRotate(root.left);
            return righrRotate(root);
        }
        // RR case
        if(bf<-1 && key >root.right.data){
            return leftRotate(root);
        }
        // RL case
        if(bf<-1 && key<root.right.data){
            root.right = righrRotate(root.right);
            return leftRotate(root);
        }

        return root; // if AVL balanced
    }

    public static void preorder(Node root){
        if (root==null) {
            return ;
        }
        System.out.print(root.data+" ");
        preorder(root.left);
        preorder(root.right);
    }

    public static void main(String[] args) {
        /*
         *           25
         *         /    \
         *       20      40
         *      /  \    /  \
         *     10  22  30  50
         */

        int values[]= {40, 20, 10, 25, 30, 22, 50};
        // Node root = null;
        for(int i=0; i<values.length; i++){
            root = insert(root, values[i]);
        }

        preorder(root);
    }
}
