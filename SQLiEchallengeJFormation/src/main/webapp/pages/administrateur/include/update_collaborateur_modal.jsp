<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<div style="display: none;" aria-hidden="true"
	aria-labelledby="myModalLabel" role="dialog" tabindex="-1"
	id="updateCollaborateurModal" class="modal fade">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<button aria-hidden="true" data-dismiss="modal" class="close"
					type="button">×</button>
				<h4 class="modal-title">Mise à jour d'un collaborateur</h4>
			</div>

			<div class="modal-body">
				<div class="panel-body">
					<div class="box-widget">
						<div class="widget-head clearfix">
							<div id="top_tabby_update_collaborateur" class="block-tabby pull-left"></div>
						</div>
						<div class="widget-container">
							<div class="widget-block">
								<div class="widget-content box-padding">
									<form data-toggle="validator" id="update_collaborateur" action="add" method="post" role="form"
										class="form-horizontal left-align form-well adminex-form" enctype="multipart/form-data">
										
										<input type="hidden" id="idCollaborateur" name="idCollaborateur">
										
										<fieldset title="Etape 1">
											<legend>Personnelles</legend>
											<div class="form-group">
												<label class="control-label col-sm-4">Photo de profil</label>
												<div class="col-sm-8">
													<div class="fileupload fileupload-new" data-provides="fileupload">
														<div class="fileupload-new thumbnail" style="width: 200px; height: 150px;">
															<img id="imageCollaborateur" src='<s:url value="/images/select_image.gif"/>' alt="">
														</div>
														<div
															class="fileupload-preview fileupload-exists thumbnail"
															style="max-width: 200px; max-height: 150px; line-height: 20px;"></div>
														<div>
															<span class="btn btn-default btn-file"> <span
																class="fileupload-new col-sm-12"><i
																	class="fa fa-paper-clip"></i>Choisir une image</span> <span
																class="fileupload-exists"><i class="fa fa-undo"></i> Modifier</span>
																
																<input name="fileImage" class="default" type="file" accept=".jpeg,.png,.gif" >
																
															</span> <a href="#" class="btn btn-danger fileupload-exists"
																data-dismiss="fileupload"><i class="fa fa-trash"></i>Supprimer</a>
														</div>
													</div>
													<br>
												</div>
											</div>

											<div class="form-group">
												<label for="inputLastName" class="col-sm-3 control-label">Nom<span
													class="text-danger"> *</span></label>
												<div class="col-sm-9">
													<input autocomplete="on" name="nom" class="form-control"
														id="inputLastName" placeholder="Nom" type="text"
														required>
												</div>
											</div>

											<div class="form-group">
												<label for="inputFirstName" class="col-sm-3 control-label">Prenom<span
													class="text-danger"> *</span></label>
												<div class="col-sm-9">
													<input autocomplete="on" name="prenom" class="form-control"
														id="inputFirstName" placeholder="Prenom" type="text"
														required>
												</div>
											</div>
											<div class="row">
												<h5 class="text-danger" style="text-align: right;" >(*) champs obligatoire</h5>
											</div>
										</fieldset>

										<fieldset title="Etape 2">
											<legend>Autres</legend>

											<div class="form-group">
												<label for="thedateDiv" class="col-sm-4 control-label">Date de naissance<span class="text-danger"> *</span>
												</label>
												<div id="thedateDiv" class="">

													<div data-date-viewmode="years"
														data-date-format="dd/mm/yyyy" data-date="12/02/1990"
														class="col-sm-8 input-append date dpYears">
														<input name="dateNaissance" id="inputDateNaissance" 
															pattern="^(\d{2})\/(\d{2})\/(\d{4})" type="text"
															readonly="readonly" value="12/02/1990" size="16"
															class="form-control"> <span
															class="input-group-btn add-on">
															<button class="btn btn-primary" type="button">
																<i class="fa fa-calendar"></i>
															</button>
														</span>
													</div>
												</div>
											</div>

											<div class="form-group">


												<label for="sexeElement"
													class="col-sm-4 control-label vcenter">Sexe<span
													class="text-danger"> *</span></label>

												<div id="sexeElement" class="col-sm-8 vcenter">

													<div class="icheck row">
														<div class="square-red col-sm-4" style="margin-right: 0px; padding-right: 0px;">
															<div class="radio " style="margin: auto auto; float: none;">
																<input tabindex="3" type="radio" name="sexe"
																	id="optionHomme" value="Homme" checked="checked">
																<label id="optionHomme_label" for="optionHomme" > Male </label>
															</div>

														</div>
														<div class="square-red col-sm-5" style="margin-left: 0px; padding-left: 0px;">
															<div class="radio " style="margin: auto auto; float: none;">
																<input tabindex="3" type="radio" name="sexe"
																	id="optionFemme" value="Femme"> <label id="optionFemme_label"  for="optionFemme">
																	Female </label>
															</div>
														</div>
													</div>

												</div>
											</div>

											
											
											<div class="row">
												<h5 class="text-danger" style="text-align: right;" >(*) champs obligatoire</h5>
											</div>

										</fieldset>

										<fieldset title="Etape 3">
											<legend>Contacts</legend>
											<div class="form-group">
												<label for="inputEmail" class="col-sm-3 control-label">Email<span
													class="text-danger"> *</span></label>
												<div class="col-sm-9">
													<input autocomplete="on" name="email" class="form-control"
														id="inputEmail" placeholder="Email" type="email"
														pattern="^[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\.[a-zA-Z0-9-.]+$"
														required>
												</div>
											</div>

											<div class="form-group">
												<label for="inputTelephone" class="col-sm-3 control-label">Telephone<span
													class="text-danger"> *</span></label>
												<div class="col-sm-9">
													<input autocomplete="on" name="telephone"
														class="form-control" id="inputTelephone"
														placeholder="Ex : 0610807402" type="tel"
														pattern="^0[5-6]{1}\d{8}" required="required">
												</div>
											</div>

											<div class="form-group">
												<label for="inputAdress" class="col-sm-3 control-label">Adresse<span
													class="text-danger"> *</span></label>
												<div class="col-sm-9">
													<input autocomplete="on" name="adresse"
														class="form-control" id="inputAdress"
														placeholder="Ex : Casablanca Rue 10 N80" type="text"
														required="required">
												</div>
											</div>
											
											<div class="row">
												<h5 class="text-danger" style="text-align: right;" >(*) champs obligatoire</h5>
											</div>
											
										</fieldset>

										<%-- <fieldset title="Etape 4">
											<legend>Dérniere étape</legend>
											<div class="form-group">
												<div class="col-md-12">
													<div class="alert alert-warning">
														<p><strong>Un email</strong> va notifie le collaborateur du succès de la creation</p>
													</div>
												</div>
											</div>
										</fieldset> --%>

										<button type="submit" class="btn btn-primary finish"> Mise à jour</button>
										
									</form>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
			
		</div>
	</div>
</div>