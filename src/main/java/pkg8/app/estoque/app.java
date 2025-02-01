package pkg8.app.estoque;

import java.util.ArrayList;
import pkg8.app.estoque.DAO.ProductDAO;
import pkg8.app.estoque.entity.Product;

public class app extends javax.swing.JFrame {

    ArrayList<Product> produtoPrincipal = new ArrayList<Product>();
    Product produto = new Product();
    ProductDAO productDAO = new ProductDAO();

    public app() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {
        jLabel1 = new javax.swing.JLabel();
        txtNameProduct = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtPrice = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtAmount = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtCodigo = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtResultado = new javax.swing.JTextArea();
        consultar = new javax.swing.JButton();
        atualizar = new javax.swing.JButton();
        cadastrar = new javax.swing.JButton();
        remover = new javax.swing.JButton();
        listar = new javax.swing.JButton();
        totalEstoque = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("NOME:");
        jLabel2.setText("PREÇO:");
        jLabel3.setText("QUANTIDADE:");
        jLabel4.setText("CÓDIGO:");

        txtResultado.setColumns(20);
        txtResultado.setRows(5);
        jScrollPane1.setViewportView(txtResultado);

        consultar.setText("CONSULTAR");
        atualizar.setText("ATUALIZAR");
        cadastrar.setText("CADASTRAR");
        remover.setText("REMOVER PRODUTOS");
        listar.setText("LISTAR PRODUTOS");
        totalEstoque.setText("CALCULO TOTAL ESTOQUE");

        pack();
    }

    private void consultarActionPerformed(java.awt.event.ActionEvent evt) {
        int codigo = Integer.parseInt(txtCodigo.getText().trim());
        produto = null;
        for (Product p : productDAO.getProducts()) {
            if (p.getCodigo() == codigo) {
                produto = p;
                break;
            }
        }
        if (produto == null) {
            txtResultado.setText("Produto não encontrado");
        } else {
            txtResultado.setText(produto.toString());
        }
    }

    private void atualizarActionPerformed(java.awt.event.ActionEvent evt) {
        int codigo = Integer.parseInt(txtCodigo.getText().trim());
        Product produtoParaAtualizar = null;
        for (Product p : productDAO.getProducts()) {
            if (p.getCodigo() == codigo) {
                produtoParaAtualizar = p;
                break;
            }
        }
        if (produtoParaAtualizar == null) {
            txtResultado.setText("Produto não encontrado.");
            return;
        }
        String nome = txtNameProduct.getText();
        produtoParaAtualizar.setNameProduct(nome);
        productDAO.update(produtoParaAtualizar);
        txtResultado.setText("Produto atualizado com sucesso.");
    }

    private void cadastrarActionPerformed(java.awt.event.ActionEvent evt) {
        try {
            String nome = txtNameProduct.getText();
            double preco = Double.parseDouble(txtPrice.getText());
            int quantidade = Integer.parseInt(txtAmount.getText());
            int codigo = Integer.parseInt(txtCodigo.getText());
            Product novoProduto = new Product(nome, preco, quantidade, codigo);
            produtoPrincipal.add(novoProduto);
            productDAO.cadastrarProduto(novoProduto);
        } catch (Exception erro) {
            txtResultado.setText("Erro nos dados digitados!");
        }
    }

    private void removerActionPerformed(java.awt.event.ActionEvent evt) {
        try {
            int codigo = Integer.parseInt(txtCodigo.getText().trim());
            Product produtoParaRemover = null;
            for (Product p : productDAO.getProducts()) {
                if (p.getCodigo() == codigo) {
                    produtoParaRemover = p;
                    break;
                }
            }
            if (produtoParaRemover != null) {
                productDAO.deleteById(produtoParaRemover);
                txtResultado.setText("Produto removido com sucesso!");
            } else {
                txtResultado.setText("Produto não encontrado!");
            }
        } catch (NumberFormatException e) {
            txtResultado.setText("Código inválido. Por favor, insira um número válido.");
        }
    }

    private void listarActionPerformed(java.awt.event.ActionEvent evt) {
        StringBuilder resultado = new StringBuilder();
        for (Product p : productDAO.getProducts()) {
            resultado.append(p.toString()).append("\n");
        }
        txtResultado.setText(resultado.toString());
    }

    private void totalEstoqueActionPerformed(java.awt.event.ActionEvent evt) {
        double valorTotalEmEstoque = 0;
        for (Product p : productDAO.getProducts()) {
            produto = p;
            valorTotalEmEstoque += produto.CalcularTotalEmEstoque();
        }
        txtResultado.setText("Valor total do estoque: R$" + valorTotalEmEstoque);
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> new app().setVisible(true));
    }

    private javax.swing.JButton atualizar;
    private javax.swing.JButton cadastrar;
    private javax.swing.JButton consultar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton listar;
    private javax.swing.JButton remover;
    private javax.swing.JButton totalEstoque;
    private javax.swing.JTextField txtAmount;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtNameProduct;
    private javax.swing.JTextField txtPrice;
    private javax.swing.JTextArea txtResultado;
}
