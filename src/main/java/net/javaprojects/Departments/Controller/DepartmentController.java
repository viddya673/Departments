package net.javaprojects.Departments.Controller;

import jakarta.validation.Valid;
import net.javaprojects.Departments.Entity.Department;
import net.javaprojects.Departments.Error.DepartmentNotFoundException;
import net.javaprojects.Departments.Service.DepartmentService;
import net.javaprojects.Departments.Service.DepartmentServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DepartmentController {

    @Autowired
    private DepartmentService deptService;

    private final Logger LOGGER = LoggerFactory.getLogger(DepartmentController.class);

    @PostMapping("/departments/add")
    public Department saveDepartment(@Valid @RequestBody Department department){
        LOGGER.info("Inside save department of controller");
        return deptService.saveDepartment(department);
    }

    @GetMapping("/departments/get")
    public List<Department> fetchDepartmentList(){
        return deptService.getDepartments();
    }

    @GetMapping("/departments/get/{id}")
    public Department fetchDepartmentById(@PathVariable("id") Long departmentId) throws DepartmentNotFoundException {
        return deptService.fetchDepartmentbyId(departmentId);
    }

    @DeleteMapping("/departments/delete/{id}")
    public String DeleteDepartmentById(@PathVariable("id") Long departmentId){
        deptService.deleteDepartmentById(departmentId);
        return "Department deleted successfully!";
    }

    @PutMapping("departments/update/{id}")
    public Department updateDepartment(@PathVariable("id") Long departmentId,
                                        @RequestBody Department department){
        return deptService.updateDepartment(departmentId, department);
    }

    @GetMapping("/departments/get/by_name/{name}")
    public Department fetchDepartmentByName(@PathVariable("name") String departmentName) {
        return deptService.fetchDepartmentByName(departmentName);
    }
}
