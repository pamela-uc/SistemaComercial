package is.gonher.cobranza.bos;

public class Cobranza {
   private String folio;
   private String importe;
   private String banco;
   private String tipo;
   
public Cobranza( String folio , String importe , String tipo , String banco ){
	this.folio=folio;
	this.importe=importe;
	this.tipo=tipo;
	this.banco=banco;
}
   
public String getFolio() {
	return folio;
}
public void setFolio(String folio) {
	this.folio = folio;
}
public String getImporte() {
	return importe;
}
public void setImporte(String importe) {
	this.importe = importe;
}
public String getBanco() {
	return banco;
}
public void setBanco(String banco) {
	this.banco = banco;
}
public String getTipo() {
	return tipo;
}
public void setTipo(String tipo) {
	this.tipo = tipo;
}
   
   
   
}
