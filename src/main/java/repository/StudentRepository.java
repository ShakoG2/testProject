package repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import teachersAndStudents.Student;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

	public List<Student> getAllByFirstName(String firstName);
}
