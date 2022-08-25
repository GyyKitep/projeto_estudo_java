package br.com.spring.data.service;

import java.util.Scanner;

import org.springframework.stereotype.Service;

import br.com.spring.data.orm.Cargo;
import br.com.spring.data.repository.CargoRepository;

@Service
public class CrudCargoService {
	private final CargoRepository cargoRepository;
	private Boolean system = true;

	public CrudCargoService(CargoRepository cargoRepository) {
		this.cargoRepository = cargoRepository;
	}

	public void inicial(Scanner scanner) {
		while (system) {
			System.out.println("Qual acao voce quer executar");
			System.out.println("0 - Sair");
			System.out.println("1 - Inserir Cargo");
			System.out.println("2 - Alterar Cargo");
			System.out.println("3 - Visualizar Cargos");
			System.out.println("4 - Excluir Cargo");

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
		System.out.println("Descricao do Cargo");
		String descricao = scanner.next();
		Cargo cargo = new Cargo();
		cargo.setDescricao(descricao);
		cargoRepository.save(cargo);
		System.out.println("Inserido Cargo");

	}

	private void atualizar(Scanner scanner) {
		System.out.println("Id do Cargo");
		int id = scanner.nextInt();
		System.out.println("Descricao do Cargo");
		String descricao = scanner.next();

		Cargo cargo = new Cargo();
		cargo.setId(id);
		cargo.setDescricao(descricao);

		cargoRepository.save(cargo);
		System.out.println("Alterado Cargo");

	}
	
	private void visualizar() {
		Iterable<Cargo> cargos = cargoRepository.findAll();
		cargos.forEach(cargo -> System.out.println(cargo));
	}
	
	private void deletar(Scanner scanner) {
		System.out.println("Id do Cargo");
		int id = scanner.nextInt();
		cargoRepository.deleteById(id);	
		System.out.println("Excluir Cargo");

	}
	
}
