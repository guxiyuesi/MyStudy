package indi.guxiyuesi.HospitalManage.myHandler.patientHandler;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import indi.guxiyuesi.HospitalManage.entity.Utils.MyUtils;
import indi.guxiyuesi.HospitalManage.entity.department.Departments;
import indi.guxiyuesi.HospitalManage.entity.doctor.DoctorForPatient;
import indi.guxiyuesi.HospitalManage.entity.doctor.MedicalRecord;
import indi.guxiyuesi.HospitalManage.entity.doctorAndPatient.DoctorAndPatient;
import indi.guxiyuesi.HospitalManage.entity.drug.Drug;
import indi.guxiyuesi.HospitalManage.entity.patient.Patient;
import indi.guxiyuesi.HospitalManage.entity.patient.Record;
import indi.guxiyuesi.HospitalManage.entity.patient.Registration;
import indi.guxiyuesi.HospitalManage.service.GetInformation;
import indi.guxiyuesi.HospitalManage.service.ModifyInformation;
import lombok.Data;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author 叶意
 * @ClassName patientHandler
 * @Description TODO
 * @createTime 2021年12月20日  04:53:00
 */

@Controller
@Data
@RequestMapping("/patient")
public class PatientHandler {
    private GetInformation getInformation;
    private ModifyInformation modifyInformation;

    public PatientHandler() {
        modifyInformation = new ModifyInformation();
        getInformation = new GetInformation();
    }

    @RequestMapping("/patientInfo")
    private void getPatientInfo(Long id, HttpServletResponse resp) throws IOException {
        System.out.println(id);
        Patient patient = getInformation.getPatientInfo(id);
        resp.setContentType("text/html;charset=UTF-8");
        resp.getWriter().write(JSON.toJSONString(patient));
    }

    @RequestMapping("/updatePatientInfo")
    private void updatePatientInfo(Patient patient, HttpServletResponse resp) throws IOException {
        modifyInformation.updatePatientInfo(patient);
    }

    @RequestMapping("/getDoctorsByDepartments")
    private void getDoctorsByDepartment(String departmentsString, HttpServletResponse resp) throws IOException {
        System.out.println(departmentsString);
        List<DoctorForPatient> doctors = new LinkedList<>();
        List<String> departments = JSONObject.parseArray(departmentsString, String.class);
        for (String department :
                departments) {
            doctors.addAll(getInformation.getDoctorByDepartment(department));
        }

        doctors = getDoctorsWorking(doctors);
        resp.setContentType("text/html;charset=UTF-8");
        resp.getWriter().write(JSON.toJSONString(doctors));
    }

    private List<DoctorForPatient> getDoctorsWorking(List<DoctorForPatient> doctors) {
        List<DoctorForPatient> temp = new LinkedList<>();
        String weekday = MyUtils.GetWeekday();
        for (DoctorForPatient doctor : doctors) {
            if(weekday.equals("Monday") && doctor.getMonday() == 1 ||
                weekday.equals("Tuesday") && doctor.getTuesday() == 1 ||
                weekday.equals("Wednesday") && doctor.getWednesday() == 1 ||
                weekday.equals("Thursday") && doctor.getThursday() == 1 ||
                weekday.equals("Friday") && doctor.getFriday() == 1 ||
                weekday.equals("Saturday") && doctor.getSaturday() == 1 ||
                weekday.equals("Sunday") && doctor.getSunday() == 1){
                synchronized (this) {
                    doctor.setRegistrationNumber(1);
                    doctor.setRegistrationNumber(getInformation.getRegistrationNumber(doctor.getDoctorId()));
                }
                temp.add(doctor);
            }
        }
        return temp;
    }

    @RequestMapping("/registration")
    public void registration(Registration registration, HttpServletResponse resp) {
        modifyInformation.registration(registration);
    }

    @RequestMapping("getRegistrationInfo")
    public void getRegistrationInfo(Long patientId, HttpServletResponse resp) throws IOException {
        List<DoctorAndPatient> doctors = getInformation.getRegistrationInfo(patientId);
        resp.setContentType("text/html;charset=UTF-8");
        resp.getWriter().write(JSON.toJSONString(doctors));
    }

    @RequestMapping("getMedicalRecords")
    public void getMedicalRecords(Long patientId, HttpServletResponse resp) throws IOException {
        List<MedicalRecord> medicalRecords = getInformation.getMedicalRecords(patientId);
        resp.setContentType("text/html;charset=UTF-8");
        resp.getWriter().write(JSON.toJSONString(medicalRecords));
    }

    @RequestMapping("/getRecord")
    private void getRecord(Long medicalRecordId, HttpServletResponse resp) throws IOException {
        Record record = getInformation.getRecord(medicalRecordId);
        resp.setContentType("text/html;charset=UTF-8");
        resp.getWriter().write(JSON.toJSONString(record));
    }

    @RequestMapping("/getDrugs")
    private void getDrugs(Long medicalRecordId, HttpServletResponse resp) throws IOException {
        List<Drug> drugs = getInformation.getDrugs(medicalRecordId);
        resp.setContentType("text/html;charset=utf-8");
        resp.getWriter().write(JSON.toJSONString(drugs));
    }
}
