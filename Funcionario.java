//Eduardo de Oliveira Aguiar - RA: 2706954
public class Funcionario extends Pessoa {
    private String cargo;
    private double salario;

    public Funcionario() {
        super();
        this.cargo = "";
        this.salario = 0.0;
    }
    //Sobrecarga
    public Funcionario(String nome, String telefone, String email, String cargo, double salario) {
        super(); 
        this.setNome(nome);        
        this.setTelefone(telefone); 
        this.setEmail(email);       
        this.cargo = cargo;
        this.salario = salario;
    }

    public String getCargo() { return cargo; }
    public void setCargo(String cargo) { this.cargo = cargo; }
    public double getSalario() { return salario; }
    public void setSalario(double salario) { this.salario = salario; }

    //Sobrescrita
    @Override
    public String getDados() { 
        return super.getDados() + " | Cargo: " + cargo + " | Salario: R$" + salario;
    }
}