package fabricaDeMuebles;

public class MuebleNoExisteException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public MuebleNoExisteException(String string){
		super(string);
	}
}
