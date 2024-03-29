package br.com.projuris;

import java.math.BigDecimal;

public class CustoCargo {
	private String cargo;
	private BigDecimal custo;

	public CustoCargo(String cargo, BigDecimal custo) {
		setCargo(cargo);
		setCusto(custo);
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public BigDecimal getCusto() {
		return custo;
	}

	public void setCusto(BigDecimal custo) {
		this.custo = custo;
	}
	
	public String toString() {
		return getCargo() + ": " + getCusto().doubleValue();
	}
}
