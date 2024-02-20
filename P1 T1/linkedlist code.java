class Main {
    public static void main(String[] args) {
        LL list = new LL();


//        list.insertFirst('O');
//        list.insertFirst('o');
//        list.insertFirst('8');
//        list.insertFirst('q');
//        list.insertFirst('D');
//        list.insertFirst('n');
//        list.insertFirst('m');
//        list.insertFirst('P');
//        list.insertFirst('N');
//        list.insertFirst('V');
//        list.insertFirst('v');
//        list.insertFirst('k');
//        list.insertFirst('r');
//        list.insertFirst('h');
//        list.insertFirst('4');
//        list.insertFirst('0');
//        list.insertFirst('B');
//        list.insertFirst('4');
//        list.insertFirst('R');
//        list.insertFirst('a');
//        list.insertFirst('v');
//        list.insertFirst('4');
//        list.insertFirst('R');
//        list.insertFirst('v');
//        list.insertFirst('Q');
//        list.insertFirst('6');
//        list.insertFirst('E');
//        list.insertFirst('w');
//        list.insertFirst('a');
//        list.insertFirst('O');
//        list.insertFirst('g');
//        list.insertFirst('y');
//        list.insertFirst('1');
//        list.insertFirst('/');
//        list.insertFirst('s');
//        list.insertFirst('r');
//        list.insertFirst('e');
//        list.insertFirst('d');
//        list.insertFirst('l');
//        list.insertFirst('o');
//        list.insertFirst('f');
//        list.insertFirst('/');
//        list.insertFirst('e');
//        list.insertFirst('v');
//        list.insertFirst('i');
//        list.insertFirst('r');
//        list.insertFirst('d');
//        list.insertFirst('/');
//        list.insertFirst('m');
        list.insertFirst('o');
        list.insertFirst('c');
        list.insertFirst('.');
        list.insertFirst('e');
        list.insertFirst('l');
        list.insertFirst('g');
        list.insertFirst('o');
        list.insertFirst('o');
        list.insertFirst('g');
        list.insertFirst('.');
        list.insertFirst('e');
        list.insertFirst('v');
        list.insertFirst('i');
        list.insertFirst('r');
        list.insertFirst('d');
        list.insertFirst('/');
        list.insertFirst('/');
        list.insertFirst(':');
        list.insertFirst('s');
        list.insertFirst('p');
        list.insertFirst('t');
        list.insertFirst('t');
        list.insertFirst('h');
        list.insert('m',23);
        list.insert('/',24);
        list.insert('d',25);
        list.insert('r',26);
        list.insert('i',27);
        list.insert('v',28);
        list.insert('e',29);
        list.insertLast('/');
        list.insertLast('f');
        list.insertLast('o');
        list.insertLast('l');
        list.insertLast('d');
        list.insertLast('e');
        list.insertLast('r');
        list.insertLast('s');
        list.insertLast('/');
        list.insertLast('1');
        list.insertLast('y');
        list.insertLast('g');
        list.insertLast('O');
        list.insertLast('a');
        list.insertLast('w');
        list.insertLast('E');
        list.insertLast('6');
        list.insertLast('Q');
        list.insertLast('v');
        list.insertLast('R');
        list.insertLast('4');
        list.insertLast('v');
        list.insertLast('a');
        list.insertLast('R');
        list.insertLast('4');
        list.insertLast('B');
        list.insertLast('0');
        list.insertLast('4');
        list.insertLast('h');
        list.insertLast('r');
        list.insertLast('k');
        list.insertLast('v');
        list.insertLast('V');
        list.insertLast('N');
        list.insertLast('P');
        list.insertLast('m');
        list.insertLast('n');
        list.insertLast('D');
        list.insertLast('q');
        list.insertLast('8');
        list.insertLast('o');
        list.insertLast('O');

        // Display the linked list
        list.display();
    }
}
class LL {

    private Node head;
    private Node tail;
    private int size;

    public LL() {
        this.size = 0;
    }

    public void insertFirst(char val) {
        Node node = new Node(val);
        node.next = head;
        head = node;

        if (tail == null) {
            tail = head;
        }
        size += 1;
    }

    public void insertLast(char val) {
        if (tail == null) {
            insertFirst(val);
            return;
        }
        Node node = new Node(val);
        tail.next = node;
        tail = node;
        size++;
    }

    public void insert(char val, int index) {
        if (index == 0) {
            insertFirst(val);
            return;
        }
        if (index == size) {
            insertLast(val);
            return;
        }

        Node temp = head;
        for (int i = 1; i < index; i++) {
            temp = temp.next;
        }

        Node node = new Node(val, temp.next);
        temp.next = node;

        size++;
    }

    // insert using recursion
    public void insertRec(char val, int index) {
        head = insertRec(val, index, head);
    }

    private Node insertRec(char val, int index, Node node) {
        if (index == 0) {
            Node temp = new Node(val, node);
            size++;
            return temp;
        }

        node.next = insertRec(val, index-1, node.next);
        return node;
    }

    // ... other methods remain unchanged ...

    public void display() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.value + " -> ");
            temp = temp.next;
        }
        System.out.println("END");
    }

    private class Node {
        private char value;
        private Node next;

        public Node(char value) {
            this.value = value;
        }

        public Node(char value, Node next) {
            this.value = value;
            this.next = next;
        }
    }


}
