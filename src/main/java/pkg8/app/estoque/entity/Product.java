package pkg8.app.estoque.entity;

import java.text.NumberFormat;
import java.util.Locale;

public class Product {
    private Locale localeBR = new Locale("pt", "BR");
    private NumberFormat currencyFormat;
    private String nameProduct;
    private double price;
    private int amount;
    private int codigo;

    public Product() {
        this.currencyFormat = NumberFormat.getCurrencyInstance(this.localeBR);
    }

    public Product(String nameProduct, double price, int amount, int codigo) {
        this.currencyFormat = NumberFormat.getCurrencyInstance(this.localeBR);
        this.nameProduct = nameProduct;
        this.price = price;
        this.amount = amount;
        this.codigo = codigo;
    }

    public String getNameProduct() {
        return this.nameProduct;
    }

    public double getPrice() {
        return this.price;
    }

    public int getAmount() {
        return this.amount;
    }

    public int getCodigo() {
        return this.codigo;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public double valorEmEstoque() {
        return this.price * this.amount;
    }

    public double calcularTotalEmEstoque() {
        return this.price * this.amount;
    }

    @Override
    public String toString() {
        return "Código-" + this.codigo + " - Produto: " + this.nameProduct + ", " + this.currencyFormat.format(this.price) + ", Quantidade: " + this.amount;
    }
}
package pkg8.app.estoque.entity;

import java.text.NumberFormat;
import java.util.Locale;

public class Product {
    private Locale localeBR = new Locale("pt", "BR");
    private NumberFormat currencyFormat;
    private String nameProduct;
    private double price;
    private int amount;
    private int codigo;

    public Product() {
        this.currencyFormat = NumberFormat.getCurrencyInstance(this.localeBR);
    }

    public Product(String nameProduct, double price, int amount, int codigo) {
        this.currencyFormat = NumberFormat.getCurrencyInstance(this.localeBR);
        this.nameProduct = nameProduct;
        this.price = price;
        this.amount = amount;
        this.codigo = codigo;
    }

    public String getNameProduct() {
        return this.nameProduct;
    }

    public double getPrice() {
        return this.price;
    }

    public int getAmount() {
        return this.amount;
    }

    public int getCodigo() {
        return this.codigo;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public double valorEmEstoque() {
        return this.price * this.amount;
    }

    public double calcularTotalEmEstoque() {
        return this.price * this.amount;
    }

    @Override
    public String toString() {
        return "Código-" + this.codigo
          + " - Produto: " + this.nameProduct +
          ", " + this.currencyFormat.format(this.price) +
          ", Quantidade: " + this.amount;
    }
}
