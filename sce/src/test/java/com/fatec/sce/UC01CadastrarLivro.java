package com.fatec.sce;

import static org.junit.Assert.*;

import org.junit.Test;

import com.fatec.sce.model.Livro;


	
	
	public class UC01CadastrarLivro {
		/**
		 * Objetivo - verificar o comportamento na inclusao com dados validos
		 */
		
		@Test
		public void CT01CadastrarLivroComDadosValidos(){
		try{
		//cenario
		Livro umLivro = new Livro();
		//acao
		umLivro.setIsbn("121212");
		umLivro.setTitulo("Engenharia de Softwar");
		umLivro.setAutor("Pressman");
		}catch(RuntimeException e){
		//verificacao
			fail ("nao deve falhar");
		}
		}
		@Test
		public void CT02CadastrarLivroComDadosValidos(){
			try{
			//cenario
			Livro umLivro = new Livro();
			//acao
			umLivro.setIsbn("");
			umLivro.setTitulo("Engenharia de Softwar");
			umLivro.setAutor("Pressman");
			}catch(RuntimeException e){
			//verificacao
			fail ("nao deve falhar");
			}
			}
		@Test
		public void CT03CadastrarLivroComDadosValidos(){
			try{
			//cenario
			Livro umLivro = new Livro();
			String aux ="";
			//acao
			umLivro.setIsbn("asdsadsadsad");
			umLivro.setTitulo("Engenharia de Softwar");
			umLivro.setAutor("Pressman");
			aux = umLivro.getIsbn();
			aux = umLivro.getAutor();
			aux = umLivro.getTitulo();
			
			}catch(RuntimeException e){
			//verificacao
			fail ("nao deve falhar");
			}
			}
		}
	
	
	
	
	
