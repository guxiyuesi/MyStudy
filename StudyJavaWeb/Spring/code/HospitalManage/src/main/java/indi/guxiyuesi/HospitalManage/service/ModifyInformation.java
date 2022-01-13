package indi.guxiyuesi.HospitalManage.service;

import indi.guxiyuesi.HospitalManage.entity.admin.Admin;
import indi.guxiyuesi.HospitalManage.entity.department.DrugAndDepartment;
import indi.guxiyuesi.HospitalManage.entity.doctor.Doctor;
import indi.guxiyuesi.HospitalManage.entity.doctor.MedicalRecord;
import indi.guxiyuesi.HospitalManage.entity.doctor.MedicalRecordAndDrug;
import indi.guxiyuesi.HospitalManage.entity.doctor.TempDoctor;
import indi.guxiyuesi.HospitalManage.entity.doctorAndPatient.IdPackage;
import indi.guxiyuesi.HospitalManage.entity.drug.Drug;
import indi.guxiyuesi.HospitalManage.entity.patient.Patient;
import indi.guxiyuesi.HospitalManage.entity.patient.Registration;
import indi.guxiyuesi.HospitalManage.myHandler.enterSystem.EnterSystem;
import indi.guxiyuesi.HospitalManage.repository.adminRepository.AdminRepository;
import indi.guxiyuesi.HospitalManage.repository.doctorRepository.DoctorRepository;
import indi.guxiyuesi.HospitalManage.repository.drugRepository.DrugRepository;
import indi.guxiyuesi.HospitalManage.repository.patientRepository.PatientRepository;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.stereotype.Service;

import javax.print.Doc;
import java.io.InputStream;

/**
 * @author 叶意
 * @ClassName ModifyInformation
 * @Description TODO
 * @createTime 2021年12月14日  12:24:00
 */
@Service
public class ModifyInformation {
    private SqlSession sqlSession;
    private SqlSessionFactory sqlSessionFactory;

    public ModifyInformation() {
        //加载配置文件, 获取sqlSession
        InputStream inputStream = EnterSystem.class.getClassLoader().getResourceAsStream("config.xml");
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        sqlSessionFactory = sqlSessionFactoryBuilder.build(inputStream);
    }

    public Integer updateAdmin(Admin admin) {
        sqlSession = sqlSessionFactory.openSession();
        AdminRepository adminRepository = sqlSession.getMapper(AdminRepository.class);
        Integer rows = adminRepository.updateAdmin(admin);
        sqlSession.commit();
        sqlSession.close();
        return rows;
    }

    public Integer updateDoctor(Doctor doctor) {
        sqlSession = sqlSessionFactory.openSession();
        DoctorRepository doctorRepository = sqlSession.getMapper(DoctorRepository.class);
        Integer rows = doctorRepository.updateDoctorInfo(doctor);
        sqlSession.commit();
        sqlSession.close();
        return rows;
    }

    public Integer addDoctor(Doctor doctor) {
        sqlSession = sqlSessionFactory.openSession();
        DoctorRepository doctorRepository = sqlSession.getMapper(DoctorRepository.class);
        Integer rows = doctorRepository.insertDoctor(doctor);
        sqlSession.commit();
        sqlSession.close();
        return rows;
    }

    public Integer updatePatient(Patient patient) {
        sqlSession = sqlSessionFactory.openSession();
        PatientRepository patientRepository = sqlSession.getMapper(PatientRepository.class);
        Integer rows = patientRepository.updatePatient(patient);
        sqlSession.commit();
        sqlSession.close();
        return rows;
    }

    public Integer updateDrug(Drug drug) {
        sqlSession = sqlSessionFactory.openSession();
        DrugRepository drugRepository = sqlSession.getMapper(DrugRepository.class);
        Integer rows = drugRepository.updateDrug(drug);
        sqlSession.commit();
        sqlSession.close();
        return rows;
    }

    public void insertDrugAndDepartment(Integer departmentId, Long drugId) {
        DrugAndDepartment drugAndDepartment = new DrugAndDepartment(departmentId, drugId);
        sqlSession = sqlSessionFactory.openSession();
        DrugRepository drugRepository = sqlSession.getMapper(DrugRepository.class);
        drugRepository.insertDrugAndDepartment(drugAndDepartment);
        sqlSession.commit();
        sqlSession.close();
    }

    public void deleteDrugAndDepartment(Integer departmentId, Long drugId) {
        DrugAndDepartment drugAndDepartment = new DrugAndDepartment(departmentId, drugId);
        sqlSession = sqlSessionFactory.openSession();
        DrugRepository drugRepository = sqlSession.getMapper(DrugRepository.class);
        drugRepository.deleteDrugAndDepartment(drugAndDepartment);
        sqlSession.commit();
        sqlSession.close();
    }

    public Integer insertIntoMedicalRecord(MedicalRecord medicalRecord) {
        sqlSession = sqlSessionFactory.openSession();
        DoctorRepository doctorRepository = sqlSession.getMapper(DoctorRepository.class);
        Integer row = doctorRepository.insertIntoMedicalRecord(medicalRecord);
        sqlSession.commit();
        sqlSession.close();
        return row;
    }

    public void insertIntoMedicalRecordAndDrug(MedicalRecordAndDrug medicalRecordAndDrug) {
        sqlSession = sqlSessionFactory.openSession();
        DoctorRepository doctorRepository = sqlSession.getMapper(DoctorRepository.class);
        doctorRepository.insertIntoMedicalRecordAndDrug(medicalRecordAndDrug);
        sqlSession.commit();
        sqlSession.close();
    }

    public void updateDrugNum(MedicalRecordAndDrug medicalRecordAndDrug) {
        sqlSession = sqlSessionFactory.openSession();
        DoctorRepository doctorRepository = sqlSession.getMapper(DoctorRepository.class);
        doctorRepository.updateDrugNum(medicalRecordAndDrug);
        sqlSession.commit();
        sqlSession.close();
    }

    public Integer updateDoctorSelf (Doctor doctor) {
        sqlSession = sqlSessionFactory.openSession();
        System.out.println(doctor.getDoctorPhoneNumber());
        DoctorRepository doctorRepository = sqlSession.getMapper(DoctorRepository.class);
        Integer row = doctorRepository.updateDoctor(doctor);
        sqlSession.commit();
        sqlSession.close();
        return row;
    }
    public void updateCurrentNumber(TempDoctor tempDoctor) {
        sqlSession = sqlSessionFactory.openSession();
        DoctorRepository doctorRepository = sqlSession.getMapper(DoctorRepository.class);
        doctorRepository.updateCurrentNumber(tempDoctor);
        sqlSession.commit();
        sqlSession.close();
    }

    public void updatePatientInfo(Patient patient) {
        sqlSession = sqlSessionFactory.openSession();
        PatientRepository patientRepository = sqlSession.getMapper(PatientRepository.class);
        patientRepository.updatePatientInfo(patient);
        sqlSession.commit();
        sqlSession.close();
    }

    public void registration(Registration registration) {
        sqlSession = sqlSessionFactory.openSession();
        PatientRepository patientRepository = sqlSession.getMapper(PatientRepository.class);
        patientRepository.registration(registration);
        sqlSession.commit();
        sqlSession.close();
    }

    public void insertDrugs(Drug drug) {
        sqlSession = sqlSessionFactory.openSession();
        AdminRepository adminRepository = sqlSession.getMapper(AdminRepository.class);
        adminRepository.insertDrugs(drug);
        sqlSession.commit();
        sqlSession.close();
    }

    public void deleteDrug(Long drugId) {
        sqlSession = sqlSessionFactory.openSession();
        AdminRepository adminRepository = sqlSession.getMapper(AdminRepository.class);
        adminRepository.deleteDrug(drugId);
        sqlSession.commit();
        sqlSession.close();
    }

}
