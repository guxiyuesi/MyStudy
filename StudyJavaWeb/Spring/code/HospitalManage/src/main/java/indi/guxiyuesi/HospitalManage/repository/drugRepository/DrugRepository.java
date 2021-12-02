package indi.guxiyuesi.HospitalManage.repository.drugRepository;

import indi.guxiyuesi.HospitalManage.entity.drug.Drug;

import java.util.List;

public interface DrugRepository {
    List<Drug> selectAllDrugs();
}
