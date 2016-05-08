package fabricaDeMuebles;

import java.io.File;

public class Gestionar {
	
	/**
	 * TIENDA
	 */
	private static Tienda tienda = new Tienda();
	
	public static Tienda getTienda() {
		return tienda;
	}
	
	public static void setTienda(Tienda Tienda) {
		Gestionar.tienda = Tienda;
	}
	
	/**
	 * FICHERO
	 */
	private static File file = new File("Sin título");
	
	public static File getFile() {
		return file;
	}

	public static void setFile(File file) {
		Gestionar.file = file;
	}
	
	/**
	 * MODIFICADO
	 */
	private static boolean modificado;
	
	public static boolean modificado() {
		return modificado;
	}

	public static void setModificado(boolean modificado) {
		Gestionar.modificado = modificado;
	}
}
