package Chapter3_StacksAndQueues.utils;

public class MyStack {
    public class MyNode{
        int data;
        MyNode next;
        public MyNode(int data){
            this.data = data;
        }
    }
    MyNode top;

    public void push(int data){
        MyNode newNode = new MyNode(data);
        if(top != null){
            newNode.next = top;
        }
        top = newNode;
    }

    public Integer pop(){
        if(isEmpty())
            return null;
        int data = top.data;
        top = top.next;
        return data;
    }

    public boolean isEmpty(){
        return top == null;
    }
}
