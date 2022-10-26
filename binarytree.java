import sun.reflect.generics.tree.Tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class binarytree {
    private TreeNode root;
    private int Lenght;
    private class TreeNode{
        private int data;
        private TreeNode left;
        private TreeNode right;

        public TreeNode(int data){
            this.data= data;
        }
    }
    public void binarytree(){
        root = null;
        Lenght =0;
    }
    public boolean isempty(){
        return Lenght==0;
    }
    public TreeNode root(){
        return root;
    }
//    public void inserttree(int value){
//        TreeNode temp = new TreeNode(value);
//
//    }
    public void  inserttree(){
        TreeNode first = new TreeNode(3);
        Lenght++;
        TreeNode second =  new TreeNode(4);
        Lenght++;
        TreeNode thrid =  new TreeNode(6);
        
        TreeNode fourth =  new TreeNode(7);
        TreeNode fiveth =  new TreeNode(8);
        TreeNode six =  new TreeNode(5);


        root= first;
        first.left = second;
        first.right = six;
        second.left = thrid;
        second.right = fourth;
        fourth.left= fiveth;


    }
    public void linespace(){
        System.out.println();
    }
    // <------------ pre order --------->
    public void recursivepreorder(TreeNode root){
        if(root == null){
            return;
        }
        System.out.print(root.data +" ");
        recursivepreorder(root.left);
        recursivepreorder(root.right);
    }
    public void iterativepreorder(){
        if(root == null){
            return;
        }
        Stack<TreeNode> stacks= new Stack<>();
        stacks.push(root);
        while(!stacks.isEmpty()){
            TreeNode temp = stacks.pop();
            System.out.println(temp.data+" ");
            if(temp.right!=null){
                stacks.push(temp);
            }
            if(temp.left!=null){
                stacks.push(temp);
            }
        }

    }
    //<-----------  in order ---------->
    public void recursiveinorder(TreeNode root){
        if(root == null){
            return;
        }
        recursiveinorder(root.left);
        System.out.print(root.data + " ");
        recursiveinorder(root.right);

    }

    public void iterativeinorder(){
        if(root == null){
            return;
        }
        Stack<TreeNode> stacks =  new Stack<>();
        TreeNode temp = root;
        while (!stacks.isEmpty() || temp!=null){
            if(temp!= null){
                stacks.push(temp);
                temp= temp.left;
            }else{
                temp =stacks.pop();
                System.out.println(temp.data+" ");
                temp=  temp.right;
            }
        }
    }

    //<----------- post-order ----------->
    public void recursivepostorder(TreeNode root){
        if(root ==  null){
            return;
        }
        recursivepostorder(root.left);
        recursivepostorder(root.right);
        System.out.print(root.data + " ");

    }

    public void iterativepostorder(){
        if(root==null){
            return;
        }
        Stack<TreeNode> stacks = new Stack<>();
        TreeNode current = root;
        while(!stacks.isEmpty() || current!= null){
            if(current!=null){
                stacks.push(current);
                current =  current.left;
            }else{
                TreeNode temp = stacks.peek().right;
                if(temp!= null){
                    temp = stacks.pop();
                    System.out.println(temp.data);
                    while (!stacks.isEmpty() && temp== stacks.peek().right){
                        temp = stacks.pop();
                        System.out.println(temp.data);
                    }
                }else{
                    current = temp;
                }
            }

        }
    }
    //<----------- level order-------------->
    public  void levelorder(){
        if(root== null){
            return;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            TreeNode temp = queue.poll();
            System.out.print(temp.data+ " ");
            if(temp.left!=null){
                queue.offer(temp.left);
            }
            if(temp.right!= null){
                queue.offer(temp.right);
            }
        }

    }

    //<------------ finding the maximum value ------------>
    public int maxorder(TreeNode root){
        if(root ==null){
            return Integer.MIN_VALUE;
        }
        int result = root.data;
        int left = maxorder(root.left);
        int right = maxorder(root.right);
        if(left> result){
            result =left;
        }if(right> result){
            result =right;
        }
        return result;
    }
    public static void main(String[] args) {
        binarytree bt = new binarytree();
        bt.inserttree();
        bt.recursivepreorder(bt.root());
        bt.linespace();
        bt.recursiveinorder(bt.root());
        bt.linespace();
        bt.recursivepostorder(bt.root());
        bt.linespace();
        bt.levelorder();
        bt.linespace();
        System.out.println(bt.maxorder(bt.root));

    }
}
