<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
				<div class="row">
				  <div class="col-6">
				  	<div class="card">
					  <div class="card-body">
					    <strong>Batch Execution</strong>
					    <div style="height: 300px !important;overflow-y: scroll;">
					    <table class="table">
						    <thead class="thead-dark">
						      <tr>
						        <th>Status</th>
						        <th>Batch Job</th>
						        <th>Execution Time</th>
						      </tr>
						    </thead>
						    <tbody id="batch_execution_status">	
						    </tbody>
					    </table> 
					    </div>
					  </div>
					</div>
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
		$("#headid").html('<i class="fas fa-fw fa-tachometer-alt"></i> Dashboard');
		$("#dashboardid").addClass("active");
		console.log(hostpath+"batch_status");
		$.ajax({
	        url: hostpath+"batch_status",
	        type: 'GET',
	        dataType: 'json', 
	        success: function(res) {
	           $(res).each(function(i, o) {
	        	   $("#batch_execution_status").append('<tr><td>'+o.exitCode+'</td><td>'+o.jobName+'</td><td>'+o.endTime+'</td></tr>');
	        	 });
	        }
	    });
	</script>
</body>

</html>
