package br.com.spring.data.service;

import java.util.Scanner;

import org.springframework.stereotype.Service;

import br.com.spring.data.orm.UnidadeTrabalho;
import br.com.spring.data.repository.UnidadeTrabalhoRepository;

@Service
public class CrudUnidadeTrabalhoService {
	private final UnidadeTrabalhoRepository unidadeTrabalhoRepository;
	private Boolean system = true;

	public CrudUnidadeTrabalhoService(UnidadeTrabalhoRepository unidadeTrabalhoRepository) {
		this.unidadeTrabalhoRepository = unidadeTrabalhoRepository;
	}

	public void inicial(Scanner scanner) {
		while (system) {
			System.out.println("Qual acao voce quer executar");
			System.out.println("0 - Sair");
			System.out.println("1 - Inserir Unidade Trabalho");
			System.out.println("2 - Alterar Unidade Trabalho");
			System.out.println("3 - Visualizar Unidade Trabalho");
			System.out.println("4 - Excluir Unidade Trabalho");

			int action = scanner.nextInt();

			switch (action) {
			case 1:
				salvar(scanner);
				break;
			case 2:
				atualizar(scanner);
				break;
			case 3:
				visualizar();
				break;
			case 4:
				deletar(scanner);
				break;
			default:
				system = false;
			}

		}

	}

	private void salvar(Scanner scanner) {
		System.out.println("Nome da Unidade");
		String nome = scanner.next();
		
		System.out.println("Digite o endereco");
		String endereco = scanner.next();
		
		UnidadeTrabalho unidadeTrabalho = new UnidadeTrabalho();
		unidadeTrabalho.setDescricao(nome);
		unidadeTrabalho.setEndereco(endereco);
		
		unidadeTrabalhoRepository.save(unidadeTrabalho);
		
		System.out.println("Inserido Unidade Trabalho");

	}

	private void atualizar(Scanner scanner) {
		System.out.println("Id da Unidade");
		int id = scanner.nextInt();
		
		System.out.println("Nome da Unidade");
		String nome = scanner.next();
		
		System.out.println("Endereco da unidade");
		String endereco = scanner.next();

		
		UnidadeTrabalho unidadeTrabalho = new UnidadeTrabalho();
		unidadeTrabalho.setDescricao(nome);
		unidadeTrabalho.setEndereco(endereco);
		
		unidadeTrabalhoRepository.save(unidadeTrabalho);
		
		System.out.println("Alterado Unidade Trabalho");

	}
	
	private void visualizar() {
		Iterable<UnidadeTrabalho> unidadeTrabalho = unidadeTrabalhoRepository.findAll();
		unidadeTrabalho.forEach(t -> System.out.println(t));
	}
	
	private void deletar(Scanner scanner) {
		System.out.println("Id do Cargo");
		int id = scanner.nextInt();
		unidadeTrabalhoRepository.deleteById(id);	
		System.out.println("Excluir Cargo");

	}
	
}
