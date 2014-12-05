<!-- Begin SelectHabilitaion from multi-select -->
	<script type="text/javascript">
	
// 	$('.ms-list').off("click", "**");
	
	$('#ms-my_multi_select3_costum div ul .ms-elem-selectable').click(function selectedItem() {
		
			/* $('.ms-elem-selectable').removeClass("selectedItem");
			$(this).addClass("selectedItem"); */
			
			var str = $(this).attr('id'); 
			var id = str.substring(0,str.lastIndexOf("-"));
			
			document.getElementById("habilitationOptionId_"+id).setAttribute("selected", "true");
			
			/*document.getElementById('theHabilitation_add').value = id;
			
			document.getElementById('theHabilitationName').innerHTML = $(this).html();
			document.getElementById('theHabilitationDescription').innerHTML = $(this).attr('data-description'); */
		});
	
		$('#ms-my_multi_select3_costum div ul .ms-elem-selection').click(function selectedItem() {
			
			/* $('.ms-elem-selectable').removeClass("selectedItem");
			$(this).addClass("selectedItem"); */
			
			var str = $(this).attr('id'); 
			var id = str.substring(0,str.lastIndexOf("-"));
			
			document.getElementById("habilitationOptionId_"+id).removeAttribute("selected");
			
			/*document.getElementById('theHabilitation_add').value = id;
			
			document.getElementById('theHabilitationName').innerHTML = $(this).html();
			document.getElementById('theHabilitationDescription').innerHTML = $(this).attr('data-description'); */
		});
	
	
	$('#ms-my_multi_select3_costum_2 div ul .ms-elem-selectable').click(function selectedItem() {
		
		console.log('jdkjf');
		
		$('.ms-elem-selectable').removeClass("selectedItem");
		$(this).addClass("selectedItem");
		
		var str = $(this).attr('id');
		var id = str.substring(0,str.lastIndexOf("-"));
		
		document.getElementById('theHabilitation_delete').value = id;
// 		document.getElementById('theHabilitationScore_3').value = id;
// 		var score = $(this).attr('data-score');
// 		document.getElementById('theScore_2').value = score;
		
// 		$('.startRating_2').rating('select',score-1);
		
		document.getElementById('theHabilitationName_2').innerHTML = $(this).html();
		document.getElementById('theHabilitationDescription_2').innerHTML = $(this).attr('data-description');
	});
		
		$(".ms-elem-selectable").mouseleave(function(){
			$(this).removeClass("ms-hover");
		});
		
		
		function initMultiSelectionList()
		{
			var multiSelect = document.getElementById('my_multi_select3_costum');
			var element;
			for(i=0; i < multiSelect.length; i++)
				{
					if(multiSelect[i].selected){
						element = document.getElementById(multiSelect[i].value+"-selectable");
						element.style.color.display = "none";
						
					}else{
						element = document.getElementById(multiSelect[i].value+"-selection");
						element.style.color.display = "list-item";
					}
				}
		}
		
		initMultiSelectionList();
		
	</script>
<!-- End SelectHabilitaion from multi-select -->