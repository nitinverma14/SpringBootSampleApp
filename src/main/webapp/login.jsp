<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html lang="en">
<head>
	 <jsp:include page="head.jsp"></jsp:include>
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
                    <h5>Sign In</h5>
                  </div>
                  <form method="POST" action="${contextPath}/login">
                    <div class="form-group">
                      <input name="username" required="required" autofocus="autofocus" type="text" class="form-control form-control-user" placeholder="Enter Username"/>
                    </div>
                    <div class="form-group">
                      <input name="password" required="required" type="password" class="form-control form-control-user" placeholder="Enter Password"/>
                    </div>
            		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                    <button type="submit" class="btn btn-primary btn-user btn-block">
                      Sign In
                    </button>
                    <span style="color: #e74a3b;">${error}</span>
                    <span style="color: #1cc88a;">${message}</span>
                  </form>
                </div>
              </div>
            </div>
          </div>
        </div>
 		<strong><i class="fas fa-fw fa-copyright"></i> Optum<sup>TM</sup>, Inc. All Rights Reserved</strong>
      </div>

    </div>

  </div>

 <jsp:include page="script.jsp"></jsp:include>
</body>

</html>
