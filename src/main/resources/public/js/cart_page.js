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
$(function() {

    $('#checkout').click(function () {
        alert("Successfully checked out! :)");
    })
})

function deleteLineItem(id) {
    $.ajax({
        url: '/delete-lineitem',
        type: 'POST',
        data: {"ticketId" : id},
        success: function (data) {
            console.log("LineItem deleted. Data: " + data.responseText);
            $("#cartItem" + id).remove();
        },
        error: function (data) {
            console.log("LineItem deletion ERROR. Data: " + data.responseText);
        }
    })
}



