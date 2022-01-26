package SourcePackages;

import java.util.EmptyStackException;

public class Mystack {
    Node head;

    //Kiem tra xem stack co rong khong
    public boolean isEmpty(){
        return head == null;
    }

    //Them 1 phan tu vao dau stack
    public void push(Product info){
        Node newNode = new Node(info);
        newNode.nextNode = head;
        head = newNode;
    }

    //Lay phan tu vao dau stack
    public Product pop(){
        if(isEmpty()) throw new EmptyStackException();
        Product temp = head.info;
        head = head.nextNode;
        return temp;
    }

    //Xem phan tu dau tien cua stack
    public Product peek(){
        if(isEmpty())  throw new EmptyStackException();
        return head.info;
    }

    //Hien thi ca stack
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
