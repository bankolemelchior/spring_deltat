package com.begin.deltat.student;

import java.time.LocalDate;
import java.util.List;

public class StudentService {
    
    public List<Student> getStudents() {
        		return List.of(
			new Student(
				1L,
				"Mike",
				"mike@gmail.com",
				LocalDate.of(2000, 9, 3),
				21
			), 
			new Student(
				2L,
				"Victor",
				"victor@gmail.com",
				LocalDate.of(2005, 2, 6),
				19
			)
		);
    }
}
