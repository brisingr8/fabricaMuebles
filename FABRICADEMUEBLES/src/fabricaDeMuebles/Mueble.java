package fabricaDeMuebles;

public class Mueble {
	private int cantMadera;
	private String tipo;
	private String material;
	private String ID;
	private int fecha;
	
	public Mueble(Material material, Tipo tipo){
		setID();
		setMaterial(material.name());
		setTipo(tipo.name());
	}
	
	public Mueble(String ID) throws IDNoValidoException {
		setID(ID);
	}
	
	private void setID(String ID) {
		this.ID = ID;
	}

	protected int getCantMadera() {
		return cantMadera;
	}

	protected void setCantMadera(int cantMadera) {
		this.cantMadera = cantMadera;
	}

	public String getID() {
		return ID;
	}

	protected void setID() {
		if(getClass().getSimpleName().equals("Silla")){
			this.ID = "SI";
		}
		else if(getClass().getSimpleName().equals("Mesa")){
			this.ID = "ME";
		}
		else{
			this.ID = "AR";
		}
	}

	protected int getFecha() {
		return fecha;
	}

	protected void setFecha(int fecha) {
		this.fecha = fecha;
	}
	
	public String getTipo() {
		return tipo;
	}

	protected void setTipo(String tipo) {
		if(getClass().getSimpleName().equals("Silla")){
			this.tipo = "SILLA";
		}
		else if(getClass().getSimpleName().equals("Mesa")){
			this.tipo = "MESA";
		}
		else{
			this.tipo = "ARMARIO";
		}
	}

	public String getMaterial() {
		return material;
	}

	protected void setMaterial(String material) {
		this.material = material;
	}

	public String toString(){
		if(getClass().getSimpleName().equals("Mesa")){
			return " y su ID es " + ID + ".";
		}
		else if(getClass().getSimpleName().equals("Silla")){
			return " y su ID es " + ID + ".";
		}
		else{
			return " y su ID es " + ID + ".";
		}
	}
}
