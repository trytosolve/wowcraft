var clone_id = 1;

$(document).ready(function () {
    $(".add").click(function () {
        var clone = $(".clone_reagent").clone();
        clone.attr('class', 'clone_reagent' + clone_id);
        clone.find("#cboReagents").attr('id','cboReagents'+clone_id)
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
        var cboReagents = "#cboReagents";
        var count = ".count";
        for (var i = 1; i <= clone_id+1; i++) {
            var keyValue = $(cboReagents+" :selected").text();
            $(count).attr('name', "myMap."+keyValue);
            count = ".count" + i;
            cboReagents = "#cboReagents"+i;
        }
    });
});
