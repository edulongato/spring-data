package br.com.alura.spring.data.service;

import br.com.alura.spring.data.orm.Cargo;
import br.com.alura.spring.data.orm.Funcionario;
import br.com.alura.spring.data.orm.UnidadeDeTrabalho;
import br.com.alura.spring.data.repository.CargoRepository;
import br.com.alura.spring.data.repository.FuncRepository;
import br.com.alura.spring.data.repository.UniTraRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

@Service
public class CrudFuncionarioService {

    private Boolean system = true;
    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    private final CargoRepository cargoRepository;
    private final FuncRepository funcRepository;
    private final UniTraRepository uniTraRepository;

    public CrudFuncionarioService(CargoRepository cargoRepository, FuncRepository funcRepository, UniTraRepository uniTraRepository) {
        this.cargoRepository = cargoRepository;
        this.funcRepository = funcRepository;
        this.uniTraRepository = uniTraRepository;
    }

    public void inicial(Scanner scanner) {
        while (system) {
            System.out.println("Qual ação da unidade de trabalho deseja executar ?");
            System.out.println("0 - Sair");
            System.out.println("1 - Salvar");
            System.out.println("2 - Atualizar");
            System.out.println("3 - Visializar");
            System.out.println("4 - Deletar");


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
                    break;
            }
        }
        salvar(scanner);
    }



    private void salvar(Scanner scanner) {
        System.out.println("Digite o nome: ");
        String nome = scanner.next();

        System.out.println("Digite o CPF: ");
        String cpf = scanner.next();

        System.out.println("Digite o salario: ");
        Double salario = scanner.nextDouble();

        System.out.println("Digite a data de contratacao: ");
        String dataContratacao = scanner.next();

        System.out.println("Digite o cargoId: ");
        Integer cargoId = scanner.nextInt();

        List<UnidadeDeTrabalho> unidades = unidade(scanner);
        Funcionario funcionario = new Funcionario();
        funcionario.setNome(nome);
        funcionario.setCpf(cpf);
        funcionario.setSalario(salario);
        funcionario.setDataContratacao(LocalDate.parse(dataContratacao, formatter));

        Optional<Cargo> cargo = cargoRepository.findById(cargoId);
        funcionario.setCargo(cargo.get());
        funcionario.setUnidadeTrabalhos(unidades);

        funcRepository.save(funcionario);
        System.out.println("Salvo");
    }

    private List<UnidadeDeTrabalho> unidade(Scanner scanner) {
        Boolean isTrue = true;
        List<UnidadeDeTrabalho> unidades = new ArrayList<>();

        while (isTrue){
            System.out.println("Digite a unidadeId (Para sair digite 0)");
            Integer unidadeId = scanner.nextInt();

            if (unidadeId != 0){
                Optional<UnidadeDeTrabalho> unidade = uniTraRepository.findById(unidadeId);
                unidades.add(unidade.get());
            }else {
                isTrue = false;
            }

        }
        return unidades;

    }

    private void atualizar(Scanner scanner) {

        System.out.println("Digite o id: ");
        Integer id = scanner.nextInt();

        System.out.println("Digite o nome: ");
        String nome = scanner.next();

        System.out.println("Digite o CPF: ");
        String cpf = scanner.next();

        System.out.println("Digite o salario: ");
        Double salario = scanner.nextDouble();

        System.out.println("DIgite a data de contratacao: ");
        String dataContratacao = scanner.next();

        System.out.println("Digite o cargoId: ");
        Integer cargoId = scanner.nextInt();

        Funcionario funcionario = new Funcionario();
        funcionario.setId(id);
        funcionario.setNome(nome);
        funcionario.setCpf(cpf);
        funcionario.setSalario(salario);
        funcionario.setDataContratacao(LocalDate.parse(dataContratacao, formatter));

        Optional<Cargo> cargo = cargoRepository.findById(cargoId);
        funcionario.setCargo(cargo.get());

        funcRepository.save(funcionario);
        System.out.println("Atualizado!");

    }

    private void visualizar(){
        Iterable<Funcionario> funcionarios = funcRepository.findAll();
        funcionarios.forEach(System.out::println);
    }

    private void deletar(Scanner scanner){
        System.out.println("Id");
        int id = scanner.nextInt();
        funcRepository.deleteById(id);
        System.out.println("Deletado");
    }



}


