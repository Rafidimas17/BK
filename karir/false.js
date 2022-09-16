let local = localStorage;
function tidak() {
  var new_data = document.getElementById("tidak").value;
  if (local.getItem("data_false") == null) {
    local.setItem("data_false", "[]");
  }

  var old_data = JSON.parse(local.getItem("data_false"));
  old_data.push(new_data);
  local.setItem("data_false", JSON.stringify(old_data));
}
