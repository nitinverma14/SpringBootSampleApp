<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
      <footer class="sticky-footer bg-white">
        <div class="container my-auto">
          <div class="copyright text-center my-auto">
            <span>Copyright &copy; <strong>Jarvis (Central Notification Engine)</strong>. All Rights Reserved</span>
          </div>
        </div>
      </footer>

      <script src="${contextPath}/resources/js/date.js"></script>
      <script>
        var cms = parseInt('<%= response.getHeader("ms") %>');
		function refreshServerTime(){
			cms = cms + 1000;
			$("#s-time").text(new Date(cms).toString("dd/MM/yyyy hh:mm:ss tt"));
		}
		setInterval( refreshServerTime , 1000);
      </script>