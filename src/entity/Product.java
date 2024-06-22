//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package entity;

import java.text.NumberFormat;
import java.util.Locale;

public class Product {
    Locale localeBR = new Locale("pt", "BR");
    NumberFormat currencyFormat;
    public String NameProduct;
    public double Price;
    public int Amount;
    public int Codigo;

    public Product() {
        this.currencyFormat = NumberFormat.getCurrencyInstance(this.localeBR);
    }

    public Product(String nameProduct, double price, int amount, int codigo) {
        this.currencyFormat = NumberFormat.getCurrencyInstance(this.localeBR);
        this.NameProduct = nameProduct;
        this.Price = price;
        this.Amount = amount;
        this.Codigo = codigo;
    }

    public String getNameProduct() {
        return this.NameProduct;
    }

    public double getPrice() {
        return this.Price;
    }

    public int getAmount() {
        return this.Amount;
    }

    public int getCodigo() {
        return this.Codigo;
    }

    public void setNameProduct(String nameProduct) {
        this.NameProduct = nameProduct;
    }

    public void setPrice(double price) {
        this.Price = price;
    }

    public void setAmount(int amount) {
        this.Amount = amount;
    }

    public void setCodigo(int codigo) {
        this.Codigo = codigo;
    }

    public double ValorEmEstoque() {
        return this.Price * (double)this.Amount;
    }

    public double CalcularTotalEmEstoque() {
        return this.Price * (double)this.Amount;
    }

    public String toString() {
        int var10000 = this.Codigo;
        return "        Código-" + var10000 + "- Produto: " + this.NameProduct + ", " + this.currencyFormat.format(this.Price) + ", Quantidade: " + this.Amount + ", Valor total do produto no estoque: " + this.currencyFormat.format(this.ValorEmEstoque());
    }
}
