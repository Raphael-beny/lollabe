package br.com.lollabe.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.lollabe.model.Tipo;
import br.com.lollabe.repository.TipoRepository;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/tipo")
public class TipoController {
	
	@Autowired
	private TipoRepository tipoRepository;
	
	@GetMapping
	public List<Tipo> listaTipos(){
		return tipoRepository.findAll();
	}
	
	@GetMapping("/{id}")
	public Optional<Tipo> buscarTipo(@PathVariable long id){
		return tipoRepository.findById(id);
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Tipo salvarTipo(@RequestBody Tipo tipo) {
		return tipoRepository.save(tipo);
	}
	
	@DeleteMapping
	public void deletarTipo(@RequestBody Tipo tipo) {
		tipoRepository.delete(tipo);
	}
	
	@PutMapping
	public Tipo atualizarTipo(@RequestBody Tipo tipo) {
		return tipoRepository.save(tipo);
	}
	
	@DeleteMapping("/{id}")
	public void deletarTipoPorId(@PathVariable long id){
		tipoRepository.deleteById(id);
	}
	
	@PutMapping("/{id}")
	public Tipo atualizarTipoPorId(@PathVariable long id, @RequestBody Tipo tipo) {
		tipo.setId(id);
		return tipoRepository.save(tipo);
	}
	

}
