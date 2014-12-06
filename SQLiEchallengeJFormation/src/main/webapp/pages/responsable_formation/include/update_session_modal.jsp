<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<div style="display: none;" aria-hidden="true" aria-labelledby="myModalLabel" role="dialog" tabindex="-1" id="updateSessionModal" class="modal fade">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<button aria-hidden="true" data-dismiss="modal" class="close" type="button">×</button>
				<h4 class="modal-title">Mise à jour session</h4>
			</div>

			<div class="modal-body">
				<div class="panel-body">
					<form data-toggle="validator" id="add_session" action="update" method="post" role="form" class="form-horizontal adminex-form">

						<input type="hidden" name="idFormation" value='<s:property value="idFormation" />' id="idFormation_session">
						<input type="hidden" name="idSession" value="" id="inputIdSessionFormation">
						
						<div class="form-group">
							<label for="inputTitreSessionFormation" class="col-sm-3 control-label">Titre session<span class="text-danger" > *</span></label> 
							<div class="col-sm-9">
								<input autocomplete="on" name="titreSessionFormation" class="form-control" id="inputTitreSessionFormation" placeholder="Nom" type="text" required>
							</div>
						</div>
						
						<div class="form-group">
							<label for="inputLieuSessionFormation" class="col-sm-3 control-label">Lieu<span class="text-danger" > *</span></label> 
							<div class="col-sm-9">
								<input autocomplete="on" name="lieuSessionFormation" class="form-control" id="inputLieuSessionFormation" placeholder="Ex : atelier de programmation JEE" type="text">
							</div>
						</div>
						
						
						<div class="form-group">
                            <label class="control-label col-sm-3">Date <span class="text-danger" > *</span></label>
                            <div class="col-sm-9">
                                <div class="input-group input-large custom-date-range" data-date="13/07/2013" data-date-format="dd/mm/yyyy">
                                    <input type="text" id="inputDateDebutSession" class="form-control " name="dateDebutSessionFormation" pattern="^(\d{2})\/(\d{2})\/(\d{4})" readonly="readonly" value="12/12/2014" size="16">
                                    <span class="input-group-addon">à</span>
                                    <input type="text" id="inputDateFinSession" class="form-control" name="dateFinSessionFormation" pattern="^(\d{2})\/(\d{2})\/(\d{4})" readonly="readonly" value="13/12/2014" size="16">
                                </div>
<%--                                 <span class="help-block">Choisir l'interval</span> --%>
                            </div>
                        </div>
                        
                        
                        <div class="form-group">
							<label for="inputFormateur" class="col-sm-3 control-label">Formateur<span class="text-danger" > *</span></label> 
							<div class="col-sm-9">
								<select id="inputFormateur" name="idFormateur" class="form-control input-sm m-bot15">
										<s:iterator value="formateurs">
											<option value='<s:property value="idUtilisateur" />'><s:property value="fullname" /></option>
										</s:iterator>
                            	</select>
							</div>
						</div>
						
                        <div class="form-group">
							<label for="desciptionSessionFormation" class="col-sm-3 control-label">Description<span class="text-danger" > *</span></label> 
							<div class="col-sm-9">
								<div class="compose-editor">
                                    <textarea class="wysihtml5 form-control" rows="9" name="desciptionSessionFormation" id="desciptionSessionFormation"></textarea>
                                </div>
							</div>
						</div>
                                
						

						<div class="form-group">
							<div class="col-sm-5">
								<button type="submit" class="btn btn-primary">Mise à Session</button>
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