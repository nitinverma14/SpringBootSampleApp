<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page import="com.jarvis.enums.PreferenceEnum" %>
<!DOCTYPE html>
<html lang="en">
<head>
	<jsp:include page="head.jsp"></jsp:include>
</head>

<body id="page-top">

  <div id="wrapper">

    <jsp:include page="sidebar.jsp"></jsp:include>
    <div id="content-wrapper" class="d-flex flex-column">
      <div id="content">
        <jsp:include page="nav.jsp"></jsp:include>
        <div class="container-fluid">
				 <h5>Add Member Info</h5>
				<div class="card">
				  <div class="card-body">
				    	<form:form autocomplete="off" modelAttribute="memberInfo" action="${context}/mock_epmp_save">
						   <div class="form-group row ">
							  	<div class="column col-4">
								    <form:label for="title" path="firstName" >First Name<span style="color: red;">*</span></form:label>
								    <form:input type="text" required="required" path="firstName" class="form-control" id="firstName" aria-describedby="firstnameHelp" placeholder="Enter First Name"></form:input>
							   </div>
	
							   <div class="column col-4">
								     <form:label for="title" path="lastName">Last Name<span style="color: red;">*</span></form:label>
								   	 <form:input type="text" required="required" path="lastName" class="form-control" id="lastName" aria-describedby="lastnameHelp" placeholder="Enter Last Name"></form:input>
							    </div>
							    <div class="column col-4">
								     <form:label for="title" path="dob">D.O.B<span style="color: red;">*</span></form:label>
								   	  <form:input autocomplete="off" path="dob" required="required" data-date-format="dd/mm/yyyy" id="datepicker" class="form-control" placeholder="Enter D.O.B"></form:input>
							    </div>
						  </div>
						  
						    <div class="form-group row ">
							  	<div class="column col-4">
								    <form:label for="title" path="emailAddress" >Email<span style="color: red;">*</span></form:label>
								    <form:input type="email" required="required" path="emailAddress" class="form-control" id="title" aria-describedby="emailHelp" placeholder="Enter Email"></form:input>
							   </div>
	
							   <div class="column col-4">
								     <form:label for="sel1" path="gender">Gender<span style="color: red;">*</span></form:label>
								   	<form:select class="form-control" id="selGender" required="required" path="gender">
									    <option value="M">Male</option>
									    <option value="F">Female</option>
									 </form:select>
							    </div>
							    <div class="column col-4">
								     <form:label for="title" path="phoneNumber">Phone Number<span style="color: red;">*</span></form:label>
								   	 <form:input type="tel" pattern=".{10}" required="required" path="phoneNumber"  class="form-control" id="title" aria-describedby="phoneNumberHelp" placeholder="Enter Phone Number {10}"></form:input>
							    </div>
						  </div>
						  <div class="form-group row ">
							   <div class="column col-4">
								     <form:label for="title" path="addressLine1">Address<span style="color: red;">*</span></form:label>
								   	 <form:input type="text" required="required" path="addressLine1" class="form-control" id="title" aria-describedby="addressHelp" placeholder="Enter Address"></form:input>
							    </div>
							    <div class="column col-4">
								     <form:label for="title" path="city">City<span style="color: red;">*</span></form:label>
								   	 <form:input type="text" required="required" path="city" class="form-control" id="title" aria-describedby="cityHelp" placeholder="Enter City"></form:input>
							    </div>
							    	<div class="column col-4">
								    <form:label for="title" path="county">Country<span style="color: red;">*</span></form:label>
								    <%-- <form:input type="text" required="required" path="county" class="form-control" id="title" aria-describedby="countryHelp" placeholder="Enter Country"></form:input> --%>
								    <form:select required="required" path="county" class="form-control" id="title" aria-describedby="countryHelp" placeholder="Enter Country">
								    	<form:option value="IN">India</form:option>
								    	<form:option value="US">USA</form:option>
								    </form:select>
							   </div>
	
						  </div>
						  <div class="form-group row ">
							   <div class="column col-4">
								     <form:label for="title" path="preference">Preference<span style="color: red;">*</span></form:label>
								   	 	<form:select class="form-control" id="selPrefrence" required="required" path="preference">
									    <option value="<%=PreferenceEnum.SMS%>"><%=PreferenceEnum.SMS%></option>
									    <option value="<%=PreferenceEnum.EMAIL%>"><%=PreferenceEnum.EMAIL%></option>
									    <option value="<%=PreferenceEnum.BOTH%>"><%=PreferenceEnum.BOTH%></option>
									 </form:select>
							    </div>
	
						  </div>
						  <button type="submit" class="btn btn-primary"><i class="fas fa-fw fa-sync"></i> Save Changes</button> 
						</form:form>
				  </div>
				</div>
        </div>
      </div>
      <jsp:include page="footer.jsp"></jsp:include>
    </div>
  </div>
  <a class="scroll-to-top rounded" href="#page-top">
    <i class="fas fa-angle-up"></i>
  </a>

   <jsp:include page="script.jsp"></jsp:include>
   <script src="${contextPath}/resources/js/sweetalert.min.js"></script>
   
   <script>
		$("#headid").html('<i class="fas fa-fw fa-street-view"></i> Mock EPMP');
		$("#mockepmpid").addClass("active");
		$('#datepicker').datepicker({
	        weekStart: 1,
	        daysOfWeekHighlighted: "6,0",
	        autoclose: true,
	        todayHighlight: true,
	    });
		
	</script>
</body>

</html>
