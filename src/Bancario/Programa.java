package Bancario;

import java.util.Scanner;

public class Programa {
	//Scanner será usado para receber a entrada de dados do usuário
	public static Scanner entrada = new Scanner(System.in);
	
	public static void main(String[] args) {
		 
		
		//Metodo que recebe o Switch sendo chamado dentro do main
		PainelOpcoes();
		

	}
	//Inicio do painel de opcoes do Switch
	public static void PainelOpcoes() {
		//Apresentando no console todas as opcoes disponiveis
		System.out.println("---------------------------------");
		System.out.println("Digite a opção que você deseja:  ");
		System.out.println("Opcão 1 - Criar Cliente          ");
		System.out.println("Opcão 2 - Listar Clientes        ");
		System.out.println("Opcão 3 - Remover cliente        ");
		System.out.println("Opcão 4 - Consultar por CPF      ");
		System.out.println("Opcão 5 - Criar conta            ");
		System.out.println("Opcão 6 - Listar contas          ");
		System.out.println("Opcão 7 - Efetuar Depósito       ");
		System.out.println("Opcão 8 - Efetuar Saque          ");
		System.out.println("Opcão 9 - Verificar saldo        ");
		System.out.println("Opcão 10 - Associar contas       ");
		System.out.println("Opcão 11 - Retornar contas       ");
		System.out.println("Opcão 12 - Remover conta         ");
		System.out.println("Opcão 13 - Sair                  ");
		
		System.out.println("---------------------------------");
		//entrada de dados para o Switch
		 int opcoes = entrada.nextInt();
		 
		 switch(opcoes) {
		 case 1:
			 
			 System.out.println("Digite o nome do cliente: ");
			 //Recebendo nome do cliente
			 String nome = entrada.next();
			 System.out.println("Digite o CPF do cliente: ");
			 //Recebendo cpf do cliente
			 String cpf = entrada.next();
			 System.out.println("Digite o Email do cliente");
			 //Recebendo email do cliente
			 String email = entrada.next();
			 //Verificando se cliente já se encontra na lista, fazendo busca através do cpf
			 Cliente clienteVerificar = Cliente.localizarCpf(cpf);
			 // Se clienteVerificar for igual a null significa que está sendo inserido um novo cliente, 1e não um já cadastrado
			 if(clienteVerificar == null) {
				 //Criando o objeto do tipo cliente
				 Cliente cliente = new Cliente(nome,cpf,email);
				 //Chamando o metodo adicionar para inserir o novo cliente no ArrayList
				 Cliente.adicionarCliente(cliente);
			 }else {System.err.println("Cliente já existe na lista!");}
			 //Chamando novamente o painel de opcôes
			PainelOpcoes();
			 break;
			 
		  case 2:
			  //Chamando o metodo listarClientes de dentro da classe cliente para apresentar todos os clientes cadastrados até o momento
			  Cliente.listarClientes();
			  //Chamando novamente o painel de opcões
			  PainelOpcoes();
			  break;
		  case 3:
			  System.out.println("Digite o CPF do cliente que você deseja remover: ");
			  //Recebendo o cpf do cliente para encontra-lo e remove-lo
			  String cpfRemover = entrada.next();
			  //Removendo cliente encontrado
			  Cliente.removerCliente(cpfRemover);
			  //Chamando novamente o painel de opcões
			  PainelOpcoes();
			  break;
		  case 4:
			  System.out.println("Digite o CPF do cliente que você deseja consultar: ");
			  String cpfConsulta = entrada.next();
			  //Buscando cliente através do cpf pelo metodo dentro da class Cliente consultarClientePorCpf
			  Cliente.consultarClientePorCpf(cpfConsulta);
			  //Chamando novamente o painel de opcões
			  PainelOpcoes();
			  break;
			  
		  case 5:
			  //Criando uma nova conta sem associação nenhuma
			  Conta conta = new Conta();
			  //Chamando o metodo adicionar conta para adiciona-la dentro do arrayList
			  Conta.adicionarConta(conta);
			  System.out.println("Conta criada!!");
			  //Chamando novamente o painel de opcões
			  PainelOpcoes();
			  break;
			  
		  case 6:
			  //Chamando o metodo listarToasAsContas de dentro da class Conta
			  Conta.listarTodasAsContas();
			  //Chamando novamente o painel de opcões
			  PainelOpcoes();
			  break;
		  case 7:
			  System.out.println("Digite o valor do depósito: ");
			  //Recebendo o valor do depósito
			  float valorDeposito = entrada.nextFloat();
			  System.out.println("Número da conta para o depósito: ");
			  //Recebendo o numero da conta que será feito o depósito
			  int numeroContaDeposito = entrada.nextInt();
			  //instanciando um objeto tempDeposito para chamar o metodo depositar
			  Conta tempDeposito = new Conta();
			  //Realizando o depósito através do metodo depositar que está na class Conta
			  tempDeposito.depositar(valorDeposito, numeroContaDeposito);
			  //Chamando novamente o painel de opcões
			  PainelOpcoes();
			  break;
		  case 8:
			  System.out.println("Digite o valor do saque: ");
			  //Recebendo o valor do saque
			  float valorSaque = entrada.nextFloat();
			  System.out.println("Número da conta para o saque: ");
			  //Recebendo o numero da conta que será feito o saque
			  int numeroContaSaque = entrada.nextInt();
			  //instanciando um objeto tempSaque para chamar o metodo sacar
			  Conta tempSaque = new Conta();
			  //Realizando o saque
			  tempSaque.sacar(valorSaque, numeroContaSaque);
			  //Chamando novamente o painel de opcões
			  PainelOpcoes();
			  break;
		  case 9:
			  System.out.println("Digite o número da conta que você deseja saber o saldo: ");
			  //Recebendo o numero da conta para localizar
			  int numeroVerificarSaldo = entrada.nextInt();
			  //Consultando saldo através do metodo ConsultarSaldo que se encontra dentro da class Conta
			  Conta.consultarSaldo(numeroVerificarSaldo);
			  //Chamando novamente o painel de opções
			  PainelOpcoes();
			  break;
		  case 10:
			  System.out.println("Digite o número do CPF do cliente que você deseja associar: ");
			  //Recebendo o cpf do cliente
			  String cpfCliente = entrada.next();
			  System.out.println("Digite o número da conta que você deseja associar ao cliente: ");
			  //Recebendo o numero da conta
			  int numeroContaAssociar = entrada.nextInt();
			  //Localizando e recebendo a conta que precisa ser associada
			  Conta tempContaAssociar = Conta.localizarConta(numeroContaAssociar);
			  //Localizando e recebendo o cliente que será associado a conta
			  Cliente tempClienteAssociar = Cliente.localizarCpf(cpfCliente);
			  //Verificando se conta e cliente existem para efetuar a associação 
			  if(tempContaAssociar != null && tempClienteAssociar != null) {
				  //Metodo associar recebe os dois objetos do tipo Cliente e Conta para fazer a associação
				  Conta.associarConta(tempContaAssociar, tempClienteAssociar);
				  System.out.println("Conta associada com sucesso!");
			  }else{System.err.println("Cliente ou conta não existe!!");}
			  //Chamando novamente o painel de opções
			  PainelOpcoes();
			  break;
		  case 11:
			  System.out.println("Digite o CPF do cliente para listarmos as contas existentes: ");
			  //Recebendo o cpf do cliente
			  String cpfListar = entrada.next();
			  //Retornando todas as contas associadas ao cliente especifico
			  Conta.retornarContasCliente(cpfListar);
			  //Chamando novamente o painel de opções 
			  PainelOpcoes();
			  break;
		  
		  case 12:
			  System.out.println("Digite o número da conta que você deseja remover: ");
			  //Recebendo o numero da conta para removê-la
			  int numeroContaRemocao = entrada.nextInt();
			  //Conta sendo removida
			  Conta.removerConta(numeroContaRemocao);
			  //Chamando novamente o painel de opções 
			  PainelOpcoes();
			  break;
		  case 13:
			  //Opção para finalizar o programa!
			  System.out.println("Obrigado!!!");
			  System.exit(0);
			  break;
		default:
			//Caso algum número seja digitado de forma incorreta
			System.err.println("Digito inválido");
		 }
	}
	

}
