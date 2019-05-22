package com.nelioalves.cursomc.domain;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.nelioalves.cursomc.domain.enums.EstadoPagamento;

@Entity
@Inheritance(strategy=InheritanceType.JOINED)
/*
 * Aqui posso escolher criar tabelas independentes nas subclasses
 * ou uma só tabela com todos os atributos da subclasse ao qual eu instancio
 * uma e seto os valores da outra subclasse para null.
 * A DICA É: se tiver muitos atributos cria tabelas independentes, se tiver
 * poucos atributos, cria uma tabela com todos os valores.
 */
public abstract class Pagamento implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	//não coloquei o @GeneratedValue(strategy = GenerationType.IDENTITY)
	//pois não quero gerar o ID automaticamente, já que pagamento e pedido
	//é um para um, quero que gerem o mesmo id
	private Integer id;
	//private EstadoPagamento estado;
	private Integer estado; //aqui deve ser um inteiro, se nn vai salvar errado no BD
	
	@JsonIgnore
	@OneToOne
	@JoinColumn(name="pedido_id")
	@MapsId //Garante que o pedido e o pagamento terão o mesmo ID
	private Pedido pedido;
	
	public Pagamento() {
		
	}

	public Pagamento(Integer id, EstadoPagamento estado, Pedido pedido) {
		super();
		this.id = id;
		this.estado = estado.getCod();
		this.pedido = pedido;
	}


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public EstadoPagamento getEstado() {
		return EstadoPagamento.toEnum(estado);
	}

	public void setEstado(EstadoPagamento estado) {
		this.estado = estado.getCod();
	}

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pagamento other = (Pagamento) obj;
		return Objects.equals(id, other.id);
	}
	
	
	
}
