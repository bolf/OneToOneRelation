package OneToOneRelation.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import OneToOneRelation.entity.InstructorDetail;

@Repository
public interface InstructorDetailRepository extends JpaRepository<InstructorDetail, Long> {}
