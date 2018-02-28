$(function() {

    $('.addToCartBtn').click(function () {
        var eventId = this.eventId;
        $.ajax({
            url: '/api/add_to_cart?id=' + id,
            success: function (data) {
                $('.num_of_prods').html(data);
            }
        });
    });
}
