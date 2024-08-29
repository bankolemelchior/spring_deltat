package com.begin.deltat.student;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

// @Component
@Service
public class StudentService {
    
	private final StudentRepository studentRepository;

	public StudentService(StudentRepository studentRepository) {
		this.studentRepository = studentRepository;
	}


		public List<Student> getStudents() {
        return studentRepository.findAll();
    }

		public void addNewStudent(Student student) {
			Optional<Student> studentByEmail = studentRepository.findStudentByEmail(student.getEmail());

			if(studentByEmail.isPresent()) {
				throw new IllegalStateException("email already existe !");
			}

			studentRepository.save(student);

			System.out.println(student);
		}

		public void deleteStudent(Long studentId) {
			boolean existStudent = studentRepository.existsById(studentId);
			if(!existStudent) {
				throw new IllegalStateException("Studentd with id " + studentId + " does not exists");
			}

			studentRepository.deleteById(studentId);
		}
}
