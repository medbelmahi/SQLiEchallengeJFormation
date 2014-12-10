<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>


<!-- Remplir Update Utilisateur Modal -->
	<script type="text/javascript">
	
	function jsonGetUtilisateur(idUtilisateur){
		//make ajax request to /ajax/getCollaborateur?idCollaborateur=x
		$.getJSON('<s:url action="get/utilisateur" namespace="/ajax" />', {idUtilisateur : idUtilisateur}, function(jsonResponse) {
			//if satuts == "success" , do
			if(jsonResponse.status === "success"){
				
				//set inputs value from jsonResponse
				document.getElementById("idUtilisateur").value = jsonResponse.idUtilisateur;
				document.getElementById("inputLastName").value = jsonResponse.nom;
				document.getElementById("inputFirstName").value = jsonResponse.prenom;
				document.getElementById("inputEmail").value = jsonResponse.email;
				document.getElementById("inputTelephone").value = jsonResponse.telephone;
				document.getElementById("inputDateNaissance").value = jsonResponse.dateNaissance;
				document.getElementById("inputAdress").value = jsonResponse.adresse; 
				
				//set image profil
				var imageProfil = document.getElementById("utilisateurImageProfil");
				imageProfil.setAttribute("src",jsonResponse.imageProfil);
				
				
				//check sexe option
				if(jsonResponse.sexe == "Homme"){
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
				
				var profilSelected = document.getElementById("profilSelected");
				
				//select profil option
				for(var i=0; i < profilSelected.length; i++){
					if(jsonResponse.profil == profilSelected[i].value){
						profilSelected[i].selected=true;
					}else{
						profilSelected[i].selected=false;
					}
				}
				
				$('#updateUtilisateurModal').modal('show');
				
			}
	  	});
	}	
	
	</script>
<!-- End Remplir Update Utilisateur Modal -->

<!-- Begin envoyer un message à un Utilisateur utilisant ajax -->
	<script type="text/javascript">
		function jsonGetUtilisateur_forSendEmail(idUtilisateur){
			//make ajax request to /ajax/getCollaborateur?idCollaborateur=x
			$.getJSON('<s:url action="get/utilisateur" namespace="/ajax" />', {idUtilisateur : idUtilisateur}, function(jsonResponse) {
				//if satuts == "success" , do
				if(jsonResponse.status === "success"){
					
					//set inputs value from jsonResponse
					document.getElementById("idUtilisateur_sendMessage").value = jsonResponse.idUtilisateur;
					document.getElementById("fullnameTo").innerHTML = jsonResponse.fullname;
					document.getElementById("to").value = jsonResponse.email;
	
				}
		  	});
			
			$('#sendUtilisateurMessageModal').modal('show');
		};
		
		
		//envoyer le message à un utilisateur utilisant ajax puisque l'action prend bcp du temps
		function sendMessageToCollaboroateur_ajax(){
			var idCollaborateur = document.getElementById("idCollaborateur_sendMessage").value;
			var object = document.getElementById("subject").value;
			var msg = document.getElementById("msg_").value;
			
			if(idCollaborateur != "" && object != "" && msg != ""){
				$('#sendMessageModal').modal('hide');
				$.getJSON('<s:url action="sendEmailToCollaborateurAjax" namespace="/ajax" />', {id : idCollaborateur, object : object, msg : msg}, function(jsonResponse) {
					//if satuts == "success" , do
					if(jsonResponse.status === "success"){
						
						$.gritter.add({
				            // (string | mandatory) the heading of the notification
				            title: 'Message !',
				            // (string | mandatory) the text inside the notification
				            text: 'Le message ("'+jsonResponse.object+'") été bien envoyé à '+jsonResponse.collaborateur.fullname+' .'
				            
				        });
						
						
						//vider les champs :
							document.getElementById("subject").value = "";
							document.getElementById("msg_").value = "";
					}else
						{
							alert("message nn envoyé");
						}
			  	});
			}else
				{
					alert("remplir tout les champ");
				}
		}
	</script>
<!-- End envoyer un message à un Utilisateur utilisant ajax -->

<!-- Begin Initialisation de cellspacing table utilisateur -->
	<script type="text/javascript">
		function fnFormatDetails ( oTable, nTr )
		{
		    var aData = oTable.fnGetData( nTr );
		    var sOut = '<table width="100%" cellpadding="5" cellspacing="0" border="0" style="padding-left:50px;">';
		    sOut += '<tr><td colspan="2" rowspan="3"><div class="profile-pic text-center"><img class="image-profil" alt="" src="'+aData[9]+'"></div></td><td>Telephone : </td><td>'+aData[3]+'</td></tr>';
		    sOut += '<tr><td>Date de naissance : </td><td>'+aData[8]+'</td></tr>';
    		sOut += '<tr><td>Sexe : </td><td>'+aData[4]+'</td></tr>';
    		sOut += '<tr><td>Nom &amp; Prènom : </td><td>'+aData[1]+'</td><td>Adresse : </td><td>'+aData[7]+'</td></tr>';
    		sOut += '<tr><td>Email : </td><td>'+aData[2]+'</td><td>Profil : </td><td>'+aData[5]+'</td></tr>';
		    sOut += '</table>';
		    $('.image-profil').off( "click", "**" );
		    $('.image-profil').click(false);
		    return sOut;
		}
		
		$('.image-profil').off( "click", "**" );
		$('.image-profil').click(false);
	</script>
<!-- End Initialisation de cellspacing table utilisateur -->


<script>
    /*=====STEPY WIZARD====*/
    $(function() {
        $('#add_utilisateur').stepy({
            backLabel: 'Previous',
            block: true,
            nextLabel: 'Next',
            titleClick: true,
            titleTarget: '.stepy-tab'
        });
    });
    /*=====STEPY WIZARD WITH VALIDATION====*/
    $(function() {
        $('#stepy_form').stepy({
            backLabel: 'Précédent',
            nextLabel: 'Suivant',
            errorImage: true,
            block: true,
            description: true,
            legend: false,
            titleClick: true,
            titleTarget: '#top_tabby',
            validate: true
        });
        $('#stepy_form').validate({
            errorPlacement: function(error, element) {
                $('#stepy_form div.stepy-error').append(error);
            },
            rules: {
                'nom': 'required',
                'email': 'required',
                'prenom': 'required',
                'dateNaissance': 'required',
                'telephone': 'required',
                'adresse': 'required'
            },
            messages: {
                'nom': {
                    required: 'Nom : ce champ est obligatoire!'
                },
                'email': {
                    required: 'Email : ce champ est obligatoire!'
                },
                'prenom': {
                    required: 'Prénom : ce champ est obligatoire!'
                },
                'dateNaissance': {
                    required: 'Date De Naissance : ce champ est obligatoire!'
                },
                'telephone': {
                    required: 'Telephone : ce champ est obligatoire!'
                },
                'adresse': {
                    required: 'Adresse : ce champ est obligatoire!'
                }
            }
        });
    });
    
    $( "#stepy_form" ).submit(function( event ) {
    	  alert( "Handler for .submit() called." );
    	  event.preventDefault();
    	});
    
    
    function beforSubmitTheForm(){
    	
    	return false;
    }
</script>
