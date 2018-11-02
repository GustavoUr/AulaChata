package com.fatec.sce;

import static org.junit.Assert.*;


import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.junit.Test;

import com.fatec.sce.model.Livro;
import com.fatec.sce.model.Usuario;
import com.fatec.sce.servico.Emprestimo;
import com.fatec.sce.servico.ServicoEmprestimo;





public class UC09RegistraEmprestimoDeLivro {
	static private Livro livro;
	static private Livro livroNull;
	static private Usuario usuario;
	static private ServicoEmprestimo servico;

	@Test
	public void CT01RegistraEmprestimoDeLivro_com_sucesso() {
//cenario
		livro = new Livro();
		livro.setIsbn("121212");
		livro.setTitulo("Engenharia de Software");
		livro.setAutor("Pressman");
		usuario = new Usuario();
		usuario.setRa("1111");
		usuario.setNome("Jose da Silva");
		servico = new ServicoEmprestimo();
//acao
		Emprestimo resultadoEsperado = servico.empresta(livro, usuario);
//verificação
		assertNotNull(resultadoEsperado);
	}

	@Test
	public void CT02RegistraEmprestimoDeLivro_com_sucesso() {
		// cenario
		Emprestimo emprestimo = null;
		// acao
		emprestimo = ObtemEmprestimo.comDadosValidos();
		// verificação
		assertNotNull(emprestimo);
	}

	@Test
	public void CT02UC01FB_registra_emprestimo_com_sucesso_validacao_da_data() {
		// cenario
		DateTimeFormatter fmt = DateTimeFormat.forPattern("YYYY/MM/dd");
		String dataEsperada = new DateTime().plusDays(8).toString(fmt);
		ServicoEmprestimo servico = null;
		// acao
		Emprestimo emprestimo = ObtemEmprestimo.comDadosValidos();
		String dataObtida = emprestimo.getDataDevolucao();
		// verificacao
		assertTrue(dataEsperada.equals(dataObtida));
	}
	@Test
	public void CT03Da_Pau() {
		// cenario
		livro = new Livro();
		
		usuario = new Usuario();
		usuario.setRa("1111");
		usuario.setNome("Jose da Silva");
		servico = new ServicoEmprestimo();
		livro = null;
//acao
		Emprestimo resultadoEsperado = servico.empresta(livro, usuario);
//verificação
		
	}
	@Test
	public void CT04Da_Pau() {
		// cenario
		livro = new Livro();
		livro.setIsbn("121212");
		livro.setTitulo("Engenharia de Software");
		livro.setAutor("Pressman");
		usuario = new Usuario();
		
		servico = new ServicoEmprestimo();
		
		usuario = null;
//acao
		Emprestimo resultadoEsperado = servico.empresta(livro, usuario);
//verificação
		
	}
	@Test
	public void CT05Testa_o_que_falta(){
		livro = new Livro();
		livro.setIsbn("121212");
		livro.setTitulo("Engenharia de Software");
		livro.setAutor("Pressman");
		livroNull = new Livro();
		livroNull = null;
		usuario = new Usuario();
		usuario.setRa("1111");
		usuario.setNome("Jose da Silva");
		servico = new ServicoEmprestimo();
//acao
		Emprestimo resultadoEsperado = servico.empresta(livro, usuario);
		livro = resultadoEsperado.getLivro();
		usuario = resultadoEsperado.getUsuario();
		resultadoEsperado.setLivro(livroNull);
		
//verificação
		assertNotNull(resultadoEsperado);
	}
	@Test
	public void CT06_registra_emprestimo_com_Falha() {
		// cenario
		DateTimeFormatter fmt = DateTimeFormat.forPattern("YYYY/MM/dd");
		String dataEsperada = "11/12/8998";
		ServicoEmprestimo servico = null;
		// acao
		Emprestimo emprestimo = ObtemEmprestimo.comDadosValidos();
		String dataObtida = emprestimo.getDataDevolucao();
		// verificacao
		emprestimo.setDataEmprestimo(dataEsperada);
	}
}