<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<div style="display: none;" aria-hidden="true" aria-labelledby="myModalLabel" role="dialog" tabindex="-1" id="addProfilModal" class="modal fade">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<button aria-hidden="true" data-dismiss="modal" class="close" type="button">×</button>
				<h4 class="modal-title">Ajouter Nouveau Profil</h4>
			</div>

			<div class="modal-body">
				<div class="panel-body">
					<form data-toggle="validator" id="add_profil" action="add" method="post" role="form" class="form-horizontal adminex-form">

						<div class="form-group">
							<label for="inputLastName_2" class="col-sm-3 control-label">Nom<span class="text-danger" > *</span></label> 
							<div class="col-sm-9">
								<input autocomplete="on" name="nom" class="form-control" id="inputProfilName_2" placeholder="Nom" type="text" required>
							</div>
						</div>

						<div class="form-group">
							<label for="inputAdress_2" class="col-sm-3 control-label">Description<span class="text-danger" > *</span></label> 
							<div class="col-sm-9">
								<input autocomplete="on" name="description" class="form-control" id="inputDescription_2" placeholder="Ex : ce profil dédié aux personnes..." type="text">
							</div>
						</div>
						
						<div class="form-group">
							<label for="inputRole_2" class="col-sm-3 control-label">Role de base<span class="text-danger" > *</span></label> 
							<div class="col-sm-9">
								<select id="inputRole_2" name="role" class="form-control input-sm m-bot15">
										<option value='Administrateur'>Administrateur</option>
										<option value='Responsable de formation'>Responsable de formation</option>
										<option value='Formateur'>Formateur</option>
                            	</select>
							</div>
						</div>

						<div class="form-group">
							<div class="col-sm-5">
								<button type="submit" class="btn btn-primary">Ajouter Profil</button>
							</div>
							<div class="col-sm-7">
								<h5 class="text-danger" style="text-align: right;" >(*) champs obligatoire</h5>
							</div>
						</div>
					</form>
				</div>
			</div>
			<!-- <div class="modal-footer">
				<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
				<button type="button" class="btn btn-success">Save changes</button>
			</div> -->

		</div>
	</div>
</div>