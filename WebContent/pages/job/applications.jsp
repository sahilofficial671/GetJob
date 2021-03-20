<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<t:app>
	<jsp:attribute name="body">
		<div class="container mt-5 mb-5">
			<div class="row">
				<div class="col-sm-12">
					
				</div>
			</div>
			<div class="row">
				<div class="col-sm-6 offset-sm-3">
				<jsp:include page="/components/alert.jsp" />
					<div class="card">
					  <div class="card-header">
					    Applications
					  </div>
					  <div class="card-body p-0">
						<div class="jobs-container">
							<div class="jobs-inner">
							<c:if test="${!applications.isEmpty()}">
								<c:forEach items="${applications}" var="application">
									<div class="job">
										<div class="head d-flex justify-content-between">
											<div class="block-1">
												<div class="id badge bg-primary">ID: ${application.getId()}</div>
											</div>
											
											<div class="block-2">
												<span class="badge bg-primary no-underline" data-bs-toggle="tooltip" data-bs-placement="top" title="${application.getApplicationStatusTimeStamp()}">Status: ${application.getApplicationStatus()}</span>
											</div>
										</div>
										<div class="content d-flex justify-content-between">
											<div class="block-1">
												<div class="title">${application.job.getTitle()}</div>
												<div class="description">${job.getDescription()}</div>
											</div>
											<div class="block-2">
												<div class="company">${application.job.getCompany()}</div>
												<div class="salary_offered">${application.job.getSalaryOffered()}</div>
											</div>	
										</div>		
									</div>						        
								</c:forEach>
							</c:if>
							<c:if test="${application.isEmpty()}">
								<p class="text-center pt-2">No applications available.</p>
							</c:if>
								
							</div> <!--  jobs-inner -->
						</div>	<!--  jobs-container -->
					  </div>
					</div>
				</div>
						
				</div>
			</div>
		</div>
	</jsp:attribute>
</t:app>