package br.com.alura.spring.data;

import br.com.alura.spring.data.service.CrudCargoService;
import br.com.alura.spring.data.service.CrudFuncionarioService;
import br.com.alura.spring.data.service.CrudUnidadeTrabalhoService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class SpringDataApplication implements CommandLineRunner {

    private Boolean system = true;

    private final CrudCargoService cargoService;
    private final CrudFuncionarioService funcionarioService;
    private final CrudUnidadeTrabalhoService unidadeTrabalhoService;

    public SpringDataApplication(CrudCargoService cargoService,
                                 CrudFuncionarioService funcionarioService,
                                 CrudUnidadeTrabalhoService unidadeTrabalhoService) {

        this.cargoService = cargoService;
        this.funcionarioService = funcionarioService;
        this.unidadeTrabalhoService = unidadeTrabalhoService;
    }


    public static void main(String[] args) {
        SpringApplication.run(SpringDataApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        Scanner sc = new Scanner(System.in);

        while (system) {
            System.out.println("Qual ação voçe quer executar?");
            System.out.println("0 - Sair");
            System.out.println("1 - Cargo");
            System.out.println("2 - Funcionario");
            System.out.println("1 - Unidade de Trabalho");

            Integer function = sc.nextInt();

            switch (function){
                case 1:
                    cargoService.inicial(sc);
                    break;
                case 2:
                    funcionarioService.inicial(sc);
                    break;
                case 3:
                    unidadeTrabalhoService.inicial(sc);
                    break;
                default:
                    System.out.println("Finalizando");
                    system = false;
                    break;
            }

        }


    }
}
