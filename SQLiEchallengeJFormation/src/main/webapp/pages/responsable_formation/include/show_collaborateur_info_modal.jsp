<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<div style="display: none;" aria-hidden="true" aria-labelledby="myModalLabel" role="dialog" tabindex="-1" id="collaborateurInfoModal" class="modal fade">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<button aria-hidden="true" data-dismiss="modal" class="close" type="button">×</button>
				<h4 class="modal-title">Les informations du collaborateur</h4>
			</div>

			<div class="modal-body">
				<div class="panel-body">
					
					
					<!-- info collaborateur div Begin -->
						<div class="row">
							<div class="col-md-12">
								<div class="panel">
									<div class="panel-body" style="padding: 0px;">
										<div class="profile-pic text-center">
											<img id="imageCollaborateur" alt="" src=''>
											<h2 id="collaborateurFullname">
												
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
												<div class="desk" id="collaborateurEmail"></div>
											</li>
											<li>
												<div class="title">Telephone</div>
												<div class="desk" id="collaborateurTelephone"></div>
											</li>
											<li>
												<div class="title">Date de naissance</div>
												<div class="desk" id="collaborateurDateNaissance"></div>
											</li>
											<li>
												<div class="title">Sexe</div>
												<div class="desk" id="collaborateurSexe"></div>
											</li>
											<li>
												<div class="title">Adresse</div>
												<div class="desk" id="collaborateurAdresse"></div>
											</li>
											<li>
												<div class="title">Habilitations</div>
												<div class="desk" id="collaborateurHablitations"></div>
											</li>
										</ul>
									</div>
								</div>
							</div>
						</div>
					
					
				</div>
				 <div class="modal-footer">
                     <button type="button" class="btn btn-default" data-dismiss="modal">Fermer</button>
                 </div>
			</div>

		</div>
	</div>
</div>