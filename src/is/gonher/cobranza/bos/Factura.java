package is.gonher.cobranza.bos;

public class Factura {
	private String porCargo;
	private String pago;
	private String saldo;
	private String descrip;
	private String tipo;
	
	public Factura(String porCargo,String pago,String saldo,String descrip,String tipo){
		 this.porCargo=porCargo;
		 this.pago=pago;
		 this.saldo=saldo;
		 this.descrip=descrip;
		 this.tipo=tipo;
	}
	
	public String getPorCargo() {
		return porCargo;
	}
	public void setPorCargo(String porCargo) {
		this.porCargo = porCargo;
	}
	public String getPago() {
		return pago;
	}
	public void setPago(String pago) {
		this.pago = pago;
	}
	public String getSaldo() {
		return saldo;
	}
	public void setSaldo(String saldo) {
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
	
	

}
