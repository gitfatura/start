package br.com.start.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import br.com.start.comum.AppBaseEntity;

@Entity
@Table(name = "TB_CARRO")
public class CarroEntity extends AppBaseEntity implements Serializable {

	private static final long serialVersionUID = -4865729194315901658L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "CAR_ID")
	private Long id;

	@Column(name="CAR_MARCA", length = 100, nullable = false)
	private String marca;

	@Column(name="CAR_MODELO", length = 100, nullable = false)
	private String modelo;

	@Column(name="CAR_PLACA", length = 20, nullable = false)
	private String placa;

	 
	
	public CarroEntity() {
	}

	public CarroEntity(Long id, String marca, String modelo, String placa) {
		this.id = id;
		this.marca = marca;
		this.modelo = modelo;
		this.placa = placa;
	}

	@Override
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CarroEntity other = (CarroEntity) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
