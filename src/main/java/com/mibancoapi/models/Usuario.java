package com.mibancoapi.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "users")
@NoArgsConstructor
@AllArgsConstructor @ToString
public class Usuario implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 7030071407758955195L;

	
	//public static int  idUsuario;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long idClient;
	
	@Column(length = 50)
	public String nombreUsuario;
	public String claveBancaria;
	public Double saldoCuenta;
	@Column( name = "bancariaCV", length = 100 , nullable = false,unique = true )
	public int cbu;
	public boolean log;
	//public int idCliente = this.idUsuario;
	public Long getIdClient() {
		return idClient;
	}
	public void setIdClient(Long idClient) {
		this.idClient = idClient;
	}
	public String getNombreUsuario() {
		return nombreUsuario;
	}
	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}
	public String getClaveBancaria() {
		return claveBancaria;
	}
	public void setClaveBancaria(String claveBancaria) {
		this.claveBancaria = claveBancaria;
	}
	public Double getSaldoCuenta() {
		return saldoCuenta;
	}
	public void setSaldoCuenta(Double saldoCuenta) {
		this.saldoCuenta = saldoCuenta;
	}
	public int getCbu() {
		return cbu;
	}
	public void setCbu(int cbu) {
		this.cbu = cbu;
	}
	public boolean isLog() {
		return log;
	}
	public void setLog(boolean log) {
		this.log = log;
	}
	
	/*public Usuario() {
		idUsuario++;
	}*/
	
	
}
