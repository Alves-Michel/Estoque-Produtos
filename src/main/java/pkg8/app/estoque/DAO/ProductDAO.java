package pkg8.app.estoque.DAO;

import pkg8.app.estoque.conection.Conection;
import pkg8.app.estoque.entity.Product;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO {
    public ProductDAO() {}

    public void cadastrarProduto(Product product) {
        String sql = "INSERT INTO PRODUCT (NOME, PRECO, QUANTIDADE, CODIGO) VALUES (?, ?, ?, ?)";
        try (Connection conn = Conection.getConexao();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, product.getNameProduct());
            ps.setDouble(2, product.getPrice());
            ps.setInt(3, product.getAmount());
            ps.setInt(4, product.getCodigo());
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void update(Product product) {
        String sql = "UPDATE product SET nome = ?, preco = ?, quantidade = ? WHERE codigo = ?";
        try (Connection conn = Conection.getConexao();
             PreparedStatement pstm = conn.prepareStatement(sql)) {
            pstm.setString(1, product.getNameProduct());
            pstm.setDouble(2, product.getPrice());
            pstm.setInt(3, product.getAmount());
            pstm.setInt(4, product.getCodigo());
            pstm.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteById(Product product) {
        String sql = "DELETE FROM product WHERE codigo = ?";
        try (Connection conn = Conection.getConexao();
             PreparedStatement pstm = conn.prepareStatement(sql)) {
            pstm.setInt(1, product.getCodigo());
            pstm.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Product> getProducts() {
        String sql = "SELECT * FROM product";
        List<Product> products = new ArrayList<>();
        try (Connection conn = Conection.getConexao();
             PreparedStatement pstm = conn.prepareStatement(sql);
             ResultSet rset = pstm.executeQuery()) {
            while (rset.next()) {
                Product product = new Product();
                product.setNameProduct(rset.getString("nome"));
                product.setPrice(rset.getDouble("preco"));
                product.setAmount(rset.getInt("quantidade"));
                product.setCodigo(rset.getInt("codigo"));
                products.add(product);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return products;
    }
}
