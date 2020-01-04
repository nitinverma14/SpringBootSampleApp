<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ page import="com.jarvis.enums.PreferenceEnum" %>
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
		    <a href="${context}/action_add" class="btn btn-sm btn-secondary"><i class="fas fa-fw fa-envelope"></i> Add Action</a>		
		      <br/><br/>
		    <form:form method="post" action="${context}/action_update" modelAttribute="actionInfoForm">
		     <div id="mydiv">
			    <c:if test="${not empty message}">
			    	  <label><b><span style="color:red;text-align:center">${message}</span> </b></label>
			    </c:if>
		    </div>
			<table id="dtAction" class="table table-striped table-bordered" style="width:100%">
		        <thead>
		            <tr>
		            	<th>#</th>
		                 <th>Action Name</th>
		                 <th>Description</th>
		                 <th>Action Preference</th>
		                 <th>Template SMS Preference</th>
		                 <th>Template EMAIL Preference</th>
		                  <th style="display:none;"> Action</th>
		            </tr>
		        </thead>
		         <tbody>
		           <%-- <c:if test="${empty actionList}">
					      <tr>
					        <td colspan="8">No task to Display</td>
					      </tr>
					    </c:if>
					    <c:if test="${not empty actionList}">
					
					      <c:forEach items="${actionList}" var="actionInfo">
					        <tr class="">
					          <td>${actionInfo.id}</td>
					          <td>${actionInfo.actionName}</td>
					          <td>${actionInfo.description}</td>
					          <td>${actionInfo.actionIDPreference}</td>
					          <td>${actionInfo.templetePreference}</td>
					          <td>-</td>
					        </tr>
					      </c:forEach>
    				</c:if> --%>
    				
    				 <c:if test="${empty actionInfoForm}">
					      <tr>
					        <td colspan="8">No task to Display</td>
					      </tr>
					    </c:if>
					    <c:if test="${not empty actionInfoForm}">
					      <c:forEach items="${actionInfoForm.actionInfoDTO}" var="actionInfoDTO" varStatus="status">
					    	  <tr class="">
					          	   <td>${actionInfoDTO.id}<input  name="actionInfoDTO[${status.index}].id" type="hidden" value="${actionInfoDTO.id}"></td>
						          <td>${actionInfoDTO.actionIDName}<input name="actionInfoDTO[${status.index}].actionIDName" type="hidden" value="${actionInfoDTO.actionIDName}"></td>
						          <td>${actionInfoDTO.description}<input name="actionInfoDTO[${status.index}].description" type="hidden" value="${actionInfoDTO.description}"></td>
						          <%-- <td>${actionInfoDTO.actionIDPreference}<input name="actionInfoDTO[${status.index}].actionIDPreference" type="hidden" value="${actionInfoDTO.actionIDPreference}"></td> --%>
						          <td><select class="form-control" id="selPrefrence${status.index}" name="actionInfoDTO[${status.index}].actionIDPreference" onchange="hideSMSOrEmailPreference(${status.index})">
						         		<option ${actionInfoDTO.actionIDPreference == 'SMS' ? 'selected' : ''} value="<%=PreferenceEnum.SMS%>"><%=PreferenceEnum.SMS%></option>
									    <option ${actionInfoDTO.actionIDPreference == 'EMAIL' ? 'selected' : ''}  value="<%=PreferenceEnum.EMAIL%>"><%=PreferenceEnum.EMAIL%></option>
									    <option ${actionInfoDTO.actionIDPreference == 'BOTH' ? 'selected' : ''}  value="<%=PreferenceEnum.BOTH%>"><%=PreferenceEnum.BOTH%></option>
									 </select></td>
						          <%-- <td>${actionInfoDTO.templetePreference}<input name="actionInfoDTO[${status.index}].templetePreference" type="hidden" value="${actionInfoDTO.templetePreference}"></td> --%>
						          <td>
						          	<select class="form-control" name="actionInfoDTO[${status.index}].templeteSMSPreference" id="smsPreference${status.index}" ${actionInfoDTO.actionIDPreference == 'EMAIL' ? 'disabled' : ''}>
						          		 <option value="" selected="selected" >Select One</option>
						          		 <c:forEach items="${smsPreferenceMap}" var="entry">
										          <option ${fn:trim(actionInfoDTO.templeteSMSPreference) == fn:trim(entry.key) ? 'selected' : ''} value="${entry.key}"> ${entry.value}</option>
										    </c:forEach>
						          	</select>
						          </td>
						          <td>
						          	<select class="form-control" name="actionInfoDTO[${status.index}].templeteEMAILPreference" id="emailPreference${status.index}" ${actionInfoDTO.actionIDPreference == 'SMS' ? 'disabled' : ''}>
						          	 <option value="" selected="selected" >Select One</option>
						          		  <c:forEach items="${emailPreferenceMap}" var="entry">
										          <option ${fn:trim(actionInfoDTO.templeteEMAILPreference) == fn:trim(entry.key) ? 'selected' : ''} value=" ${entry.key}"> ${entry.value}</option>
										    </c:forEach>
						          	</select>
						          </td>
						          <td style="display:none;"><input name="actionInfoDTO[${status.index}].active" type="hidden" value="${actionInfoDTO.active}" ></td>
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
	   $("#headid").html('<i class="fas fa-fw fa-tasks"></i> Actions');
		$("#actionid").addClass("active");
		$(document).ready(function() {
		    $('#dtAction').DataTable();
		} );
		
		setTimeout('$("#mydiv").fadeOut("slow")', 3000);
		
		function hideSMSOrEmailPreference(id){
			if($("#selPrefrence"+id).val()=='SMS'){
				$("#emailPreference"+id).attr("disabled", true);
				$("#smsPreference"+id).attr("disabled",false);
			}
			if($("#selPrefrence"+id).val()=='EMAIL'){
				$("#smsPreference"+id).attr("disabled", true);
				$("#emailPreference"+id).attr("disabled", false);
			}
			if($("#selPrefrence"+id).val()=='BOTH'){
				$("#emailPreference"+id).attr("disabled", false);
				$("#smsPreference"+id).attr("disabled", false);
			}
		}
	</script>
</body>

</html>
