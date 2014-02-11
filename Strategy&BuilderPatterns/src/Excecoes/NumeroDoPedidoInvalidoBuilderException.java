package Excecoes;

@SuppressWarnings("serial")
public class NumeroDoPedidoInvalidoBuilderException extends IllegalArgumentException {
	
	public NumeroDoPedidoInvalidoBuilderException(){}
	public NumeroDoPedidoInvalidoBuilderException(String mensagem){
		super(mensagem);
	}
}
