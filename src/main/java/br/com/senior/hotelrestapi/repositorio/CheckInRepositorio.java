package br.com.senior.hotelrestapi.repositorio;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.senior.hotelrestapi.modelo.CheckIn;

@Repository
public interface CheckInRepositorio extends JpaRepository<CheckIn, Long> {

	@Query(value = "SELECT * FROM check_in c, hospede h WHERE c.id_hospede = h.id AND h.ds_nome LIKE ? AND h.nr_documento LIKE ? AND h.nr_telefone LIKE ?", nativeQuery = true)
	Page<CheckIn> buscarComParametros(String dsNome, String nrDocumento, String nrTelefone, Pageable pageable);
}
