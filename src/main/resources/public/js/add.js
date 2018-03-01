function toggleBandButton() {
    let displayStatus = $(".addBand").css("display");
    if(displayStatus === "none"){
        $(".addBand").css("display", "inline");
    } else {
        $(".addBand").css("display", "none");
    }
}

function toggleLocationButton() {
    let displayStatus = $(".addLocation").css("display");
    if(displayStatus === "none"){
        $(".addLocation").css("display", "inline");
    } else {
        $(".addLocation").css("display", "none");
    }
}


function sendAddBandForm() {
    let formArray = $("form").serializeArray();
    let bandName;
    let bandDesc;
    let bandStyle;
    for(let i = 0; i < formArray.length; i++){
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
            toggleBandButton();
            $("#bandSelect").append($("<option></option>")
                .attr("value", data["id"])
                .text(data["name"]))
        }

    });
}

function sendAddLocationForm() {
    let formArray = $("form").serializeArray();
    let locName;
    let locAddress;
    let locCapacity;
    for(let i = 0; i < formArray.length; i++){
        if(formArray[i].name === "location-name"){
            locName = formArray[i].value;
        }
        if(formArray[i].name === "location-address"){
            locAddress = formArray[i].value;
        }
        if(formArray[i].name === "capacity"){
            locCapacity = formArray[i].value;
        }
    }

    let bandDetails = {
        "name": locName,
        "address": locAddress,
        "capacity": locCapacity
    }

    $.ajax({
        url: '/add-location',
        type: 'POST',
        data: bandDetails,
        success: function (data) {
            console.log(data);
            toggleLocationButton();
            $("#locationSelect").append($("<option></option>")
                .attr("value", data["id"])
                .text(data["name"]))
        }

    });
}