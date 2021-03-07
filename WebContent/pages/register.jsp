<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<t:app>
	<jsp:attribute name="body">
		<div class="container mt-5 mb-5">
				<div class="row">
					<div class="col-sm-12">
						<div style="width: 100%;max-width: 330px;margin: 0 auto;">
							<jsp:include page="../components/alert.jsp" />
							<div class="card">
							  <div class="card-header">
							    Register
							  </div>
							  <div class="card-body">
								<form action="${pageContext.request.contextPath}/register/submit" method="post">
								  <div class="mb-3">
								    <label for="name" class="form-label">Name *</label>
								    <input type="text" class="form-control" id="name" name="name" required>
								  </div>
								  <div class="mb-3"> 
								    <label for="email" class="form-label">Email address *</label>
								    <input type="email" class="form-control" id="email" name="email" required>
								  </div>
					  			  <div class="mb-3">
								    <label for="phone" class="form-label">Phone</label>
								    <input type="number" class="form-control" id="phone" name="phone" required>
								  </div>
					   			  <div class="mb-3">
								    <label for="age" class="form-label">Age</label>
								    <input type="number" class="form-control" id="age" name="age">
								  </div>
								  <div class="mb-3">
								    <label for="password" class="form-label">Password *</label>
								    <input type="password" class="form-control" name="password" id="password" required>
								  </div>
								  <button type="submit" class="btn btn-primary">Submit</button>
								  <a href="${pageContext.request.contextPath}/login" class="btn btn-light">Cancel</a>
								</form>
							  </div>
							</div>
						</div>
					</div>
				</div>
			</div>
	</jsp:attribute>
</t:app>