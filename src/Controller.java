/**
 * Created by mer on 7/6/17.
*/

import java.util.Scanner;

public class Controller {
    private Scanner Reader = new Scanner(System.in);
    private Product [] storage;
    private Coinslot coinslot;
// OBSOLETE..
//    private boolean product_choosen;
//    private boolean money_put;
//    private boolean enough_money;

    // some logic..
    private Product selected_product;
    private int product;
    private double sum = 0.0;
    private double price = -1.0;
    private double coin = -1.0;

    private int items_in_storage;

    public Controller(Product [] storage){
        //this.customer_in = new Scanner(System.in);
        this.storage = storage;
        double arr [] =  {0.05, 0.10, 0.50, 0.20, 0.50, 1.00, 2.00};

        this.coinslot = new Coinslot(arr);
        // the states
        this.product = -1;
        this.sum = 0.0;
        this.price = -1.0;
        this.coin = -1.0;
        // items in storage..
        this.items_in_storage = storage.length;
    }

    public Controller(Product [] storage, Coinslot coinslot){
        //this.customer_in = new Scanner(System.in);
        this.storage = storage;
        this.coinslot = coinslot;
        // the states
        this.product = -1;
        this.sum = 0.0;
        this.price = -1.0;
        this.coin = -1.0;
        // items in storage..
        this.items_in_storage = storage.length;
    }

    public double getSum(){
        return this.sum;
    }

    public String displayProducts(){
        String display = "";
        for (int i = 0; i < this.storage.length; i++) {
            int number = this.storage[i].getId();
            String name = this.storage[i].getName();
            display += number + " - for: " + name + "\n";
        }
        return display;
    }

    public void setProducts(Product [] storage){
        this.storage = storage;
        this.items_in_storage = storage.length;
    }

    public String displayStorage(Product [] storage) {
        String display = "";
        for (int i = 0; i < storage.length; i++) {
            int number = storage[i].getId();
            String name = storage[i].getName();
            display += number + " - for: " + name;
        }
        return display;
    }

    public void serve(){        
    }
}
