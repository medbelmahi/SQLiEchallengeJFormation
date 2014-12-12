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
								<img id="utilisateurImageProfil" src='<s:url value="/images/select_image.gif"/>' alt="">
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
														
														
                       <p class="mtop10"><strong>File Name:</strong> img01.jpg</p>
                       <p><strong>File Type:</strong> jpg</p>
                       <p><strong>Resolution:</strong> 300x200</p>
                       <p><strong>Uploaded By:</strong> <a href="#">ThemeBucket</a></p>
                       
                       <div class="form-group">
                           <label> Ancien mot de passe<span class="text-danger"> *</span></label>
                           <div class="row">
	                           <div class="col-md-10">
	                           		<input type="password" name="oldPassword" value="" class="form-control">
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
                           <input type="text" id="nom" name="nom" value="img01.jpg" class="form-control" required="required">
                       </div>
                       <div class="form-group">
                           <label> Prènom<span class="text-danger"> *</span></label>
                           <input id="prenom" name="prenom" value="img01.jpg" class="form-control">
                       </div>
                       
                       <div class="form-group">
                           <label> Date de naissance<span class="text-danger"> *</span></label>
                           <div data-date-viewmode="years" style="padding-left: 0;"
								data-date-format="dd/mm/yyyy" data-date="12/02/1990"
								class="col-sm-12 input-append date dpYears" >
								<input name="dateNaissance" id="inputDateNaissance"
									pattern="^(\d{2})\/(\d{2})\/(\d{4})" type="text"
									readonly="readonly" value="12/02/1990" size="16"
									class="form-control"> <span
									class="input-group-btn add-on">
									<button class="btn btn-primary" type="button">
										<i class="fa fa-calendar"></i>
									</button>
								</span>
							</div>
                       </div>
                       
                       
                       <div class="form-group">
                           <label> Adresse</label>
                           <textarea rows="2" class="form-control"></textarea>
                       </div>
                       <div class="form-group">
                           <label> Telephone</label>
                           <input id="title" value="awesome image" class="form-control">
                       </div>
                       
                       <div class="form-group">
                           <label> Email</label>
                           <input id="title" value="awesome image" class="form-control">
                       </div>
                       
                       <div class="pull-right">
                           <button class="btn btn-danger btn-sm" type="button">Delete</button>
                           <button class="btn btn-success btn-sm" type="button">Save changes</button>
                       </div>
                   </div>

               </div>

           </div>
       </div>
   </div>
<!-- modal -->