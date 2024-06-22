# Controle de Estoque de Produtos em uma Loja

Imagine que você é o gerente de uma loja e precisa de um programa para gerenciar o estoque de produtos.
Você gostaria de um sistema fácil para conseguir manipular os seus produtos de maneira mais rápida. 
Vamos dar uma olhada nesse sistema que eu desenvolvi.

## Descrição:

Você possui um conjunto de produtos em estoque, e cada produto tem as seguintes informações:

- Nome do produto.
- Quantidade em estoque.
- Preço unitário.
- Código do Produto.

## Funcinalidades:

1. Cadastro de Produto: O programa deve permitir ao usuário cadastrar novos produtos, informando o nome,
quantidade em estoque e preço unitário.

2. Consulta de Produto: O usuário deve ser capaz de consultar informações sobre um produto 
específico, digitando o nome ou um código associado ao produto.

3. Atualização de Estoque: O usuário deve poder atualizar a quantidade em estoque de um produto específico, 
seja adicionando ou removendo unidades.

4. Cálculo de Valor Total do Estoque: O programa deve ser capaz de calcular o valor
total do estoque, somando o valor total de todos os produtos.

5. Listagem de Produtos: O usuário pode solicitar a listagem de todos os produtos em
estoque, exibindo seus nomes, quantidades e preços unitários.

6. Remoção de Produto: O usuário pode remover um produto do estoque, se necessário.

7. Encerramento do Programa: O usuário deve poder encerrar o programa quando quiser.

## Conclusão:   

Para implementar essa situação em Java, desenvolvemos um sistema que utiliza um banco de dados MySQL para armazenar informações sobre os produtos, como nome, quantidade, preço e código do produto. Além disso, foram implementadas funções para manipular esses dados de acordo com as operações mencionadas.

O sistema envolve conceitos como entrada e saída de dados do usuário, uso de loops para interação sobre os produtos no estoque e atualização dos registros no banco de dados para refletir as alterações feitas pelo usuário. Em resumo, é um programa que utiliza Java para interagir com um banco de dados e gerenciar o estoque de produtos de uma loja.


