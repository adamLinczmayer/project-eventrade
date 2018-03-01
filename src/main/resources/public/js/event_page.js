$(function() {

    $('#addToCartBtn').click(function () {
        let ticketId = $("#ticket-type-selection").val();
        let quantity = $("#ticket-quantity").val();
        let details = {
            "ticketId": ticketId,
            "quantity": quantity
        };
        $.ajax({
            url: '/add-to-cart',
            type: 'POST',
            data: details,
            success: function (data) {
                console.log("add-to-cart success. Data: " + data.responseText);
                $(".alert").removeClass("in").show();
                $(".alert").delay(1000).addClass("in").fadeOut(2000);
            },
            error: function (data) {
                console.log("add-to-cart ERROR. Data: " + data.responseText)
            }
        });
    })
});