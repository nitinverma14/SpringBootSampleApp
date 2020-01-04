<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

		<form id="logoutForm" method="POST" action="${contextPath}/logout">
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        </form>
        
        
        <nav class="navbar navbar-expand navbar-light bg-white topbar mb-4 static-top shadow">
          <button id="sidebarToggleTop" class="btn btn-link d-md-none rounded-circle mr-3">
            <i class="fa fa-bars"></i>
          </button>

         <h1 class="h3 mb-4 text-gray-800" style="padding: 10px;margin-top: 25px;" id="headid"></h1>

          <ul class="navbar-nav ml-auto">
			<li class="nav-item dropdown no-arrow" style="margin-top: 24px;">
			 	<strong>Server Time </strong> <span id="s-time">Loading ...</span>
			 </li>

            <div class="topbar-divider d-none d-sm-block"></div>

			 
            <li class="nav-item dropdown no-arrow">
              <a class="nav-link dropdown-toggle" href="#" id="userDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                <span class="mr-2 d-none d-lg-inline text-gray-600 small">${pageContext.request.userPrincipal.name}</span>
                <img class="img-profile rounded-circle" src="${contextPath}/resources/img/avatar.png">
              </a>
              <div class="dropdown-menu dropdown-menu-right shadow animated--grow-in" aria-labelledby="userDropdown">
                <a class="dropdown-item" href="#">
                  <i class="fas fa-cogs fa-sm fa-fw mr-2 text-gray-400"></i>
                  Some Link
                </a>
                <div class="dropdown-divider"></div>
                <a class="dropdown-item" onclick="document.forms['logoutForm'].submit()" style="cursor: pointer;">
                  <i class="fas fa-sign-out-alt fa-sm fa-fw mr-2 text-gray-400"></i>
                  Logout
                </a>
              </div>
            </li>
            
            

          </ul>

        </nav>
