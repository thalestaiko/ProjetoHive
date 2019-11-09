package net.guides.springboot2.springboot2jpacrudexample.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "trasportadora")
public class Transportadora {

	private long id;
	private String email;
	private String nome;
	private String emailId;
	private String empresa;
	private int telefone;
	private int celular;
	private int whatsapp;
	private String cep;
	private String estado;
	private String cidade;
	private String bairro;
	private String rua;
	private int numero;
	private String concorda;

	public Transportadora() {

	}

	public Transportadora(String nome, String email, String empresa, int telefone, int celular, int whatsapp, String cep,
			String estado, String cidade, String bairro, String rua, int numero) {
		this.nome = nome;
		this.email = email;
		this.emailId = emailId;
		this.empresa = empresa;
		this.telefone = telefone;
		this.celular = celular;
		this.whatsapp = whatsapp;
		this.cep = cep;
		this.estado = estado;
		this.cidade = cidade;
		this.bairro = bairro;
		this.rua = rua;
		this.numero = numero;
		
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@Column(name = "nome", nullable = false)
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Column(name = "email", nullable = false)
	public String getEmail() {
		return email;
	}

//	public void setEmail(String email) {
//		this.email = email;
//	}

//	@Column(name = "email", nullable = false)
//	public String getEmailId() {
//		return emailId;
//	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	@Column(name = "empresa", nullable = true)
	public String getEmpresa() {
		return empresa;
	}

	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}

	@Column(name = "telefone", nullable = true)
	public int getTelefone() {
		return telefone;
	}

	public void setTelefone(int telefone) {
		this.telefone = telefone;
	}

	@Column(name = "celular", nullable = true)
	public int getCelular() {
		return celular;
	}

	public void setCelular(int celular) {
		this.celular = celular;
	}

	@Column(name = "whatsapp", nullable = true)
	public int getWhatsapp() {
		return whatsapp;
	}

	public void setWhatsapp(int whatsapp) {
		this.whatsapp = whatsapp;
	}

	@Column(name = "cep", nullable = true)
	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	@Column(name = "estado", nullable = true)
	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	@Column(name = "cidade", nullable = true)
	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	@Column(name = "bairro", nullable = true)
	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	@Column(name = "rua", nullable = true)
	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	@Column(name = "numero", nullable = true)
	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getConcorda() {
		return concorda;
	}

	public void setConcorda(String concorda) {
		this.concorda = concorda;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", firstName=" + nome + ", lastName=" + nome + ", emailId=" + emailId
				+ "]";
	}

}
