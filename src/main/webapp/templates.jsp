<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
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
		    <a href="${context}/manage_sms_template/a" class="btn btn-sm btn-secondary"><i class="fas fa-fw fa-comment"></i> Add SMS Template</a> 
		    <a href="${context}/add_email_template" class="btn btn-sm btn-secondary"><i class="fas fa-fw fa-envelope"></i> Add Email Template</a>		
		    <br/><br/>
			<table id="dt" class="table table-striped table-bordered" style="width:100%">
		        <thead>
		            <tr>
		                <th>Template ID</th>
		                <th>Title</th>
		                <th>Type</th>
		                <th>Updated On</th>
		                <th>Active</th>
		                <th>Action</th>
		            </tr>
		        </thead>
		        <tbody>
		        	<c:forEach items="${templatesList}" var="t">
		        		<tr>
			                <td>${t.tempNo}</td>
			                <td>${t.title}</td>
			                <td>${t.tempType}</td>
			                <td>${t.lastModifiedDate}</td>
			                <td>${t.active}</td>
			                <td><a href="${context}/manage_sms_template/u?token=${t.id}"><i class="fas fa-fw fa-edit"></i> Edit</a></td>
		            	</tr>
		        	</c:forEach>
		          </tbody>
	            </table>
            
            
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
		$("#headid").html('<i class="fas fa-fw fa-clipboard-check"></i> Templates');
		$("#templatesid").addClass("active");
		$(document).ready(function() {
		    $('#dt').DataTable();
		} );
	</script>
</body>

</html>
