package com.luv2code.springboot.employeemvc.dao;

import com.luv2code.springboot.employeemvc.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    // that's it ... no need to write any code LOL!

}
