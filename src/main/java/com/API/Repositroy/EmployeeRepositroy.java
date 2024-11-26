package com.API.Repositroy;

import com.API.Entity.Comment;
import com.API.Entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepositroy  extends JpaRepository<Employee,Long>{
    interface CommentRepository extends JpaRepository<Comment, Long> {
    }
}
