package com.ilhom.spring_mvc_hibernate.dao;


import com.ilhom.spring_mvc_hibernate.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class EmployeeDAOImpl{

private final SessionFactory sessionFactory;

    public EmployeeDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }


    @Transactional
     public List<Employee> getAllEmployees() {

        Session session= sessionFactory.getCurrentSession();
        Query<Employee>query= session.createQuery("from Employee", Employee.class);
        List<Employee>allEmployees =query.getResultList();
        return allEmployees;
    }

    @Transactional
    public void saveEmployee(Employee employee) {

        Session session= sessionFactory.getCurrentSession();
        session.saveOrUpdate(employee);
    }

    @Transactional
    public Employee getEmployee(int id) {
        Session session= sessionFactory.getCurrentSession();
        Employee employee= session.get(Employee.class, id);
        return employee;
    }


    @Transactional
    public void deleteEmployee(int id) {
        Session session=sessionFactory.getCurrentSession();
        Query<Employee> query=session.createQuery("delete from Employee where id=:employeeId");
        query.setParameter("employeeId", id);
        query.executeUpdate();
    }
}
// git uchun yozdim