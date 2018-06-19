$(document).ready(function () {
    $("#add_reagent_button").click(function () {
        var clone = $("[id^=clone_reagent_]:last").clone();
        var lastId = clone.attr("id");
        var lastIdValue = lastId.replace("clone_reagent_", "");
        var clone_id = Number(lastIdValue) + 1;
        clone.attr("id", "clone_reagent_" + clone_id);
        clone.find("#cbox_reagents_" + lastIdValue).attr("id", "cbox_reagents_" + clone_id);
        clone.find("#cbox_reagents_" + clone_id).find("option").removeAttr("selected");
        clone.find("#empty_option").attr("selected", "selected");
        clone.find("#count_" + lastIdValue).attr("id", "count_" + clone_id);
        clone.find("#count_" + clone_id + ":text").val("");
        clone.find("#delete_" + lastIdValue).removeAttr("hidden");
        clone.find("#delete_" + lastIdValue).attr("id", "delete_" + clone_id);
        clone.find("#delete_" + lastIdValue).attr("value", clone_id);
        clone.appendTo("#recipe_property");
    });
});

$(document).ready(function () {
    $("form").on("click", "[id^=delete_]", function () {
        var buttonId = $(this).attr("id");
        var selectedId = buttonId.replace("delete_", '');
        $("#clone_reagent_" + selectedId).remove();
    });
});

$(document).ready(function () {
    $("#recipe_form").submit(function (event) {
        event.preventDefault();
        var stopsubmit = false;
        $("[id^=count_]").each(function () {
            $(this).attr("name", "none");
        })
        var clone = $("[id^=clone_reagent_]:last").clone();
        var lastId = clone.attr("id");
        var lastIdValue = lastId.replace("clone_reagent_", "");
        var clone_id = Number(lastIdValue) + 1;
        var cboxReagents = "#cbox_reagents_";
        var count = "#count_";
        for (var i = 0; i < clone_id; i++) {
            count = "#count_" + i;
            cboxReagents = "#cbox_reagents_" + i;
            var keyForMap = $(cboxReagents + " :selected").val();
            var valueForMap = $(count).val();
            if (keyForMap == "") {
                alert("Set all reagents to recipe!");
                return false;
            }
            if (!$.isNumeric(valueForMap)) {
                alert("Set numerical count values: " + valueForMap);
                return false;
            }
            $("[id^=count_]").each(function () {
                if ($(this).attr("name") != undefined && $(this).attr("name") == ("reagentCountMap['" + keyForMap + "']")) {
                    alert("Recipe must not contain equals reagents: " + keyForMap + " !");
                    stopsubmit = true;
                }
            })
            if(stopsubmit) {
                return false;
            }
            $(count).attr("name", "reagentCountMap['" + keyForMap + "']");
            $(count).attr("value", valueForMap);
        }
        $(this).unbind("submit").submit();
    });
});