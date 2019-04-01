package br.com.senior.hotelrestapi.excecao;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class RecursoNaoEncontradoExcecao extends RuntimeException {
	private static final long serialVersionUID = -4505766230652245508L;

	public RecursoNaoEncontradoExcecao(String message) {
		super(message);
	}

	public RecursoNaoEncontradoExcecao(String message, Throwable cause) {
		super(message, cause);
	}
}
