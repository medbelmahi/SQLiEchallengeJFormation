<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0">
  <meta name="description" content="">
  <link rel="shortcut icon" href="#" type="image/png">

  <title>JFormation : Télechargement des fichiers</title>
	
	
	<!--dynamic table-->
  	<link href='<s:url value="/js/advanced-datatable/css/demo_page.css"/>' rel="stylesheet" />
  	<link href='<s:url value="/js/advanced-datatable/css/demo_table.css"/>' rel="stylesheet" />
  	<link rel="stylesheet" href='<s:url value="/js/data-tables/DT_bootstrap.css"/>' />
  	
  	
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
                        <div class="col-md-9 col-sm-9">
                            <h3>Téléchargement des documents</h3>
                        </div>
                        <div style="margin-left: 0;" class="col-md-3 col-md-offset-3 col-sm-3 col-sm-offset-3">
                            <img style="margin:0 auto; float: none;" class="inv-logo" src="<s:url value="/images/login-logo.png"/>" alt=""/>
                            <!-- <p>121 King Street, Melbourne <br/>
                                Victoria 3000 Australia <br/>
                                Phone: +61 3 8376 6284</p> -->
                        </div>
                    </div>
                    <div class="invoice-address">
                        <div class="row">
                            <div class="col-md-6 col-sm-6">
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
                            <div style="margin-left: 0;" class="col-md-6 col-md-offset-6 col-sm-6 col-sm-offset-6">
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
                
                <div class="row" style="padding:15px;" >
                	<div class="panel-body">
				<div class="adv-table">
					<div class="clearfix">
						<h3>Liste des fichiers</h3>
					</div>
                
                <div id="hidden-table-info_wrapper"
						class="dataTables_wrapper form-inline" role="grid">

						<table aria-describedby="hidden-table-info_info"
							class="display table table-bordered dataTable"
							id="dynamic-table">
<!-- 							id="hidden-table-info"> -->
							<thead>
								<tr role="row">
									<th class="text-centre">Titre du document</th>
									<th class="text-centre">Desciption</th>
									<th class="text-centre">Options</th>
									<!-- <th style="display: none;">Actions</th> -->
								</tr>
							</thead>

							<tbody aria-relevant="all" aria-live="polite" role="alert">
								<s:iterator value="documents">
										<tr class="gradeA odd">
											<td><s:property value="nomDocument" /></td>
											<td><s:property value="descriptionDocument" /></td>
											<td style="width-min : 60px">
												
												<ul style="list-style: none;" class="navbar-nav nav-options">
													
													<li>
														<a title="Telecharger le document" target="_blank" href='<s:url namespace="/" action="download" >
														<s:param name="file"><s:property value="urlDocument" /></s:param></s:url>'>
															<i class="fa fa-download"></i>
														</a>
													</li>
													
												</ul>
											</td>
										</tr>
								</s:iterator>
							</tbody>
						</table>
					</div>
                		</div>
                			</div>
                			</div>
                
            </div>
            <%-- <div class="text-center ">
                <a class="btn btn-success btn-lg" href='<s:url action="session/inscription/confirme" >
                <s:param name="code"><s:property value="inscription.codeInscription"/></s:param>
                <s:param name="confirmation">true</s:param>
                </s:url>'><i class="fa fa-check"></i> Confirmation d'inscription </a>
                
                <a class="btn btn-primary btn-lg" target="_blank" href='<s:url action="session/inscription/confirme" >
                <s:param name="code"><s:property value="inscription.codeInscription"/></s:param>
                <s:param name="confirmation">false</s:param>
                </s:url>'><i class="fa fa-print"></i> Annuler </a>
            </div> --%>

        </div>
        <!--body wrapper end-->

        <!--footer section start-->
        	<s:include value="/pages/include/footer.jsp"></s:include>
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
	
	<!--dynamic table-->
	<script type="text/javascript" src='<s:url value="/js/advanced-datatable/js/jquery.dataTables.js"/>'></script>
	<script type="text/javascript" src='<s:url value="/js/data-tables/DT_bootstrap.js"/>'></script>
	<!--dynamic table initialization -->
	<script src='<s:url value="/js/dynamic_table_init.js"/>'></script>

<!--common scripts for all pages-->
	<script src='<s:url value="/js/scripts.js"/>'></script>

</body>
</html>
