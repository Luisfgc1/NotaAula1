import java.util.ArrayList;

class Estoque {
    ArrayList<Produto> listaProdutos;

    public Estoque() {
        this.listaProdutos = new ArrayList<>();
    }

    public void adicionarProduto(Produto produto) {
        listaProdutos.add(produto);
    }

    public Produto buscarProduto(String codigo) {
        for (Produto produto : listaProdutos) {
            if (produto.codigo.equals(codigo)) {
                return produto;
            }
        }
        return null;
    }
}

