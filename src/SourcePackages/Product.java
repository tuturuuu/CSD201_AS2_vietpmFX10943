package SourcePackages;

public class Product {
        String id;
        String title;
        int quantity;
        double price;

        public Product(String id, String title, int quantity, double price) {
            this.id = id;
            this.title = title;
            this.quantity = quantity;
            this.price = price;
        }

        public String toString(){
            return ""+id+" "+" |"+title+" "+" |"+quantity+" "+" |"+price+" \n";
        }
        public String write(){return " "+id+" "+" "+title+" "+" "+quantity+" "+" "+price+" \n";}
    }


