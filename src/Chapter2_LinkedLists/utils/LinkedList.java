package Chapter2_LinkedLists.utils;

public class LinkedList {
    Node head;

    public Node getHead(){
        return head;
    }

    public void insertNode(int data){
        Node newNode = new Node(data);

        Node currentNode = this.head;
        if(currentNode != null){
            while(currentNode.next != null){
                currentNode = currentNode.next;
            }
            currentNode.next = newNode;
        } else {
            this.head = newNode;
        }
    }

    public void insertNode(Node newNode){
        Node currentNode = this.head;
        if(currentNode != null){
            while(currentNode.next != null){
                currentNode = currentNode.next;
            }
            currentNode.next = newNode;
        } else {
            this.head = newNode;
        }
    }

    public void initializeFromIntValues(Integer[] intValues){
        for(int i=0; i<intValues.length; i++){
            this.insertNode(intValues[i]);
        }
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
