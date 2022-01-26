package SourcePackages;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class MyList {
    Node head;
    Node tail;
    //Them phan tu vao dau list
    public void addHead(Product info){
        Node newNode = new Node(info);
        if(head==null){
            head = newNode;
            tail = newNode;
            return;
        }
        newNode.nextNode = head;
        head = newNode;
    }

    //Them phan tu vao cuoi list
    public void addTail(Product info){
        Node newNode = new Node(info);
        if(head==null){
            head = newNode;
            tail = newNode;
            return;
        }
        tail.nextNode = newNode;
        tail = newNode;
    }

    /**
     * Di qua tung phan tu va kiem tra xem id cua Product moi co trung voi phan tu
     * nao trong list khong
     * @param id
     * @return boolean
     */
    public boolean check(String id){
        Node current = head;
        while (current.nextNode!=null){
            if (current.nextNode.info.id.compareTo(id)==0){
                return false;
            }
            current = current.nextNode;
        }
        return true;
    }

    //Hien thi list
    public String toString(){
        Node current = head;
        String temp ="";
        while(current!=null){
            temp += current.info;
            current = current.nextNode;
        }
        return temp;
    }

    //Viet phan tu vao file
    public void writeAllItemsToFile() throws IOException {
        File file = new File("src/SourcePackages/input");
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        Node current = head;
        String temp = "";
        //Di qua tung phan tu -> luu tat ca vao 1 string temp
        while(current!=null){
            temp += current.info.write();
            current = current.nextNode;
        }
        byte[] buffer = temp.getBytes(StandardCharsets.UTF_8);
        //Viet string vao file
        fileOutputStream.write(buffer,0,buffer.length);
    }

    //Tim kiem mot product dua tren id
    public void searchByCode(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the product code: ");
        String id = sc.next();
        Node current = head;
        //Di qua tung phan tu cua mang -> so sanh tung product's id voi id input
        while(current!=null){
            if(current.info.id.compareTo(id)==0){
                System.out.println(current.info);
                return;
            }
            current = current.nextNode;
        }
        //Neu khong tim ra bat cu phan tu nao -> in thong bao
        System.out.println("Code does not exist");
    }

    public void deleteElement(String id){
        Node current=head,prev = null;
        //Neu phan tu o dau list -> thay head = phan tu tiep theo cua head
        if(current!=null&&current.info.id.compareTo(id)==0){
            head = current.nextNode;
            return;
        }
        //Tim phan tu co id = id input va phan tu o phia truoc no
        while(current!=null&&current.info.id.compareTo(id)!=0){
            prev = current;
            current = current.nextNode;
        }
        //Neu khong tim duoc -> return
        if(current==null) return;

        //Thay doi con tro cua phan tu prev chi den phan tu tiep the cua current
        prev.nextNode = current.nextNode;
    }

    //Tao 1 list moi voi Node dau la sorted ->Luu tung phan tu cua list voo list moi bang insertion sort
    Node sorted=null;
    public void sortByCode(Node h){
        Node current = h;
        if(current!=null){
            Node next = current.nextNode;
            sortedInsert(current);
            //Neu current != null -> ham goi lai chinh no va dung lai khi current == null
            sortByCode(next);
            return;
        }
        head = sorted;
    }

    public void sortedInsert(Node newNode){
        //Neu sorted == null hoac id cua Node sorted > id cua Node newNode
        //-> add newNode vao dau cua list
        if(sorted==null||sorted.info.id.compareTo(newNode.info.id)>0){
            newNode.nextNode = sorted;
            sorted = newNode;
            return;
        }
        Node current = sorted;
        //Di qua tung phan tu cua list va so sanh no voi newNode -> tim vi tri cua newNode
        while (current.nextNode!=null&&current.nextNode.info.id.compareTo(newNode.info.id)<0){
            current = current.nextNode;
        }
        if (current.nextNode==null){
            tail = newNode;
        }
        //Luu newNode vao trong list
        newNode.nextNode = current.nextNode;
        current.nextNode = newNode;
    }

}
