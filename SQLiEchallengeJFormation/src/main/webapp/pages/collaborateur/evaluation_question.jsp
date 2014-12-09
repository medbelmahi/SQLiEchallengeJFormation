<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0">
    <meta name="description" content="">
    <link rel="shortcut icon" href="#" type="image/png">

    <title>Evaluation</title>
	
	    <!--icheck-->
    <link href='<s:url value="/js/iCheck/skins/minimal/minimal.css"/>' rel="stylesheet">
    <link href='<s:url value="/js/iCheck/skins/minimal/red.css"/>' rel="stylesheet">
    <link href='<s:url value="/js/iCheck/skins/minimal/green.css"/>' rel="stylesheet">
    <link href='<s:url value="/js/iCheck/skins/minimal/blue.css"/>' rel="stylesheet">
    <link href='<s:url value="/js/iCheck/skins/minimal/yellow.css"/>' rel="stylesheet">
    <link href='<s:url value="/js/iCheck/skins/minimal/purple.css"/>' rel="stylesheet">

    <link href='<s:url value="/js/iCheck/skins/square/square.css"/>' rel="stylesheet">
    <link href='<s:url value="/js/iCheck/skins/square/red.css"/>' rel="stylesheet">
    <link href='<s:url value="/js/iCheck/skins/square/green.css"/>' rel="stylesheet">
    <link href='<s:url value="/js/iCheck/skins/square/blue.css"/>' rel="stylesheet">
    <link href='<s:url value="/js/iCheck/skins/square/yellow.css"/>' rel="stylesheet">
    <link href='<s:url value="/js/iCheck/skins/square/purple.css"/>' rel="stylesheet">

    <link href='<s:url value="/js/iCheck/skins/flat/grey.css"/>' rel="stylesheet">
    <link href='<s:url value="/js/iCheck/skins/flat/red.css"/>' rel="stylesheet">
    <link href='<s:url value="/js/iCheck/skins/flat/green.css"/>' rel="stylesheet">
    <link href='<s:url value="/js/iCheck/skins/flat/blue.css"/>' rel="stylesheet">
    <link href='<s:url value="/js/iCheck/skins/flat/yellow.css"/>' rel="stylesheet">
    <link href='<s:url value="/js/iCheck/skins/flat/purple.css"/>' rel="stylesheet">
	
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

    <form class="form-signin" action="index.html" style="max-width: 100%">
        <div class="form-signin-heading text-center">
            <h1 class="sign-title">Evaluation</h1>
            <img src="images/login-logo.png" alt=""/>
        </div>


        <div class="login-wrap">
        	<div class="row">
        		<div class="col-lg-5 col-sm-5">choisir le dogré de votre satifaction</div>
        		<div class="col-lg-7 col-sm-7">
<!--         			<div class="col-lg-2 col-sm-2 text-center"></div> -->
        			<div class="col-lg-3 col-sm-3 text-center">Très satisfait</div>
        			<div class="col-lg-2 col-sm-2 text-center">Satisfait</div>
        			<div class="col-lg-2 col-sm-2 text-center">Peu  satisfait</div>
        			<div class="col-lg-3 col-sm-3 text-center">Pas du tout satisfait</div>
        			<div class="col-lg-2 col-sm-2 text-center">Non concerné</div>
        		</div>
        	</div>
        	<hr />
        	<div class="row">
                
                
                <section class="panel">
                    <header class="panel-heading">
                        Evaluation
                            <%-- <span class="tools pull-right">
                                <a href="javascript:;" class="fa fa-chevron-down"></a>
                                <a href="javascript:;" class="fa fa-times"></a>
                             </span> --%>
                    </header>
                    <div class="panel-body">
                        <table class="table table-striped">
                            <thead>
                            <tr>
                                <th>#</th>
                                <th>Question</th>
                                <th>Très satisfait</th>
                                <th>Satisfait</th>
                                <th>Peu  satisfait</th>
                                <th>Pas du tout satisfait</th>
                                <th>Non concerné</th>
                            </tr>
                            </thead>
                            <tbody>
                            	<s:iterator value="questions">
									<tr><!-- row table begin -->
										<input type="hidden" name="idQuestions" value='<s:property value="idEvaluationQuestion" />' />
										<td>1</td>
										<td><s:property value="question" /></td>
										<td>
											<div class="icheck ">
												<div class="square single-row">
													<div class="radio ">
														<input tabindex="3" type="radio" name="scores" value="5">
													</div>
												</div>
											</div>
										</td>
										<td>
											<div class="icheck ">
												<div class="square single-row">
													<div class="radio ">
														<input tabindex="3" type="radio" name="scores" value="4">
													</div>
												</div>
											</div>
										</td>
										<td>
											<div class="icheck ">
												<div class="square single-row">
													<div class="radio ">
														<input tabindex="3" type="radio" name="scores" value="3">
													</div>
												</div>
											</div>
										</td>
										<td>
											<div class="icheck ">
												<div class="square single-row">
													<div class="radio ">
														<input tabindex="3" type="radio" name="scores" value="2">
													</div>
												</div>
											</div>
										</td>
										<td>
											<div class="icheck ">
												<div class="square single-row">
													<div class="radio ">
														<input tabindex="3" type="radio" name="scores" value="1">
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
            <p>Enter your personal details below</p>
            <input type="text" autofocus="" placeholder="Full Name" class="form-control">
            <input type="text" autofocus="" placeholder="Address" class="form-control">
            <input type="text" autofocus="" placeholder="Email" class="form-control">
            <input type="text" autofocus="" placeholder="City/Town" class="form-control">
            <div class="radios">
                <label for="radio-01" class="label_radio col-lg-6 col-sm-6">
                    <input type="radio" checked="" value="1" id="radio-01" name="sample-radio"> Male
                </label>
                <label for="radio-02" class="label_radio col-lg-6 col-sm-6">
                    <input type="radio" value="1" id="radio-02" name="sample-radio"> Female
                </label>
            </div>

            <p> Enter your account details below</p>
            <input type="text" autofocus="" placeholder="User Name" class="form-control">
            <input type="password" placeholder="Password" class="form-control">
            <input type="password" placeholder="Re-type Password" class="form-control">
            <label class="checkbox">
                <input type="checkbox" value="agree this condition"> I agree to the Terms of Service and Privacy Policy
            </label>
            <button type="submit" class="btn btn-lg btn-login btn-block">
                <i class="fa fa-check"></i>
            </button>

            <div class="registration">
                Already Registered.
                <a href="login.html" class="">
                    Login
                </a>
            </div>

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

</body>
</html>
