package com.multi.db.demo.multiDbDemo.controller;

import com.multi.db.demo.multiDbDemo.dao.primary.EmployeeRepository;
import com.multi.db.demo.multiDbDemo.dao.secondry.PersonRepository;
import com.multi.db.demo.multiDbDemo.model.primary.Employee;
import com.multi.db.demo.multiDbDemo.model.secondry.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    PersonRepository personRepository;

    @RequestMapping(value = {"/","home"})
    public String showHome(){
        return "Hello world";
    }

    @RequestMapping(value = "addEmployee")
    public String addEmployee(){
        Employee e = new Employee();
        e.setId(100);
        e.setName("123");
        employeeRepository.save(e);
        return "Employee Saved";
    }

    @RequestMapping(value = "addPerson")
    public String addPerson(){
        Person p = new Person();
        p.setId(100);
        p.setName("dfkjsa");
        personRepository.save(p);
        return "Person Saved";
    }
}
