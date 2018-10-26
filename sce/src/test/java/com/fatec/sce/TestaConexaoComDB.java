package com.fatec.sce;

import static org.junit.Assert.*;
import org.junit.Test;
import com.fatec.sce.model.ConfiguraDB;
import com.fatec.sce.model.FabricaDeConexoes;
import com.mysql.jdbc.Connection;

public class TestaConexaoComDB {
	/**
	* Objetivo - verificar o comportamento do sistema na conexao ao DB com
	* configuracao valida Pré-condição - a configuracao default da fabrica de
	* conexoes é valida
	*/
	@Test
	public void quandoConectaComOBancoRetornaOK() {
	// cenario
	Connection c = null;
	try {
	// acao
	c = new FabricaDeConexoes().getConnection();
	// verificacao
	assertNotNull(c);
	} catch (Exception e) {
	fail("nao deveria falhar");
	}
	}

	/**
	 * Objetivo - verificar o comportamento do sistema na conexao ao DB com senha de
	 * acesso invalida Pré-condição - a senha cadastrada é "aluno"
	 */
	@Test
	public void quandoConectaComSenhaInvalida_SQLException() {
		// cenario
		String url = "jdbc:mysql://localhost:3306/biblioteca";
		String driver = "com.mysql.jdbc.Driver";
		String usuario = "root";
		String senha = "123"; // senha errada
		FabricaDeConexoes fabricaDeConexoes = null;
		ConfiguraDB configuraDB = new ConfiguraDB(url, driver, usuario, senha);
		fabricaDeConexoes = new FabricaDeConexoes(configuraDB);
		try {
			// acao
			fabricaDeConexoes.getConnection();
			fail("deveria falhar");
		} catch (Exception e) {
			// verificacao
			System.out.println(e.getMessage());
			assertEquals(e.getMessage(),"java.sql.SQLException: Access denied for user 'root'@'localhost' (using password: YES)");
		}
	}
	@Test
	public void quandoConectaComUsuarioInvalida_SQLException() {
		// cenario
		String url = "jdbc:mysql://localhost:3306/biblioteca";
		String driver = "com.mysql.jdbc.Driver";
		String usuario = "root1";
		String senha = "123"; // senha errada
		FabricaDeConexoes fabricaDeConexoes = null;
		ConfiguraDB configuraDB = new ConfiguraDB(url, driver, usuario, senha);
		fabricaDeConexoes = new FabricaDeConexoes(configuraDB);
		try {
			// acao
			fabricaDeConexoes.getConnection();
			fail("deveria falhar");
		} catch (Exception e) {
			// verificacao
			System.out.println(e.getMessage());
			assertEquals(e.getMessage(),"java.sql.SQLException: Access denied for user 'root1'@'localhost' (using password: YES)");
		}
	}
	@Test
	public void quandoConectaComUsuari2oInvalida_SQLException() {
		// cenario
		String url = "jdbc:mysql://localhost:3306/biblioteca";
		String driver = "com.mysql.jdbc.Driver";
		String usuario = "";
		String senha = "123"; // senha errada
		FabricaDeConexoes fabricaDeConexoes = null;
		ConfiguraDB configuraDB = new ConfiguraDB(url, driver, usuario, senha);
		fabricaDeConexoes = new FabricaDeConexoes(configuraDB);
		try {
			// acao
			fabricaDeConexoes.getConnection();
			fail("deveria falhar");
		} catch (Exception e) {
			// verificacao
			System.out.println(e.getMessage());
			assertEquals(e.getMessage(),"java.sql.SQLException: Access denied for user ''@'localhost' (using password: YES)");
		}
	}
	@Test
	public void quando2ConectaComUsuari2oInvalida_SQLException() {
		// cenario
		String url = "jdbc:mysql://localhost:8080/biblioteca";
		String driver = "asdriver";
		String usuario = "root";
		String senha = ""; // senha errada
		FabricaDeConexoes fabricaDeConexoes = null;
		ConfiguraDB configuraDB = new ConfiguraDB(url, driver, usuario, senha);
		fabricaDeConexoes = new FabricaDeConexoes(configuraDB);
		try {
			// acao
			fabricaDeConexoes.getConnection();
			fail("deveria falhar");
		} catch (Exception e) {
			// verificacao
			System.out.println("Aqui2 " + e.getMessage() );
			assertEquals(e.getMessage(),"java.lang.ClassNotFoundException: asdriver");
		}
	}
	
}