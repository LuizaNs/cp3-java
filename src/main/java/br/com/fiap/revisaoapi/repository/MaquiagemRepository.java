package br.com.fiap.revisaoapi.repository;

import br.com.fiap.revisaoapi.model.Maquiagem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MaquiagemRepository extends JpaRepository<Maquiagem, Long> {
}
