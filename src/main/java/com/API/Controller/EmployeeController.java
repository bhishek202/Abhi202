package com.API.Controller;


import com.API.Service.EmployeeService;
import com.API.payLoad.EmployeeDto;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;

import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/v1/employee")
public class EmployeeController {


    @Autowired
    private EmployeeService service;

    @PostMapping("/add")

    public ResponseEntity<?> addEmployee(@Valid @RequestBody EmployeeDto dto, BindingResult result)
    {
        //this code use in the valid code
         if(result.hasErrors()){
             return new ResponseEntity<>(result.getFieldError().getDefaultMessage(),HttpStatus.INTERNAL_SERVER_ERROR);

         }

        EmployeeDto employeeDto=service.addEmployee(dto);

        return new ResponseEntity<>(employeeDto, HttpStatus.CREATED);
    }




@DeleteMapping
public void deleteEmployee(@RequestParam Long id){
    service.deleteEmployee(id);

}
    //http://localhost:8080/api/v1/employee?pageSize=5&pageNo=1$sortDir=asc
@GetMapping
public ResponseEntity<List<EmployeeDto>> getAllEmployee(
        @RequestParam(name="pageSize",required=false,defaultValue="5")int pageSize,
        @RequestParam(name="PageNo",required=false,defaultValue="0")int pageNo,
        @RequestParam(name="sortBy",required=false,defaultValue="name")String sortBy,
        @RequestParam(name="sortDir",required=false,defaultValue="asc")String sortDir)
{
    List<EmployeeDto> employeeDtos=service.getAllEmployee(pageNo,pageSize,sortBy,sortDir);
    return new ResponseEntity<>(employeeDtos, HttpStatus.CREATED);
}
@PutMapping
public ResponseEntity<EmployeeDto> updateEmployee(@RequestParam Long id,@RequestBody EmployeeDto dto)
{
   EmployeeDto employeeDto= service.updateEmployee(id,dto);
    return new ResponseEntity<>(employeeDto, HttpStatus.OK);
}


//http://localhost:8080/api/v1/employee/employeeId/{empId}
    @GetMapping("/employeeId/{empId}")
    public ResponseEntity<EmployeeDto> getAllEmployeeById(
        @PathVariable    long empId
    ) {
        EmployeeDto dto=service.getEmployeeById(empId);
       return new ResponseEntity<>(dto,HttpStatus.OK);
    }


}
