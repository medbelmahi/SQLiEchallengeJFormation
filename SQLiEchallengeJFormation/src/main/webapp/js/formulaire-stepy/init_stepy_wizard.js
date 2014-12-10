
    /*=====STEPY WIZARD====*/
   /*  $(function() {
        $('#add_utilisateur').stepy({
            backLabel: 'Previous',
            block: true,
            nextLabel: 'Next',
            titleClick: true,
            titleTarget: '.stepy-tab'
        });
    }); */

/*=====STEPY WIZARD WITH VALIDATION for Add_utilitateur form Start ====*/
    
	function initStepyForm(idForm){
		$(function() {
	        $('#'+idForm).stepy({
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
	        $('#'+idForm).validate({
	            errorPlacement: function(error, element) {
	                $('#stepy_form div.stepy-error').append(error);
	            },
	            rules: {
	                'nom': 'required',
	                'email': 'required',
	                'prenom': 'required',
	                'dateNaissance': 'required',
	                'adresse': 'required',
	                'telephone': 'required'
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
	}
	
/*=====STEPY WIZARD WITH VALIDATION for Add_utilitateur form End ====*/
    
    
    /* init stepy wizard valisation form for upadate_tilisateur  Start */