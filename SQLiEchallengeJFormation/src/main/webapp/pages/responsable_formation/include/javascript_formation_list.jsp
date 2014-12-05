<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!-- Remplir Update Formation Modal -->
	<script type="text/javascript">
	
	function jsonGetFormation(idFormation){
		$.getJSON('<s:url action="get/formation" namespace="/ajax" />', {idFormation : idFormation}, function(jsonResponse) {
			if(jsonResponse.status === "success"){

				//set inputs value from jsonResponse
				document.getElementById("idFormationInputHidden").value = jsonResponse.idFormation;
				document.getElementById("inputTitleFormation").value = jsonResponse.titreFormation;
				document.getElementById("inputDescriptionFormation").value = jsonResponse.descriptionFormation;
				
				
				$('#updateFormationModal').modal('show');
			}
	  	});
	};
	</script>
<!-- End Remplir Update Formation Modal -->