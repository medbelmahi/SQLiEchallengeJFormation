<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!-- Charger à nouveau Le fichier script & update seance by ajax Start -->
<script type="text/javascript">
	function chargeFileJs_timepicker(){
	
		$.getScript('<s:url value="/js/pickers-init.js"/>', function(){
		   	// Here you can use anything you defined in the loaded script
		});
	}
	
	var globaleStatus = null;
	//Ajax for update seance
	function jsonUpdateSeance(idSeance, titreSeance, descriptionSeance, heureDebutSeance, heureFinSeance){
		//make ajax request to /ajax/getCollaborateur?idCollaborateur=x
		$.getJSON('<s:url action="update/seance" namespace="/ajax" />', {idSeance : idSeance, titreSeance : titreSeance,
																		descriptionSeance : descriptionSeance, heureDebutSeance : heureDebutSeance,
																		heureFinSeance : heureFinSeance}, function(jsonResponse) {
			
			//if satuts == "success" , do
			if(jsonResponse.status === "success"){
				console.log("success");				
			}else {
				console.log("erreur");
			}
			globaleStatus = jsonResponse.status;
			return jsonResponse.status;
	  	});
		
	};
	
	var FunctionOne = function () {
		  // create a deferred object
		  var r = $.Deferred();

		  // do whatever you want (e.g. ajax/animations other asyc tasks)

		  setTimeout(function () {
		    // and call `resolve` on the deferred object, once you're done
		    r.resolve();
		  }, 2500);

		  // return the deferred object
		  return r;
		};
	
	
</script>
<!-- Charger à nouveau Le fichier script & update seance by ajax End -->