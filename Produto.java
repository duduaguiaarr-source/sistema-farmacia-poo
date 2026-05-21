//Eduardo de Oliveira Aguiar - RA: 2706954
public class Produto {
    private String nome;
    private double preco;
    private int estoque;

    public Produto() {
        this.nome = "";
        this.preco = 0.0;
        this.estoque = 0;
    }
    //Sobrecarga
    public Produto(String nome, double preco, int estoque) {
        this.nome = nome;
        this.preco = preco;
        this.estoque = estoque;
    }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public double getPreco() { return preco; }
    public void setPreco(double preco) { this.preco = preco; }
    public int getEstoque() { return estoque; }
    public void setEstoque(int estoque) { this.estoque = estoque; }

    //Sobrecarga
    public double calcularPreco() { 
        return preco;
    }

    //Sobrecarga
    public double calcularPreco(double desconto) { 
        return preco - (preco * desconto / 100);
    }

    public String getDados() {
        return "Produto: " + nome + " | Preco: R$" + preco + " | Estoque: " + estoque;
    }
}