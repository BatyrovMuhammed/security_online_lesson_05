package legendsoft.security_online_lesson_05.repository;

import legendsoft.security_online_lesson_05.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}
