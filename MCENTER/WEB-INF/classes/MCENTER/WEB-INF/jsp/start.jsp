<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Login</title>
</head>
<body>
   

 
      
  <s:form action="dailydoctorinputaction" method="post" margin="auto">
    <s:submit method="execute" value="Start Doctor" key="label.logout" align="center" />
</s:form> 


 <s:form action="patientInCounterJSONaction" method="post" margin="auto">
    <s:submit value="PatientSavetoDBUsingJSON" key="label.logout" align="center" />
</s:form>

<s:form action="/DailyDoctorVSpatientFinalListShow1.jsp" method="post" margin="auto">
    <s:submit value="DailyDoctorVSpatientshow" method="dailydoctorVSpatient"  key="label.logout" align="center" />
</s:form>

<%--   <s:form action="doctorVSpatientaction" method="post" margin="auto">
    <s:submit method="doctorVSpatient" value="doctorVSpatient" key="label.logout" align="center" />
</s:form>   

 <s:form action="patientinCounterAJAX.jsp" method="post" margin="auto">
    <s:submit value="PatientSavetoDBUsingAJAX" key="label.logout" align="center" />
</s:form>



 <s:form action="patientInCounter.jsp" method="post" margin="auto">
    <s:submit value="PatientSavetoDB" key="label.logout" align="center" />
</s:form>
 
<s:form action="patientaction" method="post" margin="auto">
    <s:submit method="patient" value="Patient" key="label.logout" align="center" />
</s:form>
   
<s:form action="patientDBaction" method="post" margin="auto">
    <s:submit method="patient" value="SerialfromDB" key="label.logout" align="center" />
</s:form> --%>

<s:form action="/doctorVSpatientHighchart1.jsp" method="post" margin="auto">
    <s:submit method="dailydoctorVSpatientchart" value="High Chart" key="label.logout" align="center" />
</s:form>


<s:form action="dailyRegularMedicineBillSearchByPharmasist1.jsp" method="post" margin="auto">
    <s:submit  value="Searched by Pharmasist" key="label.logout" align="center" />
</s:form>
   
 <s:form action="searchPrescriptionTOeditBYDoctor1.jsp" method="post" margin="auto">
    <s:submit  value="Searched by Doctor" key="label.logout" align="center" />
</s:form>
<s:form action="dailyRegularTestBillSearchByTechnician1.jsp" method="post" margin="auto">
    <s:submit  value="Searched by Labtechnecian" key="label.logout" align="center" />
</s:form>


<s:form action="serialForOutsiderTestPatient.jsp" method="post" margin="auto">
    <s:submit  value="serial For Outsider Test Patient" key="label.logout" align="center" />
</s:form>

<s:form action="testforOthers1.jsp" method="post" margin="auto">
    <s:submit  value="Outsider Test Bill" key="label.logout" align="center" />
</s:form>

<s:form action="newstudentMedicalCheckUp1.jsp" method="post" margin="auto">
    <s:submit  value="New Student Medical Checkup" key="label.logout" align="center" />
</s:form>
  
<s:form action="totalBill.jsp" method="post" margin="auto">
    <s:submit value="Total bill of Employee/others" key="label.logout" align="center" />
</s:form>

<s:form action=" addDependent1.jsp" method="post" margin="auto">
    <s:submit value="Add Dependent" key="label.logout" align="center" />
</s:form>

<s:form action="medicalFitnessCertificate.jsp" method="post" margin="auto">
    <s:submit value="Medical Fitness Certificate" key="label.logout" align="center" />
</s:form>
<s:form action="medicalFitnessCertificateAfterRecovery.jsp" method="post" margin="auto">
    <s:submit value="Medical Fitness Certificate After Recovery" key="label.logout" align="center" />
</s:form>
<s:form action="medicalcertificateforRest.jsp" method="post" margin="auto">
    <s:submit value="Medical Certificate for Rest" key="label.logout" align="center" />
</s:form>
  
</body>
</html>
