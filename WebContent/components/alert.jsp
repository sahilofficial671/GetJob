<%
if(request.getSession().getAttribute("status") != null){
	if(request.getSession().getAttribute("status").equals("success")){
		%>
			<div class="alert alert-success" role="alert">
						<% out.print(request.getSession().getAttribute("message")); %>
			</div>
		<%
	}
	if(request.getSession().getAttribute("status").equals("error")){
		%>
			<div class="alert alert-danger" role="alert">
						<% out.print(request.getSession().getAttribute("message")); %>
			</div>
		<%
	}
	if(request.getSession().getAttribute("status").equals("warning")){
		%>
			<div class="alert alert-warning" role="alert">
						<% out.print(request.getSession().getAttribute("message")); %>
			</div>
		<%
	}
	if(request.getSession().getAttribute("status").equals("info")){
		%>
			<div class="alert alert-primary" role="alert">
						<% out.print(request.getSession().getAttribute("message")); %>
			</div>
		<%
	}
}
%>