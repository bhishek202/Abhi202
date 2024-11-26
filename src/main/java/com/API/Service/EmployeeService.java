package com.API.Service;

import com.API.Config.ResourceNotFound;
import com.API.Entity.Employee;
import com.API.Repositroy.EmployeeRepositroy;
import com.API.payLoad.EmployeeDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;


import java.util.List;

import java.util.stream.Collectors;



@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepositroy repositroy;
    @Autowired
    private ModelMapper modelMapper;


    public EmployeeDto addEmployee(EmployeeDto dto)
    {

        Employee employee=mapToEntity(dto);
        Employee emp= repositroy.save(employee);
        EmployeeDto employeeDto=mapToDto(emp);

       return employeeDto;

    }
    public void deleteEmployee(long id)
    {
        repositroy.deleteById(id);


    }
    public List<EmployeeDto> getAllEmployee(int pageNo, int pageSize,String sortBy,String sortDir)
    {
        //Sort the data asecndig to decendig order code
       Sort sort=sortDir.equalsIgnoreCase("asc")  ?Sort.by(sortBy).ascending():Sort.by(sortBy).descending();
        //fetch the recode code pageNo and PageSize this (page) get the All deteils pageNo and pageSize
        Pageable page = PageRequest.of(pageNo,pageSize, sort);
        Page<Employee> all = repositroy.findAll(page);
        //this code convert the object to list form
        List<Employee> employee=all.getContent();
        List<EmployeeDto>dto= employee.stream().map(e->mapToDto(e)).collect(Collectors.toList());
        return dto;
    }
    public EmployeeDto updateEmployee(long id, EmployeeDto dto)
    {
       Employee employee=mapToEntity(dto);
       employee.setId(id);
       Employee updateEmployee=repositroy.save(employee);
       EmployeeDto employeeDto=mapToDto(employee);
       return employeeDto;
    }

  //convert Entity to Dto
   EmployeeDto mapToDto(Employee employee) {
       EmployeeDto dto= modelMapper.map(employee,EmployeeDto.class);
      // EmployeeDto dto = new EmployeeDto();
      // dto.setId(employee.getId());
       //dto.setName(employee.getName());
      // dto.setEmail(employee.getEmail());
      // dto.setMobile(employee.getMobile());
       return dto;
   }
//  convert dto to Entity
    Employee mapToEntity(EmployeeDto dto) {
      Employee emp=  modelMapper.map(dto,Employee.class);
        //Employee emp = new Employee();
       // emp.setId(dto.getId());
        //emp.setName(dto.getName());
       // emp.setEmail(dto.getEmail());
       // emp.setMobile(dto.getMobile());
        return emp;

    }
    //get the data id through the use the modelmapper dependancy
    // this code use handal the Exceptoin  singal id Id through get the data
    public EmployeeDto getEmployeeById(long empId) {
      Employee employee=repositroy.findById(empId).orElseThrow(
              ()-> new ResourceNotFound("I YOU NOT FOCUS PROGRAM THEN you have see the    "+empId)
      );

        EmployeeDto dto=  mapToDto(employee);
         return dto;
    }


}
