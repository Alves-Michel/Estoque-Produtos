//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import java.text.NumberFormat;
import java.util.Locale;

public class Product {
    public String NameProduct;
    public double Price;
    public int Amount;
    public int Codigo;

    public Product() {
    }

    public Product(String nameProduct, double price, int amount, int codigo) {
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

    public double ValorEmEstoque() {
        return this.Price * (double)this.Amount;
    }

    public double CalcularTotalEmEstoque() {
        return this.Price * (double)this.Amount;
    }

    public void AdcionarProdutos(int amout) {
        this.Amount += amout;
        System.out.println("        Produto atualizado com sucesso!");
    }

    public void RemoverProdutos(int amount) {
        this.Amount -= amount;
        System.out.println("        Produto removido com sucesso!");
    }

    public String toString() {
        Locale localeBR = new Locale("pt", "BR");
        NumberFormat currencyFormat = NumberFormat.getCurrencyInstance(localeBR);
        int var10000 = this.Codigo;
        return "        Código-" + var10000 + "- Produto: " + this.NameProduct + ", " + currencyFormat.format(this.Price) + ", Quantidade: " + this.Amount + ", Valor total do produto no estoque: " + currencyFormat.format(this.ValorEmEstoque());
    }
}
