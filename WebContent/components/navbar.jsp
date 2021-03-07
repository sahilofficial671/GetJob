<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<nav class="navbar navbar-dark bg-primary navbar-expand-lg">
    <div class="container-fluid">
      <a class="navbar-brand" href="${pageContext.request.contextPath}">Get Job</a>
      <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbar-menu" aria-controls="#navbar-menu" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
      </button>
      <div class="collapse navbar-collapse" id="navbar-menu">
        <ul class="navbar-nav me-auto mb-2 mb-lg-0">
          <li class="nav-item">
            <a class="nav-link active" href="${pageContext.request.contextPath}/jobs">Jobs</a>
          </li>
          <li class="nav-item dropdown">
	          <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">
	            Recruiters
	          </a>
	          <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
	            <li><a class="dropdown-item" href="${pageContext.request.contextPath}/dashboard">Add Job</a></li>
	          </ul>
	        </li>
        </ul>
        <div class="d-flex right">
	        <% if(request.getSession().getAttribute("logged") != null) { %>
	       		<ul class="navbar-nav me-auto mb-2 mb-lg-0">
			        <li class="nav-item dropdown">
				        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">
							<c:out value="${sessionScope.user.name}"/>
			          	</a>
			          <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
			            <li><a class="dropdown-item" href="#">Profile</a></li>
			            <li><hr class="dropdown-divider"></li>
				  		<li><a href="${pageContext.request.contextPath}/logout" class="dropdown-item">Logout</a></li>
			          </ul>
		        	</li>
	     		</ul>
		  	<% }else{ %>
		        <a href="${pageContext.request.contextPath}/login" class="btn btn-light me-2">Login</a>
				<a href="${pageContext.request.contextPath}/register" class="btn btn-outline-light">Register</a>
	     	<% } %>
        </div>
      </div>
    </div>
</nav>