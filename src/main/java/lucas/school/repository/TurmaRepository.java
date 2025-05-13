package lucas.school.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import lucas.school.models.Turma;

@Repository
public interface TurmaRepository extends JpaRepository<Turma, Long> {
}
