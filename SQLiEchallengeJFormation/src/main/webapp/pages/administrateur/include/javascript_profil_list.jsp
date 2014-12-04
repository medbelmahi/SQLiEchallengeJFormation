<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!-- Remplir affectation modal Start -->
<script type="text/javascript">
	
	//remplir le modal d'affectation des Actions
	function jsonGetProfil_pourAffectation(idProfil){
		$.getJSON('<s:url action="get/actions" namespace="/ajax" />', {idProfil : idProfil}, function(jsonResponse) {
			if(jsonResponse.status === "success"){
				
				//set inputs value from jsonResponse
				document.getElementById("idProfilAffectation").value = jsonResponse.idProfil;
				
				var checkboxElementInnerHtml = "";
				var stringTemp = "";
				
				for(key in jsonResponse.allActionsMap){
					if(existeAction(jsonResponse.allActionsMap[key] , jsonResponse.profilActionsMap)){
						stringTemp = '<div class="col-lg-12 vcenter">'
									+'<div class="col-sm-12 icheck ">'
									+'<div class="square-green single-row col-sm-12">'
									+'<div class="checkbox col-sm-12" style="position: relative;">'
									+'<input name="actions" value="'+key+'" type="checkbox" checked>'
// 									+'<label class="popovers" data-trigger="hover" data-placement="right" data-content="'+jsonResponse.actionBeans[i].action.descriptionAction+'" data-original-title="'+jsonResponse.actionBeans[i].action.nomAction+'">'
									+'<label>' +jsonResponse.allActionsMap[key]+ '</label>'
									+'</div>'
									+'</div>'
									+'</div>'
									+'</div>';
					}else{
						stringTemp = '<div class="col-lg-12 vcenter">'
							+'<div class="col-sm-12 icheck ">'
							+'<div class="square-green single-row col-sm-12">'
							+'<div class="checkbox col-sm-12" style="position: relative;">'
							+'<input name="actions" value="'+key+'" type="checkbox">'
//								+'<label class="popovers" data-trigger="hover" data-placement="right" data-content="'+jsonResponse.actionBeans[i].action.descriptionAction+'" data-original-title="'+jsonResponse.actionBeans[i].action.nomAction+'">'
							+'<label>' +jsonResponse.allActionsMap[key]+ '</label>'
							+'</div>'
							+'</div>'
							+'</div>'
							+'</div>';
					}
					
					checkboxElementInnerHtml += stringTemp;
				}
				
				var checkboxElement = document.getElementById("checkboxElement");
				checkboxElement.innerHTML = checkboxElementInnerHtml;
				
				document.getElementById("profilTitle").innerHTML = "Affectation des action au profil ( "+jsonResponse.nomProfil+" )";
				 
				//initialiser icheck
				 $.getScript('<s:url value="/js/icheck-init.js"/>', function(){
				   // Here you can use anything you defined in the loaded script
				});
				 
				// popovers
			    $('.popovers').popover();
				 
				$('#myModal_action').modal('show');
			}
	  	});
	};
	
	function existeAction(action , listAction){
			for(key_ in listAction){
				if(listAction[key_] == action )return true;
			}
			
			return false;
		};
	
</script>
<!-- Remplir affectation modal End -->