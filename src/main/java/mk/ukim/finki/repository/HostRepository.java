package mk.ukim.finki.repository;

import mk.ukim.finki.model.Host;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface HostRepository extends JpaRepository<Host, Long> {
}
