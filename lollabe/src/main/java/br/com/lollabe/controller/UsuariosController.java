package br.com.lollabe.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.lollabe.exception.RegistroNaoEncontradoException;
import br.com.lollabe.model.Usuario;
import br.com.lollabe.repository.UsuariosRepository;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/usuarios")
public class UsuariosController {
	
	@Autowired
	private UsuariosRepository usuariosRepository;
	
	@GetMapping
	public List<Usuario> listaUsuarios(){
		return usuariosRepository.findAll();
	}
	
	@PostMapping("/login")
	public Usuario logar(@RequestBody Usuario usuario) {
		Usuario usuarioLogado = this.buscarPor(usuario);
		return usuarioLogado;
	}
	
	public Usuario buscarPor(Usuario usuario) {
		return Optional.ofNullable(usuariosRepository.buscarUsuarioPorEmailESenha(usuario.getEmail(), usuario.getSenha()))
				.orElseThrow(() -> new RegistroNaoEncontradoException("Usuário nao encontrado"));
	}
}
