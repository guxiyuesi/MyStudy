package indi.guxiyuesi.HospitalManage.myHandler.adminHandler;

import com.alibaba.fastjson.JSON;
import indi.guxiyuesi.HospitalManage.entity.doctor.Doctor;
import indi.guxiyuesi.HospitalManage.entity.drug.Drug;
import indi.guxiyuesi.HospitalManage.entity.patient.Patient;
import indi.guxiyuesi.HospitalManage.service.GetInformation;
import lombok.Data;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

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
    public AdminHandler() {
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

    @RequestMapping(value = "/patient", params = {"patientIdNumber"})
    public void getPatientByIdNumber(String patientIdNumber, HttpServletResponse resp) throws IOException {
        Patient patient = getInformation.getPatientByIdNumber(patientIdNumber);
        String data = patient == null ? "select false":JSON.toJSONString(patient);
        resp.setContentType("text/html;charset=UTF-8");
        resp.getWriter().write(data);
    }

}
