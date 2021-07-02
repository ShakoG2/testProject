package teachersAndStudents;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
@Table(name = "teachers")
@SequenceGenerator(name = "studentSeq", sequenceName = "student_seq", allocationSize = 1)
public class Student {

	public enum Gender {
		FEMALE, MALE
	}

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "studentSeq")
	private Long id;

	@Column(name = "first_name")
	private String firstName;

	@Enumerated(EnumType.STRING)
	@Column(name = "gender")
	private Teacher.Gender gender;

	@Column(name = "last_name")
	private String lastName;

	@Column(name = "s_class")
	private Integer sClass;

	@ManyToMany(mappedBy = "students", cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
	private List<Teacher> teachers;
}
