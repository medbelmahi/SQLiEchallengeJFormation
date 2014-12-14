<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>


<div class="col-sm-12">

	<div class="row">
		<div id="hidden-table-info_wrapper"
			class="dataTables_wrapper form-inline" role="grid">
		
			<table aria-describedby="hidden-table-info_info"
				class="display table table-bordered dataTable"
			id="hidden-table-info">
		
				<thead>
					<tr role="row">
						<th class="text-center">Prènom &amp; Nom</th>
						<th class="text-center">Telphone</th>
						<th class="text-center">Email</th>
						<th class="text-center">Sexe</th>
						<th class="text-center">Status</th>
						<th style="display: none;">Adresse</th>
						<th style="display: none;">Date de naissance</th>
						<th style="display: none;">habilitations</th>
						<th style="display: none;">image</th>
					</tr>
				</thead>
		
				<tbody aria-relevant="all" aria-live="polite" role="alert">
					<s:iterator value="collaborateurInscrit">
							<tr class="gradeA odd">
								<td><s:property value="collaborateur.fullname" /></td>
								<td><s:property value="collaborateur.telephoneCollaborateur" /></td>
								<td><s:property value="collaborateur.emailCollaborateur" /></td>
								<td><s:property value="collaborateur.sexeCollaborateur" /></td>
								<td class="text-center">
									<s:if test='%{status==1}'>  
										<span class="label label-success">Confirmer</span>
									</s:if>
									<s:elseif test='%{status==0}'>
										<span class="label label-danger">Annuler</span>
									</s:elseif>
									<s:else>
										<span class="label label-warning">Non traiter</span>
									</s:else>
								</td>
								
								<td style="display: none;"><s:property value="collaborateur.adresseCollaborateur" /></td>
								<td style="display: none;"><s:property value="collaborateur.dateNaissanceCollaborateur" /></td>
								
								<td style="display: none;">
									<ul>
										<s:iterator value="collaborateur.habilitations">
											<li><s:property value="nomHabilitation" /></li>
										</s:iterator>
									</ul>
								</td>
								<td style="display: none;"><s:url namespace="/" action='download'>
																	<s:param name="file"><s:property value="collaborateur.urlPhotoCollaborateur" />
																	</s:param></s:url></td>
								
							</tr>
					</s:iterator>
				</tbody>
			</table>
		</div>
	</div>
</div>