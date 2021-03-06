package br.com.lollabe.controller;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.databind.ObjectMapper;


import br.com.lollabe.model.Produto;
import br.com.lollabe.repository.ProdutoRepository;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/cadastro")
public class ProdutoController {

	@Autowired
	private ProdutoRepository produtoRepository;
	
	@GetMapping
	public List<Produto> listaProdutos(){
		return produtoRepository.findAll();
	}
	

	@GetMapping("/{id}")
	public Optional<Produto> buscarColaborador(@PathVariable Long	id){
		return produtoRepository.findById(id);
	}
	
	@RequestMapping(method=RequestMethod.POST)
    public ResponseEntity<String> receiveData(String produtoJson, MultipartFile foto) {

        ObjectMapper mapper = new ObjectMapper();
        Produto produto = null;

        try {
            produto = mapper.readValue(produtoJson, Produto.class);
            byte[] fotoemBytes = foto.getBytes();
			produto.setFoto(fotoemBytes);
        } catch (IOException e) {
            return ResponseEntity.badRequest().body("Não foi possível ler o json");
        }
        produtoRepository.save(produto);
        return ResponseEntity.ok("Produto cadastrado com sucesso!");
    }
	
	
	@DeleteMapping
	public void deletarProduto(@RequestBody Produto produto) {
		produtoRepository.delete(produto);
	}
	
	@PutMapping
	public Produto atualizarProduto(@RequestBody Produto produto) {
		return produtoRepository.save(produto);
	}
	
	@DeleteMapping("/{id}")
	public void deletarProdutoPorId(@PathVariable Long id){
		produtoRepository.deleteById(id);
	}
	
	@PutMapping("/{id}")
	public Produto atualizarProdutoPorId(@PathVariable Long id, @RequestBody Produto produto) {
		produto.setId(id);
		return produtoRepository.save(produto);
	}
	
	
}
