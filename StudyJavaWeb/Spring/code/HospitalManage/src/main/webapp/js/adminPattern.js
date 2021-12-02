// 管理员信息选项卡
let $selectAdmin = $("#selectAdmin");
// 医生信息选项卡
let $selectDoctor = $("#selectDoctor");
// 病人信息选项卡
let $selectPatient = $("#selectPatient");
// 药品信息选项卡
let $selectDrug = $("#selectDrug");

// 医生信息内容
let $doctorValue = $("#doctorValue");
// 管理员信息内容
let $adminValue = $("#adminInfo");
// 病人信息内容
let $patientValue = $("#patientValue");
// 药品信息内容
let $drugValue = $("#drugValue");

$selectAdmin.click(function () {
   $selectDoctor.css("border-right", "solid 2px black");
   $doctorValue.css("display", "none");
   $selectDrug.css("border-right", "solid 2px black");
   $drugValue.css("display", "none");
   $selectPatient.css("border-right", "solid 2px black");
   $patientValue.css("display", "none");
   $selectAdmin.css("border-right", "solid 0px black");
   $adminValue.css("display", "block");
});

$selectDrug.click(function () {
   $selectDoctor.css("border-right", "solid 2px black");
   $doctorValue.css("display", "none");
   $selectAdmin.css("border-right", "solid 2px black");
   $adminValue.css("display", "none");
   $selectPatient.css("border-right", "solid 2px black");
   $patientValue.css("display", "none");
   $selectDrug.css("border-right", "solid 0px black");
   $drugValue.css("display", "block");

   $.ajax({
      url: "/admin/drugs",
      type:"get",
      dataType: "text",
      success:function (data) {
         if ($(".drugTr").val() === undefined) {
            let array = JSON.parse(data);
            for (let i = 0; i < array.length; ++i) {
               console.log(array[i].drugId);
               $("#drugInfoThead").after(
                   "<tr class='drugTr'>" +
                   "<td>" + array[i].drugId + "</td>" +
                   "<td>" + array[i].drugName + "</td>" +
                   "<td>" + array[i].drugNumber + "</td>" +
                   "<td><button id='modifyDrugByAdmin'>修改</button></td>" +
                   "</tr>");
            }
         }
      }
   })
});


$selectDoctor.click(function () {
   $selectDrug.css("border-right", "solid 2px black");
   $drugValue.css("display", "none");
   $selectAdmin.css("border-right", "solid 2px black");
   $adminValue.css("display", "none");
   $selectPatient.css("border-right", "solid 2px black");
   $patientValue.css("display", "none");
   $selectDoctor.css("border-right", "solid 0px black");
   $doctorValue.css("display", "block");

   $.ajax({
      url: "/admin/doctors",
      type:"get",
      dataType: "text",
      success:function (data) {
         console.log($(".doctorTr").val());
         if($(".doctorTr").val() === undefined) {
            let array = JSON.parse(data);
            for (let i = 0; i < array.length; ++i) {
               $("#doctorInfoThead").after(
                   "<tr class='doctorTr'>" +
                   "<td>" + array[i].doctorId + "</td>" +
                   "<td>" + array[i].doctorName + "</td>" +
                   "<td>" + array[i].departmentName + "</td>" +
                   "<td><button id='modifyDoctorByAdmin'>修改</button></td>" +
                   "</tr>"
               );
            }
         }
      }
   })
});

let $patientInfoThead = $("#patientInfoThead");
$selectPatient.click(function () {
   $selectDrug.css("border-right", "solid 2px black");
   $drugValue.css("display", "none");
   $selectAdmin.css("border-right", "solid 2px black");
   $adminValue.css("display", "none");
   $selectDoctor.css("border-right", "solid 2px black");
   $doctorValue.css("display", "none");
   $selectPatient.css("border-right", "solid 0px black");
   $patientValue.css("display", "block");

   $patientInfoThead.css("display", "none");
});

let $selectPatientByIdNumber = $("#selectPatientByIdNumber");
$selectPatientByIdNumber.click(function () {

   $.ajax({
      url:"/admin/patient",
      data: "patientIdNumber="+$("#patientIdNumber").val(),
      dataType : "text",
      method : "get",
      success : function (data) {
         if (data === "select false") {
            console.log(data);
            if ($("#patientMark").val() === undefined) {
               $selectPatientByIdNumber.after("" +
                   "<div id='patientMark' style='color: red'>未查询到信息</div>" +
                   "");
            }
         }
         else {
            if (!($("#patientMark").val() === undefined)) {
               $patientInfoThead.css("display", "block");
               let patient = JSON.parse(data);
               $patientInfoThead.after("" +
                   "<tr class='patientTr'>" +
                   "<td>patientAccount</td>" +
                   "<td>" + patient.patientAccount + "</td>" +
                   "</tr>");
            }
         }
      }

   })
});
