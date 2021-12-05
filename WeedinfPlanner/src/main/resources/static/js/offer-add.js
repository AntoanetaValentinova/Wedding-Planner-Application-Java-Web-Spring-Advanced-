var index=0;
$("#button-add-attr").click(function () {
    let html = '';
     html += '  <div class="col-md-6 form-group">\n'+' <div class="input-group">\n' +
         '                            <input th:errorclass="is-invalid"\n' +
         '                                   name="includedAttributes['+ index +']" th:value="*{includedAttributes['+ index +']}" class="form-control input col-md-12 col-12" type="text">\n' +
         '                        </div>'+
         '                        </div>';

index++;
    $('#includedAttributes').append(html);
});

var indexPic=0;
$("#button-add-picture").click(function () {
    let html = '';
    html += '<div class="group-picture input-group row ">\n' +
        '                    <label for="name" class="form-label gold-text col-md-3">Picture title</label>\n' +
        '                    <input th:errorclass="is-invalid" required minlength="1" maxlength="20"\n' +
        '                           name="picturesBind['+ indexPic+'].namePicture" th:value="*{picturesBind['+ indexPic+'].namePicture}"\n' +
        '                           class="form-control input col-md-4 col-4" type="text" id="name-'+indexPic+'">\n' +
        '                    <input th:errorclass="is-invalid" required\n' +
        '                            name="picturesBind['+ indexPic+'].pictureFile" th:value="*{picturesBind['+ indexPic+'].pictureFile}"\n' +
        '                           class="form-control input col-md-5 col-5" type="file" id="picture-'+indexPic+'">\n' +
        '                </div>';

    indexPic++;
    $('#pictures').append(html);
});

function showPic(event ) {
    console.log(event);

    return console.log('ok');
}

// remove row
// $('#button-delete-attr').on('click', function () {
//     console.log('ok')
//     console.log($(this))
//     let btn = document.getElementsByClassName('button-delete-attr')[0];
//     console.log(btn)
//     btn.parentElement.parentElement.remove();
// })

