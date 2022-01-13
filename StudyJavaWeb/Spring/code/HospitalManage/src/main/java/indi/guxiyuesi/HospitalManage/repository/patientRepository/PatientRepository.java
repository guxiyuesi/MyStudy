package indi.guxiyuesi.HospitalManage.repository.patientRepository;

import indi.guxiyuesi.HospitalManage.entity.doctor.DoctorForPatient;
import indi.guxiyuesi.HospitalManage.entity.doctor.MedicalRecord;
import indi.guxiyuesi.HospitalManage.entity.doctorAndPatient.DoctorAndPatient;
import indi.guxiyuesi.HospitalManage.entity.drug.Drug;
import indi.guxiyuesi.HospitalManage.entity.patient.Patient;
import indi.guxiyuesi.HospitalManage.entity.patient.Record;
import indi.guxiyuesi.HospitalManage.entity.verification.Verification;
import indi.guxiyuesi.HospitalManage.entity.patient.Registration;

import java.util.List;

public interface PatientRepository {
    public Patient selectPatientByAccountAndP(Verification verification);
    public Integer addAccount(Verification verification);
    public Patient selectPatientByIDNumber(String patientIDNumber);
    public Integer updatePatient(Patient patient);
    public Patient selectPatientForDoctor(String doctorId);
    Patient getPatientInfo(Long patientId);
    void updatePatientInfo(Patient patient);
    List<DoctorForPatient> getDoctorByDepartment(String departmentName);
    Integer getRegistrationNumber(String doctorId);
    void registration(Registration registration);
    List<DoctorAndPatient> getRegistrationInfo(Long patientId);
    List<MedicalRecord> getMedicalRecords(Long patientId);
    Record getRecord(Long medicalRecordId);
    List<Drug> getDrugs(Long medicalRecordId);
}
