package br.com.fiap.revisaoapi.repository;
import br.com.fiap.revisaoapi.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
