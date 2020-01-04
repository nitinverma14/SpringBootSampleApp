<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>


    <ul class="navbar-nav sidebar sidebar-dark accordion" id="accordionSidebar" style="background-color: #343a40;">

      <a class="sidebar-brand d-flex align-items-center justify-content-center" href="${contextPath}/">
          <i class="fas fa-dharmachakra" style="font-size: 25px;"></i>
        <div class="sidebar-brand-text mx-3">Jarvis Engine</div>
      </a>
      

      <hr class="sidebar-divider my-0"/>

      <li class="nav-item" id="dashboardid">
        <a class="nav-link" href="${contextPath}/">
          <i class="fas fa-fw fa-tachometer-alt"></i>
          <span>Dashboard</span></a>
      </li> 
      
      <li class="nav-item" id="actionid">
        <a class="nav-link" href="${contextPath}/actions" >
          <i class="fas fa-fw fa-tasks"></i>
          <span>Event Preference</span></a>
      </li>
      
       <li class="nav-item" id="mockepmpid">
        <a class="nav-link" href="${contextPath}/mock_epmp" >
          <i class="fas fa-fw fa-street-view"></i>
          <span>Mock EPMP</span></a>
      </li>
      
      <li class="nav-item" id="ruleid">
        <a class="nav-link" href="${contextPath}/rules" >
          <i class="fas fa-fw fa-cogs"></i>
          <span>Rules</span></a>
      </li>
      
      <li class="nav-item" id="templatesid">
        <a class="nav-link" href="${contextPath}/templates">
          <i class="fas fa-fw fa-clipboard-check"></i>
          <span>Templates</span></a>
      </li>



      <div class="text-center d-none d-md-inline">
        <button class="rounded-circle border-0" id="sidebarToggle"></button>
      </div>

    </ul>
