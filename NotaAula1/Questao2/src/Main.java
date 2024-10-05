import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Estoque estoque = new Estoque();

        System.out.println("Você deseja cadastrar um produto, ou realizar a compra?");
        System.out.println("1 - cadastrar 2 - comprar");
        int opcaoCadastroCompra = sc.nextInt();
        sc.nextLine();

        switch (opcaoCadastroCompra) {
            case 1:
                cadastrarProduto(sc, estoque);
                break;
            case 2:
                comprarProduto(sc, estoque);
                break;
            default:
                System.out.println("Opção inválida!");
        }

        sc.close();
    }

    private static void cadastrarProduto(Scanner sc, Estoque estoque) {
        System.out.println("Cadastro de produto");
        System.out.println("Digite o código:");
        String codigo = sc.nextLine();

        System.out.println("Digite o nome:");
        String nome = sc.nextLine();

        System.out.println("Digite o tamanho ou peso:");
        String tamanhoOuPeso = sc.nextLine();

        System.out.println("Digite a cor:");
        String cor = sc.nextLine();

        System.out.println("Digite o valor:");
        double valor = sc.nextDouble();

        System.out.println("Digite a quantidade em estoque:");
        int quantidadeEstoque = sc.nextInt();
        sc.nextLine();

        Produto novoProduto = new Produto(codigo, nome, tamanhoOuPeso, cor, valor, quantidadeEstoque);
        estoque.adicionarProduto(novoProduto);
        novoProduto.exibirProduto();

        System.out.println("Produto cadastrado com sucesso!");
    }

    private static void comprarProduto(Scanner sc, Estoque estoque) {
        System.out.println("Digite o código do produto que deseja comprar:");
        String codigo = sc.nextLine();

        Produto produto = estoque.buscarProduto(codigo);
        if (produto == null) {
            System.out.println("Produto não cadastrado");
            return;
        }

        System.out.println("Quantas unidades deseja comprar?");
        int quantidadeVendida = sc.nextInt();

        if (quantidadeVendida <= produto.quantidadeEstoque) {
            double valorTotal = produto.valor * quantidadeVendida;
            System.out.println("Valor total sem desconto: R$ " + valorTotal);

            System.out.println("\nFormas de pagamentos disponíveis");
            System.out.println("1 - Pix\n2 - Espécie\n3 - Transferência\n4 - Débito\n5 - Crédito");
            int formaPagamento = sc.nextInt();

            double desconto = 0;

            switch (formaPagamento) {
                case 1:
                case 2:
                case 3:
                case 4:
                    desconto = 0.05 * valorTotal;
                    valorTotal -= desconto;
                    System.out.println("Valor total com desconto de 5% aplicado: R$ " + valorTotal);
                    break;
                case 5:
                    System.out.println("Você deseja parcelar em 3x sem juros? (1- Sim, 2- Não)");
                    int opcaoParcelamento = sc.nextInt();

                    if (opcaoParcelamento == 1) {
                        System.out.println("Valor parcelado em 3x de R$ " + valorTotal / 3);
                    } else if (opcaoParcelamento == 2) {
                        System.out.println("Digite o valor pago");
                        double valorPago = sc.nextDouble();

                        if (valorPago > valorTotal) {
                            double troco = valorPago - valorTotal;
                            System.out.println("Troco: R$ " + troco);
                        } else if (valorPago < valorTotal) {
                            System.out.println("Valor insuficiente");
                        }
                    }
                    break;
                default:
                    System.out.println("Forma de pagamento inválida");
                    return;
            }

            produto.atualizarEstoque(quantidadeVendida);
            System.out.println("Venda realizada com sucesso!");
            System.out.println("Quantidades em estoque restantes: " + produto.quantidadeEstoque);
        } else {
            System.out.println("Estoque insuficiente!");
        }
    }
}
