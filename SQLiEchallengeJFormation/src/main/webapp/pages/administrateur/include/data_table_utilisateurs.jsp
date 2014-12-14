<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<div class="row">
	<div class="col-sm-12">
		<section class="panel">
			<header class="panel-heading">
				liste des utilisateurs <span class="tools pull-right">
<!-- 					<a href="javascript:;" class="fa fa-chevron-down" id="downUpCollaborateur"></a>  -->
<!-- 					<a href="javascript:;" class="fa fa-times"></a> -->
				</span>
			</header>
			<div class="panel-body">
				<div class="adv-table">
					<div class="clearfix">
						<div class="btn-group">
							<a href="#addUtilisateurModal" data-toggle="modal"><button class="btn btn-primary">
								Ajouter utilisateur <i class="fa fa-plus" ></i>
							</button></a>
						</div>
					</div>
					<div id="hidden-table-info_wrapper"
						class="dataTables_wrapper form-inline" role="grid">

						<table aria-describedby="hidden-table-info_info"
							class="display table table-bordered dataTable"
							id="hidden-table-info">
							<thead>
								<tr role="row">
									<th class="text-center">Prénom &amp; Nom</th>
									<th class="text-center">Email</th>
									<th class="text-center">Telephone</th>
									<th class="text-center">Sexe</th>
									<th class="text-center">Profil</th>
									<th class="text-center">Options</th>
									<th style="display: none;">Adresse</th>
									<th style="display: none;">Date de naissance</th>
									<th style="display: none;">image</th>
								</tr>
							</thead>

							<tbody aria-relevant="all" aria-live="polite" role="alert">
								<s:iterator value="utilisateurs">
									<tr class="gradeA odd">
										<td class="sorting"><s:property value="fullname" /></td>
										<td class="text-center"><s:property value="emailUtilisateur" /></td>
										<td class="text-center"><s:property
												value="telephoneUtilisateur" /></td>
										<td class="text-center"><s:property
												value="sexeUtilisateur" /></td>
										<td>
											<s:property
												value="profil.getNomProfil()" />
										</td>
										<td class="text-center td_option_class" >
											<ul style="list-style: none;" class="navbar-nav nav-options">
											
												<li style="padding-right: 15px;">
													<a href='javascript:void(0);'
													   onclick="jsonGetUtilisateur(<s:property value="idUtilisateur"/>);" 
													   title="Mise à jour">
														<i class="fa fa-pencil"></i>
													</a>
												</li>
												
												<li style="padding-right: 15px;">
													<a data-href=<s:url action="utilisateurs/delete" ><s:param name="idUtilisateur"><s:property value="idUtilisateur"/></s:param></s:url> data-toggle="confirmation" data-original-title="" title="Supprimer ?" >
														<i class="fa fa-trash-o"></i>
													</a>
												</li>
												<li>
													<a href='javascript:void(0);'
													   onclick="jsonGetUtilisateur_forSendEmail(<s:property value="idUtilisateur"/>);" 
													   title="Envoyer un email">
														<i class="fa fa-envelope-o"></i>
													</a>
												</li>
											</ul>
										</td>
										<td style="display: none;"><s:property value="adresseUtilisateur" /></td>
										<td style="display: none;"><s:property value="dateNaissanceUtilisateur" /></td>
										<td style="display: none;"><s:url namespace="/" action='download'>
																	<s:param name="file"><s:property value="urlPhotoUtilisateur" />
																	</s:param></s:url>
										
										</td>
									</tr>
								</s:iterator>
							</tbody>
						</table>
					</div>
				</div>
			</div>
		</section>
	</div>
</div>