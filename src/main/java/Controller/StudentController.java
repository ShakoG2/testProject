package Controller;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import repository.StudentRepository;
import teachersAndStudents.Student;

import java.util.List;

@RestController
@RequestMapping("students")
@RequiredArgsConstructor
public class StudentController {


	private final StudentRepository studentRepository;


	@GetMapping("{id}")
	public Student getAll(@PathVariable final long id) {
		return studentRepository.getById(id);
	}

	@GetMapping("{firstName}")
	public List<Student> getAll(@PathVariable String firstName) {
		return studentRepository.getAllByFirstName(firstName);
	}

	@PutMapping("{id}")
	public Student updateStudent(@RequestBody Student student, final long id) {
		Student student1 = studentRepository.getById(id);
		student1.setFirstName(student.getFirstName());
		student1.setGender(student.getGender());
		student1.setSClass(student.getSClass());
		student1.setLastName(student.getLastName());
		return studentRepository.save(student1);
	}

}
