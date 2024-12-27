package com.spring.orm.dao;

import java.util.List;

import org.springframework.orm.hibernate5.HibernateTemplate;

import com.spring.orm.entities.Student;

import jakarta.transaction.Transactional;

public class StudentDao {

	private HibernateTemplate hibernateTemplate;

	// this is for saving student
	@Transactional // for enabling write operation
	public int insert(Student student) {
		Integer i = (Integer) this.hibernateTemplate.save(student);// result was not storing int int so we took the //
																	// Object class Integer

		return i;
	}
	
	//this method is for retrieving single object data
	public Student getStudent(int id) {
		Student student = this.hibernateTemplate.get(Student.class,id);
		return student;
	}
	
	
	//this method is for retrieving all object data
	public List<Student> getAllStudent(){
		List<Student> all = this.hibernateTemplate.loadAll(Student.class);
		return all;
	}
	
	//deleting the object from database
	@Transactional
	public void deleteStudent(int id) {
		Student student = this.hibernateTemplate.get(Student.class,id);
		this.hibernateTemplate.delete(student);
		System.out.println(id + " : is deleted from database");
	}
	
	
	
	//update
	@Transactional
	public void updateStudent(Student student) {
		this.hibernateTemplate.update(student);
	}
	
	
	

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

}