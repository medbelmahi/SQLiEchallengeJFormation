<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0">
    <meta name="description" content="">
    <link rel="shortcut icon" href="#" type="image/png">

    <title>JFormation : Evaluation</title>
	
	<!--icheck-->
    <link href='<s:url value="/js/iCheck/skins/square/red.css"/>' rel="stylesheet">
	
    <link href='<s:url value="/css/style.css"/>' rel="stylesheet">
    <link href='<s:url value="/css/style-responsive.css"/>' rel="stylesheet">

    <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
    <script src="js/html5shiv.js"></script>
    <script src="js/respond.min.js"></script>
    <![endif]-->
</head>

<body class="login-body">

<div class="container">

    <form class="form-signin" action="reponses" style="max-width: 100%" method="post" onsubmit="doBeforeSbmit();">
    <input type="hidden" name='code' value='<s:property value="code" />' />
        <div class="form-signin-heading text-center">
            <h1 class="sign-title">Evaluation</h1>
            <img src="images/login-logo.png" alt=""/>
        </div>


        <div class="login-wrap">
        	<div class="row">
        		
        	</div>
        	<hr />
        	<div class="row">
                
                
                <section class="panel">
                    <header class="panel-heading">
                        Evaluation
                    </header>
                    <div class="panel-body">
                        <table class="table table-striped">
                            <thead>
                            <tr>
                                <th>#</th>
                                <th>Question</th>
                                <th class="text-center">Non concerné</th>
                                <th class="text-center">Pas du tout satisfait</th>
                                <th class="text-center">Peu  satisfait</th>
                                <th class="text-center">Satisfait</th>
                                <th class="text-center">Très satisfait</th>
                            </tr>
                            </thead>
                            <tbody>
                            	<s:iterator value="questions" status="itStatus">
									<tr><!-- row table begin -->
										
										<td>
											<s:property value="#itStatus.count" />
											<input type="hidden" name='idQuestions' value='<s:property value="idEvaluationQuestion" />' />
											<input type="hidden" name='scores' value="" />
										</td>
										<td><s:property value="question" /></td>
										<td>
											<div class="icheck ">
												<div class="square-red">
													<div class="radio ">
														<input tabindex="3" checked="checked" type="radio" name='scores[<s:property value="%{#itStatus.count-1}" />]' value="1">
													</div>
												</div>
											</div>
										</td>
										<td>
											<div class="icheck ">
												<div class="square-red">
													<div class="radio ">
														<input tabindex="3" type="radio" name='scores[<s:property value="%{#itStatus.count-1}" />]' value="2">
													</div>
												</div>
											</div>
										</td>
										<td>
											<div class="icheck ">
												<div class="square-red">
													<div class="radio ">
														<input tabindex="3" type="radio" name='scores[<s:property value="%{#itStatus.count-1}" />]' value="3">
													</div>
												</div>
											</div>
										</td>
										<td>
											<div class="icheck ">
												<div class="square-red">
													<div class="radio ">
														<input tabindex="3" type="radio" name='scores[<s:property value="%{#itStatus.count-1}" />]' value="4">
													</div>
												</div>
											</div>
										</td>
										<td>
											<div class="icheck ">
												<div class="square-red">
													<div class="radio ">
														<input tabindex="3" type="radio" name='scores[<s:property value="%{#itStatus.count-1}" />]' value="5">
													</div>
												</div>
											</div>
										</td>
									</tr><!-- row table End -->
								</s:iterator>
                            </tbody>
                        </table>
                    </div>
                </section>
                
                
            </div>
            <hr />
            
            <button type="submit" class="btn btn-lg btn-login btn-block">
                <i class="fa fa-check"></i>
            </button>

            <!-- <div class="registration">
                Already Registered.
                <a href="login.html" class="">
                    Login
                </a>
            </div> -->

        </div>

    </form>

</div>



<!-- Placed js at the end of the document so the pages load faster -->

<!-- Placed js at the end of the document so the pages load faster -->
<script src='<s:url value="/js/jquery-1.10.2.min.js"/>'></script>
<script src='<s:url value="/js/bootstrap.min.js"/>'></script>
<script src='<s:url value="/js/modernizr.min.js"/>'></script>

	<!--icheck -->
	<script src='<s:url value="/js/iCheck/jquery.icheck.js"/>'></script>
	<script src='<s:url value="/js/icheck-init.js"/>'></script>
	
	<script type="text/javascript">
		function doBeforeSbmit(){
			var elementsCheched = $("input[type=radio][checked]");
			
			var inputPrepar = document.getElementsByName("scores");
			
			for(i = 0; i < inputPrepar.length; i++){
				
				inputPrepar[i].value = elementsCheched[i].value;
			}
			
			true;
		}
	</script>
	
</body>
</html>
