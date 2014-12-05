<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!-- Update collaborateur modale Start -->
<div style="display: none;" aria-hidden="true" aria-labelledby="myModalLabel" role="dialog" tabindex="-1" id="updateCollaborateurModal" class="modal fade">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<button aria-hidden="true" data-dismiss="modal" class="close" type="button">×</button>
				<h4 class="modal-title">Mise à jour du Collaborateur</h4>
			</div>
			
			<div class="modal-body">
				<div class="panel-body">
					<form data-toggle="validator" id="update_collaborateur" action="update" method="post" role="form" class="form-horizontal adminex-form" enctype="multipart/form-data" >
						<div class="form-group">
							<label class="control-label col-sm-4">Image de profil</label>
							<div class="col-sm-8">
								<div class="fileupload fileupload-new" data-provides="fileupload">
									<div class="fileupload-new thumbnail" style="width: 200px; height: 150px;">
										<img id="imageCollaborateur" src='<s:url value="/images/select_image.gif"/>' alt="">
									</div>
									<div class="fileupload-preview fileupload-exists thumbnail" style="max-width: 200px; max-height: 150px; line-height: 20px;"></div>
									<div>
										<span class="btn btn-default btn-file"> 
											<span class="fileupload-new"><i class="fa fa-paper-clip"></i>Choisir une image</span> 
											<span class="fileupload-exists"><i class="fa fa-undo"></i> Modifier</span> 
											<input class="default" type="file">
										</span> 
										<a href="#" class="btn btn-danger fileupload-exists" data-dismiss="fileupload"><i class="fa fa-trash"></i>Supprimer</a>
									</div>
								</div>
								<br>
							</div>
						</div>
						
						<input type="hidden" id="idCollaborateur" name="idCollaborateur">
						
						<div class="form-group">
							<label for="inputLastName" class="col-sm-3 control-label">Nom</label> <h5 class="text-danger" > *</h5>
							<div class="col-sm-9">
								<input autocomplete="off" name="nom" class="form-control" id="inputLastName" placeholder="Nom" type="text" required>
							</div>
						</div>

						<div class="form-group">
							<label for="inputFirstName" class="col-sm-3 control-label">Prenom<span class="text-danger" > *</span></label> 
							<div class="col-sm-9">
								<input autocomplete="off" name="prenom" class="form-control" id="inputFirstName" placeholder="Prenom" type="text" required>
							</div>
						</div>

						<div class="form-group">
							<label for="inputEmail" class="col-sm-3 control-label">Email<span class="text-danger" > *</span></label> 
							<div class="col-sm-9">
								<input autocomplete="off" name="email" class="form-control" id="inputEmail" placeholder="Email" type="email" required>
							</div>
						</div>

						<div class="form-group" >
							<label for="thedateDiv" class="col-sm-3 control-label">Date de naissance<span class="text-danger" > *</span></label>
							<div id="thedateDiv" class="">

								<div data-date-viewmode="years" data-date-format="dd/mm/yyyy" data-date="12/02/1990" class="col-sm-9 input-append date dpYears">
									<input name="dateNaissance" id="inputDateNaissance" pattern="^(\d{2})\/(\d{2})\/(\d{4})" type="text" readonly="readonly" value="12/02/1990" size="16" class="form-control"> 
									<span class="input-group-btn add-on">
										<button class="btn btn-primary" type="button">
											<i class="fa fa-calendar"></i>
										</button>
									</span>
								</div>
							</div>
						</div>

						<div class="form-group" >
							<label for="inputTelephone" class="col-sm-3 control-label">Telephone<span class="text-danger" > *</span></label> 
							<div class="col-sm-9">
								<input autocomplete="off" name="telephone" class="form-control" id="inputTelephone" placeholder="Ex : 0610807402" type="text" pattern="^0[5-6]{1}\d{8}">
							</div>
						</div>


						<div class="form-group">
							<label for="inputAdress" class="col-sm-3 control-label">Adresse<span class="text-danger" > *</span></label> 
							<div class="col-sm-9">
								<input autocomplete="off" name="adresse" class="form-control" id="inputAdress" placeholder="Ex : Casablanca Rue 10 N80" type="text">
							</div>
						</div>


						<div class="form-group">
								<label for="sexeElement" class="col-sm-3 control-label vcenter">Sexe<span class="text-danger" > *</span></label>
							
							<div  id="sexeElement" class="col-sm-9 vcenter">
								<div class="icheck ">
									<div class="square-green single-row col-sm-6">
										<div class="radio ">
											<input tabindex="3" type="radio" name="sexe" id="optionHomme" value="true"> <label> Male </label>
										</div>
									</div>
									<div class="square-red single-row col-sm-6">
										<div class="radio ">
											<input tabindex="3" type="radio" name="sexe" id="optionFemme" value="false"> <label> Female </label>
										</div>
									</div>
								</div>

							</div>
						</div>
						
						<div class="form-group">
							<div class="col-sm-5">
								<button type="submit" class="btn btn-primary" >Mise à jour</button>
							</div>
							<div class="col-sm-7">
								<h5 class="text-danger" style="text-align: right;" >(*) champs obligatoire</h5>
							</div>
						</div>
					</form>
				</div>
			</div>
			<!--  -->

		</div>
	</div>
</div>
<!-- Update collaborateur modale End -->