package com.fatec.sce.model;

public class Usuario {
private String ra;
private String nome;
public String getRa() {
return ra;
}
public void setRa(String ra) {
this.ra = ra;
}
public String getNome() {
return nome;
}
public void setNome(String nome) {
this.nome = nome;
}
@Override
public boolean equals(Object obj) {
if (this == obj)
return true;
if (obj == null)
return false;
if (getClass() != obj.getClass())
return false;
Usuario other = (Usuario) obj;
if (nome == null) {
if (other.nome != null) {
	
}

} 
if (ra == null) {
if (other.ra != null) {
	
}

}
	


return true;
}
}