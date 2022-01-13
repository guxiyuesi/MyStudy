package indi.guxiyuesi.HospitalManage.myHandler.doctorHandler;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import indi.guxiyuesi.HospitalManage.entity.doctor.Doctor;
import indi.guxiyuesi.HospitalManage.entity.doctor.MedicalRecord;
import indi.guxiyuesi.HospitalManage.entity.doctor.MedicalRecordAndDrug;
import indi.guxiyuesi.HospitalManage.entity.doctor.TempDoctor;
import indi.guxiyuesi.HospitalManage.entity.doctorAndPatient.DoctorAndPatient;
import indi.guxiyuesi.HospitalManage.entity.drug.Drug;
import indi.guxiyuesi.HospitalManage.entity.drug.Drugs;
import indi.guxiyuesi.HospitalManage.entity.drug.TempDrug;
import indi.guxiyuesi.HospitalManage.entity.patient.Patient;
import indi.guxiyuesi.HospitalManage.service.GetInformation;
import indi.guxiyuesi.HospitalManage.service.ModifyInformation;
import lombok.Data;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author 叶意
 * @ClassName DoctorHandler
 * @Description TODO
 * @createTime 2021年12月16日  05:18:00
 */
@Controller
@Data
@RequestMapping(value = "/doctor")
public class DoctorHandler {
    private GetInformation getInformation;
    private ModifyInformation modifyInformation;

    public DoctorHandler() {
        modifyInformation = new ModifyInformation();
        getInformation = new GetInformation();
    }

    @RequestMapping("/doctorById")
    private void selectDoctorById(String id, HttpServletResponse resp) throws IOException {
        System.out.println(id);
        Doctor doctor = getInformation.getDoctorById(id);
        System.out.println(doctor);
        resp.setContentType("text/html;charset=UTF-8");
        String data = JSON.toJSONString(doctor);
        resp.getWriter().write(data);
    }

    @RequestMapping("/currentPatient")
    private void selectPatientForDoctor(String id, HttpServletResponse resp) throws IOException {
        Patient patient = getInformation.selectPatientForDoctor(id);
        resp.setContentType("text/html;charset=UTF-8");
        String data = JSON.toJSONString(patient);
        resp.getWriter().write(data);
    }

    @RequestMapping("/doctorAndPatient")
    private void selectDoctorAndPatient(String theDoctorId, Integer thePatientId, HttpServletResponse resp) throws IOException {
        System.out.println(theDoctorId + "      " + thePatientId);
        DoctorAndPatient doctorAndPatient = getInformation.selectDoctorAndPatient(theDoctorId, thePatientId);
        resp.setContentType("text/html;charset=UTF-8");
        String data = JSON.toJSONString(doctorAndPatient);
        resp.getWriter().write(data);
    }

    @RequestMapping("/getDrugsByDepartmentId")
    private void getDrugs(Integer theDepartmentId, HttpServletResponse resp) throws IOException {
        List<Drug> drugs = getInformation.selectDrugsByDepartment(theDepartmentId);
        resp.setContentType("text/html;charset=UTF-8");
        String data = JSON.toJSONString(drugs);
        resp.getWriter().write(data);
    }

    @RequestMapping("/writeRecord")
    private void writeRecord(MedicalRecord medicalRecord, String tempDrugs, HttpServletResponse resp) throws IOException {
        synchronized (this) {
            //System.out.println(tempDrugs);
            List<TempDrug> drugs = JSONObject.parseArray(tempDrugs, TempDrug.class);
            modifyInformation.insertIntoMedicalRecord(medicalRecord);
            getInformation.getMedicalRecordId(medicalRecord);
            for (TempDrug tempDrug : drugs) {
                //System.out.println(tempDrug);
                MedicalRecordAndDrug medicalRecordAndDrug = new MedicalRecordAndDrug(Long.parseLong(tempDrug.getTheDrugId()), medicalRecord.getMedicalRecordId(), Integer.parseInt(tempDrug.getTheDrugNumber()));
                modifyInformation.insertIntoMedicalRecordAndDrug(medicalRecordAndDrug);
                modifyInformation.updateDrugNum(medicalRecordAndDrug);
            }
            resp.setContentType("text/html;charset=UTF-8");
            resp.getWriter().write("success");
        }
    }

    @RequestMapping("/updateDoctor")
    private void updateDoctorSelf(Doctor doctor, HttpServletResponse resp) throws IOException {
        System.out.println(doctor);
        Integer row = modifyInformation.updateDoctorSelf(doctor);
        resp.setContentType("text/html;charset=UTF-8");
        resp.getWriter().write(String.valueOf(row));
    }

    @RequestMapping("/getCurrentNumber")
    private void getCurrentNumber(String doctorId, HttpServletResponse resp) throws IOException {
        Integer currentNumber = getInformation.getCurrentNumber(doctorId);
        resp.setContentType("text/html;charset=UTF-8");
        resp.getWriter().write(String.valueOf(currentNumber));
    }

    @RequestMapping("/getPatientId")
    private void getPatientId(Integer doctorCurrentNumber, HttpServletResponse resp) throws IOException {
        Long patientId = getInformation.getPatientId(doctorCurrentNumber);
        resp.setContentType("text/html;charset=UTF-8");
        resp.getWriter().write(String.valueOf(patientId));
    }

    @RequestMapping("/getPatientByPatientId")
    private void getPatientByPatientId(Long patientId, HttpServletResponse resp) throws IOException {
        Patient patient = getInformation.getPatientByPatientId(patientId);
        resp.setContentType("text/html;charset=UTF-8");
        resp.getWriter().write(JSON.toJSONString(patient));
    }

    @RequestMapping("/updateCurrentNumber")
    private void updateCurrentNumber(String doctorId, HttpServletResponse resp) throws IOException {
        TempDoctor tempDoctor = getInformation.getTempDoctor(doctorId);
        tempDoctor.setDoctorCurrentNumber(tempDoctor.getDoctorCurrentNumber() + 1);
        modifyInformation.updateCurrentNumber(tempDoctor);
    }
}
