$(document).ready(function () {
  $("#signin-btn").on("click", function (e) {
    let select = document.getElementById("#select-user");
    switch (select.value) {
      case "User":
        window.location.href = "../account/user-account.html";
        break;
      case "Desk clerk":
        window.location.href = "../account/dc-account.html";
        break;
      case "Manager":
        window.location.href = "../account/manager-account.html";
        break;
      default:
        break;
    }
  });
});
