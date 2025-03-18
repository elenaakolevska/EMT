package mk.ukim.finki.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import mk.ukim.finki.model.Accommodation;

@Repository
public interface AccommodationRepository extends JpaRepository<Accommodation,Long> {
}
