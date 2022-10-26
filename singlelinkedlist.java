public class singlelinkedlist {
    private ListNode Head;
    private int Lenght;
    private class ListNode{

        private int data;
        private ListNode next;

        public ListNode(int data){
            this.data = data;
            this.next = null;
        }
    }
    public singlelinkedlist(){
        Head = null;
        Lenght = 0;
    }
    public void insert(int value){
        ListNode first = new ListNode(value);
        ListNode temp =  Head;
        if(temp == null){

        }else{
            temp.next = first;

        }

    }
    public static void main(String[] args) {

    }
}
