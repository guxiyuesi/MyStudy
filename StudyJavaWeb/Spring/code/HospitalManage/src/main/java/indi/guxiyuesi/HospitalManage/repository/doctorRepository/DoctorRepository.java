package indi.guxiyuesi.HospitalManage.repository.doctorRepository;

import indi.guxiyuesi.HospitalManage.entity.doctor.Doctor;
import indi.guxiyuesi.HospitalManage.entity.doctor.MedicalRecord;
import indi.guxiyuesi.HospitalManage.entity.doctor.MedicalRecordAndDrug;
import indi.guxiyuesi.HospitalManage.entity.doctor.TempDoctor;
import indi.guxiyuesi.HospitalManage.entity.doctorAndPatient.DoctorAndPatient;
import indi.guxiyuesi.HospitalManage.entity.doctorAndPatient.IdPackage;
import indi.guxiyuesi.HospitalManage.entity.drug.Drug;
import indi.guxiyuesi.HospitalManage.entity.drug.TempDrug;
import indi.guxiyuesi.HospitalManage.entity.patient.Patient;
import indi.guxiyuesi.HospitalManage.entity.verification.Verification;

import java.util.List;

public interface DoctorRepository {
    public Doctor selectDoctorByIdAndP(Verification verification);

    public List<Doctor> selectAllDoctor();

    public Integer updateDoctorInfo(Doctor doctor);

    public Integer insertDoctor(Doctor doctor);

    Doctor selectDoctorById(String doctorId);

    DoctorAndPatient selectDoctorAndPatient(IdPackage idPackage);

    List<Drug> selectDrugsByDepartment(Integer departmentId);

    Integer insertIntoMedicalRecord(MedicalRecord medicalRecord);

    Long getMedicalRecordId();

    void insertIntoMedicalRecordAndDrug(MedicalRecordAndDrug medicalRecordAndDrug);

    void updateDrugNum(MedicalRecordAndDrug medicalRecordAndDrug);

    Integer updateDoctor(Doctor doctor);

    Integer getCurrentNumber(String doctorId);

    Long getPatientId(Integer doctorCurrentNumber);

    Patient getPatientByPatientId(Long patientId);

    TempDoctor getTempDoctor(String doctorId);

    void updateCurrentNumber(TempDoctor tempDoctor);
}
