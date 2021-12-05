
// ------------------------------------RESPONSIVE NAVBAR-----------------------------------------------
$(function () {
    $('.toggle-menu').click(function(){
        $('.exo-menu').toggleClass('display');

    });

});

// ------------------------------------DYNAMIC INPUT TASK-----------------------------------------------
$("#btnAddTask").click(function () {
    let html = '';
    html += '<li>';
    html += '<div class="row">';
    html += '<div class="col-md-10 col-10">';
    html += '<input class="input-checkbox" type="checkbox" id="box-1">';
    html += ' <label class="label-checkbox" for="box-1">New Task</label>';
    html += ' </div>';
    html += ' <div class="col-md-2 col-2">';
    html += ' <a href="" class="btnDeleteTask"><span class="material-icons">delete</span></a>';
    html += '</div>';
    html += '</div>';
    html += '</li>';

    $('#checklist').append(html);
});

// // remove row


$('#btnDeleteTask').click( function () {
    ('#btnDeleteTask').parentElement.parentElement.remove();
});

// // MODAL UPDATE GUEST
var modalUpdateGuest = $('#modal-update-guest');
//
// // Listen for modal hide and popstate events.
function startListening() {
    $('#modal-update-guest').on('hide.bs.modal', onModalHide);
    $(window).on('popstate', onPopState);
}
//
// // Stop listening for modal hide and popstate events.
function stopListening() {
    $('#modal-update-guest').off('hide.bs.modal', onModalHide);
    $(window).off('popstate', onPopState);
}
//
// // Modal opens.
// // Add event listeners and push state.
function onModalShow(id) {
    console.log('ok')
    startListening();
    window.history.pushState({}, '', '/wedding-guests/'+id);
}
//
// // Modal hides.
// // Remove event listeners and go back.
function onModalHide() {
    stopListening();
    window.history.back();
}
//
// // Navigation occurs.
// // Remove event listeners and hide modal.
function onPopState() {
    stopListening();
    $('#modal-update-guest').modal('hide');
}
//
// // Listen for when the modal shows.
$('#modal-update-guest').on('show.bs.modal', onModalShow);

