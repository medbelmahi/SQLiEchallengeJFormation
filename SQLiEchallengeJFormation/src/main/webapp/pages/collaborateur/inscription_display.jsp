<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0">
  <meta name="description" content="">
  <link rel="shortcut icon" href="#" type="image/png">

  <title>JFormation : Confirmation d'inscription</title>

 <!-- initial style -->
	<link href='<s:url value="/css/style.css"/>' rel="stylesheet">
	<link href='<s:url value="/css/style-responsive.css"/>' rel="stylesheet">
	

  <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
  <!--[if lt IE 9]>
  <script src="js/html5shiv.js"></script>
  <script src="js/respond.min.js"></script>
  <![endif]-->
</head>

<body class="boxed-view">

<section>
    
    <!-- main content start-->
    <div class="col-lg-8" style="float:none; margin:0 auto" >

       

        <!-- page heading start-->
        <!--<div class="page-heading">-->
            <!--Page Tittle goes here-->
        <!--</div>-->
        <!-- page heading end-->

        <!--body wrapper start-->
        <div class="wrapper">

            <div class="panel">
                <div class="panel-body invoice">
                    <div class="row">
                        <div class="col-md-4 col-sm-4">
                            <h2 class="invoice-title">Inscription</h2>
                        </div>
                        <div class="col-md-4 col-md-offset-4 col-sm-4 col-sm-offset-4">
                            <img class="inv-logo" src="<s:url value="/images/login-logo.png"/>" alt=""/>
                            <!-- <p>121 King Street, Melbourne <br/>
                                Victoria 3000 Australia <br/>
                                Phone: +61 3 8376 6284</p> -->
                        </div>
                    </div>
                    <div class="invoice-address">
                        <div class="row">
                            <div class="col-md-5 col-sm-5">
                                <h2 class="corporate-id">Formation : <s:property value="inscription.sessionFormation.formation.titreFormation" /></h2>
                                <h2 class="corporate-id">Description</h2>
                                <p>
                                   	<s:property value="inscription.sessionFormation.formation.descriptionFormation" />
                                </p>
                                <h2 class="corporate-id">Session</h2>
                                <p>
                                   	<s:property value="inscription.sessionFormation.titreSessionFormation" />
                                </p>
                                <h2 class="corporate-id">Description session</h2>
                                <p>
                                   	<s:property value="inscription.sessionFormation.desciptionSessionFormation" />
                                </p>
                                
                                <h3>Date debut : <s:property value="inscription.sessionFormation.dateDebutSessionFormation" /></h3>
                                <h3>Date fin : <s:property value="inscription.sessionFormation.dateFinSessionFormation" /></h3>
                                <h2 class="corporate-id">Lieu</h2>
                                <p>
                                   	<s:property value="inscription.sessionFormation.lieuSessionFormation" />
                                </p>

                            </div>
                            <div class="col-md-4 col-md-offset-3 col-sm-4 col-sm-offset-3">
                                <div class="col-md-12">
						<!-- info collaborateur div Begin -->
						<div class="row">
							<div class="col-md-12">
								<div class="panel">
									<div class="panel-body" style="padding: 0px;">
										<div class="profile-pic text-center">
											<img alt="" src='<s:url namespace="/" action='download'>
																	<s:param name="file"><s:property value="inscription.sessionFormation.formateur.urlPhotoFormateur" />
																	</s:param></s:url>'>
											<h3 class="corporate-id">
												<s:property value="inscription.sessionFormation.formateur.fullname" />
											</h3>
										</div>
									</div>
								</div>
							</div>
							<div class="col-md-12">
								<div class="panel">
									<div class="panel-body">
										<ul class="p-info">
											<li>
												<div class="title">Email</div>
												<div class="desk"><s:property value="inscription.sessionFormation.formateur.emailUtilisateur" /></div>
											</li>
											<li>
												<div class="title">Telephone</div>
												<div class="desk"><s:property value="inscription.sessionFormation.formateur.telephoneUtilisateur" /></div>
											</li>
											<li>
												<div class="title">Date de naissance</div>
												<div class="desk"><s:property value="inscription.sessionFormation.formateur.dateNaissanceUtilisateur" /></div>
											</li>
											
											<li>
												<div class="title">Adresse</div>
												<div class="desk"><s:property value="inscription.sessionFormation.formateur.adresseUtilisateur" /></div>
											</li>
										</ul>
									</div>
								</div>
							</div>
						</div>
					</div>
                            </div>
                        </div>
                    </div>
                </div>
                
                
                <table class="table table-bordered table-invoice">
                    <thead>
                    <tr>
                        <th>#</th>
                        <th>Description de la séance</th>
                        <th class="text-center">Date</th>
                        <th class="text-center">Heure dèbut</th>
                        <th class="text-center">Heure fin</th>
                    </tr>
                    </thead>
                    <tbody>
                    <s:iterator value="inscription.sessionFormation.sceances" status="itStatus">
                    
	                    <tr>
	                        <td><s:property value="#itStatus.count" /></td>
	                        <td>
	                            <h4><s:property value="titreSeance" /></h4>descriptionSeance
	                            <p><s:property value="descriptionSeance" /></p>
	                        </td>
	                        <td class="text-center"><strong><s:property value="dateSeance" /></strong></td>
	                        <td class="text-center"><strong><s:property value="heureDebutSeance" /></strong></td>
	                        <td class="text-center"><strong><s:property value="heureFinSeance" /></strong></td>
	                    </tr>
                    </s:iterator>

                    </tbody>
                </table>
                
                
            </div>
            <div class="text-center ">
                <a class="btn btn-success btn-lg" href='<s:url action="session/inscription/confirme" >
                <s:param name="code"><s:property value="inscription.codeInscription"/></s:param>
                <s:param name="confirmation">true</s:param>
                </s:url>'><i class="fa fa-check"></i> Confirmation d'inscription </a>
                
                <a class="btn btn-primary btn-lg" target="_blank" href='<s:url action="session/inscription/confirme" >
                <s:param name="code"><s:property value="inscription.codeInscription"/></s:param>
                <s:param name="confirmation">false</s:param>
                </s:url>'><i class="fa fa-print"></i> Annuler </a>
            </div>

        </div>
        <!--body wrapper end-->

        <!--footer section start-->
        <footer class="">
            2014 &copy; Mouad &amp; Mohamed
        </footer>
        <!--footer section end-->


    </div>
    <!-- main content end-->
</section>

<!-- Placed js at the end of the document so the pages load faster -->
	<script src='<s:url value="/js/jquery-1.10.2.min.js"/>'></script>
	<script src='<s:url value="/js/jquery-ui-1.9.2.custom.min.js"/>'></script>
	<script src='<s:url value="/js/jquery-migrate-1.2.1.min.js"/>'></script>
	<script src='<s:url value="/js/bootstrap.min.js"/>'></script>
	<script src='<s:url value="/js/modernizr.min.js"/>'></script>
	<script src='<s:url value="/js/jquery.nicescroll.js"/>'></script>


<!--common scripts for all pages-->
	<script src='<s:url value="/js/scripts.js"/>'></script>

</body>
</html>
