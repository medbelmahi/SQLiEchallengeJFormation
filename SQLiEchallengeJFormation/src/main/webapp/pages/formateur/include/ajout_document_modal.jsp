<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<div style="display: none;" aria-hidden="true" aria-labelledby="myModalLabel" role="dialog" tabindex="-1" id="addDocumentModal" class="modal fade">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<button aria-hidden="true" data-dismiss="modal" class="close" type="button">×</button>
				<h4 class="modal-title">Ajouter Nouveau Document</h4>
			</div>

			<div class="modal-body">
				<div class="panel-body">
					
					<h5 class="text-danger" style="text-align: right;" >Vous avez le droit d'ajouter des fichiers de type (pdf, doc, docx)</h5>
					
					<form data-toggle="validator" id="add_document" action="add" method="post" role="form" class="form-horizontal adminex-form" enctype="multipart/form-data" >
						<input name="idSession" value='<s:property value="idSession"/>' type="hidden">
						<div class="form-group">
							<label for="inputTitleFormation_2" class="col-sm-3 control-label">Titre du document<span class="text-danger" > *</span></label> 
							<div class="col-sm-9">
								<input autocomplete="on" name="nomDocument" class="form-control" id="inputTitleFormation_2" placeholder="Nom" type="text" required>
							</div>
						</div>

						<div class="form-group">
							<label for="inputDescription_2" class="col-sm-3 control-label">Description<span class="text-danger" > *</span></label> 
							<div class="col-sm-9">
								<input autocomplete="on" name="descriptionDocument" class="form-control" id="inputDescription_2" placeholder="Ex : l'objectif de cette formaton est ..." type="text">
							</div>
						</div>
						
						<div class="form-group">
                                    <label class="control-label col-md-3">Fichier</label>
                                    <div class="controls col-md-9">
                                        <div class="fileupload fileupload-new" data-provides="fileupload">
                                                <span class="btn btn-default btn-file">
                                                <span class="fileupload-new"><i class="fa fa-paper-clip"></i> Choisir un fichier</span>
                                                <span class="fileupload-exists"><i class="fa fa-undo"></i> Modifier</span>
                                                <input type="file" class="default" name="document" />
                                                </span>
                                            <span class="fileupload-preview" style="margin-left:5px;"></span>
                                            <a href="#" class="close fileupload-exists" data-dismiss="fileupload" style="float: none; margin-left:5px;"></a>
                                        </div>
                                    </div>
                                </div>
						
						<div class="form-group">
							<div class="col-sm-5">
								<button type="submit" class="btn btn-primary">Ajouter Document</button>
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