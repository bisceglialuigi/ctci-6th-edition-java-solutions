package Chapter2_LinkedLists.utils;

public class LinkedList {
    Node head;

    public Node getHead(){
        return head;
    }

    public LinkedList insertNode(LinkedList linkedList, int data){
        Node newNode = new Node(data);

        Node currentNode = linkedList.head;
        if(currentNode != null){
            while(currentNode.next != null){
                currentNode = currentNode.next;
            }
            currentNode.next = newNode;
        } else {
            linkedList.head = newNode;
        }
        return linkedList;
    }

    public void printList(){
        StringBuilder stringBuilder = new StringBuilder();
         Node currentNode = head;
        while(currentNode != null){
            stringBuilder.append(currentNode.data);
            stringBuilder.append(", ");
            currentNode = currentNode.next;
        }
        stringBuilder.append("\n");
        System.out.print(stringBuilder);
    }
}
