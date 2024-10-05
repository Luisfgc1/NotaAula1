class Produto {
    String codigo;
    String nome;
    String tamanhoOuPeso;
    String cor;
    double valor;
    int quantidadeEstoque;

    public Produto(String codigo, String nome, String tamanhoOuPeso, String cor, double valor, int quantidadeEstoque) {
        this.codigo = codigo;
        this.nome = nome;
        this.tamanhoOuPeso = tamanhoOuPeso;
        this.cor = cor;
        this.valor = valor;
        this.quantidadeEstoque = quantidadeEstoque;
    }

    public void exibirProduto() {
        System.out.println("Código: " + codigo);
        System.out.println("Nome: " + nome);
        System.out.println("Tamanho/Peso: " + tamanhoOuPeso);
        System.out.println("Cor: " + cor);
        System.out.println("Valor: R$ " + valor);
        System.out.println("Quantidade em estoque: " + quantidadeEstoque);
    }

    public void atualizarEstoque(int quantidadeVendida) {
        if (quantidadeVendida <= quantidadeEstoque) {
            this.quantidadeEstoque -= quantidadeVendida;
        }
    }
}

