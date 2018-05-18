var clone_id = 1;

$(document).ready(function () {
    $(".add").click(function () {
        var clone = $(".clone_reagent:first").clone();
        clone.attr('class', 'clone_reagent' + clone_id);
        clone.find("#cboReagents").attr('id', 'cboReagents' + clone_id);
        clone.find(".empty_option").attr("selected", "selected");
        clone.find(".count").attr("value", "");
        clone.find(".count").attr('class', 'count' + clone_id);
        clone.find(".del").removeAttr("hidden");
        clone.find(".del").attr("class","del"+clone_id);
        clone.find(".del").attr("value",clone_id)
        clone.find(".del").attr('value',clone_id);
        clone.appendTo(".recipe_property");
        clone_id = clone_id + 1;
    });
});

$(document).ready(function () {
    $('form').on('click','.del2',function () {
        $('.clone_reagent2').remove();
    });
});

$(document).ready(function () {
    $('#add_recipe_form').submit(function (event) {
        event.preventDefault();
        var cboReagents = "#cboReagents";
        var count = ".count";
        for (var i = 1; i <= clone_id + 1; i++) {
            var keyForMap = $(cboReagents + " :selected").val();
            var valueForMap = $(count).val();
            $(count).attr('name', "reagentCountMap['" + keyForMap + "']");
            $(count).attr('value', valueForMap)
            count = ".count" + i;
            cboReagents = "#cboReagents" + i;
        }
        $(this).unbind('submit').submit();
    });
});

$(document).ready(function () {
    $('#edit_recipe_form').submit(function (event) {
        event.preventDefault();
        var cboReagents = "#cboReagents";
        var count = ".count";
        for (var i = 1; i <= clone_id + 1; i++) {
            var keyForMap = $(cboReagents + " :selected").val();
            var valueForMap = $(count).val();
            $(count).attr('name', "reagentCountMap['" + keyForMap + "']");
            $(count).attr('value', valueForMap)
            count = ".count" + i;
            cboReagents = "#cboReagents" + i;
        }
        $(this).unbind('submit').submit();
    });
});