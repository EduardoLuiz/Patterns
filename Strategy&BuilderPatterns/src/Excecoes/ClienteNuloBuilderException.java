package Excecoes;

@SuppressWarnings("serial")
public class ClienteNuloBuilderException extends NullPointerException {
	public ClienteNuloBuilderException(){}
	public ClienteNuloBuilderException(String mensagem){
		super(mensagem);
	}
}
