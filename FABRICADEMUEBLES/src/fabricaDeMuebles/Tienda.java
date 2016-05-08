package fabricaDeMuebles;

import java.io.Serializable;
import java.util.ArrayList;

public class Tienda implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private ArrayList<Mueble> almacen = new ArrayList<Mueble>();

	public void annadir(Tipo tipo, Material material) throws Exception {
		if (tipo.name().equals("SILLA")) {
			Silla silla = new Silla(material, tipo);
			if (!almacen.contains(silla))
				almacen.add(silla);
			else
				throw new MuebleYaExisteException("El mueble ya existe en el almacen. ");
		} else if (tipo.name().equals("MESA")) {
			Mesa mesa = new Mesa(material, tipo);

			if (!almacen.contains(mesa))
				almacen.add(mesa);
			else
				throw new MuebleYaExisteException("El mueble ya existe en el almacen. ");
		} else {
			Armario armario = new Armario(material, tipo);

			if (!almacen.contains(armario))
				almacen.add(armario);
			else
				throw new MuebleYaExisteException("El mueble ya existe en el almacen. ");
		}
	}

	public int size() {
		return almacen.size();
	}

	public Mueble anterior(int index) throws Exception {
		return almacen.get(index - 1);
	}

	public Mueble posterior(int index) throws Exception {
		return almacen.get(index + 1);
	}

	public int index(Mueble mueble) {
		return almacen.indexOf(mueble);
		// return index;
	}

	public Mueble get(String ID) throws IDNoValidoException, MuebleNoExisteException {
		try {
			return almacen.get(almacen.indexOf(new Mueble(ID)));
		} catch (ArrayIndexOutOfBoundsException e) {
			throw new MuebleNoExisteException("El mueble no está en la tienda.");
		}
	}

	public Mueble get(int index) {
		if (almacen.isEmpty())
			return null;
		if (index < 0 | index > almacen.size() - 1)
			return null;
		return almacen.get(index);
	}
}
