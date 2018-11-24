package com.multi.db.demo.multiDbDemo.dao.secondry;

import com.multi.db.demo.multiDbDemo.model.secondry.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Integer> {
}
