package fabricaDeMuebles;

public enum Tipo {

	
	MESA,
	SILLA,
	ARMARIO;
	
	private static final Tipo[] VALUES = Tipo.values();

	public static String[] generarOpcionesMenu() {
		String[] opcionesMenu = new String[getValues().length + 1];
		int i = 0;
		for (Tipo material : getValues()) {
			opcionesMenu[i++] = material.name();
		}
		opcionesMenu[i] = "Salir";
		return opcionesMenu;
	}

		public static Tipo[] getValues() {
		return VALUES;
	}
}
