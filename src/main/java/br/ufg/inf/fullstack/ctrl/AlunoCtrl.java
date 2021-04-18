package br.ufg.inf.fullstack.ctrl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import br.ufg.inf.fullstack.ctrl.business.AlunoBusiness;
import br.ufg.inf.fullstack.model.entities.Aluno;

@RestController
@RequestMapping(value="/aluno")
public class AlunoCtrl {

  @Autowired
  private AlunoBusiness business;

  @GetMapping
  public ResponseEntity<List<Aluno>> findall(){
    List<Aluno> list = business.findall();
    return ResponseEntity.ok().body(list);
  }

  @GetMapping(value = "/{id}")
  public ResponseEntity<Aluno> findByID(@PathVariable Integer id){
    Aluno retorno = business.findById(id);
    return ResponseEntity.ok(retorno);
  }


  @PostMapping
  public ResponseEntity<Aluno> insert(@RequestBody Aluno aluno){
    aluno = business.insert(aluno);
    return ResponseEntity.ok(aluno);
  }

  @DeleteMapping(value="/{id}")
  public ResponseEntity<Void> delete(@PathVariable Integer id){

    business.deletar(id);
    return ResponseEntity.noContent().build();

  }

  @PutMapping
  public ResponseEntity<Aluno> update(@RequestBody Aluno aluno){
    aluno = business.insert(aluno);
    return ResponseEntity.ok().body(aluno);
  }

  
}
