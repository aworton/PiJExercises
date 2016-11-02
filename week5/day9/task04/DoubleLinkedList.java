public class DoubleLinkedList<T extends Comparable<T>> implements MyLinkedList<T>{

    private Node<T> firstNode = null;
    private Node<T> lastNode = null;
    private int length = 0;

    @Override
    public void add(T element){
        Node<T> newNode = new Node<>(element);

        if(this.firstNode == null){
            addFirstNode(newNode);
            return;
        }

        addNewNode(newNode);
    }

    private void addNewNode(Node<T> newNode){
        
        Node<T> currentNode = this.firstNode;

        //look at each node in turn until we have one that we should not come after
        do{
            if(currentNode.getNextNode() == null)
                break;
            currentNode = currentNode.getNextNode();
        }while(currentNode != null && newNode.getValue().compareTo(currentNode.getValue()) <= 0);
        //place the current node after the new node
        prependNode(currentNode, newNode);

        //check

        incrementLength();
    }

    private void prependNode(Node<T> node, Node<T> prependNode){
        prependNode.setPrevNode(node.getPrevNode());
        node.setPrevNode(prependNode);
        prependNode.setNextNode(node);

        if(prependNode.getPrevNode() != null){
            prependNode.getPrevNode().setNextNode(prependNode);
        }

        if(this.firstNode.equals(node))
            this.firstNode = prependNode;

    }
    /*
    private void appendNode(Node<T> node, Node<T> appendNode){
        Node<T> nextNode = appendNode.getNextNode();

        //point the appended node to whatever the next node is (can be null), and point the current node at the inserted node
        //appendNode.setNextNode(node.getNextNode());
        node.setPrevNode(appendNode.getPrevNode());
        appendNode.setPrevNode(node);
        node.setNextNode(appendNode);

        //attach the next node in the sequence to point back to the appended node        
        if(nextNode != null)
            nextNode.setPrevNode(appendNode);

        if(appendNode.getNextNode() == null)
            this.lastNode = appendNode;

        if(appendNode.getPrevNode() == null)
            this.firstNode = node;

        return;
    }
    */

    private void addFirstNode(Node<T> newNode){
        this.firstNode = newNode;
        incrementLength();
    }

    @Override
    public int length(){
        return this.length;
    }

    @Override
    public void remove(T value){
        Node<T> node = getNode(value);

        if(node != null){
            Node<T> prev = node.getPrevNode();
            Node<T> next = node.getNextNode();

            if(prev != null)
                prev.setNextNode(next);

            if(next != null)    
                next.setPrevNode(prev);

            if(node == this.firstNode)
                this.firstNode = next;

            if(node == this.lastNode)
                this.lastNode = prev;

            decrementLength();
        }
    }

    @Override
    public T getElementAt(int index){
        if(index > this.length){
            throw new IndexOutOfBoundsException();
        }

        Node<T> selectedNode = getNode(index);

        if(selectedNode != null)
            return selectedNode.getValue();

        return null;
    }

    /**
    * remove the node at the end of the collection
    */
    private void removeLastNode(){
        Node<T> penultimateNode = getNode(length -2);
        penultimateNode.setNextNode(null);
        decrementLength();
    }

    private void decrementLength(){
        this.length--;
        //System.out.println(this.length);
    }

    private void incrementLength(){
        this.length++;
        //System.out.println(this.length);
    }

    /**
    * retrieve the node at a specified index in the collection
    * @param index is the index position at which to retrieve the Node
    */
    private Node<T> getNode(int index){
        if(this.length == 0)
            return null;

        if(index >= this.length)
            throw new IndexOutOfBoundsException();

        Node<T> currentNode = this.firstNode;
        for(int i = 1; i <= index; i++){
            currentNode = currentNode.getNextNode();
        }

        return currentNode;
    }

    /**
    * retrieve the node with the specified value in the collection
    * @param value is the value to be held in the Node
    */
    private Node<T> getNode(T value){
        Node<T> currentNode = this.firstNode;

        if(currentNode == null)
            return null;

        while(currentNode != null){

            if(currentNode.getValue().equals(value))
                return currentNode;

            currentNode = currentNode.getNextNode();

            if(currentNode == null)
                break;
        }

        return null;
    }

    /**
    * return a string of an iteration of all elements held in the collection
    */
    @Override
    public String toString(){
        String values = "";
        for(int i = 0; i < this.length; i++){
            values += "\n\t"+getElementAt(i);
        }
        return values;
    }

}


