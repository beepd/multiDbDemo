package com.multi.db.demo.multiDbDemo.dao.primary;

import com.multi.db.demo.multiDbDemo.model.primary.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}
