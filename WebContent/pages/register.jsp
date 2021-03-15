<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<t:app>
	<jsp:attribute name="body">
		<div class="container">
				<div class="row">
					<div class="col-sm-6 offset-sm-3">
						<div style="width: 100%;max-width: 700px;margin: 20px auto;">
							<jsp:include page="../components/alert.jsp" />
							<div class="card">
							  <div class="card-header">
							    Register
							  </div>
							  <div class="card-body">
								<form action="${pageContext.request.contextPath}/register/submit" method="post">
								
								<div class="row mb-3">
								  <div class="col">
								    <label for="name" class="form-label">Name *</label>
								    <input type="text" class="form-control" id="name" name="name" required>
								  </div>
								  <div class="col">
								    <label for="email" class="form-label">Email address *</label>
								    <input type="email" class="form-control" id="email" name="email" required>
								  </div>
								</div>
								<div class="row mb-3">
								  <div class="col">
								    <label for="phone" class="form-label">Phone</label>
								    <input type="number" class="form-control" id="phone" name="phone" required>
								  </div>
								  <div class="col">
								   <label for="age" class="form-label">Age</label>
								    <input type="number" class="form-control" id="age" name="age">
								  </div>
								</div>
								<div class="row mb-3">
								  <div class="col">
   								     <label for="email" class="form-label">Type *</label>
								     <div class="form-check">
									  <input class="form-check-input" type="radio" name="type" value="1" checked>
									  <label class="form-check-label" for="type">
									    Job Seeker
									  </label>
									</div>
									<div class="form-check">
									  <input class="form-check-input" type="radio" name="type" value="2">
									  <label class="form-check-label" for="type">
									    Recruiter
									  </label>
								  	</div>
								  </div>
								  <div class="col">
								    <label for="password" class="form-label">Password *</label>
								    <input type="password" class="form-control" name="password" id="password" required>
								  </div>
								</div>
								<div class="form-group">
									<a href="${pageContext.request.contextPath}/login" class="btn btn-light float-start">Cancel</a>
								    <button type="submit" class="btn btn-primary me-2 float-end ">Submit</button>
							    </div>
								  
								</form>
							  </div>
							</div>
						</div>
					</div>
				</div>
			</div>
	</jsp:attribute>
</t:app>