package br.com.senior.hotelrestapi.controlador;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.senior.hotelrestapi.excecao.RecursoNaoEncontradoExcecao;
import br.com.senior.hotelrestapi.modelo.Hospede;
import br.com.senior.hotelrestapi.repositorio.HospedeRepositorio;

@RestController
public class HospedeControlador {

	@Autowired
	private HospedeRepositorio hospedeRepositorio;

	@GetMapping("/hospedes")
	public Page<Hospede> obterHospedes(Pageable pageable) {
		return hospedeRepositorio.findAll(pageable);
	}

	@PostMapping("/hospedes")
	public Hospede criarHospede(@Valid @RequestBody Hospede hospede) {
		return hospedeRepositorio.save(hospede);
	}

	@PutMapping("/hospedes/{idHospede}")
	public Hospede atualizarHospede(@PathVariable Long idHospede, @Valid @RequestBody Hospede hospedeRequisicao) {
		return hospedeRepositorio.findById(idHospede).map(hospede -> {
			hospede.setDsNome(hospedeRequisicao.getDsNome());
			hospede.setNrDocumento(hospedeRequisicao.getNrDocumento());
			hospede.setNrTelefone(hospedeRequisicao.getNrTelefone());
			return hospedeRepositorio.save(hospede);
		}).orElseThrow(() -> new RecursoNaoEncontradoExcecao("Hospede não encontrado com o id " + idHospede));
	}

	@DeleteMapping("/hospedes/{idHospede}")
	public ResponseEntity<?> excluirHospede(@PathVariable Long idHospede) {
		return hospedeRepositorio.findById(idHospede).map(hospede -> {
			hospedeRepositorio.delete(hospede);
			return ResponseEntity.ok().build();
		}).orElseThrow(() -> new RecursoNaoEncontradoExcecao("Hospede não encontrado com o id " + idHospede));
	}
}
