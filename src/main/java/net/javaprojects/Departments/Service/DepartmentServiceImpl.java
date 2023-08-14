package net.javaprojects.Departments.Service;

import net.javaprojects.Departments.Entity.Department;
import net.javaprojects.Departments.Repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentRepository deptRepo;
    @Override
    public Department saveDepartment(Department department) {
        return deptRepo.save(department);
    }

    @Override
    public List<Department> getDepartments() {
        return deptRepo.findAll();
    }

    @Override
    public Department fetchDepartmentbyId(Long departmentId) {
        return deptRepo.findById(departmentId).get();
    }

    @Override
    public void deleteDepartmentById(Long departmentId) {
        deptRepo.deleteById(departmentId);
    }

    @Override
    public Department updateDepartment(Long departmentId, Department department) {
        Department deptDB = deptRepo.findById(departmentId).get();

        if(Objects.nonNull(department.getDepartmentName()) && ! "".equalsIgnoreCase(department.getDepartmentName())) {
            deptDB.setDepartmentName(department.getDepartmentName());
        }

        if(Objects.nonNull(department.getDepartmentAddress()) && ! "".equalsIgnoreCase(department.getDepartmentAddress())) {
            deptDB.setDepartmentAddress(department.getDepartmentAddress());
        }

        if(Objects.nonNull(department.getDepartmentCode()) && ! "".equalsIgnoreCase(department.getDepartmentCode())) {
            deptDB.setDepartmentCode(department.getDepartmentCode());
        }

        return deptRepo.save(deptDB);
    }
}
