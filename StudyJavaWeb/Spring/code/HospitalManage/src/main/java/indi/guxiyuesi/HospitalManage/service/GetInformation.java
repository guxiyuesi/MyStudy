package indi.guxiyuesi.HospitalManage.service;

import indi.guxiyuesi.HospitalManage.entity.admin.Admin;
import indi.guxiyuesi.HospitalManage.entity.doctor.Doctor;
import indi.guxiyuesi.HospitalManage.entity.drug.Drug;
import indi.guxiyuesi.HospitalManage.entity.patient.Patient;
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

    public GetInformation() {
        //加载配置文件, 获取sqlSession
        InputStream inputStream = EnterSystem.class.getClassLoader().getResourceAsStream("config.xml");
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(inputStream);
        sqlSession = sqlSessionFactory.openSession();
    }

    public Doctor getDoctor(Verification verification) {
        DoctorRepository doctorRepository = sqlSession.getMapper(DoctorRepository.class);
        Doctor doctor = doctorRepository.selectDoctorByIdAndP(verification);
        return doctor;
    }

    public Patient getPatient(Verification verification) {
        PatientRepository patientRepository = sqlSession.getMapper(PatientRepository.class);
        Patient patient = patientRepository.selectPatientByAccountAndP(verification);
        return patient;
    }

    public Admin getAdmin(Verification verification) {
        AdminRepository adminRepository = sqlSession.getMapper(AdminRepository.class);
        Admin admin = adminRepository.selectAdminByAccountAndP(verification);
        return admin;
    }

    public List<Doctor> getAllDoctors() {
        DoctorRepository doctorRepository = sqlSession.getMapper(DoctorRepository.class);
        List<Doctor> doctors = doctorRepository.selectAllDoctor();
        return doctors;
    }

    public List<Drug> getAllDrugs() {
        DrugRepository drugRepository = sqlSession.getMapper(DrugRepository.class);
        List<Drug> drugs = drugRepository.selectAllDrugs();
        return drugs;
    }

    public Patient getPatientByIdNumber(String patientIdNumber) {
        PatientRepository patientRepository = sqlSession.getMapper(PatientRepository.class);
        Patient patient = patientRepository.selectPatientByIdNumber(patientIdNumber);
        return patient;
    }
}
