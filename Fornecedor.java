//Eduardo de Oliveira Aguiar - RA: 2706954
public class Fornecedor extends Pessoa {
    private String nomeEmpresa;
    private String cnpj;

    public Fornecedor() {
        super();
        this.nomeEmpresa = "";
        this.cnpj = "";
    }

    public String getNomeEmpresa() { return nomeEmpresa; }
    public void setNomeEmpresa(String nomeEmpresa) { this.nomeEmpresa = nomeEmpresa; }
    public String getCnpj() { return cnpj; }
    public void setCnpj(String cnpj) { this.cnpj = cnpj; }

    //Sobrescrita
    @Override
    public String getDados() { 
        return super.getDados() + " | Empresa: " + nomeEmpresa + " | CNPJ: " + cnpj;
    }
}