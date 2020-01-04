<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<jsp:include page="head.jsp"></jsp:include>
	  <link href="${contextPath}/resources/dt/dataTables.bootstrap4.min.css" rel="stylesheet"/>
</head>

<body id="page-top">

  <div id="wrapper">

    <jsp:include page="sidebar.jsp"></jsp:include>
    <div id="content-wrapper" class="d-flex flex-column">
      <div id="content">
        <jsp:include page="nav.jsp"></jsp:include>
        <div class="container-fluid">
		    <a href="${context}/rule_add" class="btn btn-sm btn-secondary"><i class="fas fa-fw fa-envelope"></i> Add Rule</a>		
		    <br/><br/>
		    <form:form method="post" action="${context}/rule_update" modelAttribute="ruleInfoForm">
		     <div id="mydiv">
			    <c:if test="${not empty message}">
			    	  <label><b><span style="color:red;text-align:center">${message}</span> </b></label>
			    </c:if>
		    </div>
			<table id="dtRule" class="table table-striped table-bordered" style="width:100%">
		        <thead>
		            <tr>
		            	<th>#</th>
		                 <th>Rule Name</th>
		                 <th>Description</th>
		                 <th>Rule Condition</th>
		                 <th>Action</th>
		            </tr>
		        </thead>
		         <tbody>
		        
		           <c:if test="${empty ruleInfoForm}">
					      <tr>
					        <td colspan="8">No task to Display</td>
					      </tr>
					    </c:if>
					    <c:if test="${not empty ruleInfoForm}">
					      <c:forEach items="${ruleInfoForm.ruleInfoDTO}" var="ruleInfoDTO" varStatus="status">
					    	  <tr class="">
					          	  <td>${ruleInfoDTO.id}<input  name="ruleInfoDTO[${status.index}].id" type="hidden" value="${ruleInfoDTO.id}"></td>
						          <td>${ruleInfoDTO.ruleName}<input name="ruleInfoDTO[${status.index}].ruleName" type="hidden" value="${ruleInfoDTO.ruleName}"></td>
						          <td>${ruleInfoDTO.description}<input name="ruleInfoDTO[${status.index}].description" type="hidden" value="${ruleInfoDTO.description}"></td>
						          <td>${ruleInfoDTO.ruleCondition}<input name="ruleInfoDTO[${status.index}].ruleCondition" type="hidden" value="${ruleInfoDTO.ruleCondition}"></td>
						          <c:if test="${ruleInfoDTO.active==null || ruleInfoDTO.active==false}">
						         	 <td><input name="ruleInfoDTO[${status.index}].active" type="checkbox" ></td>
						          </c:if>
						          <c:if test="${ruleInfoDTO.active==true}">
						         	 <td><input name="ruleInfoDTO[${status.index}].active" type="checkbox" checked="checked" ></td>
						          </c:if>
					          	  
					          </tr>
					      </c:forEach>
    				</c:if>
		          </tbody>
	            </table>
            	<button type="submit" class="btn btn-primary"><i class="fas fa-fw fa-sync"></i> Update Changes</button>  
            </form:form>
        </div>
      </div>
      <jsp:include page="footer.jsp"></jsp:include>
    </div>
  </div>
  <a class="scroll-to-top rounded" href="#page-top">
    <i class="fas fa-angle-up"></i>
  </a>

   <jsp:include page="script.jsp"></jsp:include>
   <script src="${contextPath}/resources/dt/jquery.dataTables.min.js"></script>
   <script src="${contextPath}/resources/dt/dataTables.bootstrap4.min.js"></script>
   
   
   <script>
	   $("#headid").html('<i class="fas fa-fw fa-cogs"></i> Rules');
		$("#ruleid").addClass("active");
		 $(document).ready(function() {
		    $('#dtRule').DataTable();
		} ); 
		
		setTimeout('$("#mydiv").fadeOut("slow")', 3000);
	</script>
</body>

</html>
