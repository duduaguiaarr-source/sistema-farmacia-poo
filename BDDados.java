//Eduardo de Oliveira Aguiar - RA: 2706954
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class BDDados {
    private List<Cliente> listaClientes;
    private List<Produto> listaProdutos;
    private List<Funcionario> listaFuncionarios;
    private List<Fornecedor> listaFornecedores;
    private List<Venda> listaVendas;

    private static BDDados bdInstance;

    private BDDados() {
        listaClientes = new ArrayList<>();
        listaProdutos = new ArrayList<>();
        listaFuncionarios = new ArrayList<>();
        listaFornecedores = new ArrayList<>();
        listaVendas = new ArrayList<>();
    }

    // MÉTODO SINGLETON
    public static BDDados geraBD() {
        if (bdInstance == null) {
            bdInstance = new BDDados();
        }
        return bdInstance;
    }

    public Cliente consClienteCpf(String cpf) {
        String cpfLimpoBusca = cpf.replaceAll("[^0-9]", "");
        for (Cliente c : listaClientes) {
            String cpfLimpoLista = c.getCpf().replaceAll("[^0-9]", "");
            if (cpfLimpoLista.equals(cpfLimpoBusca)) return c;
        }
        return null;
    }
    public Cliente insCliente(Cliente c) {
        if (consClienteCpf(c.getCpf()) == null) {
            listaClientes.add(c);
            return c;
        }
        return null;
    }
    public Cliente altCliente(Cliente cNovo) {
        for (int i = 0; i < listaClientes.size(); i++) {
            if (listaClientes.get(i).getCpf().equals(cNovo.getCpf())) {
                String novoNome = JOptionPane.showInputDialog(null, "Novo Nome:", "Atualizar", JOptionPane.QUESTION_MESSAGE);
                String novoEnd = JOptionPane.showInputDialog(null, "Novo Endereço:", "Atualizar", JOptionPane.QUESTION_MESSAGE);
                String novoTel = JOptionPane.showInputDialog(null, "Novo Telefone:", "Atualizar", JOptionPane.QUESTION_MESSAGE);
                if(novoNome != null) listaClientes.get(i).setNome(novoNome);
                if(novoEnd != null) listaClientes.get(i).setEndereco(novoEnd);
                if(novoTel != null) listaClientes.get(i).setTelefone(novoTel);
                return listaClientes.get(i);
            }
        }
        return null;
    }
    public Cliente delCliente(String cpf) {
        Cliente c = consClienteCpf(cpf);
        if (c != null) {
            listaClientes.remove(c);
            return c;
        }
        return null;
    }
    public List<Cliente> getListaClientes() { return listaClientes; }

    public Produto consProdutoNome(String nome) {
        for (Produto p : listaProdutos) {
            if (p.getNome().equalsIgnoreCase(nome)) return p;
        }
        return null;
    }
    public Produto insProduto(Produto p) {
        if (consProdutoNome(p.getNome()) == null) {
            listaProdutos.add(p);
            return p;
        }
        return null;
    }
    public Produto altProduto(Produto pNovo) {
        for (int i = 0; i < listaProdutos.size(); i++) {
            if (listaProdutos.get(i).getNome().equalsIgnoreCase(pNovo.getNome())) {
                
                String novoPreco = JOptionPane.showInputDialog(null, "Novo Preço:", "Atualizar", JOptionPane.QUESTION_MESSAGE);
                String novoEst = JOptionPane.showInputDialog(null, "Novo Estoque:", "Atualizar", JOptionPane.QUESTION_MESSAGE);

                try {
                    if(novoPreco != null) {
                        String precoLimpo = novoPreco.replace(",", ".");
                        if(precoLimpo.trim().isEmpty()) precoLimpo = "0";
                        
                        listaProdutos.get(i).setPreco(Double.parseDouble(precoLimpo));
                    }

                    if(novoEst != null) {
                        String estLimpo = novoEst.trim();
                        if(estLimpo.isEmpty()) estLimpo = "0";
                        listaProdutos.get(i).setEstoque(Integer.parseInt(estLimpo));
                    }
                    
                } catch(Exception e) {
                    JOptionPane.showMessageDialog(null, "Valor inválido! Use apenas números.");
                }
                
                return listaProdutos.get(i);
            }
        }
        return null;
    }
    public Produto delProduto(String nome) {
        Produto p = consProdutoNome(nome);
        if (p != null) {
            listaProdutos.remove(p);
            return p;
        }
        return null;
    }
    public List<Produto> getListaProdutos() { return listaProdutos; }

    public Funcionario consFuncNome(String nome) {
        for (Funcionario f : listaFuncionarios) {
            if (f.getNome().equalsIgnoreCase(nome)) return f;
        }
        return null;
    }
    public Funcionario insFunc(Funcionario f) {
        if (consFuncNome(f.getNome()) == null) {
            listaFuncionarios.add(f);
            return f;
        }
        return null;
    }
    public Funcionario altFunc(Funcionario fNovo) {
        for (int i = 0; i < listaFuncionarios.size(); i++) {
            if (listaFuncionarios.get(i).getNome().equalsIgnoreCase(fNovo.getNome())) {

                String novoTel = JOptionPane.showInputDialog(null, "Novo Telefone:", "Atualizar", JOptionPane.QUESTION_MESSAGE);
                String novoEmail = JOptionPane.showInputDialog(null, "Novo Email:", "Atualizar", JOptionPane.QUESTION_MESSAGE);
                String novoCargo = JOptionPane.showInputDialog(null, "Novo Cargo:", "Atualizar", JOptionPane.QUESTION_MESSAGE);
                String novoSal = JOptionPane.showInputDialog(null, "Novo Salário:", "Atualizar", JOptionPane.QUESTION_MESSAGE);

                try {
                    if(novoTel != null) listaFuncionarios.get(i).setTelefone(novoTel);
                    if(novoEmail != null) listaFuncionarios.get(i).setEmail(novoEmail);
                    if(novoCargo != null) listaFuncionarios.get(i).setCargo(novoCargo);
                    
                    if(novoSal != null) {
                        String salLimpo = novoSal.replace(",", ".");
                        listaFuncionarios.get(i).setSalario(Double.parseDouble(salLimpo));
                    }
                } catch(Exception e){ 
                    JOptionPane.showMessageDialog(null, "Valor inválido! Alteração cancelada."); 
                }
                return listaFuncionarios.get(i);
            }
        }
        return null;
    }
    public Funcionario delFunc(String nome) {
        Funcionario f = consFuncNome(nome);
        if (f != null) {
            listaFuncionarios.remove(f);
            return f;
        }
        return null;
    }
    public List<Funcionario> getListaFuncionarios() { return listaFuncionarios; }

    public Fornecedor consFornCnpj(String cnpj) {
        String cnpjBusca = cnpj.replaceAll("[^0-9]", "");
        for (Fornecedor f : listaFornecedores) {
            String cnpjLista = f.getCnpj().replaceAll("[^0-9]", "");
            if (cnpjLista.equals(cnpjBusca)) return f;
        }
        return null;
    }
    public Fornecedor insForn(Fornecedor f) {
        if (consFornCnpj(f.getCnpj()) == null) {
            listaFornecedores.add(f);
            return f;
        }
        return null;
    }
    public Fornecedor altForn(Fornecedor fNovo) {
        for (int i = 0; i < listaFornecedores.size(); i++) {
            if (listaFornecedores.get(i).getCnpj().equals(fNovo.getCnpj())) {
                
                String novaEmpresa = JOptionPane.showInputDialog(null, "Nova Empresa:", "Atualizar", JOptionPane.QUESTION_MESSAGE);
                String novoTel = JOptionPane.showInputDialog(null, "Novo Telefone:", "Atualizar", JOptionPane.QUESTION_MESSAGE);
                String novoEmail = JOptionPane.showInputDialog(null, "Novo Email:", "Atualizar", JOptionPane.QUESTION_MESSAGE);
                
                if(novaEmpresa != null) listaFornecedores.get(i).setNomeEmpresa(novaEmpresa);
                if(novoTel != null) listaFornecedores.get(i).setTelefone(novoTel);
                if(novoEmail != null) listaFornecedores.get(i).setEmail(novoEmail);
                
                return listaFornecedores.get(i);
            }
        }
        return null;
    }
    public Fornecedor delForn(String cnpj) {
        Fornecedor f = consFornCnpj(cnpj);
        if (f != null) {
            listaFornecedores.remove(f);
            return f;
        }
        return null;
    }
    public List<Fornecedor> getListaFornecedores() { return listaFornecedores; }

public void addVenda(Venda v) throws EstoqueException, VendaException {

    if (v.getQuantidade() <= 0) {
        throw new VendaException("A quantidade deve ser maior que zero!");
    }

    if (v.getProduto().getEstoque() < v.getQuantidade()) {
        throw new EstoqueException("Estoque insuficiente! Disponível: " + v.getProduto().getEstoque());
    }

    listaVendas.add(v);
    v.getProduto().setEstoque(v.getProduto().getEstoque() - v.getQuantidade()); //Reflexividade
}
    public List<Venda> getListaVendas(){ return listaVendas; }

    public Venda consVendaPorCliente(String cpfCli) {
        for (Venda v : listaVendas) {
            if (v.getCliente().getCpf().equals(cpfCli)) {
                return v;
            }
        }
        return null;
    }
    public Venda delVenda(String cpfCli) {
        Venda v = consVendaPorCliente(cpfCli);
        if (v != null) {
            v.getProduto().setEstoque(v.getProduto().getEstoque() + v.getQuantidade()); //Reflexividade
            listaVendas.remove(v);
            return v;
        }
        return null;
    }
}