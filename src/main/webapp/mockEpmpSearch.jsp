<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
		    <a href="${context}/mock_epmp_add" class="btn btn-sm btn-secondary"><i class="fas fa-fw fa-envelope"></i> Add Member Info</a>		
		    <br/><br/>
			<table id="dt" class="table table-striped table-bordered" style="width:100%">
		        <thead>
		            <tr>
		            	<th>#</th>
		                <th>Name</th>
		                 <th>D.O.B</th>
		                 <th>Email</th>
		                 <th>Gender</th>
		                 <th>Phone Number</th>
		                 <th>Preference</th>
		                 <th>Action</th>
		            </tr>
		        </thead>
		        <tbody>
		           <c:if test="${empty memberInfoList}">
					      <tr>
					        <td colspan="8">No task to Display</td>
					      </tr>
					    </c:if>
					    <c:if test="${not empty memberInfoList}">
					
					      <c:forEach items="${memberInfoList}" var="memberInfo">
					        <tr class="">
					          <td>${memberInfo.id}</td>
					          <td>${memberInfo.firstName} ${memberInfo.lastName}</td>
					          <td>${memberInfo.dob}</td>
					          <td>${memberInfo.emailAddress}</td>
					          <td>${memberInfo.gender}</td>
					          <td>${memberInfo.phoneNumber}</td>
					          <td>${memberInfo.preference}</td>
					          <td>-</td>
					        </tr>
					      </c:forEach>
    				</c:if>
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
	   $("#headid").html('<i class="fas fa-fw fa-street-view"></i> Mock EPMP');
		$("#mockepmpid").addClass("active");
		$(document).ready(function() {
		    $('#dt').DataTable();
		} );
	</script>
</body>

</html>
