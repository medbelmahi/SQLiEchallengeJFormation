<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>


<!-- Remplir Update Collaborateur Modal Start -->
	<script type="text/javascript">
	function jsonGetCollaborateur(idCollaborateur){
		//make ajax request to /ajax/getCollaborateur?idCollaborateur=x
		$.getJSON('<s:url action="get/collaborateur" namespace="/ajax" />', {idCollaborateur : idCollaborateur}, function(jsonResponse) {
			//if satuts == "success" , do
			if(jsonResponse.status === "success"){
				
				//set inputs value from jsonResponse
				document.getElementById("idCollaborateur").value = jsonResponse.idCollaborateur;
				document.getElementById("inputLastName").value = jsonResponse.nom;
				document.getElementById("inputFirstName").value = jsonResponse.prenom;
				document.getElementById("inputEmail").value = jsonResponse.email;
				document.getElementById("inputTelephone").value = jsonResponse.telephone;
				document.getElementById("inputDateNaissance").value = jsonResponse.dateNaissance;
				document.getElementById("inputAdress").value = jsonResponse.adresse; 
				
				//set image collaborateur
				var imageCollaborateur = document.getElementById("imageCollaborateur");
				imageCollaborateur.setAttribute("src",jsonResponse.imageProfil);
				
				//check sexe option
				if(jsonResponse.sexe == "true"){
					document.getElementById("optionHomme").checked = true;
					document.getElementById("optionFemme").checked = false;
					var elementGreen = $(".iradio_square-green");
					var elementRed = $(".iradio_square-red");
					elementGreen.addClass("checked");
					elementRed.removeClass("checked");
				}else{
					document.getElementById("optionFemme").checked = true;
					document.getElementById("optionHomme").checked = false;
					var elementRed = $(".iradio_square-red");
					var elementGreen = $(".iradio_square-green");
					elementRed.addClass("checked");
					elementGreen.removeClass("checked");
				}
			}
	  	});
		
		$('#updateCollaborateurModal').modal('show');
	};
	</script>
<!-- Remplir Update Collaborateur Modal End -->



<!-- Begin envoyer un message à un collaborateur utilisant ajax -->
	<script type="text/javascript">
		function jsonGetCollaborateur_forSendEmail(idCollaborateur){
			//make ajax request to /ajax/getCollaborateur?idCollaborateur=x
			$.getJSON('<s:url action="get/collaborateur" namespace="/ajax" />', {idCollaborateur : idCollaborateur}, function(jsonResponse) {
				//if satuts == "success" , do
				if(jsonResponse.status === "success"){
					
					//set inputs value from jsonResponse
					document.getElementById("idCollaborateur_sendMessage").value = jsonResponse.idCollaborateur;
					var fullName = jsonResponse.nom + " " + jsonResponse.prenom;
					document.getElementById("fullnameTo").innerHTML = fullName;
					document.getElementById("to").value = jsonResponse.email;
	
				}
		  	});
			
			$('#sendCollaborateurMessageModal').modal('show');
		};
		
	</script>
<!-- End envoyer un message à un collaborateur utilisant ajax -->
	