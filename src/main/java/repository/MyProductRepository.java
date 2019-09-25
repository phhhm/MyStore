package repository;

import model.Prouduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MyProductRepository extends JpaRepository<Prouduct, Integer> {
    Prouduct findByName(String name);
}
