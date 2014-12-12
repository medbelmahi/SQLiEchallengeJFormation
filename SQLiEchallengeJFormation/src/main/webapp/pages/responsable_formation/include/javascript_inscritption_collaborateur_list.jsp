<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>


<!-- menu collapsed Start -->
	<script type="text/javascript">
// 	$("input[type=checkbox][checked]").next().html('<small style="left: 23px; transition: left 0.2s; -webkit-transition: left 0.2s;"></small>');
	$("input[type=checkbox][checked]").next().children()[0].style.left="23px";
// 	menuCollapsed();
	
	 $(document).ready(function() {
		 jQuery($("input[type=checkbox]")[0]).next().children().trigger( "click" );
		 $('#selectAll').next().click(function(){
			 var allElement = $("input[type=checkbox]");
			 var etat = $('#selectAll')[0].checked;
				
					for(i = 1; i < allElement.length; i++ ){
						if(allElement[i].checked != etat){
							jQuery(allElement[i]).next().children().trigger( "click" );
						}
					}
				
			}
			);
		    
		} );
	 
		
	
	</script>
<!-- menu collapsed End -->

<!-- Begin Initialisation du tableau Collaborateur -->
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
<!-- End Initialisation du tableau Collaborateur -->


<!-- Remplir info Collaborateur Modal -->
<script type="text/javascript">
	function jsonGetCollaborateur(idCollaborateur){
		//make ajax request to /ajax/getCollaborateur?idCollaborateur=x
		$.getJSON('<s:url action="get/collaborateur" namespace="/ajax" />', {idCollaborateur : idCollaborateur}, function(jsonResponse) {
			//if satuts == "success" , do
			if(jsonResponse.status === "success"){
				
				//set inputs value from jsonResponse
// 				document.getElementById("idCollaborateur").value = jsonResponse.idCollaborateur;
				$("#collaborateurFullname").html(jsonResponse.fullname);
				$("#collaborateurEmail").html(jsonResponse.email);
				$("#collaborateurTelephone").html(jsonResponse.telephone);
				$("#collaborateurDateNaissance").html(jsonResponse.dateNaissance);
				$("#collaborateurSexe").html(jsonResponse.sexe);
				$("#collaborateurAdresse").html(jsonResponse.adresse);
				
				//set image profil
				var imageCollaborateur = document.getElementById("imageCollaborateur");
				imageCollaborateur.setAttribute("src",jsonResponse.imageProfil);
				
				
				//set habilitations
				var stringTemp = '<ul>';
				for(key in  jsonResponse.habilitations){
					stringTemp += '<li>'
					+'<label class="popovers" data-trigger="hover" data-placement="right" data-content="'
					+jsonResponse.habilitations[key]+'" data-original-title="'
					+key+'">'+key+'</label>'
					+'</li>';
				}
				stringTemp += '</ul>';
				
				$("#collaborateurHablitations").html(stringTemp);
				
				//popovers
				$('.popovers').popover();
				
				
				$('#collaborateurInfoModal').modal('show');
				
			}
	  	});
	};
</script>
<!-- End Remplir Info Collaborateur Modal -->
