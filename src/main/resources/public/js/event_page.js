$(function() {

    $('#addToCartBtn').click(function () {
        var ticketId = $("#ticket_type_election").val();
        var details = {
            "ticketId": ticketId
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