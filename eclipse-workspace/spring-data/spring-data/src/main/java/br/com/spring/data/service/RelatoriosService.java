package br.com.spring.data.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

import org.springframework.stereotype.Service;

import br.com.spring.data.orm.Funcionario;
import br.com.spring.data.orm.FuncionarioProjecao;
import br.com.spring.data.repository.FuncionarioRepository;
	
@Service
public class RelatoriosService {
	private final FuncionarioRepository funcionarioRepository;
	private Boolean system = true;
	private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy"); //como ele deve escrever 

	public RelatoriosService(FuncionarioRepository funcionarioRepository) {
		this.funcionarioRepository = funcionarioRepository;
	}


	public void inicial(Scanner scanner) {
		while (system) {
			System.out.println("Qual acao voce quer executar");
			System.out.println("0 - Sair");
			System.out.println("1 - Busca Funcionario por nome");
			System.out.println("2 - Busca Funcionario por nome, data contratacao e salario maior");
			System.out.println("3 - Busca Funcionario por data contratacao");
			System.out.println("4 - Pesquisa Funcionario Salario");

			int action = scanner.nextInt();

			switch (action) {
			case 1:
				buscaFuncionarioNome(scanner);
				break;
			case 2:
				buscaFuncionarioNomeSalarioMaiorData(scanner);
				break;	
			case 3:
				buscaFuncionarioDataContratacao(scanner);
				break;	
			case 4:
				pesquisafuncionarioSalario();
				break;					
			default:
				system = false;
			}

		}

	}

	private void buscaFuncionarioNome(Scanner scanner) {
		System.out.println("Qual nome deseja pesquisar?");
		String nome = scanner.next();
		
		List<Funcionario> listFuncionarios = funcionarioRepository.findByNome(nome);
		listFuncionarios.forEach(System.out::println);
	}
	
	
	private void buscaFuncionarioNomeSalarioMaiorData(Scanner scanner) {
		System.out.println("Qual nome deseja pesquisar?");
		String nome = scanner.next();
		
		System.out.println("Qual data contratacao deseja pesquisar?");
		String data = scanner.next();
		LocalDate localDate = LocalDate.parse(data, formatter);
		
		
		System.out.println("Qual salario deseja pesquisar?");
		Double salario = scanner.nextDouble();
		
		List<Funcionario> listFuncionarios = funcionarioRepository.
				findNomeSalarioMaiorDataContratacao(nome, salario, localDate);
		listFuncionarios.forEach(System.out::println);		
		
	}	

	private void buscaFuncionarioDataContratacao(Scanner scanner) {

		System.out.println("Qual data contratacao deseja pesquisar?");
		String data = scanner.next();
		LocalDate localDate = LocalDate.parse(data, formatter);
		
		List<Funcionario> listFuncionarios = funcionarioRepository.
				findDataContratacaoMaior(localDate);
		listFuncionarios.forEach(System.out::println);			
	}

	private void pesquisafuncionarioSalario() {
		List<FuncionarioProjecao> list = funcionarioRepository.findFuncionarioSalario();
		list.forEach(f -> System.out.println("Funcionario: id: " + f.getId() 
		+ " | nome: " + f.getNome() + " | salario: " + f.getSalario()));
		
	}	
	
	
}
