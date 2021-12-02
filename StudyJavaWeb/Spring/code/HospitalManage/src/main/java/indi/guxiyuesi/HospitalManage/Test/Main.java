package indi.guxiyuesi.HospitalManage.Test;

import indi.guxiyuesi.HospitalManage.entity.doctor.Doctor;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;

/**
 * @author 叶意
 * @ClassName Main
 * @Description TODO
 * @createTime 2021年11月21日  15:34:00
 */
public class Main {
    public static void main(String[] args) {
        //加载MyBatis配置文件
        InputStream inputStream = Main.class.getClassLoader().getResourceAsStream("config.xml");
        //MyBatis是通过sqlSession来完成的, 因此要获取sqlSession
        //首先new一个SqlSessionFactoryBuilder
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        //通过sqlSessionFactoryBuilder获取一个sqlSessionFactory
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(inputStream);
        //通过sqlSessionFactory获取sqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //调用myBatis的原生接口执行sql语句
        //找到sql语句
        String statement = "indi.guxiyuesi.HospitalManage.mapper.DoctorMapper.findById";
        //执行sql语句, 并将结果集赋值给POJO
        Doctor doctor = sqlSession.selectOne(statement, "1");
        System.out.println(doctor);



    }
}
