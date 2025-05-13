package lucas.school.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import lucas.school.models.Professor;

@Repository
public interface ProfessorRepository extends JpaRepository<Professor, Long> {
}
