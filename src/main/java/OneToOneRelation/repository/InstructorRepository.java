package OneToOneRelation.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import OneToOneRelation.entity.Instructor;

@Repository
public interface InstructorRepository extends JpaRepository<Instructor, Long> {}
