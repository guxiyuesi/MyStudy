package indi.guxiyuesi.HospitalManage.myHandler.adminHandler;

import com.alibaba.fastjson.JSON;
import indi.guxiyuesi.HospitalManage.entity.admin.Admin;
import indi.guxiyuesi.HospitalManage.entity.department.Department;
import indi.guxiyuesi.HospitalManage.entity.doctor.Doctor;
import indi.guxiyuesi.HospitalManage.entity.drug.Drug;
import indi.guxiyuesi.HospitalManage.entity.patient.Patient;
import indi.guxiyuesi.HospitalManage.service.GetInformation;
import indi.guxiyuesi.HospitalManage.service.ModifyInformation;
import lombok.Data;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author 叶意
 * @ClassName AdminHandler
 * @Description 管理员Handler
 * @createTime 2021年11月29日  18:43:00
 */

@Controller
@Data
@RequestMapping(value = "/admin")
public class AdminHandler {
    private GetInformation getInformation;
    private ModifyInformation modifyInformation;
    public AdminHandler() {
        modifyInformation = new ModifyInformation();
        getInformation = new GetInformation();
    }

    @RequestMapping(value = "/drugs")
    public void getDrugs(HttpServletResponse resp) throws IOException {
        List<Drug> drugs = getInformation.getAllDrugs();
        resp.setContentType("text/html;charset=UTF-8");
        String data = JSON.toJSONString(drugs);
        resp.getWriter().write(data);
    }

    @RequestMapping("/doctors")
    public void getDoctors(HttpServletResponse resp) throws IOException {
        List<Doctor> doctors =getInformation.getAllDoctors();
        String data = JSON.toJSONString(doctors);
        resp.setContentType("text/html;charset=UTF-8");
        resp.getWriter().write(data);
    }



    @RequestMapping(value = "/adminById", params = "id")
    public void getAdminById(String id, HttpServletResponse resp) throws IOException {
        System.out.println(id);
        Admin admin = getInformation.getAdminById(id);
        String data = JSON.toJSONString(admin);
        resp.setContentType("text/html;charset=UTF-8");
        resp.getWriter().write(data);
    }

    @RequestMapping(value = "/update")
    public void updateAdmin(Admin admin, HttpServletResponse resp) throws IOException {
        Integer rows = modifyInformation.updateAdmin(admin);
        resp.setContentType("text/html;charset=UTF-8");
        resp.getWriter().write(String.valueOf(rows));
    }

    @RequestMapping(value = "/updateDoctor")
    public void updateDoctor(Doctor doctor, HttpServletResponse resp) throws IOException {
        System.out.println(doctor);
        Integer rows = modifyInformation.updateDoctor(doctor);
        resp.setContentType("text/html;charset=UTF-8");
        resp.getWriter().write(String.valueOf(rows));
    }

    @RequestMapping(value = "/addDoctor")
    public void addDoctor(Doctor doctor, HttpServletResponse resp) throws IOException {
        Integer rows = modifyInformation.addDoctor(doctor);
        resp.setContentType("text/html;charset=UTF-8");
        resp.getWriter().write(String.valueOf(rows));
    }

    @RequestMapping(value = "/selectPatientByIDNumber")
    public void addDoctor(String patientIDNumber, HttpServletResponse resp) throws IOException {
        System.out.println(patientIDNumber);
        Patient patient = getInformation.getPatientByIDNumber(patientIDNumber);
        resp.setContentType("text/html;charset=UTF-8");
        resp.getWriter().write(JSON.toJSONString(patient));
    }

    @RequestMapping(value = "/updatePatient")
    public void updateDoctor(Patient patient, HttpServletResponse resp) throws IOException {
        Integer rows = modifyInformation.updatePatient(patient);
        resp.setContentType("text/html;charset=UTF-8");
        resp.getWriter().write(String.valueOf(rows));
    }

    @RequestMapping(value = "/departmentsForDrug")
    public void selectDepartmentsForDrug(Long drugId, HttpServletResponse resp) throws IOException {
        List<String> departments = getInformation.getDepartmentsForDrug(drugId);
        resp.setContentType("text/html;charset=UTF-8");
        resp.getWriter().write(JSON.toJSONString(departments));
    }

    @RequestMapping("/insertDrugs")
    public void insertDrugs(Drug drug) {
        modifyInformation.insertDrugs(drug);
    }

    @RequestMapping("/updateDrug")
    public void test(Drug drug,String departments , HttpServletResponse response) {
        Integer rows = modifyInformation.updateDrug(drug);
        Map toModifyDepartments = JSON.parseObject(departments, Map.class);
        List<Department> departmentList = getInformation.getAllDepartments();
        Map<String, Integer> departmentMap = departmentList.stream().collect(Collectors.toMap(Department::getDepartmentName, Department::getDepartmentId));
        for (Object key: toModifyDepartments.keySet()) {
            if((Boolean) toModifyDepartments.get(key)) {
                //添加记录
                modifyInformation.insertDrugAndDepartment(departmentMap.get(key), drug.getDrugId());
            } else {
                modifyInformation.deleteDrugAndDepartment(departmentMap.get(key), drug.getDrugId());
            }
        }
    }

    @RequestMapping("/deleteDrug")
    public void deleteDrug(Long drugId) {
        modifyInformation.deleteDrug(drugId);
    }
}
