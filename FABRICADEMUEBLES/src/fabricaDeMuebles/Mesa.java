package fabricaDeMuebles;

public class Mesa extends Mueble{
	private int patas;
	private int tablero;
	public Mesa(Material material, Tipo tipo){
		super(material, tipo);
		patas = 4;
		tablero = 1;
	}
	
	@Override
	public String toString(){
		return "Esta " + getClass().getSimpleName() + " tiene " + patas + " patas y "
				+ tablero + " tableros" + super.toString();
	}
}
