var EditableTable = function () {

    return {

        //main function to initiate the module
        init: function () {
            function restoreRow(oTable, nRow) {
                var aData = oTable.fnGetData(nRow);
                var jqTds = $('>td', nRow);

                for (var i = 0, iLen = jqTds.length; i < iLen; i++) {
                    oTable.fnUpdate(aData[i], nRow, i, false);
                }

                oTable.fnDraw();
            }

/*            function editRow(oTable, nRow) {
            	var aData = oTable.fnGetData(nRow);
            	var jqTds = $('>td', nRow);
            	jqTds[0].innerHTML = '<input type="text" class="form-control small" value="' + aData[0] + '">';
            	jqTds[1].innerHTML = '<input type="text" class="form-control small" value="' + aData[1] + '">';
            	jqTds[2].innerHTML = '<input type="text" class="form-control small" value="' + aData[2] + '">';
            	jqTds[3].innerHTML = '<input type="text" class="form-control small" value="' + aData[3] + '">';
            	jqTds[4].innerHTML = '<a class="edit" href="">Save</a>';
            	jqTds[5].innerHTML = '<a class="cancel" href="">Cancel</a>';
            }
            
*/            function editRow(oTable, nRow) {
                var aData = oTable.fnGetData(nRow);
                var jqTds = $('>td', nRow);
                jqTds[0].innerHTML = '<input id="idSeance" type="hidden" class="form-control small" value="' + aData[0] + '">';
                jqTds[1].innerHTML = '<input id="titreSeance" type="text" class="form-control small" value="' + aData[1] + '">';
                jqTds[2].innerHTML = '<input id="descriptionSeance" type="text" class="form-control small" value="' + aData[2] + '">';
                jqTds[3].innerHTML = '<input id="dateSeance" type="text" class="form-control" disabled="" value="' + aData[3] + '" pattern="^(\d{2})\/(\d{2})\/(\d{4})" readonly="readonly" size="16">';
//                jqTds[3].innerHTML = '<input type="text" class="form-control small" value="' + aData[3] + '">';
                jqTds[4].innerHTML = '<div class="input-group bootstrap-timepicker">'
                    					+'<input id="heureDebutSeance" type="text" value="' + aData[4] + '" class="form-control timepicker-24" readonly="readonly" >'
                						+'<span class="input-group-btn">'
                						+'<button class="btn btn-default" type="button"><i class="fa fa-clock-o"></i></button>'
                						+'</span>'
                						+'</div>';
                jqTds[5].innerHTML = '<div class="input-group bootstrap-timepicker">'
										+'<input id="heureFinSeance" type="text" value="' + aData[5] + '" class="form-control timepicker-24" readonly="readonly" >'
										+'<span class="input-group-btn">'
										+'<button class="btn btn-default" type="button"><i class="fa fa-clock-o"></i></button>'
										+'</span>'
										+'</div>';
                jqTds[6].innerHTML = '<a class="edit" href="">Modifier</a>';
                jqTds[6].innerHTML += '<a style="margin-left :10px;" class="cancel" href="">Annuler</a>';
            }

            function saveRow(oTable, nRow) {
                var jqInputs = $('input', nRow);
                oTable.fnUpdate(jqInputs[0].value, nRow, 0, false);
                oTable.fnUpdate(jqInputs[1].value, nRow, 1, false);
                oTable.fnUpdate(jqInputs[2].value, nRow, 2, false);
                oTable.fnUpdate(jqInputs[3].value, nRow, 3, false);
                oTable.fnUpdate(jqInputs[4].value, nRow, 4, false);
                oTable.fnUpdate(jqInputs[5].value, nRow, 5, false);
                oTable.fnUpdate('<a class="edit" href="">Mise à jour</a>', nRow, 6, false);
//                oTable.fnUpdate('<a class="delete" href="">Delete</a>', nRow, 5, false);
                oTable.fnDraw();
            }

            function cancelEditRow(oTable, nRow) {
                var jqInputs = $('input', nRow);
                oTable.fnUpdate(jqInputs[0].value, nRow, 0, false);
                oTable.fnUpdate(jqInputs[1].value, nRow, 1, false);
                oTable.fnUpdate(jqInputs[2].value, nRow, 2, false);
                oTable.fnUpdate(jqInputs[3].value, nRow, 3, false);
                oTable.fnUpdate('<a class="edit" href="">Edit</a>', nRow, 4, false);
                oTable.fnDraw();
            }

            var oTable = $('#editable-sample').dataTable({
                "aLengthMenu": [
                    [5, 15, 20, -1],
                    [5, 15, 20, "All"] // change per page values here
                ],
                // set the initial value
                "iDisplayLength": 5,
                "sDom": "<'row'<'col-lg-6'l><'col-lg-6'f>r>t<'row'<'col-lg-6'i><'col-lg-6'p>>",
                "sPaginationType": "bootstrap",
                "oLanguage": {
                    "sLengthMenu": "_MENU_ records per page",
                    "oPaginate": {
                        "sPrevious": "Prev",
                        "sNext": "Next"
                    }
                },
                "aoColumnDefs": [{
                        'bSortable': false,
                        'aTargets': [0]
                    }
                ]
            });

            jQuery('#editable-sample_wrapper .dataTables_filter input').addClass("form-control medium"); // modify table search input
            jQuery('#editable-sample_wrapper .dataTables_length select').addClass("form-control xsmall"); // modify table per page dropdown

            var nEditing = null;

            $('#editable-sample_new').click(function (e) {
                e.preventDefault();
                var aiNew = oTable.fnAddData(['', '', '', '',
                        '<a class="edit" href="">Edit</a>', '<a class="cancel" data-mode="new" href="">Cancel</a>'
                ]);
                var nRow = oTable.fnGetNodes(aiNew[0]);
                editRow(oTable, nRow);
                
                nEditing = nRow;
            });

            $('#editable-sample a.delete').live('click', function (e) {
                e.preventDefault();

                if (confirm("Are you sure to delete this row ?") == false) {
                    return;
                }

                var nRow = $(this).parents('tr')[0];
                oTable.fnDeleteRow(nRow);
                alert("Deleted! Do not forget to do some ajax to sync with backend :)");
            });

            $('#editable-sample a.cancel').live('click', function (e) {
                e.preventDefault();
                if ($(this).attr("data-mode") == "new") {
                    var nRow = $(this).parents('tr')[0];
                    oTable.fnDeleteRow(nRow);
                } else {
                    restoreRow(oTable, nEditing);
                    nEditing = null;
                }
            });

            $('#editable-sample a.edit').live('click', function (e) {
                e.preventDefault();

                /* Get the row as a parent of the link that was clicked on */
                var nRow = $(this).parents('tr')[0];

                if (nEditing !== null && nEditing != nRow) {
                    /* Currently editing - but not this row - restore the old before continuing to edit mode */
                    restoreRow(oTable, nEditing);
                    editRow(oTable, nRow);
                    nEditing = nRow;
                } else if (nEditing == nRow && this.innerHTML == "Modifier") {
                    /* Editing this row and want to save it */
                	
                	var idSeance = document.getElementById("idSeance").value;
                	var titreSeance = document.getElementById("titreSeance").value;
                	var descriptionSeance = document.getElementById("descriptionSeance").value;
                	var heureDebutSeance = document.getElementById("heureDebutSeance").value;
                	var heureFinSeance = document.getElementById("heureFinSeance").value;
                	
                	console.log(idSeance, titreSeance, descriptionSeance, heureDebutSeance, heureFinSeance)
                	
//                	var status = jsonUpdateSeance(idSeance, titreSeance, descriptionSeance, heureDebutSeance, heureFinSeance);
                	
                	jsonUpdateSeance(idSeance, titreSeance, descriptionSeance, heureDebutSeance, heureFinSeance);
                	setTimeout(function(){
                		
                		console.log(globaleStatus);
                    	if(globaleStatus == "success"){
                    		saveRow(oTable, nEditing);
                            nEditing = null;
                    	}else{
                    		console.log("mise à jour n'est po effectuée");
//                    		alert("mise à jour n'est po effectuée")
                    	}
                	
                	}, 1000);
                	
                	
                    
                } else {
                    /* No edit in progress - let's start one */
                    editRow(oTable, nRow);
                    //here we go
                    chargeFileJs_timepicker()
                    
                    nEditing = nRow;
                }
            });
        }

    };

}();