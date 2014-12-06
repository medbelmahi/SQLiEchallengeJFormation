<!-- Begin SelectHabilitaion from multi-select -->
	<script type="text/javascript">
	
	$('#ms-my_multi_select3_costum div ul .ms-elem-selectable').click(function selectedItem() {
		
			var str = $(this).attr('id'); 
			var id = str.substring(0,str.lastIndexOf("-"));
			
			document.getElementById("habilitationOptionId_"+id).setAttribute("selected", "selected");
			
		});
	
		$('#ms-my_multi_select3_costum div ul .ms-elem-selection').click(function selectedItem() {
			
			var str = $(this).attr('id'); 
			var id = str.substring(0,str.lastIndexOf("-"));
			
			document.getElementById("habilitationOptionId_"+id).removeAttribute("selected");
			
		});
	
		
		$(".ms-elem-selectable").mouseleave(function(){
			$(this).removeClass("ms-hover");
		});
		
		function initMultiSelectionList()
		{
			var multiSelect = document.getElementById('my_multi_select3_costum');
			var element;
			var element2;
			for(i=0; i < multiSelect.length; i++)
				{
					if(multiSelect[i].getAttribute("selected") == "selected" ) {
						element = document.getElementById(multiSelect[i].value+"-selectable");
						element.style.color.display = "none";
						element2 = document.getElementById(multiSelect[i].value+"-selection");
						element2.style.color.display = "list-item";
						
					}else{
						element2 = document.getElementById(multiSelect[i].value+"-selectable");
						element2.style.color.display = "list-item";
						element = document.getElementById(multiSelect[i].value+"-selection");
						element.style.color.display = "none";
						
					}
				}
		}
		
		initMultiSelectionList();
		
	</script>
<!-- End SelectHabilitaion from multi-select -->