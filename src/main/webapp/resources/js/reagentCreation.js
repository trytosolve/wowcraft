var clone_id = 1;

$(document).ready(function () {
    $("#add_for_add_page").click(function () {
        var clone = $("#clone_reagent:first").clone();
        clone.attr('id', 'clone_reagent' + clone_id);
        clone.find("#cboReagents").attr('id', 'cboReagents' + clone_id);
        clone.find("#empty_option").attr("selected", "selected");
        clone.find("#count").attr("value", "");
        clone.find("#count").attr('id', 'count' + clone_id);
        clone.find("#delete").removeAttr("hidden");
        clone.find("#delete").attr("id","delete"+clone_id);
        clone.find("#delete").attr("value",clone_id);
        clone.appendTo("#recipe_property");
        clone_id = clone_id + 1;
    });
});


$(document).ready(function () {
    $("#add_for_edit_page").click(function () {
        var clone = $("[id^=clone_reagent]:last").clone();
        var lastId = clone.attr('id');
        var lastIdValue = lastId.replace('clone_reagent','');
        clone_id = Number(lastIdValue)+1;
        clone.attr('id', 'clone_reagent' + clone_id);
        clone.find("#cboReagents"+lastIdValue).attr('id', 'cboReagents' + clone_id)
        clone.find("#empty_option"+lastIdValue).attr('id', 'empty_option' + clone_id);//need fix
        clone.find("#empty_option"+clone_id).attr("selected", "selected");
        clone.find("#count"+lastIdValue).attr("value", "");
        clone.find("#count"+lastIdValue).attr('id', 'count' + clone_id);
        clone.find("#delete"+lastIdValue).removeAttr("hidden");
        clone.find("#delete"+lastIdValue).attr("id","delete"+clone_id);
        clone.find("#delete"+lastIdValue).attr("value",clone_id);
        clone.appendTo("#recipe_property");
    });
});

$(document).ready(function () {
    $('form').on('click','[id^=delete]',function () {
        var buttonId = $(this).attr('id');
        var selectedId = buttonId.replace('delete', '');
        $('#clone_reagent'+selectedId).remove();
    });
});

$(document).ready(function () {
    $('#add_recipe_form').submit(function (event) {
        event.preventDefault();
        var cboReagents = "#cboReagents";
        var count = "#count";
        for (var i = 1; i <= clone_id + 1; i++) {
            var keyForMap = $(cboReagents + " :selected").val();
            var valueForMap = $(count).val();
            $(count).attr('name', "reagentCountMap['" + keyForMap + "']");
            $(count).attr('value', valueForMap)
            count = "#count" + i;
            cboReagents = "#cboReagents" + i;
        }
        $(this).unbind('submit').submit();
    });
});

$(document).ready(function () {
    $('#edit_recipe_form').submit(function (event) {
        event.preventDefault();
        var clone = $("[id^=clone_reagent]:last").clone();
        var lastId = clone.attr('id');
        var lastIdValue = lastId.replace('clone_reagent','');
        clone_id = Number(lastIdValue)+1;
        var cboReagents = "#cboReagents";
        var count = "#count";
        for (var i = 0; i <= clone_id; i++) {
            count = "#count" + i;
            cboReagents = "#cboReagents" + i;
            var keyForMap = $(cboReagents + " :selected").val();
            var valueForMap = $(count).val();
            $(count).attr('name', "reagentCountMap['" + keyForMap + "']");
            $(count).attr('value', valueForMap)
        }
        $(this).unbind('submit').submit();
    });
});