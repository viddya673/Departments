package net.javaprojects.Departments.Service;

import net.javaprojects.Departments.Entity.Department;
import net.javaprojects.Departments.Repository.DepartmentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class DepartmentServiceTest {

    @Autowired
    private DepartmentService deptService;

    @MockBean
    private DepartmentRepository deptRepo;

    @BeforeEach
    void setUp() {
        Department dept = Department.builder()
                .departmentName("IT")
                .departmentAddress("Ahmedabad")
                .departmentCode("ITAHM04")
                .departmentId(1L).build();

        Mockito.when(deptRepo.findBydepartmentNameIgnoreCase("IT")).thenReturn(dept);
    }

    @Test
    @DisplayName("Get data based on valid department name")
//    @Disabled
    public void whenValidDepartmentName_thenDepartmentShouldBeFound(){
        String departmentName = "IT";
        Department found = deptService.fetchDepartmentByName(departmentName);
        assertEquals(departmentName, found.getDepartmentName());
    }
}