<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<div style="display: none;" aria-hidden="true" aria-labelledby="myModalLabel" role="dialog" tabindex="-1" id="addHabilitationModal" class="modal fade">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<button aria-hidden="true" data-dismiss="modal" class="close" type="button">×</button>
				<h4 class="modal-title">Ajouter Nouvelle Habilitation</h4>
			</div>

			<div class="modal-body">
				<div class="panel-body">
					<form data-toggle="validator" id="add_habilitation" action="add" method="post" role="form" class="form-horizontal adminex-form">

						<div class="form-group">
							<label for="inputLastName_2" class="col-sm-3 control-label">Nom<span class="text-danger" > *</span></label> 
							<div class="col-sm-9">
								<input autocomplete="off" name="nom" class="form-control" id="inputProfilName_2" placeholder="Nom" type="text" required>
							</div>
						</div>

						<div class="form-group">
							<label for="inputAdress_2" class="col-sm-3 control-label">Description<span class="text-danger" > *</span></label> 
							<div class="col-sm-9">
								<input autocomplete="off" name="description" class="form-control" id="inputDescription_2" placeholder="Ex : ce profil dédié aux personnes..." type="text">
							</div>
						</div>

						<div class="form-group">
							<div class="col-sm-5">
								<button type="submit" class="btn btn-primary">Ajouter Habilitation</button>
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