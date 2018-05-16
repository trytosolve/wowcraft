var clone_id = 1;

$(document).ready(function () {
    $(".add").click(function () {
        var clone = $(".clone_reagent").clone();
        clone.attr('class', 'clone_reagent' + clone_id);
        clone.find("#cboReagents").attr('id', 'cboReagents' + clone_id)
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

// $("form").submit(function (event) {
//     var cboReagents = "#cboReagents";
//     var count = ".count";
//     for (var i = 1; i <= clone_id + 1; i++) {
//         var keyForMap = $(cboReagents + " :selected").text();
//         var valueForMap = $(count).val();
//         $(count).attr('name', "reagentCountMap['" + keyForMap + "']");
//         $(count).attr('value', valueForMap)
//         count = ".count" + i;
//         cboReagents = "#cboReagents" + i;
//         event.preventDefault();
//     }
// });

$(document).ready(function () {
    $(".test").click(function () {
        var cboReagents = "#cboReagents";
        var count = ".count";
        for (var i = 1; i <= clone_id+1; i++) {
            var keyForMap = $(cboReagents+" :selected").val();
            var valueForMap = $(count).val();
            $(count).attr('name', "reagentCountMap['"+keyForMap+"']");
            $(count).attr('value',valueForMap)
            count = ".count" + i;
            cboReagents = "#cboReagents"+i;
        }
    });
});
