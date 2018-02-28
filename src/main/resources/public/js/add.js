function toggleAddButton() {
    let displayStatus = $(".addBand").css("display");
    if(displayStatus === "none"){
        $(".addBand").css("display", "inline");
    } else {
        $(".addBand").css("display", "none");
    }
}


function sendAddBandForm() {
    let formArray = $("form").serializeArray();
    /*console.log(formArray);*/
    let bandName;
    let bandDesc;
    let bandStyle;
    for(let i = 0; i < formArray.length; i++){
        /*console.log(formArray[i])*/
        if(formArray[i].name === "band-name"){
            bandName = formArray[i].value;
        }
        if(formArray[i].name === "band-desc"){
            bandDesc = formArray[i].value;
        }
        if(formArray[i].name === "musicStyle"){
            bandStyle = formArray[i].value;
        }
    }
    console.log(bandName, bandDesc, bandStyle);

    let bandDetails = {
        "name": bandName,
        "musicStyle": bandStyle,
        "description": bandDesc
    }

    $.ajax({
        url: '/add-band',
        type: 'POST',
        data: bandDetails,
        success: function (data) {
            console.log(data);
            toggleAddButton();
            $("#bandSelect").append($("<option></option>")
                .attr("value", data["id"])
                .text(data["name"]))
        }

    });
}