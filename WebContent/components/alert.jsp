<%
if(request.getSession().getAttribute("status") != null){
	
	String alert_type;
    switch(request.getSession().getAttribute("status").toString()) 
    { 
        case "success": 
        	alert_type = "success";
            break; 
        case "warning": 
        	alert_type = "warning";
            break; 
        case "info": 
        	alert_type = "info"; 
            break; 
        default: 
        	alert_type = "danger";
    }
%>
	<div class="alert alert-<%=alert_type %> alert-dismissible" role="alert">
		<% out.print(request.getSession().getAttribute("message")); %>
		<button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
	</div>
<% } %>