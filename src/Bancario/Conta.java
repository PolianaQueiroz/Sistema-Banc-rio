package Bancario;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Random;

public class Conta {
	
	private int numeroConta;
	private float saldo = 0.0f;
	private boolean status;
	//CpfConta irá receber o cpf do cliente sendo assim criará um vinculo com o cliente
	private String cpfConta;
	//ArrayList conta sendo criado
	public static ArrayList<Conta> contasCadastradas = new ArrayList<>();
	
	//Metodo para associar conta recebendo dois objetos
	public static void associarConta(Conta conta, Cliente cliente) {
		//Verificando se o cliente existe e atribuindo a tempCliente
		Cliente tempCliente = Cliente.localizarCpf(cliente.getCpf());
		//Verificando se o conta existe e atribuindo a tempConta
		Conta tempConta = localizarConta(conta.getNumeroConta());
		//Condicional para saber se ambas são diferentes de null
		if(tempCliente != null && tempConta != null) {
			//O cpf da conta localizada vai receber o cpf do cliente localizado
			tempConta.setcpfConta(tempCliente.getCpf());
			//Status da conta passa a ser true, ou seja, ela agora está ativa!
			tempConta.setStatus(true);
		}
		
	}
	//Construtor padrão para criar conta
	public Conta() {
		this.status = false;
		Random random = new Random();
		this.numeroConta = random.nextInt(100000000);
	}
	//Metodo para adicionar conta no ArrayList
	public static void adicionarConta(Conta conta) {
		contasCadastradas.add(conta);
	}
	
	//Metodo para retornar o valor do cpf da conta
	public String getCpfConta() {
		return this.cpfConta;
	}
	//Metodo para modificar o valor do cpf da conta
	public void setcpfConta(String cpf) {
		this.cpfConta = cpf;
	}
	//Metodo para retornar o valor do saldo da conta
	public float getSaldo() {
		return this.saldo;
	}
	//Metodo para modificar o valor do saldo da conta
	public void setSaldo( float saldo) {
		this.saldo = saldo;
	}
	//Metodo para retornar o valor do status da conta
	public boolean getStatus() {
		return this.status;
	}
	//Metodo para modificar o valor do Status da conta
	public void setStatus(boolean condicao) {
		this.status = condicao;
	}
	//Metodo para retornar o valor do numero da conta
	public int getNumeroConta() {
		return this.numeroConta;
	}
	
	
	
	public int hashCode() {
		return Objects.hash(cpfConta, numeroConta, status);
	}


	
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Conta other = (Conta) obj;
		return Objects.equals(cpfConta, other.cpfConta) && numeroConta == other.numeroConta && status == other.status;
	}
	
	public String toString() {
		return "\nO Saldo da conta é: " + this.getSaldo() +
			   "\nO número da conta é: " + this.getNumeroConta() +
			   "\nO Status da conta é: " + this.getStatus() +
			   "\nO CPF associado a conta é: " + this.getCpfConta() + 
			   "\n";
	}

	public int numeroConta() {
		return this.numeroConta;
	}
	//Metodo para localizar conta
	public static Conta localizarConta(int numeroConta) {
	    //temp do tipo conta recebe null
		Conta temp = null;
	    //Verificando se há algum item na lista
		if(contasCadastradas.size() > 0){
			//Foreach iterando por contasCadastradas
			for(Conta conta: contasCadastradas) {
				//Se o numero da conta for igual a o numero recebido no metodo então a conta existe no ArrayList e temp recebe a conta localizada
				if(conta.getNumeroConta() == numeroConta) {
					temp = conta;
				}
			}
		}
		//temp pode retornar null ou a conta localizada
		return temp;
	}
	
	//Metodo depositar recebe um valor de deposito e um numero para verificar a existência da conta
	public void depositar(float valor, int numero) {
		//Verificando a existência da conta
		Conta temp = localizarConta(numero);
		//Se temp for diferente de null então a conta existe
		if(temp != null) {
			//Verificando se o status da conta encontrada é igual a true, e se o valor do deposito é maior que zero
			if(temp.getStatus() == true && valor > 0.0) {
				//Metodo setSaldo sendo chamado para alterar o valor de saldo, e getSaldo retornando o valor do saldo atual e somando com o valor do deposito
				temp.setSaldo(temp.getSaldo() + valor);
				System.out.println("Depósito realizado com sucesso!");
			}//Caso o valor do deposito n seja maior que zero
			else {System.err.println("Valor do depósito incorreto!!");}
			
		}//Caso a conta não exista
		else {System.err.println("Conta não existe!!");}
	 }
	//Metodo sacar valor recebe um valor de saque e um numero para verificar se a conta existe
	public void sacar(float valor, int numero) {
		//verificando através do metodo localizarConta se aconta existe ou não
		Conta temp = localizarConta(numero);
		//Se temp for diferente de null, então a conta existe
		if(temp != null) {
			//Verificando se status é igual a true e se o valor do saque é maior que zero e o valor do saque é menor igual ao saldo atual
			if(temp.getStatus() == true && valor > 0.0 && valor <= temp.getSaldo()) {
				temp.setSaldo(temp.getSaldo() - valor);
				System.out.println("Saque realizado com sucesso!");
			}//Se o valor do saque não for maior que zero nem menor igual ao saldo atual
			else {System.out.println("Valor de saque incorreto!!");}
			
		}//Caso a conta não for localizada
		else {System.err.println("Conta não existe!!");}
	 }
	 
	//Removendo conta recebe o numero da conta
	public static void removerConta(int numeroConta) {
		//Verificando se a conta existe
		Conta conta = localizarConta(numeroConta);
		//Verificando se a lista tem alguma conta e se a conta é diferente de null, ou seja, se ela existe
		if(contasCadastradas.size() > 0 && conta != null) {
			//Removendo a conta que foi localizada
			contasCadastradas.remove(conta);
			System.out.println("Conta removida com sucesso!");
			
		}//Caso a lista esteja vazia ou a conta não exista
		else {System.err.println("Não há contas na lista para remover ou a conta não existe!");}
	}
	
	//Listar todas as contas 
	public static void listarTodasAsContas() {
		//Verificando se o ArrayList é maior que zero, ou seja, se ele não está vazio
		if(contasCadastradas.size() > 0) {
			//Foreach iterando pelo arrayList e retornando com todas as contas
			for(Conta conta: contasCadastradas) {
				System.out.println(conta);
			}
		}//Caso a lista esteja vazia
		else {System.err.println("Não há contas na lista!!");}
	}
	
	//Consultando saldo de uma conta especifica
	public static void consultarSaldo(int numeroConta) {
		//Localizando e recebendo a conta especifica
		Conta temp = localizarConta(numeroConta);
		//Se temp for diferente de null, então a conta existe e se o status da mesma for diferente de false então o saldo pode ser consultado
		if(temp != null && temp.getStatus() != false) {
			System.out.println("A conta de número: " + temp.getNumeroConta());
			System.out.println("Tem o saldo de: " + temp.getSaldo() );
			
		}//Caso o if não ocorra a conta não existe ou se encontra sem vindulo com algum cliente
		else {System.err.println("Conta não existe ou se encontra inativa!!");}
	}
	
	//Retornando contas de um cliente especifico, retornarContasCliente recebe uma string numero para verificar a existência do cliente
	public static void retornarContasCliente(String numero) {
		//cliente recebe null caso não exista ou recebe o cliente localizado
		 Cliente cliente = Cliente.localizarCpf(numero);
		 //Se cliente for diferente de null, então ele existe 
		 if(cliente != null ) {
			 System.out.println("As contas cadastradas do cliente: " + cliente.getNome() + " são: ");
			 //Laço forReach iterando pelas contasCadastradas
			 for(Conta conta: contasCadastradas) {
				 //Se o cpf vinculado a conta for diferente de null e igual ao numero recebido, todas as contas existentes vinculadas ao cliente serão apresentadas
				 if(conta.getCpfConta() != null && conta.getCpfConta().equals(numero)) { 
	                  System.out.println(conta);
				 }else {System.err.println("Não há contas associadas a esse cliente");}
			 }
		 }else {System.err.println("Esse Cliente não existe!");}
		
	 }
     //Metodo para remover multiplas contas, que será chamado quando for remover algum cliente especifico na class Cliente
	 public static void removerMultiplasContas(Cliente cliente) {
		// função removeIf é usada para ir buscando e removendo todas as contas que receberam o mesmo cpf de cliente
		contasCadastradas.removeIf(Conta -> Conta.getCpfConta() == cliente.getCpf() );
	 }
}
