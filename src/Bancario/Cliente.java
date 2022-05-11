package Bancario;
import java.util.ArrayList;
import java.util.Objects;
public class Cliente {
	
	private String cpf;
	private String email;
	private String nome;
	//ArrayList de cliente sendo criado
	public static ArrayList<Cliente> clientesCadastrados = new ArrayList<>();
	//Construtor padrão 
	Cliente(){
		
	}
	//Construtor que recebe nome,cpf,email para instanciar um objeto
	Cliente(String nome, String cpf, String email){
		this.nome = nome;
		this.email = email;
		this.cpf = cpf;
	}
	//Adicionando o objeto a lista de clientesCadastrados
	public static void adicionarCliente(Cliente cliente) {
			clientesCadastrados.add(cliente);

	}
	//Localizando o cpf dentro da lista de clientesCadastrados, recebendo um número do tipo string para verificar se o cpf existe na lista de ClientesCadastrados 
	public static Cliente localizarCpf( String numeroCpf) {
		//Objeto temp recebe null
		Cliente temp = null;
		//Verificando se há algum elemento na lista
		if(clientesCadastrados.size() > 0) {
			// Laço forech, variavel c do tipo cliente está iterando por clientesCadastrados.
			for(Cliente c : clientesCadastrados) {
				//Compando o cpf dentro da lista com numero recebido, caso seja verdadeiro temp recebe o Cliente com o cpf especificado
				if(c.getCpf().equals(numeroCpf)) {
					temp = c;
				}
			}
		}
		// O retorno pode ser null ou algum cliente
		return temp;
	}
	
	//Metodo para listar os todos clientes
	public static void listarClientes() {
		//Verificando se a lista tem algum cliente
		if(clientesCadastrados.size() > 0) {
			System.out.println("Clientes listados: \n");
			//Laço foreach iternado pela lista de todos os clientes cadastrados e printando todos 
			for(Cliente c: clientesCadastrados) {
				System.out.println(c);
			}
			//Caso a lista esteja vazia
		}else {System.err.println("Não há clientes na lista!!");}
	}
	
	//Metodo para consultar o cliente pelo cpf
	public static void consultarClientePorCpf(String cpf) {
		//Consultar por cpf recebe um cpf do tipo string e utiliza ele para verificar através do metodo de localizar cpf se o cliente existe
		Cliente cliente = localizarCpf(cpf);
		//Se o cliente for diferente de null significa que ele encontrou algum cliente com o cpf especificado
		if(cliente != null) {
			System.out.println("O resultado da sua consulta foi: \n");
			System.out.println(cliente);
		}
		//Caso isso não ocorra o cliente não existe
		else {System.err.println("Cliente não existe!!");}
		
	}
	
	//Remover cliente
	public static void removerCliente(String cpf) {
		//remover cliente recebe um cpf do tipo string e utiliza ele para verificar através do metodo de localizar cpf se o cliente existe
		Cliente cliente = localizarCpf(cpf);
		//Se lista for maior que zero e o cliente for diferente de null
		if(clientesCadastrados.size() > 0 && cliente != null) {
			//Cliente localizado sendo removido
			clientesCadastrados.remove(cliente);
			//Metodo para remover todas as contas associadas ao cliente que está sendo removido
			Conta.removerMultiplasContas(cliente);
			System.out.println("Cliente removido com Sucesso!!");
		}
		//Caso o if não ocorra significa que o cliente n existe ou a lista está vazia.
		else {System.err.println("Não há clientes na lista para remover ou cliente não existe!");}
	}

	public int hashCode() {
		return Objects.hash(cpf);
	}

	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cliente other = (Cliente) obj;
		return Objects.equals(cpf, other.cpf);
	}
	
	//Metodos get para retornar o valor do atributo cpf
	public String getCpf() {
		return this.cpf;
	}
	// Metodo set para modificar o valor do atributo cpf
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	//Metodos get para retornar o valor do atributo nome
	public String getNome() {
		return this.nome;
	}
	// Metodo set para modificar o valor do atributo nome
	public void setNome(String nome) {
		this.nome = nome;
	}
	//Metodos get para retornar o valor do atributo email
	public String getEmail() {
		return this.email;
	}
	// Metodo set para modificar o valor do atributo email
	public void setEmail(String email) {
		this.email = email;
	}
	//Metodo toString vai apresentar todos os atributos no System.out.println de forma legível.
	public String toString() {
		return "O nome do cliente é: " + this.getNome() +
			   "\nO CPF do cliente é: " + this.getCpf() +
			   "\nO Email do cliente é: " + this.getEmail() +
			   "\n";
	}
	
}
