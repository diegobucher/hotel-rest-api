package br.com.senior.hotelrestapi.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.senior.hotelrestapi.modelo.Hospede;

@Repository
public interface HospedeRepositorio extends JpaRepository<Hospede, Long> {

}
