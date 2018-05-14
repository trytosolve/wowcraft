var clone_id = 1;

$(document).ready(function () {
    $(".add").click(function () {
        $(".clone_reagent").clone().attr('class', 'clone_reagent' + clone_id).appendTo(".recipe_property");
        clone_id = clone_id + 1;
    });
});

$(document).ready(function () {
    $(".del").click(function () {
        clone_id = clone_id - 1;
        $('.clone_reagent'+clone_id).remove();
    });
});