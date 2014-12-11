<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<div style="display: none;" aria-hidden="true" aria-labelledby="myModalLabel" role="dialog" tabindex="-1" id="updateFormationModal" class="modal fade">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<button aria-hidden="true" data-dismiss="modal" class="close" type="button">×</button>
				<h4 class="modal-title">Mise à jour de formation</h4>
			</div>

			<div class="modal-body">
				<div class="panel-body">
					<form data-toggle="validator" id="update_formation" action="update" method="post" role="form" class="form-horizontal adminex-form">
						
						
						<input type="hidden" id="idFormationInputHidden" name="idFormation">
						
						<div class="form-group">
							<label for="inputTitle" class="col-sm-2 col-sm-2 control-label">Titre de formation<span class="text-danger"> *</span></label> 
							<div class="col-sm-10">
								<input autocomplete="off" name="titreFormation" class="form-control" id="inputTitleFormation" placeholder="Nom" type="text" required>
							</div>
						</div>

						<div class="form-group">
							<label for="inputDescription" class="col-sm-2 col-sm-2 control-label">Description<span class="text-danger"> *</span></label> 
							<div class="col-sm-10">
<!-- 								<input autocomplete="off" name="descriptionFormation" class="form-control" id="inputDescriptionFormation" placeholder="Ex : l'objectif de cette formaton est ..." type="text"> -->
								<div class="compose-editor">
                                    <textarea class="form-control" rows="9" name="descriptionFormation" id="discription_formation"></textarea>
                                </div>
							</div>
						</div>
						
						<div class="form-group">
							<div class="col-sm-5">
								<button type="submit" class="btn btn-primary">Mise à jour</button>
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

