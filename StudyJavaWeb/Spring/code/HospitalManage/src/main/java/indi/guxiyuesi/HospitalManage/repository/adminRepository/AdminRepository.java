package indi.guxiyuesi.HospitalManage.repository.adminRepository;

import indi.guxiyuesi.HospitalManage.entity.admin.Admin;
import indi.guxiyuesi.HospitalManage.entity.drug.Drug;
import indi.guxiyuesi.HospitalManage.entity.verification.Verification;

public interface AdminRepository {
    public Admin selectAdminByAccountAndP(Verification verification);

}
