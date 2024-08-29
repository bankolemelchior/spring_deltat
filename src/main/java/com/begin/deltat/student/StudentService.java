package com.begin.deltat.student;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

// @Component
@Service
public class StudentService {
    
	private final StudentRepository studentRepository;

	public StudentService(StudentRepository studentRepository) {
		this.studentRepository = studentRepository;
	}

		//For getting all students
		public List<Student> getStudents() {
        return studentRepository.findAll();
    }

		//For adding student
		public void addNewStudent(Student student) {
			Optional<Student> studentByEmail = studentRepository.findStudentByEmail(student.getEmail());

			if(studentByEmail.isPresent()) {
				throw new IllegalStateException("email already existe !");
			}

			studentRepository.save(student);

			System.out.println(student);
		}

		//For deleting a student
		public void deleteStudent(Long studentId) {
			boolean existStudent = studentRepository.existsById(studentId);
			if(!existStudent) {
				throw new IllegalStateException("Studentd with id " + studentId + " does not exists");
			}

			studentRepository.deleteById(studentId);
		}

		//For updation student
		@Transactional
		public void updateStudent(Long studentId, String name, String email) {
				Student student = studentRepository.findById(studentId)
												.orElseThrow(() -> new IllegalStateException("The student does not exists"));

				if(name != null && name.length() > 0 && !Objects.equals(student.getName(), name)) {
					student.setName(name);
				}

				if(email != null && email.length() > 0 && !Objects.equals(student.getEmail(), email)) {
					Optional<Student> studentOptional = studentRepository.findStudentByEmail(email);
					if(studentOptional.isPresent()) {
								throw new IllegalStateException("email taken");
					}
					student.setEmail(email);
				}
		}
}
