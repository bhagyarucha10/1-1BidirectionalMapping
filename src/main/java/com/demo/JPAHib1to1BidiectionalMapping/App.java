package com.demo.JPAHib1to1BidiectionalMapping;

import com.demo.JPAHib1to1BidiectionalMapping.model.Address;
import com.demo.JPAHib1to1BidiectionalMapping.model.Student;

/**
 * Hello world!
 *
 */
import jakarta.persistence.*;

public class App {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("EmployeePU1");
        EntityManager em = emf.createEntityManager();

        // Create and persist a Student with an Address
        Student student = new Student("Rucha..", "Mohan...");
        Address address = new Address("112...", "blore...", "560072...");

        // Bidirectional relationship setup
        student.setAddress(address);
        address.setStudent(student);

        em.getTransaction().begin();
        em.persist(student);
        em.getTransaction().commit();
        System.out.println("saved");
/*
        // Retrieve the student and address
        Student retrievedStudent = em.find(Student.class, student.getId());
        System.out.println("Retrieved Student: " + retrievedStudent);
        Address retrievedAddress = retrievedStudent.getAddress();
        System.out.println("Retrieved Address: " + retrievedAddress);
*/
        // Clean up
        em.close();
        emf.close();
    }
}
