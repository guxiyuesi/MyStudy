package indi.guxiyuesi.HospitalManage.myHandler.enterSystem;

import com.alibaba.fastjson.JSON;
import indi.guxiyuesi.HospitalManage.entity.admin.Admin;
import indi.guxiyuesi.HospitalManage.entity.doctor.Doctor;
import indi.guxiyuesi.HospitalManage.entity.patient.Patient;
import indi.guxiyuesi.HospitalManage.entity.verification.Verification;
import indi.guxiyuesi.HospitalManage.service.AddAccount;
import indi.guxiyuesi.HospitalManage.service.GetInformation;
import lombok.Data;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.print.Doc;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.*;
import java.io.IOException;
import java.util.List;

/**
 * @author 叶意
 * @ClassName EnterSystem
 * @Description 登录, 注册的Controller层
 * @createTime 2021年11月23日  10:16:00
 */

@Controller
@Data
@RequestMapping("/enterSystem")
public class EnterSystem {
    private Doctor doctor;
    private Patient patient;
    private Admin admin;
    private GetInformation getInformation;

    public EnterSystem() {
        getInformation = new GetInformation();
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST, params = {"account", "password", "radio"})
    public void login(Verification verification, HttpServletResponse resp, HttpSession httpSession) throws IOException {
        String data = "";
        switch (verification.getRadio()) {
            case "doctor":
                doctor = getInformation.getDoctor(verification);
                httpSession.setAttribute("doctor", doctor);
                data = doctor == null ? "" : "";
                break;
            case "patient":
                patient = getInformation.getPatient(verification);
                httpSession.setAttribute("patient", patient);
                data = patient == null ? "":"";
                break;
            case "admin":
                admin = getInformation.getAdmin(verification);
                httpSession.setAttribute("admin", admin);
                data = admin == null ? "":"adminPattern.jsp";
                break;
        }

        if (data.equals("")) {
            data = "login false";
        }
        System.out.println(data);
        resp.setContentType("text/html;charset=UTF-8");
        resp.getWriter().write(data);
    }

    @RequestMapping(value = "/signUp", method = RequestMethod.POST, params = {"account", "password", "radio"})
    public void signUp(Verification verification, HttpServletResponse resp) throws IOException {
        String data = "";
        int row = 0;
        patient = getInformation.getPatient(verification);
        if (patient == null) {
            AddAccount addAccount = new AddAccount();
            row = addAccount.addPatientAccount(verification);
        }
        data = row == 0 ? "sign up failed" : "";
        resp.setContentType("text/html;charset=UTF-8");
        resp.getWriter().write(data);
    }


}
