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
		<div class="row">
			<div>
				<canvas id="canvas" height="350" width="700"></canvas>
			</div>
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
		console.log(idSession);
		var arrayAbsenceCount = new Array();
		var arraySeance = new Array();
		function remplirChartEvaluation(idSession){
			$.getJSON('<s:url action="get/evaluation/result" namespace="/ajax" />', {idSession : idSession}, function(jsonResponse) {
				
				//if satuts == "success" , do
				if(jsonResponse.status === "success"){
					var arrayAbsenceCount = new Array();
					var arraySeance = new Array();
					for(i=0; i<jsonResponse.results.length ; i++){
						arrayAbsenceCount[i]=jsonResponse.results[i].absenceCount;
						arraySeance[i]= 'Séance : '+jsonResponse.results[i].idSeance;
					}
					
				}
				
	  		});
		}
		
		var randomScalingFactor = function(){ return Math.round(Math.random()*100)};
		var lineChartData = {
			labels : arraySeance,
			datasets : [
				{
					label: "My First dataset",
					fillColor : "rgba(220,220,220,0.2)",
					strokeColor : "rgba(220,220,220,1)",
					pointColor : "rgba(220,220,220,1)",
					pointStrokeColor : "#fff",
					pointHighlightFill : "#fff",
					pointHighlightStroke : "rgba(220,220,220,1)",
					data : 
				}
			]

		}

	window.onload = function(){
		var ctx = document.getElementById("canvas").getContext("2d");
		window.myLine = new Chart(ctx).Line(lineChartData, {
			responsive: true
		});
	}


	</script>

<!--common scripts for all pages-->
<!--<script src="js/scripts.js"></script>-->

</body>
</html>
