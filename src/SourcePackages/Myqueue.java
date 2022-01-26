package SourcePackages;

public class Myqueue {
    public Node head, tail;
    public Myqueue(){
        head = tail = null;
    }
    //Kiem tra xem queue co empty hay khong
    public boolean isEmpty() {
        return head == null;
    }
    //Lay phan tu dau cua queue
    public Product dequeue() throws Exception {
        if(isEmpty()) throw new Exception();
        Product temp = head.info;
        head = head.nextNode;
        if(head==null) tail = null;
        return temp;
    }

    //Them phan tu vao cuoi queue
    public void enqueue(Product x){
        if(isEmpty()){
            head = tail = new Node(x);
        }
        else{
            tail.nextNode = new Node(x);
            tail = tail.nextNode;
        }
    }

    //Xem phan tu o dau queue
    public Product front() throws  Exception{
        if(isEmpty()) throw new Exception();
        return head.info;
    }

    //Hien thi mang
    public String toString(){
        Node current = head;
        String temp ="";
        while(current!=null){
            temp += current.info;
            current = current.nextNode;
        }
        return temp;
    }
}
