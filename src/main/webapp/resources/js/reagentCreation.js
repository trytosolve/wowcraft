$(document).ready(function () {
    $(".add").click(function () {
        var links = $("[rebest='yes']").length;
        $("#clone_reagent").clone().attr('id', 'clone_reagent' + links).appendTo(".recipe_property");
    });
});