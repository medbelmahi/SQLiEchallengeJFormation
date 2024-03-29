<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>


<!-- Remplir Update Collaborateur Modal -->
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
				
				var urlRacine = "${pageContext.request.contextPath}";
				
				//set image profil
				var imageCollaborateur = document.getElementById("imageCollaborateur");
				imageCollaborateur.setAttribute("src",urlRacine+'/download?file='+jsonResponse.imageProfil);
				
				
				//check sexe option
				if(jsonResponse.sexe == "Homme"){
					document.getElementById("optionHomme").checked = true;
					document.getElementById("optionFemme").checked = false;
					var elementGreen = $("#optionHomme_label").prev();
					var elementRed = $("#optionFemme_label").prev();
					elementGreen.addClass("checked");
					elementRed.removeClass("checked");
				}else{
					document.getElementById("optionFemme").checked = true;
					document.getElementById("optionHomme").checked = false;
					var elementGreen = $("#optionHomme_label").prev();
					var elementRed = $("#optionFemme_label").prev();
					elementRed.addClass("checked");
					elementGreen.removeClass("checked");
				}
				
				$('#updateCollaborateurModal').modal('show');
				
			}
	  	});
	};
</script>
<!-- End Remplir Update Collaborateur Modal -->

<!-- Begin envoyer un message à un Collaborateur ajax -->
	<script type="text/javascript">
		function jsonGetCollaborateur_forSendEmail(idCollaborateur){
			//make ajax request to /ajax/getCollaborateur?idCollaborateur=x
			$.getJSON('<s:url action="get/collaborateur" namespace="/ajax" />', {idCollaborateur : idCollaborateur}, function(jsonResponse) {
				//if satuts == "success" , do
				if(jsonResponse.status === "success"){
					
					//set inputs value from jsonResponse
					document.getElementById("idCollaborateur_sendMessage").value = jsonResponse.idCollaborateur;
					document.getElementById("fullnameTo").innerHTML = jsonResponse.fullname;
					document.getElementById("to").value = jsonResponse.email;
	
				}
		  	});
			
			$('#sendCollaborateurMessageModal').modal('show');
		};
		
	</script>
<!-- End envoyer un message à un Collaborateur utilisant ajax -->

<!-- Begin Initialisation du tableua Collaborateur -->
	<script type="text/javascript">
		function fnFormatDetails ( oTable, nTr )
		{
		    var aData = oTable.fnGetData( nTr );
		    var sOut = '<table width="100%" cellpadding="5" cellspacing="0" border="0" style="padding-left:50px;">';
		    sOut += '<tr><td colspan="2" rowspan="3"><div class="profile-pic text-center"><img class="image-profil" alt="" src="'+aData[9]+'"></div>';
		    sOut += '</td><td width="130">Sexe : </td><td width="108">'+aData[4]+'</td></tr>';
		    sOut += '<tr><td>Date de naissance : </td><td>'+aData[7]+'</td></tr>';
		    sOut += '<tr><td>Adresse : </td><td>'+aData[6]+'</td></tr>';
		    sOut += '<tr><td width="121">Nom & Prénom : </td><td width="213">'+aData[1]+'</td></tr>';
		    sOut += '<tr><td>Email : </td><td>'+aData[2]+'</td><td rowspan="3">habilitaition</td><td rowspan="3">'+aData[8]+'</td></tr>';
		    sOut += '<tr><td>Telephone : </td><td>'+aData[3]+'</td></tr>';
		    sOut += '</table>';
		    
		    return sOut;
		}
		
		
		$('.image-profil').off( "click", "**" );
	    $('.image-profil').click(false);
		
		
	</script>
<!-- End Initialisation du tableua Collaborateur -->


<!-- init stepy wizard valisation form for upadate and add collaborateur  Start  -->
	<script type="text/javascript">
		initStepyForm('add_collaborateur');
		initStepyForm('update_collaborateur');
	</script>
<!-- init stepy wizard valisation form for upadate and add collaborateur  Start  -->