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
@SequenceGenerator(name = "teachersSeq", sequenceName = "teachers_seq", allocationSize = 1)
public class Teacher {

	public enum Gender {
		FEMALE, MALE
	}

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "teachersSeq")
	private Long id;

	@Column(name = "first_name")
	private String firstName;

	@Column(name = "last_name")
	private String lastName;

	@Enumerated(EnumType.STRING)
	@Column(name = "gender")
	private Gender gender;

	@Column(name = "subject")
	private String subject;


	@ManyToMany(mappedBy = "student_id", fetch = FetchType.LAZY)
	@JoinTable(name = "teachers_and_students",
			joinColumns = {@JoinColumn(name = "teacher_id")},
			inverseJoinColumns = {@JoinColumn(name = "student_id")}
	)
	private List<Student> students;

}
