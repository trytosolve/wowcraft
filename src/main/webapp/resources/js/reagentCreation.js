var clone_id = 1;

$(document).ready(function () {
    $(".add").click(function () {
        var clone = $(".clone_reagent").clone();
        clone.attr('class', 'clone_reagent' + clone_id);
        clone.find(".reagentName").attr('class', 'reagentName' + clone_id);
        clone.find(".reagentName").attr('value', 'reagentName' + clone_id);
        clone.find(".count").attr('class', 'count' + clone_id);
        clone.appendTo(".recipe_property");
        clone_id = clone_id + 1;
    });
});

$(document).ready(function () {
    $(".del").click(function () {
        clone_id = clone_id - 1;
        $('.clone_reagent' + clone_id).remove();
    });
});

$(document).ready(function () {
    $(".test").click(function () {
        var reagentName = ".reagentName";
        var count = ".count";
        for (var i = 1; i <= clone_id+1; i++) {
            var countValue = $(reagentName+" :selected").text;
            $(count).attr('name', countValue);
            count = ".count" + i;
            reagentName = ".reagentName"+i;
        }
    });
});
