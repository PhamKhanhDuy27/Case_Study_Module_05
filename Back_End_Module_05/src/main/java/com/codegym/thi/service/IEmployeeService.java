package com.codegym.thi.service;

import com.codegym.thi.dto.EmployeeDto;

import java.util.List;

public interface IEmployeeService {
    List<EmployeeDto> getAll();

    EmployeeDto getById(int id);

    void addEmployee(EmployeeDto employeeDto);

    void deleteEmployee(int id);

    List<EmployeeDto> getEmployeeByBranchId(int id);
}
