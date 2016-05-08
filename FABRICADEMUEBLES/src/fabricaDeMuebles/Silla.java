package fabricaDeMuebles;

public class Silla extends Mueble{
	private int patas;
	private int respaldo; 
	
	public Silla(Material material, Tipo tipo){
		super(material, tipo);
		patas = 4;
		respaldo = 1;
	}
	
	@Override
	public String toString(){
		return "Esta " + getClass().getSimpleName() + " tiene " + patas + " patas y "
				+ respaldo + " respaldo" + super.toString();
	}
}
