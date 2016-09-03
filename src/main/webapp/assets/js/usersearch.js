function searchViaAjax() {
    $.ajax({
        type : "POST",
        contentType : "application/json",
        url : "/api/users/search",
        data : $("#search").val(),
        dataType : 'json',
        timeout : 100000,
        success : function(data) {
            console.log("SUCCESS: ", data);
        },
        error : function(e) {
            console.log("ERROR: ", e);
        },
        done : function(e) {
            console.log("DONE");
        }
    });
}

$(document).ready(function($) {
    $("#search").keydown(function(event) {
        searchViaAjax();
    });
});
