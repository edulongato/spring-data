package br.com.alura.spring.data;

import br.com.alura.spring.data.service.CrudeCargoService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class SpringDataApplication implements CommandLineRunner {

    private final CrudeCargoService cargoService;

    private Boolean system = true;

    public SpringDataApplication(CrudeCargoService cargoService) {
        this.cargoService = cargoService;

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

            int action = sc.nextInt();
            if (action == 1) {
                cargoService.inicial(sc);
            } else {
                system = false;
            }
        }


    }
}