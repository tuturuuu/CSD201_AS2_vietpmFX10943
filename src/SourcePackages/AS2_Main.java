package SourcePackages;

import java.io.IOException;
import java.util.Scanner;

public class AS2_Main {
    static OperationToProduct operationToProduct = new OperationToProduct();
    static MyList list = new MyList();
    static Mystack stack = new Mystack();
    static Myqueue queue = new Myqueue();
    public static void showMenu() throws IOException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Choose one of this options:");
        System.out.println("Product list:");
        System.out.println("1. Load data from file and display");
        System.out.println("2. Input & add to the end.");
        System.out.println("3. Display data");
        System.out.println("4. Save product list to file.");
        System.out.println("5. Search by ID");
        System.out.println("6. Delete by ID");
        System.out.println("7. Sort by ID.");
        System.out.println("8. Convert to Binary");
        System.out.println("9. Load to stack and display");
        System.out.println("10. Load to queue and display.");
        System.out.println("0. Exit");
        int choice=1;
        while (choice!=0) {
            System.out.print("Choice= ");
            switch (choice=sc.nextInt()) {
                case 1:
                    System.out.println("ID |  Title   | Quantity | price");
                    System.out.println("--------------------------------");
                    operationToProduct.getAllItemsFromFile("src/SourcePackages/input",list);
                    break;
                case 2:
                    operationToProduct.inputToEnd(list);
                    break;
                case 3:
                    System.out.println("ID |  Title   | Quantity | price");
                    System.out.println("--------------------------------");
                    operationToProduct.display(list);
                    break;
                case 4:
                    operationToProduct.writeAllItemsToFile(list);
                    break;
                case 5:
                    operationToProduct.searchByCode(list);
                    break;
                case 6:
                    operationToProduct.deleteElement(list);
                    break;
                case 7:
                    operationToProduct.sortByCode(list);
                    break;
                case 8:
                    System.out.print("Result= ");
                    operationToProduct.convertToBinary(list.head.info.quantity,0);
                    System.out.println();
                    break;
                case 9:
                    System.out.println("ID |  Title   | Quantity | price");
                    System.out.println("--------------------------------");
                    operationToProduct.getAllItemsFromFile("src/SourcePackages/input",stack);
                    break;
                case 10:
                    System.out.println("ID |  Title   | Quantity | price");
                    System.out.println("--------------------------------");
                    operationToProduct.getAllItemsFromFile("src/SourcePackages/input", queue);
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Re-Enter the choice 0-10");
            }
        }
    }
}

