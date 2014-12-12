<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!-- Remplir Update Session Modal -->
	<script type="text/javascript">
	
	function jsonGetSession(idSession){
		$.getJSON('<s:url action="get/session" namespace="/ajax" />', {idSession: idSession}, function(jsonResponse) {
			if(jsonResponse.status === "success"){

				//set inputs value from jsonResponse
				document.getElementById("inputIdSessionFormation").value = idSession;
				document.getElementById("inputTitreSessionFormation").value = jsonResponse.titreSessionFormation;
				document.getElementById("inputLieuSessionFormation").value = jsonResponse.lieuSessionFormation;
				document.getElementById("inputDateDebutSession").value = jsonResponse.dateDebutSessionFormation;
				document.getElementById("inputDateFinSession").value = jsonResponse.dateFinSessionFormation;
				
				//set description
// 				$("#updateSessionModal iframe").contents().find(".wysihtml5-editor").html(jsonResponse.desciptionSessionFormation);
				$("#desciptionSessionFormation").html(jsonResponse.desciptionSessionFormation);
				
				//set formateur
				var selecteBox = document.getElementById("inputFormateur");
				for(i = 0 ; i < selecteBox.length; i++){
					if(selecteBox[i].value == jsonResponse.idFormateur){
						selecteBox[i].selected = true;
					}
					else{
						selecteBox[i].selected = false;
					}
				}
				
				$('#updateSessionModal').modal('show');
			}
	  	});
	};
	</script>
<!-- End Remplir Update Session Modal -->