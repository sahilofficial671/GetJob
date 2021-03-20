<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<t:app>
	<jsp:attribute name="body">
		<div class="container mt-5 mb-5">
			<div class="row">
				<div class="col-sm-12">
					<jsp:include page="../components/alert.jsp" />
				</div>
			</div>
			<div class="row menu-tab">
				<div class="col-sm-2">
					<a href="${pageContext.request.contextPath}/jobs" class="tab">
						<div class="tab-title d-flex justify-content-between">
							<div class="tab-head">Total Jobs</div>
							<div class="tab-value">20</div>
						</div>
					</a>
				</div>
				<div class="col-sm-2">
					Dashboard
				</div>
				<div class="col-sm-2">

				</div>
					
				<div class="col-sm-6">
					
				</div>
			</div>
		</div>
	</jsp:attribute>
</t:app>