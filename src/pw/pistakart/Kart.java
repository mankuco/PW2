package pw.pistakart;

public class Kart {
	
	private int idKart;
	private boolean tipoKart;  //True= Adulto  False= Infantil
	private Estados estado;	
	private String nombrePista;
	
	//CONSTRUCTOR PARAMETRIZADO
	public Kart(int idKart, boolean tipoKart, Estados estado) {
		super();
		this.idKart = idKart;
		this.tipoKart = tipoKart;
		this.estado = estado;
	}
	//CONSTRUCTOR
	public Kart() {
		super();
	}
	
	/* 
	 * @Resumen Devuelve la identificación del kart
	 * @return idKart = int que identifica al kart
	 */
	public int getIdKart() {
		return idKart;
	}
	/* 
	 * @Resumen Cambia la identificación del kart
	 * @param idKart = int que identifica al kart
	 */
	public void setIdKart(int idKart) {
		this.idKart = idKart;
	}
	/* 
	 * @Resumen Devuelve el tipo de kart
	 * @return tipokart = bool // true=adulto, false=infantil
	 */ 
	public boolean getTipoKart() {
		return tipoKart;
	}
	/* 
	 * @Resumen Cambia el tipo de kart
	 * @return tipokart = bool // true=adulto, false=infantil
	 */
	public void setTipoKart(boolean tipoKart) {
		this.tipoKart = tipoKart;
	}
	/* 
	 * @Resumen Devuelve el estado del kart
	 * @return estado = Estados // DISPONIBLE, RESERVADO o MANTENIMIENTO 
	 */
	public Estados getEstado() {
		return estado;
	}
	/* 
	 * @Resumen Cambia el estado del kart
	 * @return estado = Estados // DISPONIBLE, RESERVADO o MANTENIMIENTO 
	 */
	public void setEstado(Estados estado) {
		this.estado = estado;
	}
	public int getnombrePista(){
		return nombrePista;
		}
	public string setnombrePista(string nombrePista){
		this.nombrePista=nombrePista;
		}
	/* 
	 * @Resumen Devuelve una cadena con la informacion del kart
	 * @return string
	 */
	@Override
	public String toString() {
		return "KART [IDKart=" + idKart + ", TipoKart=" + tipoKart + ", Estado=" + estado + "]";
	}	
}