package br.ufg.inf.fullstack.ctrl.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import br.ufg.inf.fullstack.model.repositories.MatriculaRepository;
import br.ufg.inf.fullstack.model.entities.Matricula;

@Service
public class MatriculaBusiness {

  @Autowired
  private MatriculaRepository repository;

  public List<Matricula>  findAll(){
    return repository.findAll();
  }

  public Matricula findById(Integer id){
    Optional<Matricula> retorno = repository.findById(id);
    return retorno.get();
  }

  public Matricula insert(Matricula matricula){
    return repository.save(matricula);
  }

  public void delete(Integer id){
    repository.deleteById(id);
  }
  

  public Matricula update(Matricula matricula){
    Matricula matriculaUpd = repository.findById(
      matricula.getIdMatricula()
    ).get();

    matriculaUpd.setAluno(
      matricula.getAluno()
    );

    matriculaUpd.setOferta(
      matricula.getOferta()
    );

    return repository.save(matriculaUpd);

  }



}
