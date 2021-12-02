package indi.guxiyuesi.HospitalManage.repository.patientRepository;

import indi.guxiyuesi.HospitalManage.entity.patient.Patient;
import indi.guxiyuesi.HospitalManage.entity.verification.Verification;

public interface PatientRepository {
    public Patient selectPatientByAccountAndP(Verification verification);
    public Integer addAccount(Verification verification);
    public Patient selectPatientByIdNumber(String patientIdNumber);
}
