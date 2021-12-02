<%@ page import="indi.guxiyuesi.HospitalManage.entity.admin.Admin" %><%--
  Created by IntelliJ IDEA.
  User: 18045
  Date: 2021-11-28
  Time: 22:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>管理员</title>
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/adminPattern.css" charset="GBK"/>
    <script type="text/javascript" src="<%=request.getContextPath() %>/js/jquery_3_6_0.js"></script>
</head>

<body>
<div><h2>管理员模式</h2></div>


<div id="value">
    <div id="select">
        <ul id="selectUL">
            <!-- 侧边框 -->
            <li>
                <div class="selection" id="selectAdmin">管理员信息</div>
            </li>
            <li>
                <div class="selection" id="selectDoctor">医生信息</div>
            </li>
            <li>
                <div class="selection" id="selectPatient">病人信息</div>
            </li>
            <li>
                <div class="selection" id="selectDrug">药品信息</div>
            </li>
        </ul>
    </div>
    <!-- 管理员信息 -->
    <div id="content">
        <div id="adminInfo">
            <div>
                <div class="forInline">
                    <div id="adminAccountText" class="adminLabel">
                        <% Admin admin = (Admin)session.getAttribute("admin"); %>
                        adminAccount:<%= admin.getAdministratorAccount() %>
                    </div>
                </div>

                <div class="forInline">
                    <div id="adminNameText" class="adminLabel">
                        adminName:<%= admin.getAdministratorName() %>
                    </div>
                    <div id="adminNameInput" >
                        <input type="text" name="adminName" id="adminName" class="adminInput">
                    </div>
                </div>

                <div class="forInline">
                    <div id="adminGenderText" class="adminLabel">
                        adminGender:<%= admin.getAdministratorGender()%>
                    </div>
                    <div id="adminGenderInput">
                        <input type="text" name="adminGender" id="adminGender" class="adminInput">
                    </div>
                </div>

                <div class="forInline">
                    <div id="adminPhoneNumText" class="adminLabel">
                        adminPhoneNum:<%=admin.getAdministratorPhoneNumber() %>
                    </div>
                    <div id="adminPhoneNumInput">
                        <input type="text" name="adminPhoneNum" id="adminPhoneNum" class="adminInput">
                    </div>
                </div>

                <div class="forInline">
                    <div id="adminPasswordText" class="adminLabel">
                        adminPassword:<%=admin.getAdministratorPassword()%>
                    </div>
                    <div id="adminPasswordInput">
                        <input type="text" name="adminPassword" id="adminPassword" class="adminInput">
                    </div>
                </div>

            </div>

            <div class="button">
                <input type="button" id="modify" class="submit" value="修改">
            </div>

            <div class="button">
                <input id="submit" class="submit" value="提交" type="button">
            </div>
        </div>

        <!-- 医生信息 -->
        <div id="doctorValue">
            <div>
                <div id="doctorInfoDiv">
                    <table id="doctorInfoTable">
                        <thead id="doctorInfoThead">
                        <th>
                            工号
                        </th>
                        <th>
                            姓名
                        </th>
                        <th>
                            部门
                        </th>
                        <th>
                            是否修改
                        </th>
                        </thead>
                    </table>
                </div>
            </div>
        </div>

        <!--病人信息-->
        <div id="patientValue">
            <div>请输入身份证号:
                <input type="text" id="patientIdNumber" />
                <button id="selectPatientByIdNumber">查询</button>
            </div>
            <div>
                <div id="patientInfoDiv">
                    <table id="patientInfoTable">
                        <thead id="patientInfoThead">
                        <th>
                            内容
                        </th>
                        <th>
                            信息
                        </th>
                        </thead>
                    </table>
                </div>
            </div>
        </div>

        <!--药品信息-->
        <div id="drugValue">
            <div>
                <div id="drugInfoDiv">
                    <table id="drugInfoTable">
                        <thead id="drugInfoThead">
                        <th>
                            序号
                        </th>
                        <th>
                            药品名
                        </th>
                        <th>
                            药品数量
                        </th>
                        <th>
                            是否修改
                        </th>
                        </thead>
                    </table>
                </div>
            </div>
        </div>

    </div>
</div>


</body>
<script type="text/javascript" src="<%=request.getContextPath() %>/js/adminPattern.js"></script>
</html>
