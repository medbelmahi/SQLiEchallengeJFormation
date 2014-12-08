<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<div style="display: none;" aria-hidden="true" aria-labelledby="myModalLabel" role="dialog" tabindex="-1" id="addQuestionModal" class="modal fade">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<button aria-hidden="true" data-dismiss="modal" class="close" type="button">×</button>
				<h4 class="modal-title">Ajouter Nouvelle Question</h4>
			</div>

			<div class="modal-body">
				<div class="panel-body">
					<form data-toggle="validator" id="add_question" action="add" method="post" role="form" class="form-horizontal adminex-form">

						<div class="form-group">
							<label for="inputQuestion_2" class="col-sm-3 control-label">Question<span class="text-danger" > *</span></label> 
							<div class="col-sm-9">
								<input autocomplete="on" name="question" class="form-control" id="inputQuestion_2" placeholder="Nom" type="text" required>
							</div>
						</div>

						
						<div class="form-group">
							<div class="col-sm-5">
								<button type="submit" class="btn btn-primary">Ajouter Question</button>
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
