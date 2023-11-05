package legendsoft.security_online_lesson_05.repository;

import legendsoft.security_online_lesson_05.models.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {

    @Query("select p from Person p where p.email = :email")
    Person getByEmailPerson(@Param("email") String email);
}
