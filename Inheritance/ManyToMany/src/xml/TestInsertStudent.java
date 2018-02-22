package xml;

import java.util.HashSet;
import java.util.Set;

//package com.candidjava.hibernate;
public class TestInsertStudent {
	public static void main(String arg[]) {
		StudentDao m = new StudentDao();
		Set<Course> cor = new HashSet<Course>();
		cor.add(new Course(".net"));
		cor.add(new Course("bootstrap"));
		Student bk = new Student("raman", cor);
		Student b = new Student("arun", cor);
		bk.setCourses(cor);
		b.setCourses(cor);
		m.insertStudent(bk);
		m.insertStudent(b);

	}

}
