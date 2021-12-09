$(document).ready(function() {
    $("#check-in input").datepicker({
        autoclose: true
    });
    $("#check-in").on("show", function(e) {
        if (e.date) {
            $(this).data("stickyDate", e
                .date);
        } else {
            $(this).data("stickyDate",
                null);
        }
    });
    $("#check-in").on("hide", function(e) {
        var stickyDate = $(this).data(
            "stickyDate");
        if (!e.date && stickyDate) {
            console.debug(
                "restore stickyDate",
                stickyDate);
            $(this).datepicker("setDate",
                stickyDate);
            $(this).data("stickyDate",
                null);
        }
    });
    $("#check-out input").datepicker({
        autoclose: true
    });
    $("#check-out").on("show", function(e) {
        if (e.date) {
            $(this).data("stickyDate", e
                .date);
        } else {
            $(this).data("stickyDate",
                null);
        }
    });
    $("#check-out").on("hide", function(e) {
        var stickyDate = $(this).data(
            "stickyDate");
        if (!e.date && stickyDate) {
            console.debug(
                "restore stickyDate",
                stickyDate);
            $(this).datepicker("setDate",
                stickyDate);
            $(this).data("stickyDate",
                null);
        }
    });
});
