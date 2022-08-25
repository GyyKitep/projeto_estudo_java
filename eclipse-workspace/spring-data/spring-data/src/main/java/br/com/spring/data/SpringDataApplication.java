package br.com.spring.data;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.spring.data.orm.UnidadeTrabalho;
import br.com.spring.data.service.CrudCargoService;
import br.com.spring.data.service.CrudFuncionarioService;
import br.com.spring.data.service.CrudUnidadeTrabalhoService;
import br.com.spring.data.service.RelarotioFuncionarioDinamico;
import br.com.spring.data.service.RelatoriosService;

@SpringBootApplication
public class SpringDataApplication implements CommandLineRunner {

	private final CrudCargoService cargoService;
	private final CrudUnidadeTrabalhoService unidadeTrabalhoService;
	private final CrudFuncionarioService funcionarioService;
	private final RelatoriosService relatoriaService;
	private final RelarotioFuncionarioDinamico relarotioFuncionarioDinamico;

	private Boolean system = true;

	public SpringDataApplication(CrudCargoService cargoService, CrudUnidadeTrabalhoService unidadeTrabalhoService,
			CrudFuncionarioService funcionarioService, RelatoriosService relatoriaService,
			RelarotioFuncionarioDinamico relarotioFuncionarioDinamico) {
		this.cargoService = cargoService;
		this.unidadeTrabalhoService = unidadeTrabalhoService;
		this.funcionarioService = funcionarioService;
		this.relatoriaService = relatoriaService;
		this.relarotioFuncionarioDinamico = relarotioFuncionarioDinamico;
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringDataApplication.class, args);
	}

	@Override // executado depois do maisn
	public void run(String... args) throws Exception {
		Scanner scanner = new Scanner(System.in);

		Boolean isTrue = true;
		List<UnidadeTrabalho> unidades = new ArrayList<>();

		while (isTrue) {
			System.out.println("O que deseja fazer");
			System.out.println("0 - Sair");
			System.out.println("1 - Manutencao Cargo");
			System.out.println("2 - Manutencao Unidade de Trabalho");
			System.out.println("3 - Manutencao Funcionario");
			System.out.println("4 - Relatorio Funcionario");
			System.out.println("5 - Relatorio Dinamico");
			int action = scanner.nextInt();

			if (action != 0) {

				switch (action) {
				case 1:
					cargoService.inicial(scanner);
					break;
				case 2:
					unidadeTrabalhoService.inicial(scanner);
					break;
				case 3:
					funcionarioService.inicial(scanner);
					break;
				case 4:
					relatoriaService.inicial(scanner);
					break;
				case 5:
					relarotioFuncionarioDinamico.inicial(scanner);
					break;
				default:
					system = false;
				}

			} else {
				isTrue = false;
			}
		}

	}

}
