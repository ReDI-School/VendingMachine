/**
 * Created by mer on 7/6/17.
 */
public class Product {
    private int id;
    private float weight;
    private double price;
    private String name;

    public Product(int id, float weight, double price, String name){
        this.id = id;
        this.weight = weight;
        this.price = price;
        this.name = name;
    }

    public int getId(){ return this.id;}

    public float getWeight(){
        return this.weight;
    }

    public double getPrice(){
        return this.price;
    }

    public String getName(){
        return this.name;
    }

    public void setId(int id){
        this.id = id;
    }

    // set method always are void..
    public void setWeight(float weight){
        this.weight = weight;
    }

    public void setPrice(double price){
        this.price = price;
    }

    public void setName(String name){
        this.name = name;
    }
}
