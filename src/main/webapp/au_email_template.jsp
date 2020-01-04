<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html lang="en">
<head>
	<jsp:include page="head.jsp"></jsp:include>
	<link rel="stylesheet" href="${contextPath}/resources/grapesjs/css/grapes.min.css"/>
    <link href="${contextPath}/resources/grapesjs/css/grapesjs-preset-newsletter.css" rel="stylesheet"/>
</head>

<body id="page-top">

  <div id="wrapper">

    <jsp:include page="sidebar.jsp"></jsp:include>
    <div id="content-wrapper" class="d-flex flex-column">
      <div id="content">
        <jsp:include page="nav.jsp"></jsp:include>
        <div class="container-fluid">
				<h5><i class="fas fa-fw fa-envelope"></i> Add email template</h5>
				<div class="card">
				  <div class="card-body">
				    	<form>
						  <div class="form-group">
						    <label for="title">Template Title <span style="color: red;">*</span></label>
						    <input autofocus="autofocus" type="text" class="form-control" id="title" aria-describedby="titleHelp" placeholder="Enter template title">
						    <small id="titleHelp" class="form-text text-muted">Please enter a template title.</small>
						  </div>
						  <div id="gjs" style="margin-bottom: 10px;max-height: 500px;">Loading...</div>
						  <button type="submit" class="btn btn-primary"><i class="fas fa-fw fa-sync"></i> Save Changes</button>
						</form>
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
   <script src="${contextPath}/resources/grapesjs/grapes.min.js"></script>
   <script src="${contextPath}/resources/grapesjs/grapesjs-preset-newsletter.min.js"></script>
   <script src="${contextPath}/resources/grapesjs/grapesjs-blocks-basic.min.js"></script>
   <script>
		$("#headid").html('<i class="fas fa-fw fa-clipboard-check"></i> Email Template');
		$("#templatesid").addClass("active");
		var host = 'https://artf.github.io/grapesjs/';
	      var images = [
	        host + 'img/grapesjs-logo.png',
	        host + 'img/tmp-blocks.jpg',
	        host + 'img/tmp-tgl-images.jpg',
	        host + 'img/tmp-send-test.jpg',
	        host + 'img/tmp-devices.jpg',
	      ];
		var editor = grapesjs.init({
		      container : '#gjs',
		      assetManager: {
		          assets: images,
		          upload: 0,
		          uploadText: 'Uploading is not available in this demo'
		      },
		      plugins: ['gjs-preset-newsletter','gjs-blocks-basic'],
		      pluginsOpts: {
		        'gjs-preset-newsletter': {
		          modalTitleImport: 'Import template'
		        }
		      }
		  });
	</script>
</body>

</html>
