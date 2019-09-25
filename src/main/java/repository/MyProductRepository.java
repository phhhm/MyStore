package repository;

import model.Prouduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface MyProductRepository extends JpaRepository<Prouduct, Integer> {
    Prouduct findByName(String name);
}
