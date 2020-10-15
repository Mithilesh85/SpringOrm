package com.mithilesh.spring.orm.dao;

import java.util.List;

import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.transaction.annotation.Transactional;

import com.mithilesh.spring.orm.entities.Student;

public class StudentDao {

	private HibernateTemplate hibernateTemplate;

	// inserting data in database
	@Transactional
	public int insert(Student student) {
		Integer i = (Integer) this.hibernateTemplate.save(student);

		return i;
	}

	// get a single data
	public Student getStudent(int studentId) {
		Student student = this.hibernateTemplate.get(Student.class, studentId);

		return student;
	}
      
	//get all students
	public List<Student> getAllStudent()
	{
		List<Student> st = this.hibernateTemplate.loadAll(Student.class);
		return st;
	}
	
	//deleting the data
	@Transactional
	public void deleteStudent(int studentId)
	{
		Student student = this.hibernateTemplate.get(Student.class,studentId);
		this.hibernateTemplate.delete(student);
	}
    //updating the data
	@Transactional
	public void updateStudent(Student student)
	{
		this.hibernateTemplate.update(student);
	}
	
	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

}
