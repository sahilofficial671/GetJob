<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<t:app>
	<jsp:attribute name="body">
		<div class="container mt-5 mb-5">
			<div class="row menu-tab">
					
				<div class="col-sm-6 offset-sm-3">
				<jsp:include page="../../components/alert.jsp" />
					<div class="card mb-5">
					  <div class="card-header">
					    Create Job
					  </div>
					  <div class="card-body">
						<form action="${pageContext.request.contextPath}/jobs/submit" method="post">
						  <div class="mb-3">
						    <label for="title" class="form-label">Title *</label>
						    <input type="text" class="form-control" id="title" name="title" required>
						  </div>
						  <div class="mb-3"> 
						    <label for="description" class="form-label">Description *</label>
						    <input type="text" class="form-control" id="description" name="description" required>
						  </div>
 				   			  <div class="mb-3">
						    <label for="company" class="form-label">Company</label>
						    <input type="text" class="form-control" id="company" name="company">
						  </div>
  				   			  <div class="mb-3">
						    <label for="location" class="form-label">Location</label>
						    <input type="text" class="form-control" id="location" name="location">
						  </div>
			  			  <div class="mb-3">
						    <label for="salary_offered" class="form-label">Salary Offered</label>
						    <input type="number" class="form-control" id="salary_offered" name="salary_offered" required>
						  </div>
						  <div class="mb-3">
						    <label for="min_exp" class="form-label">Minimum Experience *</label>
						    <input type="number" class="form-control" name="min_exp" id="min_exp" required>
						  </div>
 							  <div class="mb-3">
						    <label for="max_exp" class="form-label">Maximum Experience *</label>
						    <input type="number" class="form-control" name="max_exp" id="max_exp" required>
						  </div>
						  <button type="submit" class="btn btn-primary">Submit</button>
						</form>
					  </div>
					</div>
				</div>
			</div>
		</div>
	</jsp:attribute>
</t:app>