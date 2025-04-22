package mk.ukim.finki.repository;

import mk.ukim.finki.dto.CategoryCountDTO;
import mk.ukim.finki.model.domain.Accommodation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccommodationRepository extends JpaRepository<Accommodation, Long> {

    @Query("SELECT a.category, COUNT(a) FROM Accommodation a GROUP BY a.category")
    List<Object[]> countByCategoryAcc();

}