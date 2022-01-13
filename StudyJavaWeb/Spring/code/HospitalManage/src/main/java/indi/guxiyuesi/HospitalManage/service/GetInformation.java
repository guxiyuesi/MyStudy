package indi.guxiyuesi.HospitalManage.service;

import indi.guxiyuesi.HospitalManage.entity.admin.Admin;
import indi.guxiyuesi.HospitalManage.entity.department.Department;
import indi.guxiyuesi.HospitalManage.entity.doctor.Doctor;
import indi.guxiyuesi.HospitalManage.entity.doctor.DoctorForPatient;
import indi.guxiyuesi.HospitalManage.entity.doctor.MedicalRecord;
import indi.guxiyuesi.HospitalManage.entity.doctor.TempDoctor;
import indi.guxiyuesi.HospitalManage.entity.doctorAndPatient.DoctorAndPatient;
import indi.guxiyuesi.HospitalManage.entity.doctorAndPatient.IdPackage;
import indi.guxiyuesi.HospitalManage.entity.drug.DepartmentForDrug;
import indi.guxiyuesi.HospitalManage.entity.drug.Drug;
import indi.guxiyuesi.HospitalManage.entity.patient.Patient;
import indi.guxiyuesi.HospitalManage.entity.patient.Record;
import indi.guxiyuesi.HospitalManage.entity.verification.Verification;
import indi.guxiyuesi.HospitalManage.myHandler.enterSystem.EnterSystem;
import indi.guxiyuesi.HospitalManage.repository.adminRepository.AdminRepository;
import indi.guxiyuesi.HospitalManage.repository.doctorRepository.DoctorRepository;
import indi.guxiyuesi.HospitalManage.repository.drugRepository.DrugRepository;
import indi.guxiyuesi.HospitalManage.repository.patientRepository.PatientRepository;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.print.Doc;
import java.io.InputStream;
import java.util.List;

/**
 * @author 叶意
 * @ClassName GetInformation
 * @Description service层, 获取医生, 病人, 管理员对象
 * @createTime 2021年11月25日  11:07:00
 */
@Service
public class GetInformation {
    private SqlSession sqlSession;
    private SqlSessionFactory sqlSessionFactory;

    public GetInformation() {
        //加载配置文件, 获取sqlSession
        InputStream inputStream = EnterSystem.class.getClassLoader().getResourceAsStream("config.xml");
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        sqlSessionFactory = sqlSessionFactoryBuilder.build(inputStream);
    }

    public Doctor getDoctor(Verification verification) {
        sqlSession = sqlSessionFactory.openSession();
        DoctorRepository doctorRepository = sqlSession.getMapper(DoctorRepository.class);
        Doctor doctor = doctorRepository.selectDoctorByIdAndP(verification);
        sqlSession.close();
        return doctor;
    }

    public Patient getPatient(Verification verification) {
        sqlSession = sqlSessionFactory.openSession();
        PatientRepository patientRepository = sqlSession.getMapper(PatientRepository.class);
        Patient patient = patientRepository.selectPatientByAccountAndP(verification);
        sqlSession.close();
        return patient;
    }

    public Admin getAdmin(Verification verification) {
        sqlSession = sqlSessionFactory.openSession();
        AdminRepository adminRepository = sqlSession.getMapper(AdminRepository.class);
        Admin admin = adminRepository.selectAdminByAccountAndP(verification);
        sqlSession.close();
        return admin;
    }

    public List<Doctor> getAllDoctors() {
        sqlSession = sqlSessionFactory.openSession();
        DoctorRepository doctorRepository = sqlSession.getMapper(DoctorRepository.class);
        List<Doctor> doctors = doctorRepository.selectAllDoctor();
        sqlSession.close();
        return doctors;
    }

    public List<Drug> getAllDrugs() {
        sqlSession = sqlSessionFactory.openSession();
        DrugRepository drugRepository = sqlSession.getMapper(DrugRepository.class);
        List<Drug> drugs = drugRepository.selectAllDrugs();
        sqlSession.close();
        return drugs;
    }

    public List<String> getDepartmentsForDrug(Long drugId) {
        sqlSession = sqlSessionFactory.openSession();
        DrugRepository drugRepository = sqlSession.getMapper(DrugRepository.class);
        List<String> departmentsName = drugRepository.selectDepartmentsForDrug(drugId);
        sqlSession.close();
        return departmentsName;
    }



    public Admin getAdminById(String administratorId) {
        sqlSession = sqlSessionFactory.openSession();
        AdminRepository adminRepository = sqlSession.getMapper(AdminRepository.class);
        Admin admin = adminRepository.selectAdminById(administratorId);
        sqlSession.close();
        return admin;
    }

    public Patient getPatientByIDNumber(String patientIDNumber) {
        sqlSession = sqlSessionFactory.openSession();
        PatientRepository patientRepository = sqlSession.getMapper(PatientRepository.class);
        Patient patient = patientRepository.selectPatientByIDNumber(patientIDNumber);
        sqlSession.close();
        return patient;
    }

    public List<Department> getAllDepartments() {
        sqlSession = sqlSessionFactory.openSession();
        DrugRepository drugRepository = sqlSession.getMapper(DrugRepository.class);
        List<Department> departments = drugRepository.selectAllDepartments();
        sqlSession.close();
        return departments;
    }

    public Doctor getDoctorById(String doctorId) {
        sqlSession = sqlSessionFactory.openSession();
        DoctorRepository doctorRepository = sqlSession.getMapper(DoctorRepository.class);
        Doctor doctor = doctorRepository.selectDoctorById(doctorId);
        sqlSession.close();
        return doctor;
    }

    public Patient selectPatientForDoctor(String doctorId) {
        sqlSession = sqlSessionFactory.openSession();
        PatientRepository patientRepository = sqlSession.getMapper(PatientRepository.class);
        Patient patient = patientRepository.selectPatientForDoctor(doctorId);
        sqlSession.close();
        return patient;
    }

    public Patient getPatientByPatientId(Long patientId) {
        sqlSession = sqlSessionFactory.openSession();
        DoctorRepository doctorRepository = sqlSession.getMapper(DoctorRepository.class);
        Patient patient = doctorRepository.getPatientByPatientId(patientId);
        sqlSession.close();
        return patient;
    }

    public DoctorAndPatient selectDoctorAndPatient(String doctorId, Integer patientId) {
        IdPackage idPackage = new IdPackage(doctorId, patientId);
        sqlSession = sqlSessionFactory.openSession();
        DoctorRepository doctorRepository = sqlSession.getMapper(DoctorRepository.class);
        DoctorAndPatient doctorAndPatient = doctorRepository.selectDoctorAndPatient(idPackage);
        sqlSession.close();
        return doctorAndPatient;
    }

    public List<Drug> selectDrugsByDepartment(Integer departmentId) {
        sqlSession = sqlSessionFactory.openSession();
        DoctorRepository doctorRepository = sqlSession.getMapper(DoctorRepository.class);
        List<Drug> drugs = doctorRepository.selectDrugsByDepartment(departmentId);
        sqlSession.close();
        return drugs;
    }

    public void getMedicalRecordId(MedicalRecord medicalRecord) {
        sqlSession = sqlSessionFactory.openSession();
        DoctorRepository doctorRepository = sqlSession.getMapper(DoctorRepository.class);
        medicalRecord.setMedicalRecordId(doctorRepository.getMedicalRecordId());
        sqlSession.close();
    }

    public Integer getCurrentNumber(String doctorId) {
        sqlSession = sqlSessionFactory.openSession();
        DoctorRepository doctorRepository = sqlSession.getMapper(DoctorRepository.class);
        Integer currentNumber = doctorRepository.getCurrentNumber(doctorId);
        sqlSession.close();
        return currentNumber;
    }

    public Long getPatientId(Integer doctorCurrentNumber) {
        sqlSession = sqlSessionFactory.openSession();
        DoctorRepository doctorRepository = sqlSession.getMapper(DoctorRepository.class);
        Long patientId = doctorRepository.getPatientId(doctorCurrentNumber);
        sqlSession.close();
        return patientId;
    }

    public TempDoctor getTempDoctor(String doctorId) {
        sqlSession = sqlSessionFactory.openSession();
        DoctorRepository doctorRepository = sqlSession.getMapper(DoctorRepository.class);
        TempDoctor tempDoctor = doctorRepository.getTempDoctor(doctorId);
        sqlSession.close();
        return tempDoctor;
    }

    public Patient getPatientInfo(Long patientId) {
        sqlSession = sqlSessionFactory.openSession();
        PatientRepository patientRepository = sqlSession.getMapper(PatientRepository.class);
        Patient patient = patientRepository.getPatientInfo(patientId);
        sqlSession.close();
        return patient;
    }

    public List<DoctorForPatient> getDoctorByDepartment(String departmentName) {
        sqlSession = sqlSessionFactory.openSession();
        PatientRepository patientRepository = sqlSession.getMapper(PatientRepository.class);
        List<DoctorForPatient> doctors = patientRepository.getDoctorByDepartment(departmentName);
        sqlSession.close();
        return doctors;
    }

    public Integer getRegistrationNumber(String doctorId) {
        sqlSession = sqlSessionFactory.openSession();
        PatientRepository patientRepository = sqlSession.getMapper(PatientRepository.class);
        Integer registration = 1;
        try {
            registration = patientRepository.getRegistrationNumber(doctorId) + 1;
        }catch (Exception e) {
        }
        sqlSession.close();
        return registration;
    }

    public List<DoctorAndPatient> getRegistrationInfo(Long patientId) {
        sqlSession = sqlSessionFactory.openSession();
        PatientRepository patientRepository = sqlSession.getMapper(PatientRepository.class);
        List<DoctorAndPatient> doctors =  patientRepository.getRegistrationInfo(patientId);
        sqlSession.close();
        return doctors;
    }

    public List<MedicalRecord> getMedicalRecords(Long patientId) {
        sqlSession = sqlSessionFactory.openSession();
        PatientRepository patientRepository = sqlSession.getMapper(PatientRepository.class);
        List<MedicalRecord> medicalRecords = patientRepository.getMedicalRecords(patientId);
        sqlSession.close();
        return medicalRecords;
    }

    public Record getRecord(Long medicalRecordId) {
        sqlSession = sqlSessionFactory.openSession();
        PatientRepository patientRepository = sqlSession.getMapper(PatientRepository.class);
        Record record = patientRepository.getRecord(medicalRecordId);
        sqlSession.close();
        return record;
    }

    public List<Drug> getDrugs(Long medicalRecordId) {
        sqlSession = sqlSessionFactory.openSession();
        PatientRepository patientRepository = sqlSession.getMapper(PatientRepository.class);
        List<Drug> drugs = patientRepository.getDrugs(medicalRecordId);
        sqlSession.close();
        return drugs;
    }
}
