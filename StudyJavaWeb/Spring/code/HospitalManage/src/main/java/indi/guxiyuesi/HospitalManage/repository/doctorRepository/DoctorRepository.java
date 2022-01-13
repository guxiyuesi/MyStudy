package indi.guxiyuesi.HospitalManage.repository.doctorRepository;

import indi.guxiyuesi.HospitalManage.entity.doctor.Doctor;
import indi.guxiyuesi.HospitalManage.entity.verification.Verification;

import java.util.List;

public interface DoctorRepository {
    public Doctor selectDoctorByIdAndP(Verification verification);

    public List<Doctor> selectAllDoctor();

    public Integer updateDoctorInfo(Doctor doctor);

    public Integer insertDoctor(Doctor doctor);
}
