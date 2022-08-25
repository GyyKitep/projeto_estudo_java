package br.com.spring.data.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import br.com.spring.data.orm.Cargo;
import br.com.spring.data.orm.Funcionario;
import br.com.spring.data.orm.UnidadeTrabalho;
import br.com.spring.data.repository.CargoRepository;
import br.com.spring.data.repository.FuncionarioRepository;
import br.com.spring.data.repository.UnidadeTrabalhoRepository;

@Service
public class CrudFuncionarioService {

	private final CargoRepository cargoRepository;
	private final FuncionarioRepository funcionarioRepository;
	private final UnidadeTrabalhoRepository unidadeTrabalhoRepository;
	
	private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	private Boolean system = true;

	public CrudFuncionarioService(FuncionarioRepository funcionarioRepository, CargoRepository cargoRepository,
			UnidadeTrabalhoRepository unidadeTrabalhoRepository) {
		this.funcionarioRepository = funcionarioRepository;
		this.cargoRepository = cargoRepository;
		this.unidadeTrabalhoRepository = unidadeTrabalhoRepository;
	}

	public void inicial(Scanner scanner) {
		while (system) {
			System.out.println("Qual acao voce quer executar");
			System.out.println("0 - Sair");
			System.out.println("1 - Inserir Funcionario");
			System.out.println("2 - Alterar Funcionario");
			System.out.println("3 - Visualizar Funcionarios");
			System.out.println("4 - Excluir Funcionario");

			int action = scanner.nextInt();

			switch (action) {
			case 1:
				salvar(scanner);
				break;
			case 2:
				atualizar(scanner);
				break;
			case 3:
				visualizar(scanner);
				break;
			case 4:
				deletar(scanner);
				break;
			default:
				system = false;
				break;
			}

		}

	}

	private void salvar(Scanner scanner) {
		System.out.println("Nome do Funcionario");
		String nome = scanner.next();
		
		System.out.println("CPF do Funcionario");
		String cpf = scanner.next();
		
		System.out.println("Salario do Funcionario");
		Double salario = scanner.nextDouble();
		
		System.out.println("Data Contradacao do Funcionario");
		String dataContratacao = scanner.next();
		
		System.out.println("Id do Cargo");
		Integer idCargo = scanner.nextInt();
		
		Optional<Cargo> cargo = cargoRepository.findById(idCargo);

		List<UnidadeTrabalho> unidades = unidade(scanner);	
		
		
		Funcionario funcionario = new Funcionario();
		funcionario.setNome(nome);
		funcionario.setCpf(cpf);
		funcionario.setSalario(salario);
		funcionario.setDataContratacao(LocalDate.parse(dataContratacao, formatter));
		funcionario.setCargo(cargo.get());
		funcionario.setUnidadeTrabalhos(unidades);
	

		//funcionario.setCargo(cargo.);
		funcionarioRepository.save(funcionario);
		System.out.println("Inserido o Funcionario");

	}
	private List<UnidadeTrabalho> unidade(Scanner scanner){
		Boolean isTrue = true;
		List<UnidadeTrabalho> unidades = new ArrayList<>();
		
		while(isTrue) {
			System.out.println("Digite a unidadeID ( para sair digite 0) ");
			Integer unidadeID = scanner.nextInt();
			
			if(unidadeID != 0) {
				Optional<UnidadeTrabalho> unidade = unidadeTrabalhoRepository.findById(unidadeID);
				unidades.add(unidade.get());
			}else {
				isTrue = false;
			}
		}
		
		return unidades;
	}

	private void atualizar(Scanner scanner) {
		System.out.println("Id do Funcionario");
		int id = scanner.nextInt();
		
		System.out.println("Nome do Funcionario");
		String nome = scanner.next();
		
		System.out.println("CPF do Funcionario");
		String cpf = scanner.next();
		
		System.out.println("Salario do Funcionario");
		Double salario = scanner.nextDouble();
		
		System.out.println("Data Contradacao do Funcionario");
		String dataContratacao = scanner.next();
		
		System.out.println("Id do Cargo");
		Integer idCargo = scanner.nextInt();
		
		Optional<Cargo> cargo = cargoRepository.findById(idCargo);

		List<UnidadeTrabalho> unidades = unidade(scanner);	
		
		
		Funcionario funcionario = new Funcionario();
		funcionario.setId(id);
		funcionario.setNome(nome);
		funcionario.setCpf(cpf);
		funcionario.setSalario(salario);
		funcionario.setDataContratacao(LocalDate.parse(dataContratacao, formatter));
		funcionario.setCargo(cargo.get());
		funcionario.setUnidadeTrabalhos(unidades);

		funcionarioRepository.save(funcionario);
		System.out.println("Alterado Funcionario");

	}

	private void visualizar(Scanner scanner) {
		System.out.println("Qual pagina voce deseja visualizar");
		Integer page = scanner.nextInt();
		
		
		Pageable pageable = PageRequest.of(page, 5, Sort.by(Sort.Direction.DESC, "nome"));		
		Page<Funcionario> funcionarios = funcionarioRepository.findAll(pageable);
		
		System.out.println("Total de paginas: " +  funcionarios);
		System.out.println("Pagina atual: " + funcionarios.getNumber());
		System.out.println("Total de elemetos: " + funcionarios.getTotalElements());
		funcionarios.forEach(funcionario -> System.out.println(funcionario));
	}

	private void deletar(Scanner scanner) {
		System.out.println("Id do Funcionario");
		int id = scanner.nextInt();
		funcionarioRepository.deleteById(id);
		System.out.println("Excluir Funcionario");

	}

}
