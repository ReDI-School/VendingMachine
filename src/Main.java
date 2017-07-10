/**
 * Created by mer on 7/6/17.
 */

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // coinslot
        double arr[] = {0.05, 0.10, 0.50, 0.20, 0.50, 1.00, 2.00};
        Coinslot coinslot = new Coinslot(arr);

        // some products..
        Product keks = new Product(1, 0.1f, 0.80, "Butterkeks");
        Product cola = new Product(2, 0.4f, 0.90, "Some labeled cola");
        Product tea = new Product(3, 0.5f, 0.50, "Green tea");
        Product water = new Product(4, 0.5f, 1.45, "Silent water");
        Product coffee = new Product(5, 0.5f, 1.20, "Coffee black");

        Product[] storage = {keks, cola, tea, water, coffee};

        // some logic..
        String selected_product_name = "";

        // the given amount of money (sum of all given coins).
        double sum = 0.00;
        // the price for a product.
        double price = -1;
        // a virtual coin.
        double coin;
        // menu choice to make.
        int choice = -1;
        // number of menu items.
        int available = 2;
        // the product which was choosen.
        int product = -1;

        Scanner Reader = new Scanner(System.in);

        // choice - 1. money first, 2. product first.
        System.out.println("Dear Customer, please make your choice..");
        while (!(-1 < choice && choice < available + 1)) {
            System.out.println("available: " + available);
            System.out.println("choice: " + choice);
            //choice = Reader.nextInt();
            if (choice == -1 && sum == 0.00 && product == -1 && available == 2 && price == -1.00) {
                System.out.println("1 - insert money..");
                System.out.println("2 - choose product..");
                System.out.println("0 - terminate transation..");
                choice = Reader.nextInt();
            }

            if (choice == 1 && sum == 0.00 && product == -1 && available == 2 && price == -1.00) {
                // give some money..
                System.out.println("Your credit is: " + sum + " " + coinslot.getCurrency());
                System.out.println("Please put some more money into the coinslot.");
                boolean validcoin = true;
                while (validcoin) {
                    coin = Reader.nextDouble();
                    if (coinslot.isValid(coin)){
                        sum += coin;
                        System.out.println("Your credit is: " + sum + " " + coinslot.getCurrency());
                    }
                    else{
                        System.out.println("That's not valid coin..");
                        break;
                    }
                }

            }
            if (((choice == 1 && sum > 0.00) || (choice == 2 && sum == 0.00)) && product == -1 && available == 2 && price == -1.00) {
                // choose a product
                System.out.println("Please choose your product.");
                // display products
                for (int i = 0; i < storage.length; i++) {
                    int id = storage[i].getId();
                    price = storage[i].getPrice();
                    String name = storage[i].getName();
                    String currency = coinslot.getCurrency();
                    System.out.println(id + " " + "(" + price  + currency + ") - for: " + name);
                }// end display products
                System.out.println("0 - terminate transation..");
                available = storage.length;
                System.out.println("available: " + available);
            }
            if (available == storage.length){
                System.out.println("product: " + product);
                while (!( 0 < product && product < available + 1)) {
                    product = Reader.nextInt();
                }
                System.out.println("You have choosen: " + storage[product-1].getName());
                price = storage[product - 1].getPrice();
                System.out.println("price: " + price);
                System.out.println("Your credit is: " + sum + " " + coinslot.getCurrency());
                System.out.println("You have to insert at least: " + price + coinslot.getCurrency());
                while (!(sum >= price)) {
                    // ask for more coins
                    System.out.println("Please put some more money into the coinslot.");
                    coin = Reader.nextDouble();
                    if (coinslot.isValid(coin)) {
                        sum += coin;
                        System.out.println("Your credit is: " + sum + " " + coinslot.getCurrency());
                    } else {
                        System.out.println("That's not valid coin..");
                    }
                }
                if (sum > price) {
                    double change = sum - price;
                    System.out.println("Your change is: " + change + " " + coinslot.getCurrency());
                }
                System.out.println("Please take your " + storage[product - 1].getName() + " out of the tray.");
                System.out.println("Enjoy your snack.");
                sum = 0.00;
                price = -1;
                choice = -1;
                available = 2;
                product = -1;
            }
            if (choice == 0) {
                System.out.println("Sorry - You can't take away any Item.");
                System.out.println("You have terminated the transaction.");
                if (sum > 0){
                    double change = sum;
                    System.out.println("Your change is: " + change + " " + coinslot.getCurrency());
                }
                sum = 0.00;
                price = -1;
                choice = -1;
                available = 2;
                product = -1;
                //break;
                // in addition..
            }
        }
    }
}

