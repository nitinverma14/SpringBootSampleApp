<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html lang="en">
<head>
	 <jsp:include page="../head.jsp"></jsp:include>
</head>

<body style="background: linear-gradient(110deg, #fff 60%, #343a40 60%);">

  <div class="container">

    <div class="row justify-content-center">

      <div class="col-xl-10 col-lg-12 col-md-9">

        <div class="card o-hidden border-0 shadow-lg my-5">
          <div class="card-body p-0">
            <div class="row">
              <div class="col-lg-6 d-none d-lg-block bg-login-image"></div>
              <div class="col-lg-6">
                <div class="p-5">
                  <div class="text-center">
                    <h1><i class="fas fa-fw fa-dharmachakra"></i><br/>Jarvis</h1>
                    <p>- Central Notification Engine -</p>
                    <h5>403 - Access Denied</h5>
                    <a class="btn btn-sm btn-warning" href="${context}/">Go to Home</a>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
 		<strong><i class="fas fa-fw fa-copyright"></i> Optum<sup>TM</sup>, Inc. All Rights Reserved</strong>
      </div>

    </div>

  </div>

 <jsp:include page="../script.jsp"></jsp:include>
</body>

</html>
