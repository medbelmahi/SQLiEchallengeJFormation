<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<div style="display: none;" aria-hidden="true" aria-labelledby="myModalLabel" role="dialog" tabindex="-1" id="addFormationModal" class="modal fade">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<button aria-hidden="true" data-dismiss="modal" class="close" type="button">×</button>
				<h4 class="modal-title">Ajouter Nouvelle Formation</h4>
			</div>

			<div class="modal-body">
				<div class="panel-body">
					<form data-toggle="validator" id="add_formation" action="add" method="post" role="form" class="form-horizontal adminex-form">

						<div class="form-group">
							<label for="inputTitleFormation_2" class="col-sm-3 control-label">Titre de formation<span class="text-danger" > *</span></label> 
							<div class="col-sm-9">
								<input autocomplete="off" name="titreFormation" class="form-control" id="inputTitleFormation_2" placeholder="Nom" type="text" required>
							</div>
						</div>

						<div class="form-group">
							<label for="inputDescription_2" class="col-sm-3 control-label">Description<span class="text-danger" > *</span></label> 
							<div class="col-sm-9">
								<input autocomplete="off" name="descriptionFormation" class="form-control" id="inputDescription_2" placeholder="Ex : l'objectif de cette formaton est ..." type="text">
							</div>
						</div>
						
						<div class="form-group">
							<div class="col-sm-5">
								<button type="submit" class="btn btn-primary">Ajouter Formation</button>
							</div>
							<div class="col-sm-7">
								<h5 class="text-danger" style="text-align: right;" >(*) champs obligatoire</h5>
							</div>
						</div>
					</form>
				</div>
			</div>

		</div>
	</div>
</div>