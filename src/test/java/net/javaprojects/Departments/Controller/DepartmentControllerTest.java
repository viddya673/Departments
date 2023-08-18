package net.javaprojects.Departments.Controller;

import lombok.SneakyThrows;
import net.javaprojects.Departments.Entity.Department;
import net.javaprojects.Departments.Error.DepartmentNotFoundException;
import net.javaprojects.Departments.Service.DepartmentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(DepartmentController.class)
class DepartmentControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private DepartmentService deptService;

    private Department dept;

    @BeforeEach
    void setUp() {
        dept = Department.builder()
                .departmentName("ECE")
                .departmentAddress("Chennai")
                .departmentCode("CECHE34")
                .build();
    }

    @SneakyThrows
    @Test
    void saveDepartment() {
        Department inputDept = Department.builder()
                .departmentName("ECE")
                .departmentAddress("Chennai")
                .departmentCode("CECHE34")
                .departmentId(1L)
                .build();

        Mockito.when(deptService.saveDepartment(inputDept))
                .thenReturn(dept);

        mockMvc.perform(post("/departments/add")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\n" +
                        "    \"departmentName\": \"ECE\",\n" +
                        "    \"departmentAddress\": \"Chennai\",\n" +
                        "    \"departmentCode\": \"CECHE34\"\n" +
                        "}")).andExpect(status().isOk());
    }

    @Test
    void fetchDepartmentById() throws Exception {
        Mockito.when(deptService.fetchDepartmentbyId(1L))
                .thenReturn(dept);
        mockMvc.perform(get("/departments/get/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.departmentName").value(dept.getDepartmentName()));
    }
}