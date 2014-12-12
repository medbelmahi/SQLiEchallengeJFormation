<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!-- Modal -->
   <div class="modal fade" id="updateCompteProfil" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
       <div class="modal-dialog">
           <div class="modal-content">
               <div class="modal-header">
                   <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                   <h4 class="modal-title">Edit Media Gallery</h4>
               </div>

               <div class="modal-body row">

                   <div class="col-md-5 img-modal">
                       <!-- <img src="images/gallery/image1.jpg" alt="">
                       <a href="#" class="btn btn-white btn-sm"><i class="fa fa-pencil"></i> Edit Image</a>
                       <a href="#" class="btn btn-white btn-sm"><i class="fa fa-eye"></i> View Full Size</a> -->
						
						<div class="fileupload fileupload-new" data-provides="fileupload">
							<div class="fileupload-new thumbnail" style="width: 200px; height: 150px;">
								<img id="utilisateurImageProfil" src='<s:property value="%{#session.utilisateur.urlPhotoUtilisateur}" />' alt="">
							</div>
							<div
								class="fileupload-preview fileupload-exists thumbnail"
								style="max-width: 216px; max-height: 216px; line-height: 20px;"></div>
							<div>
								<span class="btn btn-default btn-file"> <span
									class="fileupload-new col-sm-12"><i
										class="fa fa-paper-clip"></i>Choisir une Photo</span> <span
									class="fileupload-exists"><i class="fa fa-undo"></i> Modifier</span>
									
									<input name="fileImage" class="default" type="file">
									
								</span> <a href="#" class="btn btn-danger fileupload-exists"
									data-dismiss="fileupload"><i class="fa fa-trash"></i>Supprimer</a>
							</div>
						</div>
														
														
                      <%--  <p class="mtop10"><strong>File Name:</strong> img01.jpg</p>
                       <p><strong>File Type:</strong> jpg</p>
                       <p><strong>Resolution:</strong> 300x200</p>
                       <p><strong>Uploaded By:</strong> <a href="#">ThemeBucket</a></p> --%>
                       
                       <div style="margin-top: 15px;" class="form-group">
                           <label> Ancien mot de passe<span class="text-danger"> *</span></label>
                           <div class="row">
	                           <div class="col-md-10">
	                           		<input type="password" name="oldPassword" value="" class="form-control">
	                           </div>
                           </div>
                       </div>
                       <div class="form-group">
                       		<div class="row">
                       			<div class="col-md-8">
                       				<label>change le mot de passe</label>
                       			</div>
                       			<div class="col-md-4">
                       				<input type="checkbox" name="changePassword" value="1" id="changePassword">
                       			</div>
                       		</div>
                       </div>
                       <div class="form-group">
                           <label> Nouveau mot de passe<span class="text-danger"> *</span></label>
                           <div class="row">
	                           <div class="col-md-10">
	                           		<input id="newPassword_1" type="password" name="newPassword_1" value="" class="password-change form-control">
	                           </div>
	                           <div class="col-md-2" id="newPassword_2_valide"></div>
                           </div>
                       </div>
                       <div class="form-group">
                           <label> Nouveau mot de passe<span class="text-danger"> *</span></label>
                           <div class="row">
                           		<div class="col-md-10">
                           			<input id="newPassword_2" type="password" name="newPassword_2" value="" class="password-change form-control">
                           		</div>
                           		<div class="col-md-2" id="newPassword_1_valide"></div>
                           </div>
                       </div>
                       
                       
                   </div>
                   <div class="col-md-7">
                       <div class="form-group">
                           <label> Nom<span class="text-danger"> *</span></label>
                           <input required="required" type="text" id="nom" name="nom" value='<s:property value="%{#session.utilisateur.nomUtilsateur}" />' class="form-control" required="required">
                       </div>
                       <div class="form-group">
                           <label> Prènom<span class="text-danger"> *</span></label>
                           <input required="required" id="prenom" name="prenom" value='<s:property value="%{#session.utilisateur.prenomUtilisateur}" />' class="form-control">
                       </div>
                       
                       <div class="form-group">
                           <label> Date de naissance<span class="text-danger"> *</span></label>
                           <div data-date-viewmode="years" style="padding-left: 0;"
								data-date-format="dd/mm/yyyy" data-date="12/02/1990"
								class="col-sm-12 input-append date dpYears" >
								<input name="dateNaissance" id="inputDateNaissance"
									pattern="^(\d{2})\/(\d{2})\/(\d{4})" type="text"
									readonly="readonly" value='<s:property value="%{#session.utilisateur.dateNaissanceUtilisateur}" />' size="16"
									class="form-control" required="required"> <span
									class="input-group-btn add-on">
									<button class="btn btn-primary" type="button">
										<i class="fa fa-calendar"></i>
									</button>
								</span>
							</div>
                       </div>
                       
                       
                       <div class="form-group">
                           <label> Adresse<span class="text-danger"> *</span></label>
                           <textarea required="required" rows="2" class="form-control"><s:property value="%{#session.utilisateur.adresseUtilisateur}" /></textarea>
                       </div>
                       <div class="form-group">
                           <label> Telephone<span class="text-danger"> *</span></label>
                           <input required="required" id="title" value='<s:property value="%{#session.utilisateur.telephoneUtilisateur}" />' class="form-control">
                       </div>
                       
                       <div class="form-group">
                           <label> Email<span class="text-danger"> *</span></label>
                           <input required="required" id="title" value='<s:property value="%{#session.utilisateur.emailUtilisateur}" />' class="form-control">
                       </div>
                       
                       <div class="pull-right">
                           <button class="btn btn-danger btn-sm" type="button">Annuler</button>
                           <button class="btn btn-success btn-sm" type="button">Sauvgarder les changements</button>
                       </div>
                   </div>

               </div>

           </div>
       </div>
   </div>
<!-- modal -->