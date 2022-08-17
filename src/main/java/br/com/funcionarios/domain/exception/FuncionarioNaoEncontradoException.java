package br.com.funcionarios.domain.exception;

public class FuncionarioNaoEncontradoException extends EntidadeNaoEncontradaException {

	private static final long serialVersionUID = 1L;

	public FuncionarioNaoEncontradoException(String mensagem) {
		super(mensagem);
	}
	
	public FuncionarioNaoEncontradoException(Long id) {
		this(String.format("Não existe um cadastro de funcionário com código %d", id));
	}
	
}