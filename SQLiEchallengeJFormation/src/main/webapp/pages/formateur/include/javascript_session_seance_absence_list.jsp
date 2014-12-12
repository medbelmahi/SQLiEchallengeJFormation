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


<!-- Begin Initialisation du tableua Collaborateur -->
	<script type="text/javascript">
		function fnFormatDetails ( oTable, nTr )
		{
		    var aData = oTable.fnGetData( nTr );
		    var sOut = '<table width="100%" cellpadding="5" cellspacing="0" border="0" style="padding-left:50px;">';
		    /* sOut += '<tr><td>Nom & Prénom:</td><td>'+aData[1]+'</td></tr>';
		    sOut += '<tr><td>Email:</td><td>'+aData[2]+'</td></tr>';
		    sOut += '<tr><td>Telephone:</td><td>'+aData[3]+'</td></tr>';
		    sOut += '<tr><td>Sexe:</td><td>'+aData[4]+'</td></tr>';
		    sOut += '<tr><td>Adresse:</td><td>'+aData[6]+'</td></tr>';
		    sOut += '<tr><td>Date de naissance:</td><td>'+aData[7]+'</td></tr>';
		    sOut += '<tr><td>Habilitations:</td><td>'+aData[8]+'</td></tr>'; */
		    sOut += '<tr><td colspan="2" rowspan="3"><div class="profile-pic text-center"><img alt="" src="'+aData[9]+'"></div>';
		    sOut += '</td><td width="130">Sexe : </td><td width="108">'+aData[5]+'</td></tr>';
		    sOut += '<tr><td>Date de naissance : </td><td>'+aData[7]+'</td></tr>';
		    sOut += '<tr><td>Adresse : </td><td>'+aData[6]+'</td></tr>';
		    sOut += '<tr><td width="121">Nom & Prénom : </td><td width="213">'+aData[2]+'</td></tr>';
		    sOut += '<tr><td>Email : </td><td>'+aData[3]+'</td><td rowspan="3">habilitaition</td><td rowspan="3">'+aData[8]+'</td></tr>';
		    sOut += '<tr><td>Telephone : </td><td>'+aData[4]+'</td></tr>';
		    sOut += '</table>';
		
		    return sOut;
		}
	</script>
<!-- End Initialisation du tableua Collaborateur -->