package com.fatec.sce;

import static org.junit.Assert.*;

import org.junit.Test;

import com.fatec.sce.model.Livro;
import com.fatec.sce.model.Usuario;

public class UC05CadastrarUsuario {

	@Test
	public void seila() {
	try{
		//cenario
		Usuario User = new Usuario();
		Usuario user = new Usuario();
		String aux ="";
		//acao
		User.setNome("121212");
		User.setRa("sdsadsad");
		
		aux = User.getRa();
		if(User.equals(User)){
			aux = User.getNome();
		}
		if(User.equals(user)) {
			
		}
	
	}catch(RuntimeException e){
		//verificacao
			fail ("nao deve falhar");
		}
	}
	@Test
	public void seila2() {
	try{
		//cenario
		Usuario User = null;
		Usuario user = new Usuario();
		Usuario nome = new Usuario();
		Livro oi = new Livro();
		String aux ="";
		//acao
		user.setNome(null);
		user.setRa("sdsadsad");
		nome.setNome(null);
		nome.setRa(null);
		if(user.equals(user) == false){
			aux = User.getNome();
		}
		if(user.equals(User)== false) {
			aux = user.getRa();
		}
		if(user.equals(oi) == false){
			aux = User.getNome();
		}
		if(user.equals(oi)){
			
		}
		if(nome.equals(user) == false){
			aux = User.getNome();
		}
	
	}catch(RuntimeException e){
		//verificacao
			fail ("nao deve falhar");
		}
	
		
	

}
	@Test
	public void seila3() {
	try{
		//cenario
		Usuario User = new Usuario();
		Usuario user = new Usuario();
		Livro oi = new Livro();
		Usuario nome = new Usuario();
		
		user.setNome(null);
		user.setRa("sdsadsad");
		nome.setNome(null);
		nome.setRa(null);
		String aux ="";
		//acao
		User.setNome("121212");
		User.setRa("sdsadsad");
		
		aux = User.getRa();
		if(user.equals(oi) == false){
			aux = User.getNome();
		}
		else {
			
		}
		if(user.equals(oi)){
			
		}
		else {
			
		}
		if(nome.equals(user) == false){
			aux = User.getNome();
	
	}}catch(RuntimeException e){
		//verificacao
			fail ("nao deve falhar");
		}}
}
	
