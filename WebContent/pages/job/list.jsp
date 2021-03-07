<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<t:app>
	<jsp:attribute name="body">
		<div class="container mt-5 mb-5">
			<div class="row">
				<div class="col-sm-12">
					<jsp:include page="/components/alert.jsp" />
				</div>
			</div>
			<div class="row">
				<div class="col-sm-6 offset-sm-3">
					<div class="card">
					  <div class="card-header">
					    Latest Jobs
					  </div>
					  <div class="card-body p-0">
						<div class="jobs-container">
							<div class="jobs-inner">
							<c:if test="${!jobs.isEmpty()}">
								<c:forEach items="${jobs}" var="job">
									<div class="job">
										<div class="head d-flex justify-content-between">
											<div class="block-1">
												<div class="id badge bg-primary">ID: ${job.getId()}</div>
											</div>
											<c:if test="${sessionScope.logged != null }">
												<div class="block-2">
													<a href="${pageContext.request.contextPath}/job/delete?id=${job.getId()}" class="delete badge bg-danger"><i class="far fa-trash-alt"></i></a>
												</div>
											</c:if>
										</div>
										<div class="content d-flex justify-content-between">
											<div class="block-1">
												<div class="title">${job.getTitle()}</div>
												<div class="description">${job.getDescription()}</div>
											</div>
											<div class="block-2">
												<div class="company">${job.getCompany()}</div>
												<div class="salary_offered">${job.getSalaryOffered()}</div>
											</div>	
										</div>		
									</div>						        
								</c:forEach>
							</c:if>
							<c:if test="${jobs.isEmpty()}">
								<p class="text-center pt-2">No jobs available.</p>
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