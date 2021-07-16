package br.com.alura.spring.data.service;

import br.com.alura.spring.data.orm.Cargo;
import br.com.alura.spring.data.orm.UnidadeDeTrabalho;
import br.com.alura.spring.data.repository.UniTraRepository;
import org.springframework.stereotype.Service;

import java.util.Scanner;

@Service
public class CrudUnidadeTrabalhoService {

    private Boolean system = true;

    private final UniTraRepository uniTraRepository;

    public CrudUnidadeTrabalhoService(UniTraRepository uniTraRepository) {
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
        salvar(scanner);
    }

    private void salvar(Scanner scanner) {

        System.out.println("Nome da Unidade de Trabalho: ");
        String descricao = scanner.next();

        System.out.println("Digite o Endereco: ");
        String endereco = scanner.next();

        UnidadeDeTrabalho unidadeDeTrabalho = new UnidadeDeTrabalho();
        unidadeDeTrabalho.setDescricao(descricao);
        unidadeDeTrabalho.setEndereco(endereco);

        uniTraRepository.save(unidadeDeTrabalho);
        System.out.println("Salvo");

    }

    private void atualizar(Scanner scanner) {

        System.out.println("Digite o id:");
        int id = scanner.nextInt();

        System.out.println("Digite o nome da unidade: ");
        String descicao = scanner.next();

        System.out.println("Digite o endereco da unidade");
        String endereco = scanner.next();

        UnidadeDeTrabalho unidadeDeTrabalho = new UnidadeDeTrabalho();
        unidadeDeTrabalho.setId(id);
        unidadeDeTrabalho.setDescricao(descicao);
        unidadeDeTrabalho.setEndereco(endereco);
        uniTraRepository.save(unidadeDeTrabalho);
        System.out.println("Atualizado");

    }

    private void visualizar(Scanner scanner) {

        Iterable<UnidadeDeTrabalho> unidades = uniTraRepository.findAll();
        unidades.forEach(System.out::println);

    }

    private void deletar(Scanner scanner) {
        System.out.println("Id");
        int id = scanner.nextInt();
        uniTraRepository.deleteById(id);
        System.out.println("Deletado");
    }


}
