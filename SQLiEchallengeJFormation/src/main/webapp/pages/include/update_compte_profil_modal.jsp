<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!-- Modal Update profil Start -->
   <div class="modal fade" id="updateCompteProfil" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
       <div class="modal-dialog">
           <div class="modal-content" style="width: 110%;">
               <div class="modal-header">
                   <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                   <h4 class="modal-title">Mise à jour de votre compte</h4>
               </div>

               <div class="modal-body row" style="padding-left: 35px; padding-right: 35px;">
				<form data-toggle="validator" id="update_utilisateur" action="update" method="post" role="form" 
										class="form-horizontal left-align form-well adminex-form" enctype="multipart/form-data">
                   <div class="col-md-5 img-modal">
						
						<div class="fileupload fileupload-new" data-provides="fileupload">
							<div class="fileupload-new thumbnail" style="width: 200px; height: 150px;">
								<img id="utilisateurImageProfil" src='<s:url namespace="/" action='download'>
																	<s:param name="file"><s:property value="%{#session.utilisateur.urlPhotoUtilisateur}" />
																	</s:param></s:url>' alt="">
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
                       			<div class="col-md-8" style="vertical-align: center; padding-right: 0;">
                       				<label>Modifier Mot de passe</label>
                       			</div>
                       			<div class="col-md-3" style="padding-left: 0;">
                       				<input type="checkbox" name="changePassword" class="js-switch-red" value="true" id="changePassword_">
                       			</div>
                       		</div>
                       </div>
                       <div class="form-group">
                           <label> Nouveau mot de passe<span class="text-danger"> *</span></label>
                           <div class="row">
	                           <div class="col-md-10">
	                           		<input id="newPassword_1" readonly type="password" name="newPassword" value="" class="password-change form-control">
	                           </div>
	                           <div class="col-md-2" id="newPassword_2_valide"></div>
                           </div>
                       </div>
                       <div class="form-group">
                           <label> Nouveau mot de passe<span class="text-danger"> *</span></label>
                           <div class="row">
                           		<div class="col-md-10">
                           			<input id="newPassword_2" readonly type="password" name="newPassword_2" value="" class="password-change form-control">
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
                           <textarea required="required" rows="2" name="adresse" class="form-control"><s:property value="%{#session.utilisateur.adresseUtilisateur}" /></textarea>
                       </div>
                       <div class="form-group">
                           <label> Telephone<span class="text-danger"> *</span></label>
                           <input required="required" id="title" pattern="^0[5-6]{1}\d{8}" name="telephone"
                           		value='<s:property value="%{#session.utilisateur.telephoneUtilisateur}" />' class="form-control">
                       </div>
                       
                       <div class="form-group">
                           <label> Email<span class="text-danger"> *</span></label>
                           <input required="required" id="title" pattern="^[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\.[a-zA-Z0-9-.]+$" name="email"
                           		value='<s:property value="%{#session.utilisateur.emailUtilisateur}" />' class="form-control">
                       </div>
                       
                       <div class="form-group">


							<label for="sexeElement" style="margin-left: 0px; padding-left: 0px; text-align: left;"
								class="col-sm-3 control-label vcenter">Sexe<span
								class="text-danger"> *</span></label>

							<div id="sexeElement" class="col-sm-8 vcenter">
									<s:set name="myVarSexe" value="%{#session.utilisateur.sexeUtilisateur}"/>
									
								<div class="icheck row">
									<div class="square-red col-sm-4" style="margin-right: 0px; padding-right: 0px;">
										<div class="radio " style="margin: auto auto; float: none;">
											<s:if test="%{#myVarSexe=='Homme'}">
												<input tabindex="3" type="radio" name="sexe"
													id="optionHomme" value="Homme" checked="checked">
											</s:if>
											<s:else>
												<input tabindex="3" type="radio" name="sexe" 
													id="optionHomme" value="Homme">
											</s:else>
											<label id="optionHomme_label" for="optionHomme" > Male </label>
										</div>
										

									</div>
									<div class="square-red col-sm-5" style="margin-left: 0px; padding-left: 0px;">
										<div class="radio " style="margin: auto auto; float: none;">
										<s:if test="%{#myVarSexe=='Femme'}">
											<input tabindex="3" type="radio" name="sexe" id="optionFemme" value="Femme" checked="checked">
										</s:if>
										<s:else>
											<input tabindex="3" type="radio" name="sexe" id="optionFemme" value="Femme">
										</s:else> 
											<label id="optionFemme_label" for="optionFemme">
												Female </label>
										</div>
									</div>
								</div>

							</div>
						</div>
                  			
                       <div class="pull-right">
                           <button data-dismiss="modal" class="btn btn-default btn-sm" type="button">Annuler</button>
                           <button type="submit" class="btn btn-success btn-sm" type="button">Sauvgarder les changements</button>
                       </div>
                   </div>
				</form>
               </div>
               

           </div>
       </div>
   </div>
<!-- Modal Update profil End -->