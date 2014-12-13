<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!-- change select session Start -->
	<script type="text/javascript">
		//ajax function get all sessions of a formation
		function getAllSession(){
			var idFormation = $('#selectIdFormation')[0].value;
			//make ajax request to /ajax/ get la liste des sessions d'une formations 
			$.getJSON('<s:url action="get/sessions" namespace="/ajax" />', {idFormation : idFormation}, function(jsonResponse) {
				
				console.log(idFormation);
				
				//if satuts == "success" , do
				if(jsonResponse.status === "success"){
					
					var selectCentent = "";
					for(key in jsonResponse.sessions){
						selectCentent += '<option value="'+key+'" >'+jsonResponse.sessions[key]+'</option>';
					}
					
					$('#selectIdSession').html(selectCentent);
				}
				
	  		});
		}
		
		$('#selectIdFormation').change(function(){
			
			getAllSession();
		});
		$(document).ready(function() {
			getAllSession();
		});
		
	</script>
<!-- change select session End -->

<!-- Dashboard popUp Chart Start -->
	<script type="text/javascript" >
		function ouvre_popup(page) {
			console.log(page);
		   window.open(page,"nom_popup","menubar=no, status=no, scrollbars=no, menubar=no, width=850, height=500");
		}
		
		function popUpEvaluation(){
			var idSession  = $('#selectIdSession')[0].value;
			ouvre_popup('<s:url action="dashboard/dashbord_chart_evaluation" namespace="/responsableFormation" />?idSession='+idSession);
		}
	</script>
<!-- Dashboard popUp Chart End -->