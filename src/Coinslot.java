/**
 * Created by mer on 7/6/17.
 */
public class Coinslot {
    // some accepted coins..
    private double[] acoins;
    private String currency;
    //private int [] change;

    public Coinslot(double[] acoins, String currency) {
        if (currency.length() == 3) {
            this.currency = currency;
            this.acoins = acoins;
        }
    }

    public Coinslot(double [] acoins) {
        this.acoins = acoins;
        // this.acoins = ; // new int[6]; // {0.05f, 0.1f, 0.2f, 0.5f, 1.0f, 2.0f};
        this.currency = "EUR";
        //    this.change = {0.05f, 0.1f, 0.1f, 0.2f, 0.2f, 0.2f, 0.5f, 1.0f, 2.0f}
    }

    public double[] getAcceptedCoins() {
        return this.acoins;
    }

    public void setAccptedCoins(double[] acoins) {
        this.acoins = acoins;
    }

    public String getCurrency() {
        return this.currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    //public int[] getChange(){    return this.change;    }

    //public void setChange(double[] change){ this.change = change; }

    public boolean isValid(double coin) {
        boolean valid = false;
        for (int i = 0; i < acoins.length; i++) {
            if (coin == acoins[i]) {
                valid = true;
            }
        }
        return valid;
    }
}