//Eduardo de Oliveira Aguiar - RA: 2706954
public class Cliente extends Pessoa {
    private String cpf;
    private String endereco;

    public Cliente() {
        super();
        this.cpf = "";
        this.endereco = "";
    }
    //Sobrecarga
    public Cliente(String nome, String cpf, String telefone, String endereco) {
        super(); 
        this.setNome(nome); 
        this.setCpf(cpf);            
        this.setTelefone(telefone);  
        this.setEndereco(endereco);
    }

    public String getCpf() { return cpf; }
    public void setCpf(String cpf) { this.cpf = cpf; }
    public String getEndereco() { return endereco; }
    public void setEndereco(String endereco) { this.endereco = endereco; }

    //Sobrescrita
    @Override
    public String getDados() { 
        return super.getDados() + " | CPF: " + cpf + " | Endereco: " + endereco;
    }
}