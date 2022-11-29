package asimo.v.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import asimo.v.entities.eventObjects.Course;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {

}
