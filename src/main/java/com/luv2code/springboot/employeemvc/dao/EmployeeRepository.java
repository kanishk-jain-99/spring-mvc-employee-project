package com.luv2code.springboot.employeemvc.dao;

import com.luv2code.springboot.employeemvc.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    // that's it ... no need to write any code LOL!

    //sort by last name JPA repo will automatically create the query as per the method name given below

    public List<Employee> findAllByOrderByLastNameAsc();

}
