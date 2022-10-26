public class binarysearchtree {
    private TreeNode root;
    private int length;
    private class TreeNode {

        private int data;
        private TreeNode left;
        private TreeNode right;

        public TreeNode(int data) {
            this.data = data;
        }
    }
    public void binarysearchtree(){
        this.root = null;
    }
    //<------------ inserting a node to binary tree --------->
    public TreeNode inserrtree(TreeNode root,int value){
        if(root== null){
            root = new TreeNode(value);
            return root;
        }
        if(root.data > value){
            root.left = inserrtree(root,value);
        }else {
            root.right = inserrtree(root, value);
        }
        return root;
    }
    //<-----------------key value search----------->
    public TreeNode search(TreeNode root, int key){
        if(root==null || root.data==key){
            return root;
        }
        if(root.data>key){
            return search(root.left,key);
        }else{
            return search(root.right,key);
        }
    }
    public void recursiveinorder(TreeNode root){
        if(root == null){
            return;
        }
        recursiveinorder(root.left);
        System.out.print(root.data + " ");
        recursiveinorder(root.right);

    }
    public static void main(String[] args) {
        binarysearchtree bst = new binarysearchtree();
        bst.inserrtree(bst.root, 10);
        bst.inserrtree(bst.root,2);
        bst.inserrtree(bst.root,4);
        bst.inserrtree(bst.root,12);
        bst.recursiveinorder(bst.root);

        //System.out.println(bst.search(bst.root,4));

    }
}
