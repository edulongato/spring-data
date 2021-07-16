package br.com.alura.spring.data.repository;


import br.com.alura.spring.data.orm.UnidadeDeTrabalho;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UniTraRepository extends CrudRepository<UnidadeDeTrabalho, Integer> {
}
