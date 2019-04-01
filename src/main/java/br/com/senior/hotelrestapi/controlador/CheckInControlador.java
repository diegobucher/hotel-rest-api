package br.com.senior.hotelrestapi.controlador;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.senior.hotelrestapi.excecao.RecursoNaoEncontradoExcecao;
import br.com.senior.hotelrestapi.modelo.CheckIn;
import br.com.senior.hotelrestapi.repositorio.CheckInRepositorio;

@RestController
public class CheckInControlador {

	@Autowired
	private CheckInRepositorio checkInRepositorio;

	@GetMapping("/checkIns")
	public Page<CheckIn> obterCheckInsParams(@RequestParam(value = "nome", required = false) String dsNome,
			@RequestParam(value = "documento", required = false) String nrDocumento,
			@RequestParam(value = "telefone", required = false) String nrTelefone, Pageable pageable) {
		if (StringUtils.isEmpty(dsNome) && StringUtils.isEmpty(nrDocumento) && StringUtils.isEmpty(nrTelefone))
			return checkInRepositorio.findAll(pageable);
		else
			return checkInRepositorio.buscarComParametros(dsNome, nrDocumento, nrTelefone, pageable);
	}

	@PostMapping("/checkIns")
	public CheckIn criarCheckIn(@Valid @RequestBody CheckIn checkIn) {
		return checkInRepositorio.save(checkIn);
	}

	@PutMapping("/checkIns/{idCheckIn}")
	public CheckIn atualizarCheckIn(@PathVariable Long idCheckIn, @Valid @RequestBody CheckIn checkInRequisicao) {
		return checkInRepositorio.findById(idCheckIn).map(checkIn -> {
			checkIn.setDtEntrada(checkInRequisicao.getDtEntrada());
			checkIn.setDtSaida(checkInRequisicao.getDtSaida());
			checkIn.setAdicionalVeiculo(checkInRequisicao.isAdicionalVeiculo());
			checkIn.setHospede(checkInRequisicao.getHospede());
			return checkInRepositorio.save(checkIn);
		}).orElseThrow(() -> new RecursoNaoEncontradoExcecao("CheckIn não encontrado com o id " + idCheckIn));
	}

	@DeleteMapping("/checkIns/{idCheckIn}")
	public ResponseEntity<?> excluirCheckIn(@PathVariable Long idCheckIn) {
		return checkInRepositorio.findById(idCheckIn).map(checkIn -> {
			checkInRepositorio.delete(checkIn);
			return ResponseEntity.ok().build();
		}).orElseThrow(() -> new RecursoNaoEncontradoExcecao("CheckIn não encontrado com o id " + idCheckIn));
	}

}
