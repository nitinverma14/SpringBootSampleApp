<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
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
				<h5><i class="fas fa-fw fa-comment"></i> Add SMS template</h5>
				<div class="card">
				  <div class="card-body">
				    	<form:form method="POST" action="${context}/au_sms_template" modelAttribute="templateDto">
				    	  <form:hidden path="idr"/>	
				    	  <form:hidden path="ops"/>	
						  <div class="form-group">
						    <label for="title">Template Title <span style="color: red;">*</span></label>
						    <form:input type="text" class="focusfield form-control" path="title" placeholder="Enter template title"/>
						    <form:errors path="title" cssClass="errorf"/>
						  </div>
						   <div class="form-group">
							   <div class="custom-control custom-switch">
							    <form:checkbox class="custom-control-input" path="active" id="active"></form:checkbox>
							    <label class="custom-control-label" for="active">Mark template active</label>
							  </div>
						   </div>
						   <div class="form-group">
						    <label for="template">Template <span style="color: red;">*</span></label>
						    <form:textarea rows="10" class="form-control" path="template" aria-describedby="templateHelp"></form:textarea>
						    <form:errors path="template" cssClass="errorf"/>
						    <small id="templateHelp" class="form-text text-muted">Template variables : <code>$name</code>  <code>$phone</code> <code>$email</code></small>
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
   <script>
		$("#headid").html('<i class="fas fa-fw fa-clipboard-check"></i> Manage Template');
		$("#templatesid").addClass("active");
	</script>
</body>

</html>
