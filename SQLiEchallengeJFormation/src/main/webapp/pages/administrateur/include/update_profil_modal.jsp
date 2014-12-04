<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<div style="display: none;" aria-hidden="true" aria-labelledby="myModalLabel" role="dialog" tabindex="-1" id="updateModal" class="modal fade">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<button aria-hidden="true" data-dismiss="modal" class="close" type="button">×</button>
				<h4 class="modal-title">Mise à jour du profil</h4>
			</div>

			<div class="modal-body">
				<div class="panel-body">
					<form data-toggle="validator" id="update_utilisateur" action="updateProfil" method="post" role="form" class="form-horizontal adminex-form">
						
						
						<input type="hidden" id="idProfil" name="idProfil">
						
						<div class="form-group">
							<label for="inputLastName_2" class="col-sm-2 col-sm-2 control-label">Nom</label> 
							<div class="col-sm-10">
								<input autocomplete="off" name="nom" class="form-control" id="inputProfilName" placeholder="Nom" type="text" required>
							</div>
						</div>

						<div class="form-group">
							<label for="inputAdress_2" class="col-sm-2 col-sm-2 control-label">Description *</label> 
							<div class="col-sm-10">
								<input autocomplete="off" name="description" class="form-control" id="inputDescription" placeholder="Ex : ce profil dédié aux personnes..." type="text">
							</div>
						</div>
						
						<div class="form-group">
							<label for="inputRole_2" class="col-sm-2 col-sm-2 control-label">Role de base</label> 
							<div class="col-sm-10">
								<select id="inputRole" name="role" class="form-control input-sm m-bot15">
										<option value='Administrateur'>Administrateur</option>
										<option value='Responsable de formation'>Responsable de formation</option>
										<option value='Formateur'>Formateur</option>
                            	</select>
							</div>
						</div>

						
						<button type="submit" class="btn btn-primary" >Mise à jour</button>
						<!-- <div class="modal-footer">
							<button type="button" class="btn btn-default" data-dismiss="modal">Annuler</button>
							<button type="submit" class="btn btn-success">Mise à jour</button>
						</div> -->
					</form>
				</div>
			</div>
			<!--  -->

		</div>
	</div>
</div>

