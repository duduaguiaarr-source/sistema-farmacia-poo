# 💊 Sistema de Gestão para Farmácias - POO em Java

Este projeto é um sistema de gerenciamento de farmácia desenvolvido 100% em **Java puro**. O foco principal deste projeto é a aplicação prática e rigorosa dos pilares da **Orientação a Objetos (POO)**, sem o uso de interfaces gráficas ou bancos de dados externos, priorizando a lógica de programação, arquitetura de software e estruturação de dados em memória.

## 🚀 Funcionalidades

O sistema funciona via terminal (CLI) e possui um menu interativo que permite:
- Cadastrar Clientes, Funcionários e Produtos.
- Realizar Vendas (com validação de estoque e vínculo de entidades).
- Listar todos os cadastros e o histórico de vendas realizadas.

## 🧠 Conceitos Técnicos Aplicados

O projeto foi estruturado separando estritamente **Classes de Entidade** (armazenamento de dados) de **Classes de Controle** (regras de negócio e I/O). Os seguintes conceitos de POO foram implementados:

* **Encapsulamento:** Proteção de dados com atributos `private` e manipulação exclusiva via métodos `getters` e `setters`.
* **Herança:** Criação de uma superclasse `Pessoa` que herda suas características para as subclasses `Cliente`, `Funcionario` e `Fornecedor`.
* **Polimorfismo:**
  * **Sobrescrita (Override):** Personalização do método `getDados()` nas classes filhas.
  * **Sobrecarga (Overload):** Variações do método `calcularPreco()` na classe `Produto`.
* **Tratamento de Exceções:** Criação de exceções de negócio personalizadas (`EstoqueException` e `VendaException`) para tratamento robusto de erros.
* **Interfaces:** Uso da interface `Operacoes` para definir o contrato de métodos da classe de controle.
* **Reflexividade:** Navegação estruturada entre objetos (ex: `venda.getProduto().setEstoque()`).

## 📂 Estrutura do Projeto

O sistema é composto pelas seguintes classes e interfaces:

- **Entidades:** `Pessoa`, `Cliente`, `Funcionario`, `Fornecedor`, `Produto`, `Venda`.
- **Controle & Dados:** `FarmaciaControle`, `Dados` (Banco de dados em memória via `ArrayList`), `Operacoes` (Interface).
- **Auxiliares:** `Leitura` (Tratamento de inputs do usuário via `Scanner`), `EstoqueException`, `VendaException`.
- **Main:** `Principal` (Ponto de entrada do sistema).

## 💻 Como Executar

1. Certifique-se de ter o [Java JDK](https://www.oracle.com/java/technologies/downloads/) instalado em sua máquina.
2. Clone este repositório:
   ```bash
   git clone [https://github.com/SEU-USUARIO/nome-do-repositorio.git](https://github.com/SEU-USUARIO/nome-do-repositorio.git)