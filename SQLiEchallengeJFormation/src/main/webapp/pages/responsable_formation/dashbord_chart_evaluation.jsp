<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0">
  <link rel="shortcut icon" href="#" type="image/png">

  <title>Graphe</title>

 <!-- initial style -->
	<link href='<s:url value="/css/style.css"/>' rel="stylesheet">
	<link href='<s:url value="/css/style-responsive.css"/>' rel="stylesheet">

  <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
  <!--[if lt IE 9]>
  <script src="js/html5shiv.js"></script>
  <script src="js/respond.min.js"></script>
  <![endif]-->
</head>

<body style="background-color: #FFFFFF;" class="">

<section>
    <div class="container ">
    	<div id="erreur-row" class="row">
    		
    	</div>
		<div class="row">
			<div>
				<canvas id="canvas" height="350" width="700"></canvas>
			</div>
		</div>
		
		<div style="margin-top: 20px;" id="quesionTable" class="row">
			
		</div>

    </div>
</section>

	<s:property value="idSession"/>
	
<!-- Placed js at the end of the document so the pages load faster -->
	<script src='<s:url value="/js/jquery-1.10.2.min.js"/>'></script>
	<script src='<s:url value="/js/jquery-migrate-1.2.1.min.js"/>'></script>
	<script src='<s:url value="/js/bootstrap.min.js"/>'></script>
	<script src='<s:url value="/js/modernizr.min.js"/>'></script>
	
	<!-- Chart JS -->
	<script src='<s:url value="/lib/JFormation/js/Chart.js"/>'></script>
	
	<script type="text/javascript" >
		var query = window.location.search;
		
		var idSession = query.substring(query.indexOf('=')+1);
		var arrayAbsenceCount = new Array();
		var arraySeance = new Array();
		function remplirChartEvaluation(idSession){
			$.getJSON('<s:url action="get/evaluation/result" namespace="/ajax" />', {idSession : idSession}, function(jsonResponse) {
				
				//if satuts == "success" , do
				if(jsonResponse.status === "success"){
					
					for(i=0; i<jsonResponse.results.length ; i++){
						arrayAbsenceCount[i]=jsonResponse.results[i].avgScore;
						arraySeance[i]= 'Question : '+jsonResponse.results[i].idQuestion;
					}
					
					
					if(jsonResponse.results.length == 0){
						$('#erreur-row').html('<div class="col-md-12">'
					   							+'<div class="alert alert-block alert-danger fade in">'
				                				+'<button type="button" class="close close-sm" data-dismiss="alert">'
				                    			+'<i class="fa fa-times"></i>'
				                    			+'</button>'
				                    			+'<strong>Erreur : aucune donnée disponible</strong>'
				                    			+'</div>'
				                    			+'</div>');
					}else{
						var tableContent = '<table class="table table-striped"><thead><tr><th>id</th><th>Question</th></tr></thead><tbody>';
						for(i=0; i<jsonResponse.results.length ; i++){
							tableContent += '<tr><td>'+jsonResponse.results[i].idQuestion+'</td><td>'+jsonResponse.results[i].question+'</td></tr>';
						}
						tableContent += '</table>';
						$('#quesionTable').html(tableContent);
					}
					
				}
				
	  		});
		}
		remplirChartEvaluation(idSession)
		
		

	window.onload = function(){
		var barChartData = {
				labels : arraySeance,
				datasets : [
					{
						label: "My First dataset",
						fillColor : "rgba(215, 40, 40, 0.9)",
						strokeColor : "rgba(220,220,220,1)",
						pointColor : "rgba(220,220,220,1)",
						pointStrokeColor : "#fff",
						pointHighlightFill : "#fff",
						pointHighlightStroke : "rgba(220,220,220,1)",
						data : arrayAbsenceCount
					}
				]
	
			}
		setTimeout(function () {
			var ctx = document.getElementById("canvas").getContext("2d");
			window.myLine = new Chart(ctx).Bar(barChartData, {
				responsive: true
			});
		  }, 1000);
		
	}


	</script>

<!--common scripts for all pages-->
<!--<script src="js/scripts.js"></script>-->

</body>
</html>
