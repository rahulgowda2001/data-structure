import javax.print.DocFlavor;
import java.util.EmptyStackException;
import java.util.List;
import java.util.Stack;

public class stacks {
    private ListNode Top;
    private int Length;

    private class ListNode{
        private int data;
        private ListNode next;

        public ListNode(int data) {
            this.data = data;
        }

    }
    public  stacks(){
        Top= null;
        Length= 0;
    }
    public void pushinsert(int value){
        ListNode push = new ListNode(value);
        push.next = Top;
        Top = push;
        Length++;
    }
    public int pop(int result){
        if(isempty())
            throw new EmptyStackException();
        result = Top.data;
        Top = Top.next;
        Length--;
        return result;

    }
    public int peak(){
        if(isempty())
            throw new EmptyStackException();
        return Top.data;
    }
    public int length(){
        return Length;
    }
    public boolean isempty(){
       return Length ==0;
    }
    public void display(){
        if(isempty())
            throw new EmptyStackException();
        for(int i=0;i<Length;i++){

            System.out.print(Top.data +"--> ");
            Top=Top.next;
        }


    }
    public static String reverse(String str){
        Stack<Character> stack = new Stack<>();
        char[] chars = str.toCharArray();
        for(char c : chars){
            stack.push(c);
        }
        for(int i =0;i<str.length();i++){
            chars[i]= stack.pop();
        }
        return new String( chars);
    }
    public int[] nextgreaterelement(int[] arr){
        Stack<Integer> stacks = new Stack<>();
        int[] result = new int[arr.length];
        for(int i =arr.length-1;i>=0;i--){
            if(!stacks.isEmpty()){
                while(!stacks.isEmpty() && arr[i]>=stacks.peek()){
                    stacks.pop();
                }
            }
            if(stacks.isEmpty()){
                result[i]= -1;
            }else{
                result[i] = stacks.peek();
            }
            stacks.push(arr[i]);
        }
        return result;
    }
    public void display(int[] arr){
        if(isempty()){
            throw new EmptyStackException();
        }
        for(int i=0 ; i<= arr.length-1;i++){
            System.out.print(arr[i]+ " ");
        }

    }
    public static void main(String[] args) {
        stacks stc = new stacks();
        stc.pushinsert(10);
        stc.pushinsert(20);
        stc.pushinsert(30);
        stc.pushinsert(40);
        stc.display();
        String stacks = "ABCD";
        System.out.println("before reverse -->" + stacks);
        System.out.println("after reverse--> "+ reverse(stacks));
        int[] array = {1,8,7,10,3,4,12};
        stc.display(stc.nextgreaterelement(array));


    }
}
