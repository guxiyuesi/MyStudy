package indi.guxiyuesi.HospitalManage.service;

import indi.guxiyuesi.HospitalManage.entity.verification.Verification;
import indi.guxiyuesi.HospitalManage.myHandler.enterSystem.EnterSystem;
import indi.guxiyuesi.HospitalManage.repository.patientRepository.PatientRepository;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;

/**
 * @author 叶意
 * @ClassName AddPatientAccount
 * @Description 添加账号
 * @createTime 2021年11月25日  11:36:00
 */
public class AddAccount {
    private SqlSession sqlSession;

    public AddAccount() {
        //加载配置文件, 获取sqlSession
        InputStream inputStream = EnterSystem.class.getClassLoader().getResourceAsStream("config.xml");
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(inputStream);
        sqlSession = sqlSessionFactory.openSession();
    }

    public Integer addPatientAccount(Verification verification) {
        Integer row = 0;
        PatientRepository patientRepository = sqlSession.getMapper(PatientRepository.class);
        row = patientRepository.addAccount(verification);
        sqlSession.commit();
        sqlSession.close();
        return row;
    }
}
