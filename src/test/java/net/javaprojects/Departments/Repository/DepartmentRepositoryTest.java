package net.javaprojects.Departments.Repository;

import net.javaprojects.Departments.Entity.Department;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class DepartmentRepositoryTest {

    @Autowired
    private DepartmentRepository deptRepo;

    @Autowired
    private TestEntityManager entityManager;

    @BeforeEach
    void setUp() {

        Department dept = Department.builder().departmentName("ME")
                .departmentAddress("Bangalore")
                .departmentCode("MEBLR07")
                .build();
        entityManager.persist(dept);
    }

    @Test
    public void whenFindById_thenReturnDepartment(){
        Department dept = deptRepo.findById(1L).get();
        assertEquals(dept.getDepartmentName(), "ME");
    }
}