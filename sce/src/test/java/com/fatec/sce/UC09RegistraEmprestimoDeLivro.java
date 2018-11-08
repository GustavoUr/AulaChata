package com.fatec.sce;

import static org.junit.Assert.*;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.junit.Ignore;
import org.junit.Test;
import com.fatec.sce.model.Emprestimo;
import com.fatec.sce.model.Livro;
import com.fatec.sce.model.Usuario;
import com.fatec.sce.servico.ServicoEmprestimo;

public class UC09RegistraEmprestimoDeLivro {
	static private Livro livro;
	static private Usuario usuario;
	static private ServicoEmprestimo servico;

	@Test
	public void CT01RegistraEmprestimoDeLivro_com_sucesso() {
		// cenario
		livro = new Livro();
		livro.setIsbn("121212");
		livro.setTitulo("Engenharia de Software");
		livro.setAutor("Pressman");
		usuario = new Usuario();
		usuario.setRa("1111");
		usuario.setNome("Jose da Silva");
		servico = new ServicoEmprestimo();
		// acao
		Emprestimo resultadoEsperado = servico.empresta(livro, usuario);
		// verificação
		assertNotNull(resultadoEsperado);
	}

	@Test
	public void CT02UC01FB_registra_emprestimo_com_sucesso_validacao_da_data() {
		// cenario
		DateTimeFormatter fmt = DateTimeFormat.forPattern("yyyy/MM/dd");
		String dataEsperada = new DateTime().plusDays(8).toString(fmt);
		ServicoEmprestimo servico = null;
		// acao
		Emprestimo emprestimo = ObtemEmprestimo.comDadosValidos();
		String dataObtida = emprestimo.getDataDevolucao();
		// verificacao
		assertTrue(dataEsperada.equals(dataObtida));
	}
	@Ignore
	@Test
	public void CT03RegistraEmprestimoDeLivro_semNomeUsuario() {
		// cenario
				livro = new Livro();
				livro.setIsbn("121212");
				livro.setTitulo("Engenharia de Software");
				livro.setAutor("Pressman");
				usuario = new Usuario();
				usuario.setRa("1111");
				usuario.setNome("");
				servico = new ServicoEmprestimo();
				// acao
				Emprestimo resultadoEsperado = servico.empresta(livro, usuario);
				// verificação
				assertNotNull(resultadoEsperado);
	}
	@Ignore
	@Test
	public void CT04RegistraEmprestimoDeLivro_semRAUsuario() {
		// cenario
				livro = new Livro();
				livro.setIsbn("121212");
				livro.setTitulo("Engenharia de Software");
				livro.setAutor("Pressman");
				usuario = new Usuario();
				usuario.setRa("");
				usuario.setNome("Jose da Silva");
				servico = new ServicoEmprestimo();
				// acao
				Emprestimo resultadoEsperado = servico.empresta(livro, usuario);
				// verificação
				assertNotNull(resultadoEsperado);
	}
	@Ignore
	@Test
	public void CT05RegistraEmprestimoDeLivro_semISBNLivro() {
		// cenario
				livro = new Livro();
				livro.setIsbn("");
				livro.setTitulo("Engenharia de Software");
				livro.setAutor("Pressman");
				usuario = new Usuario();
				usuario.setRa("1111");
				usuario.setNome("Jose da Silva");
				servico = new ServicoEmprestimo();
				// acao
				Emprestimo resultadoEsperado = servico.empresta(livro, usuario);
				// verificação
				assertNotNull(resultadoEsperado);
	}
	@Ignore
	@Test
	public void CT06RegistraEmprestimoDeLivro_semTituloLivro() {
		// cenario
				livro = new Livro();
				livro.setIsbn("121212");
				livro.setTitulo("");
				livro.setAutor("Pressman");
				usuario = new Usuario();
				usuario.setRa("1111");
				usuario.setNome("Jose da Silva");
				servico = new ServicoEmprestimo();
				// acao
				Emprestimo resultadoEsperado = servico.empresta(livro, usuario);
				// verificação
				assertNotNull(resultadoEsperado);
	}
	@Ignore
	@Test
	public void CT07RegistraEmprestimoDeLivro_semAutorLivro() {
		// cenario
				livro = new Livro();
				livro.setIsbn("121212");
				livro.setTitulo("Engenharia de Software");
				livro.setAutor("");
				usuario = new Usuario();
				usuario.setRa("1111");
				usuario.setNome("Jose da Silva");
				servico = new ServicoEmprestimo();
				// acao
				Emprestimo resultadoEsperado = servico.empresta(livro, usuario);
				// verificação
				assertNotNull(resultadoEsperado);
	}
	
	/**
	* Objetivo - verificar o comportamento do metodo ehDomigo() para uma data com formato
	* valido dia invalido (domingo).
	*/
	@Test
	public void CT06se_data_devolucao_for_domingo_retorna_true(){
	//cenario
	String data = "2018/09/09"; //domingo
	//acao
	Emprestimo umEmprestimo = new Emprestimo();
	//verificacao
	assertTrue(umEmprestimo.ehDomingo(data));
	}
	
	@Test
	public void CT07_quando_entrega_atrasado_quant_dias_negativo(){
	//cenario
	Emprestimo umEmprestimo = ObtemEmprestimo.comDataDeDevolucaoVencida();
	ServicoEmprestimo servico= new ServicoEmprestimo();
	//acao
	int quantDias = servico.devolucao(umEmprestimo);
	//verificacao
	assertTrue (quantDias < 0); //quant de dias entre a data de emprestimo e a de devolucao
	}
}