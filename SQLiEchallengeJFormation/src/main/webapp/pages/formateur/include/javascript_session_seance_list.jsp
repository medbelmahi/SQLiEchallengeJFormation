<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!-- Charger à nouveau Le fichier script & update seance by ajax Start -->
<script type="text/javascript">
	function chargeFileJs_timepicker(){
	
		$.getScript('<s:url value="/js/pickers-init.js"/>', function(){
		   	// Here you can use anything you defined in the loaded script
		});
	}
	
	
	//Ajax for update seance
	function jsonUpdateSeance(idSeance, titreSeance, descriptionSeance, heureDebutSeance, heureFinSeance){
		//make ajax request to /ajax/getCollaborateur?idCollaborateur=x
		$.getJSON('<s:url action="update/seance" namespace="/ajax" />', {idSeance : idSeance, titreSeance : titreSeance,
																		descriptionSeance : descriptionSeance, heureDebutSeance : heureDebutSeance,
																		heureFinSeance : heureFinSeance}, function(jsonResponse) {
			/* //if satuts == "success" , do
			if(jsonResponse.status === "success"){
				
				//set inputs value from jsonResponse
				document.getElementById("idCollaborateur_sendMessage").value = jsonResponse.idCollaborateur;
				var fullName = jsonResponse.nom + " " + jsonResponse.prenom;
				document.getElementById("fullnameTo").innerHTML = fullName;
				document.getElementById("to").value = jsonResponse.email;
				
			} */
			
			return jsonResponse.status;
	  	});
		
	};
</script>
<!-- Charger à nouveau Le fichier script & update seance by ajax End -->