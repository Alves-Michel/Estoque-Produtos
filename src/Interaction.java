//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import DAO.ProductDAO;
import entity.Product;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class Interaction {
    public Interaction() {
    }

    public static void main(String[] args) {
        ArrayList<Product> produtoPrincipal = new ArrayList<Product>();
        Scanner leitor = new Scanner(System.in);
        Product produto = new Product();
        ProductDAO productDAO = new ProductDAO();

        int option;
        System.out.println();
        System.out.print("        Bem Vindo ao Sistema de Armazenamento de Produtos");

        do {
            System.out.println("""
                        
                               =========================================================== \s
                                        Selecione uma opção: \s
                                        1 - Cadastro de Produtos\s
                                        2 - Consulta de Produtos\s
                                        3 - Atualização de Estoque\s
                                        4 - Cálculo de valor total de estoque \s
                                        5 - Listagem de Produtos \s
                                        6 - Remoção de Produtos \s
                                        7 - Encerramento do programa \s
                               ============================================================""");
            option = leitor.nextInt();


            switch (option) {
                case 1:
                    System.out.println("======================================================");
                    System.out.print("    Nome do Produto: ");
                    leitor.nextLine();
                    String nomeProduto = leitor.nextLine();
                    System.out.print("    Preço do produto: ");
                    double precoProduto = leitor.nextDouble();
                    System.out.print("    Quantidade de produtos: ");
                    int quantidadeProduto = leitor.nextInt();
                    System.out.print("    Codigo do produto: ");
                    int codigoProduto = leitor.nextInt();
                    Product novoProduto = new Product(nomeProduto, precoProduto, quantidadeProduto, codigoProduto);
                    produtoPrincipal.add(novoProduto);

                    productDAO.cadastrarProduto(novoProduto);

                    break;

                case 2:
                    System.out.println("======================================================");
                    System.out.print("    Digite o codigo do produto a ser consultado: ");
                    int codigoConsulta = leitor.nextInt();
                    produto = null;

                    for (Product p : productDAO.getProducts()) {
                        if (p.getCodigo() == codigoConsulta) {
                            produto = p;
                            break;
                        }
                    }
                    if (produto == null) {
                        System.out.println("    Produto nao encontrado: ");
                    }
                    System.out.println(produto.toString());
                    break;
                case 3:
                    // Solicitar ao usuário o código do produto que deseja atualizar
                    System.out.print("Digite o código do produto que deseja atualizar: ");
                    int codigo = leitor.nextInt();
                    leitor.nextLine(); // Consumir a nova linha

                    // Buscar o produto pelo código
                    Product produtoParaAtualizar = null;
                    for (Product p : productDAO.getProducts()) {
                        if (p.getCodigo() == codigo) {
                            produtoParaAtualizar = p;
                            break; // Sai do loop assim que encontrar o produto
                        }
                    }

                    // Verificar se o produto foi encontrado
                    if (produtoParaAtualizar == null) {
                        System.out.println("Produto não encontrado.");
                        break;
                    }
                        System.out.println("""
                        ====================================================== \s
                        O que gostaria de atualizar? \s
                        ---> 1 - Nome \s
                        ---> 2 - Preço \s
                        ---> 3 - Quantidade \s
                        ---> 4 - Trocar Tudo \s
                        ---> 0 - Sair da Opção \s
                        ======================================================""");
                        int tipoDeAlteracao = leitor.nextInt();
                        double newPrice;
                        String novoNome;
                        int newAmount;
                        switch (tipoDeAlteracao) {
                            case 0:
                                System.out.println("Saindo da opção de atualizar.");
                                break;
                            case 1:
                                System.out.println("Digite o novo nome do produto:");
                                leitor.nextLine();
                                novoNome = leitor.nextLine();
                                produtoParaAtualizar.setNameProduct(novoNome);
                                break;
                            case 2:
                                System.out.println("Digite o novo preço do produto: ");
                                newPrice = leitor.nextDouble();
                                produtoParaAtualizar.setPrice(newPrice);
                                break;
                            case 3:
                                System.out.println("Digite a nova quantidade de produto: ");
                                newAmount = leitor.nextInt();
                                produtoParaAtualizar.setAmount(newAmount);
                                break;
                            case 4:
                                System.out.println("Digite o novo nome do produto:");
                                leitor.nextLine();
                                novoNome = leitor.nextLine();
                                System.out.println("Digite o novo preço do produto: ");
                                newPrice = leitor.nextDouble();
                                System.out.println("Digite a nova quantidade de produto: ");
                                newAmount = leitor.nextInt();
                                produtoParaAtualizar.setNameProduct(novoNome);
                                produtoParaAtualizar.setPrice(newPrice);
                                produtoParaAtualizar.setAmount(newAmount);
                                break;
                            default:
                                System.out.println("Opção inválida!");
                        }

                        productDAO.update(produtoParaAtualizar);
                        if (tipoDeAlteracao != 0) {
                            System.out.println("Produto atualizado com sucesso.");
                        }

                    break;
                case 4:
                    System.out.println("======================================================");
                    double ValorTotalEmEstoque = 0;
                    for (Product p : productDAO.getProducts()) {
                        produto = p;
                        ValorTotalEmEstoque += produto.CalcularTotalEmEstoque();
                    }
                    System.out.println("Valor total do estoque: R$" + ValorTotalEmEstoque);
                    break;

                case 5:
                    System.out.println("======================================================");
                    System.out.println("    Lista de Produtos em Estoque: ");

                    for (Product p : productDAO.getProducts()) {
                        System.out.println(p.toString());
                    }
                    break;

                case 6:
                    System.out.println("======================================================");
                    System.out.print("Digite o código do produto que deseja remover: ");
                    int codigoProduto2 = leitor.nextInt();
                    Product produtoParaRemover = null;

                    for (Product p : productDAO.getProducts()) {
                        if (p.getCodigo() == codigoProduto2) {
                            produtoParaRemover = p;
                            break;
                        }
                    }

                    if (produtoParaRemover != null) {
                        productDAO.deleteById(produtoParaRemover);
                        System.out.println("Produto removido com sucesso! ");
                    } else {
                        System.out.println("Produto não encontrado. ");
                    }
                    break;
            }
        }while (option != 7);
        System.out.println("Obrigado por utilizar o programa, volte sempre :)");
        leitor.close();
    }
}
