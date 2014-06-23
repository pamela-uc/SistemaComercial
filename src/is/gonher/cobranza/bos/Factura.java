package is.gonher.cobranza.bos;

import java.math.BigDecimal;

public class Factura {
	private String porCargo;
	private BigDecimal cargo;
	private BigDecimal pago;
	private BigDecimal saldo;
	private String descrip;
	private String tipo;
	private BigDecimal importe;
	private String dv;
	private String emision;
	private String vencimiento;
	
	public Factura(String porCargo, BigDecimal pago, BigDecimal saldo,String descrip,String tipo, BigDecimal importe ){
		 this.porCargo=porCargo;
		 this.pago=pago;
		 this.saldo=saldo;
		 this.descrip=descrip;
		 this.tipo=tipo;
		 this.importe=importe;
	}

	public String getPorCargo() {
		return porCargo;
	}

	public void setPorCargo(String porCargo) {
		this.porCargo = porCargo;
	}

	public BigDecimal getCargo() {
		return cargo;
	}

	public void setCargo(BigDecimal cargo) {
		this.cargo = cargo;
	}

	public BigDecimal getPago() {
		return pago;
	}

	public void setPago(BigDecimal pago) {
		this.pago = pago;
	}

	public BigDecimal getSaldo() {
		return saldo;
	}

	public void setSaldo(BigDecimal saldo) {
		this.saldo = saldo;
	}

	public String getDescrip() {
		return descrip;
	}

	public void setDescrip(String descrip) {
		this.descrip = descrip;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public BigDecimal getImporte() {
		return importe;
	}

	public void setImporte(BigDecimal importe) {
		this.importe = importe;
	}

	public String getDv() {
		return dv;
	}

	public void setDv(String dv) {
		this.dv = dv;
	}

	public String getEmision() {
		return emision;
	}

	public void setEmision(String emision) {
		this.emision = emision;
	}

	public String getVencimiento() {
		return vencimiento;
	}

	public void setVencimiento(String vencimiento) {
		this.vencimiento = vencimiento;
	}
	
	 

}
