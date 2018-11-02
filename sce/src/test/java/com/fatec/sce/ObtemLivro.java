package com.fatec.sce;
import com.fatec.sce.model.Livro;
import com.fatec.sce.model.Usuario;
import com.fatec.sce.servico.Emprestimo;
import com.fatec.sce.servico.ServicoEmprestimo;
public class ObtemLivro {
public static Livro comDadosValidos() {
Livro livro = new Livro();
livro.setIsbn("121212");
livro.setTitulo("Engenharia de Software");
livro.setAutor("Pressman");
return livro;
}
public static Livro comISBNInvalido_branco() {
Livro livro = new Livro();
livro.setIsbn("");

livro.setTitulo("Engenharia de Software");

livro.setAutor("Pressman");
return livro;
}
public static Livro comISBNInvalido_nulo() {
Livro livro = new Livro();
livro.setIsbn(null);

livro.setTitulo("Engenharia de Software");

livro.setAutor("Pressman");
return livro;
}
}