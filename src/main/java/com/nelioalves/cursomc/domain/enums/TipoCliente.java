package com.nelioalves.cursomc.domain.enums;

public enum TipoCliente {
	/*Eu posso deixar só a enumeracao sem nada, porém ela pode ser salva tanto
	em forma de String quanto de numeração, e caso seja em numeração e eu
	adicione outra opção no enum, pode ser que a numeração de um valor mude
	Ex: Pessoa Fisica é "1" (recebendo automaticamente, sem que eu declare),
	 e dpois é adicionado outra opção de enum antes dela, ela passa a ser 2, 
	 e todos os dados no BD estarão corrompidos.
	*/
	PESSOAFISICA(1, "Pessoa Física"),
	PESSOAJURIDICA(2, "Pessoa Jurídica");
	
	private int cod;
	private String descricao;
	
	
	//construtor de ENUM é privado
	private TipoCliente(int cod, String descricao) {
		this.cod = cod;
		this.descricao = descricao;
	}

	//Em ENUM existe apenas get, já que uma vez que você declara, não deve mudar o valor
	public int getCod() {
		return cod;
	}


	public String getDescricao() {
		return descricao;
	}
	
	public static TipoCliente toEnum(Integer cod) {
		if (cod == null) {
			return null;
		}
		//Todo objeto X nos valores possiveis do tipo Cliente
		for(TipoCliente x : TipoCliente.values()) {
			if(cod.equals(x.getCod())) {
				return x;
			}	
		}
		throw new IllegalArgumentException("Id inválido: " + cod);
	}
}
