<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<div class="row"><!-- info profil -->
	
	<div class="col-md-3">
	
	</div>
	
	<div class="col-md-6">
		<div class="col-md-12">
        <div class="panel">
            <div class="panel-body">
                <div class="profile-pic text-center">
                    <img alt="" src='<s:url namespace="/" action='download'>
										<s:param name="file"><s:property value="%{#session.utilisateur.urlPhotoUtilisateur}" />
									</s:param></s:url>'>
                    <h2 id="collaborateurFullname"><s:property value="%{#session.utilisateur.fullname}" /></h2>
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
						<div class="desk" id="collaborateurEmail"><s:property value="%{#session.utilisateur.emailUtilisateur}" /></div>
					</li>
					<li>
						<div class="title">Telephone</div>
						<div class="desk" id="collaborateurTelephone"><s:property value="%{#session.utilisateur.telephoneUtilisateur}" /></div>
					</li>
					<li>
						<div class="title">Date de naissance</div>
						<div class="desk" id="collaborateurDateNaissance"><s:property value="%{#session.utilisateur.dateNaissanceUtilisateur}" /></div>
					</li>
					<li>
						<div class="title">Sexe</div>
						<div class="desk" id="collaborateurSexe"><s:property value="%{#session.utilisateur.sexeUtilisateur}" /></div>
					</li>
					<li>
						<div class="title">Adresse</div>
						<div class="desk" id="collaborateurAdresse"><s:property value="%{#session.utilisateur.adresseUtilisateur}" /></div>
					</li>
					<li>
						<div class="title">Profil</div>
						<div class="desk" id="collaborateurHablitations"><s:property value="%{#session.utilisateur.profil.nomProfil}" /></div>
					</li>
				</ul>
				<div class="row">
					<a href="#updateCompteProfil" data-toggle="modal" style="margin-top: 20px;" class="btn btn-block btn-success">
						Mise à jour de profil
					</a>
				</div>
            </div>
        </div>
    </div>
	</div>
    
    <div class="col-md-3">
	 </div>
</div><!-- info profil -->