package modelo;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="meta",schema="servicos")
public class Meta implements Serializable{
	
	private static final long serialVersionUID = -5892455705000068550L;

	@EmbeddedId
	private MetaPK id; 
	
	private Date ate;
	
	private float valor;
	
	@Transient
	private Date desdeforapk;

	public MetaPK getId() {
		return id;
	}

	public void setId(MetaPK id) {
		this.id = id;
	}

	public Date getAte() {
		return ate;
	}

	public void setAte(Date ate) {
		this.ate = ate;
	}

	public float getValor() {
		return valor;
	}

	public void setValor(float valor) {
		this.valor = valor;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ate == null) ? 0 : ate.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + Float.floatToIntBits(valor);
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
		Meta other = (Meta) obj;
		if (ate == null) {
			if (other.ate != null)
				return false;
		} else if (!ate.equals(other.ate))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (Float.floatToIntBits(valor) != Float.floatToIntBits(other.valor))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Meta [id=" + id + ", ate=" + ate + ", valor=" + valor + "]";
	}

	public Date getDesdeforapk() {
		return desdeforapk;
	}

	public void setDesdeforapk(Date desdeforapk) {
		this.desdeforapk = desdeforapk;
	}

}
