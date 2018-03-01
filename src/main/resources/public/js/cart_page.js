function changeQuantity() {

    let quantity = $("#cartItem-quantity").val();
    let ticketId = $("#cartItem-quantity").attr("data-ticketId");
    let details = {
        "quantity": quantity,
        "ticketId": ticketId
    };
    $.ajax({
        url: '/change-quantity',
        type: 'POST',
        data: details,
        success: function (data) {
            console.log("quantity changing is successful. Data: " + data.responseText);
        },
        error: function (data) {
            console.log("quantity changing ERROR. Data: " + data.responseText);
        }
    })
}

