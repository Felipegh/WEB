

<%@tag description="calendario" pageEncoding="UTF-8"%>  
<%@ attribute name="id" required="true" %>


<script type="text/javascript">
		$(function() {
			$("#${id}").datepicker({dateFormat: 'dd/mm/yy'});
		});
</script>
<input type="text" id="${id}" name="${id}" />