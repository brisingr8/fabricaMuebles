package fabricaDeMuebles;

public enum Material {

	
	ROBLE,
	CEREZO,
	NOGAL;
	
	private static final Material[] VALUES = Material.values();

	public static String[] generarOpcionesMenu() {
		String[] opcionesMenu = new String[getValues().length + 1];
		int i = 0;
		for (Material material : getValues()) {
			opcionesMenu[i++] = material.name();
		}
		opcionesMenu[i] = "Salir";
		return opcionesMenu;
	}

		public static Material[] getValues() {
		return VALUES;
	}
}
