package net.javaprojects.Departments.Service;

import net.javaprojects.Departments.Entity.Department;
import java.util.List;

public interface DepartmentService {
    public Department saveDepartment(Department department);

    public List<Department> getDepartments();

    public Department fetchDepartmentbyId(Long departmentId);

    public void deleteDepartmentById(Long departmentId);

    public Department updateDepartment(Long departmentId, Department department);

    Department fetchDepartmentByName(String departmentName);
}
