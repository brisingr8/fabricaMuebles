package fabricaDeMuebles;

public class Armario extends Mueble{
	private int puertas;
	private int baldas;
	public Armario(Material material, Tipo tipo){
		super(material, tipo);
		puertas = 2;
		baldas = 6;
	}
	
	@Override
	public String toString(){
		return "Este " + getClass().getSimpleName() + " tiene " + puertas + " puertas y "
				+ baldas + " baldas" + super.toString();
	}
}
