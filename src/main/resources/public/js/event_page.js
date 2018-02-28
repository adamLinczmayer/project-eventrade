$(function() {

    $('#addToCartBtn').click(function () {
        var ticketId = $("form").value();
        var details = {
            "ticketId": ticketId
        };
        $.ajax({
            url: '/add-to-cart',
            type: 'POST',
            data: details,
            success: function (data) {
                console.log(data);
            }

        });
    })
}