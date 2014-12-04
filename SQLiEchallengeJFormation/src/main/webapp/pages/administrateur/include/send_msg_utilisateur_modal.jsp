<div aria-hidden="true" aria-labelledby="myModalLabel" role="dialog" tabindex="-1" id="sendUtilisateurMessageModal" class="modal fade">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button aria-hidden="true" data-dismiss="modal" class="close" type="button">×</button>
                <h4 class="modal-title">Composez votre Email</h4>
            </div>
            <div class="modal-body">
				
                  <section class="mail-box-info">
                  <form role="form-horizontal" method="post" action="sendEmailToCollaborateur">
                    <header class="header">
                        <div class="compose-btn pull-right">
                        <!-- sendMessageToCollaboroateur_ajax(); -->
                            <button class="btn btn-primary btn-sm" type="submit" ><i class="fa fa-check"></i> Send</button>
                            <!-- <button class="btn btn-sm btn-default"><i class="fa fa-times"></i> Discard</button>
                            <button class="btn btn-sm btn-default">Draft</button> -->
                        </div>
                        <div class="btn-toolbar">
                            <h4 class="pull-left" id="fullnameTo"> </h4>
                        </div>

                    </header>

                    <section class="mail-list">
                        <div class="compose-mail">
                            
                            	<input type="hidden" id="idCollaborateur_sendMessage" name="idUtilisateur">
                                <div class="form-group">
                                    <label for="to" class="col-md-3">A:</label>
                                    <input type="text" tabindex="1" id="to" class="form-control" readonly="readonly">
                                </div>

                                <div class="form-group">
                                    <label for="subject" class="col-md-3">Sujet:</label>
                                    <input type="text" tabindex="1" id="subject" class="form-control" name="object">
                                </div>

                                <div class="compose-editor">
                                    <textarea class="wysihtml5 form-control" rows="9" name="msg" id="msg_"></textarea>
                                </div>
                           
                        </div>
                    </section>
                     </form>
                </section>
            </div>
        </div>
    </div>
</div>