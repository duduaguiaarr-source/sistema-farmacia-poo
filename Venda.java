//Eduardo de Oliveira Aguiar - RA: 2706954
import java.time.LocalDate;

public class Venda {
    private Produto produto;
    private Cliente cliente;
    private Funcionario funcionario;
    private int quantidade;
    private LocalDate dataVenda;

    public Venda() {
        this.produto = new Produto();
        this.cliente = new Cliente();
        this.funcionario = new Funcionario();
        this.quantidade = 0;
        this.dataVenda = LocalDate.now();
    }

    public Produto getProduto() { return produto; }
    public void setProduto(Produto produto) { this.produto = produto; }
    public Cliente getCliente() { return cliente; }
    public void setCliente(Cliente cliente) { this.cliente = cliente; }
    public Funcionario getFuncionario() { return funcionario; }
    public void setFuncionario(Funcionario funcionario) { this.funcionario = funcionario; }
    public int getQuantidade() { return quantidade; }
    public void setQuantidade(int quantidade) { this.quantidade = quantidade; }
    public LocalDate getDataVenda() { return dataVenda; }
    public void setDataVenda(LocalDate dataVenda) { this.dataVenda = dataVenda; }
    
    public String getDados() {
        return "Venda: " + produto.getNome() + " | Qtd: " + quantidade +
               " | Cliente: " + cliente.getNome() + " | Data: " + dataVenda;
    }
}