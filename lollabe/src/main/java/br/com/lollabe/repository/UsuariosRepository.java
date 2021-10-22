package br.com.lollabe.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.lollabe.model.Usuario;

@Repository
public interface UsuariosRepository extends JpaRepository<Usuario, Integer>{

	
	@Query(value =
			"SELECT u "
			+ "FROM  Usuario u "
			+ "WHERE u.email = :email "
			+ "AND u.senha = :senha ")
	Usuario buscarUsuarioPorEmailESenha(@Param("email") String email, @Param("senha") String senha);
	
}
