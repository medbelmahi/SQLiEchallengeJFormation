<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<div class="row">
	<div class="col-md-12">
		<section class="panel">
			<header id="gestion_habilitation_panel" class="panel-heading">
				Gestion des habilitations <span class="tools pull-right">
				<a style="display: none;" class="fa fa-chevron-down" href="javascript:;" id="downUphabilitation"></a> 
				</span>
			</header>
			<div class="panel-body">

				<div class="row">
					<div class="col-md-5">
						<!-- info collaborateur div Begin -->
						<div class="row">
							<div class="col-md-12">
								<div class="panel">
									<div class="panel-body" style="padding: 0px;">
										<div class="profile-pic text-center">
											<img alt="" src='<s:property value="collaborateur.urlPhotoCollaborateur" />'>
											<h2>
												<s:property value="collaborateur.fullname" />
											</h2>
										</div>
									</div>
								</div>
							</div>
							<div class="col-md-12">
								<div class="panel">
									<div class="panel-body">
										<ul class="p-info">
											<li>
												<div class="title">Email</div>
												<div class="desk"><s:property value="collaborateur.emailCollaborateur" /></div>
											</li>
											<li>
												<div class="title">Telephone</div>
												<div class="desk"><s:property value="collaborateur.telephoneCollaborateur" /></div>
											</li>
											<li>
												<div class="title">Date de naissance</div>
												<div class="desk"><s:property value="collaborateur.dateNaissanceCollaborateur" /></div>
											</li>
											<li>
												<div class="title">Sexe</div>
												<div class="desk"><s:property value="collaborateur.sexeCollaborateur" /></div>
											</li>
											<li>
												<div class="title">Adresse</div>
												<div class="desk"><s:property value="collaborateur.adresseCollaborateur" /></div>
											</li>
										</ul>
									</div>
								</div>
							</div>
						</div>
					</div>
					<!-- info collaborateur div END -->

					<!-- Begin gestion des habilitation d'un collaborateur -->

					<div class="col-md-7">

						<div class="panel-group " id="accordion">
							
										<!-- le contenu -->
										<div class="row">
											<div class="col-md-12">
												<div class="panel">
													<div class="panel-body">
														<h4>Mise à jour des habilitations</h4>
														<form action="habilitations/update" method="post">
														<div class="row">
															<div class="col-md-12">
																<div class="form-group last">
																	<label class="control-label col-md-3">Chercher</label>
																	<input type="hidden" name="idCollaborateur" value="<s:property value="idCollaborateur" />" required="required">
																	<div class="col-md-9">
																		<select name="idHabilitations" class="multi-select" id="my_multi_select3_costum" multiple="multiple" >
																			<s:iterator value="collaborateurHabilitations">
																				<option selected="selected" id='habilitationOptionId_<s:property value="idHabilitation" />' data-score="1" value="<s:property value="idHabilitation" />" data-description="<s:property value="descriptionHabilitation" />" ><s:property value="nomHabilitation" /></option>	
																			</s:iterator>
																			<s:iterator value="nonCollaborateurHabilitations">
																				<option id='habilitationOptionId_<s:property value="idHabilitation" />' data-score="1" value="<s:property value="idHabilitation" />" data-description="<s:property value="descriptionHabilitation" />" ><s:property value="nomHabilitation" /></option>	
																			</s:iterator>
																		</select>
																	</div>

																</div>
															</div>
														
														<div class="row" style="margin-top: 20px;">
															<button type="submit" class="btn btn-success btn-lg btn-block">Mise à jour habilitation</button>
														</div>
														</div>
														</form>
														
													</div>
												</div>
											</div>
										</div>
										<!-- End ajout content -->
									
						</div>

					</div>

					<!-- End gestion des habilitation d'un collaborateur -->

				</div>
			</div>
		</section>
	</div>
</div>