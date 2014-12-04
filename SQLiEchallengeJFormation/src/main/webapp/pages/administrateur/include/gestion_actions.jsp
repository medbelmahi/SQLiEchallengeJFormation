<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<div aria-hidden="true" aria-labelledby="myModalLabel" role="dialog" tabindex="-1" id="myModal_action" class="modal fade">
     <div class="modal-dialog">
         <div class="modal-content">
             <div class="modal-header">
                 <button aria-hidden="true" data-dismiss="modal" class="close" type="button">×</button>
                 <h4 class="modal-title" id="profilTitle"></h4>
             </div>
             <div class="modal-body">

                 <form class="form-horizontal adminex-form" action="actions/update" role="form">
                 
                 	<s:hidden name="idProfil" id="idProfilAffectation" /><!-- idProfil -->

					<div class="form-group" id="checkboxElement">
						<!-- <div class="col-lg-12 vcenter">
							<div class="col-sm-12 icheck ">
								<div class="square-green single-row col-sm-12">
									<div class="checkbox col-sm-12" style="position: relative;">
										<input type="checkbox" checked> <label
											class="popovers" data-trigger="hover" data-placement="right"
											data-content="Vivamus sagittis lacus vel augue laoreet rutrum faucibus."
											data-original-title="Popovers in right">Green
											Checkbox </label>
									</div>
								</div>
							</div>
						</div>
						<div class="col-lg-12 vcenter">
							<div class="col-sm-12 icheck ">
								<div class="square-green single-row col-sm-12">
									<div class="checkbox col-sm-12" style="position: relative;">
										<input type="checkbox" checked> <label
											class="popovers" data-trigger="hover" data-placement="right"
											data-content="Vivamus sagittis lacus vel augue laoreet rutrum faucibus."
											data-original-title="Popovers in right">Green
											Checkbox _ 1 </label>
									</div>
								</div>
							</div>
						</div> -->
						
						<!-- Actions -->
					</div>


					<div class="form-group">
                         <div class="col-lg-offset-2 col-lg-10">
                             <button type="submit" class="btn btn-primary">Affecter</button>
                         </div>
                     </div>
                 </form>

             </div>

         </div>
     </div>
 </div>