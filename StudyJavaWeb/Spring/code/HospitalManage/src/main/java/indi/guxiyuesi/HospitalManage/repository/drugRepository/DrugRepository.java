package indi.guxiyuesi.HospitalManage.repository.drugRepository;

import indi.guxiyuesi.HospitalManage.entity.department.Department;
import indi.guxiyuesi.HospitalManage.entity.department.DrugAndDepartment;
import indi.guxiyuesi.HospitalManage.entity.drug.DepartmentForDrug;
import indi.guxiyuesi.HospitalManage.entity.drug.Drug;

import java.util.List;

public interface DrugRepository {
    List<Drug> selectAllDrugs();
    List<String> selectDepartmentsForDrug(Long drugId);
    List<Department> selectAllDepartments();
    Integer updateDrug(Drug drug);
    void insertDrugAndDepartment(DrugAndDepartment drugAndDepartment);
    void deleteDrugAndDepartment(DrugAndDepartment drugAndDepartment);
}
