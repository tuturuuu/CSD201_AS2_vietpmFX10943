package SourcePackages;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class OperationToProduct {
    //1 Lay item trong file va luu vao LinkedList
    public void getAllItemsFromFile(String fileName,MyList list) throws FileNotFoundException {
    File file = new File(fileName);
    Scanner sc = new Scanner(file);
    //Dung scanner de luu tung dong trong file vao linked list
    while (sc.hasNext()){
        String id = sc.next();
        String title = sc.next();
        int quantity = sc.nextInt();
        double price = sc.nextDouble();
        Product temp = new Product(id,title,quantity,price);
        list.addTail(temp);
        System.out.print(temp);
    }
    }
    //2 Nhan input tu nguoi dung va luu vao linked list

    public void inputToEnd(MyList list){
        Scanner sc = new Scanner(System.in);
        String id;
        while(true) {
            System.out.println("Enter your product's id: ");
            id = sc.next();
            if (list.check(id)){
                break;
            }
            else {
                System.out.println("Id existed. Use new id: ");
            }
        }
        System.out.println("Enter your product's title: ");
        String title = sc.next();
        System.out.println("Enter your product's quantity: ");
        int quantity = sc.nextInt();
        System.out.println("Enter your product's price: ");
        double price = sc.nextDouble();
        Product info = new Product(id,title,quantity,price);
        list.addTail(info);
    }
    //3 hien thi list
    public void display(MyList list){
        System.out.println(list);
    }
    //4 viet tat cac cac product trong mang -> file
    public void writeAllItemsToFile(MyList list) throws IOException {
        list.writeAllItemsToFile();
    }
    //5 Nhan input tu nguoi dung va tim phan tu trong list co cung id
    public void searchByCode(MyList list){
        list.searchByCode();
    }
    //6
    public void deleteElement(MyList list){
        System.out.println("Delete the product: ");
        Scanner sc = new Scanner(System.in);
        String id = sc.next();
        list.deleteElement(id);
    }
    //7 Sap xep tu be den lon
    public void sortByCode(MyList list){
        list.sorted = null;
        list.sortByCode (list.head);
    }
    //8 Chuyen sang he nhi phan
    public void convertToBinary(int i,int n){
        int du=0;
        int tmp = i;
        if(i>0){
            du = tmp%2;
            convertToBinary(i/2,n+1);
        }
        System.out.print(du);
    }
    //9 Lay tat ca cac phan tu cua file va push vao trong stack
    public void getAllItemsFromFile(String fileName, Mystack stack) throws FileNotFoundException {
        File file = new File(fileName);
        Scanner sc = new Scanner(file);
        while (sc.hasNext()){
            String id = sc.next();
            String title = sc.next();
            int quantity = sc.nextInt();
            double price = sc.nextDouble();
            Product temp = new Product(id,title,quantity,price);
            stack.push(temp);
        }
        System.out.println(stack);
    }
    //Lay tat ca cac phan tu cua file va enqueue vao trong queue temp
    public void getAllItemsFromFile(String fileName, Myqueue queue) throws FileNotFoundException {
        File file = new File(fileName);
        Scanner sc = new Scanner(file);
        while (sc.hasNext()){
            String id = sc.next();
            String title = sc.next();
            int quantity = sc.nextInt();
            double price = sc.nextDouble();
            Product temp = new Product(id,title,quantity,price);
            queue.enqueue(temp);
        }
        System.out.println(queue);
    }
}
