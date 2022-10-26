import java.util.List;
import java.util.NoSuchElementException;

public class queue {
    private ListNode front;
    private ListNode rear;
    private int Lenght;

    private class ListNode {
        private int data;
        private ListNode next;

        public ListNode(int data){
            this.data = data;
            this.next = null;
        }

    }

    public queue(){
        this.front = null;
        this.rear =  null;
        this.Lenght =  0;

    }
    public int Length(){
        return Lenght;
    }

    public boolean isempty(){
        return Lenght ==0;
    }

    public void enqueue(int value){
        ListNode temp =  new ListNode(value);
        if(isempty()){
            front = temp;
        }else{
            rear.next=  temp;
        }
        rear = temp;
        Lenght++;
    }

    public int dequeue(){
        if(isempty()){
            throw new NoSuchElementException();
        }
        int temp = front.data;
        front = front.next;
        if(front == null){
            rear = null;
        }
        Lenght--;
        return temp;

    }
    public void display(){
        if(isempty()){
            return;
        }
        ListNode current =  front;
        while(current != null){
            System.out.print(current.data+" --> ");
            current = current.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        queue que = new queue();
        que.enqueue(10);
        que.enqueue(20);
        que.enqueue(30);
        que.enqueue(40);
        que.enqueue(50);
        que.display();
        que.dequeue();
        que.display();
    }
    }

