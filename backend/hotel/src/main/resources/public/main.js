$(document).ready(function () {
  if (localStorage.getItem("user_data")) {
    var navbarUsername = document.getElementsByClassName("flex-center");
    let userData = JSON.parse(localStorage.getItem("user_data"));
    var username = document.getElementsByClassName("username");
    var usertype = document.getElementsByClassName("usertype");
    var userDataInProfile = document.getElementsByClassName("user-account");
    Array.from(username).forEach((item) => {
      item.textContent = userData?.name;
    });

    Array.from(usertype).forEach((item) => {
      item.textContent = userData?.user_type?.type.toString().toUpperCase();
    });
    Array.from(userDataInProfile).forEach((userFields) => {
      var divContent = ``;
      Object.keys(userData).forEach(function (key) {
        var val = "";
        if (key === "user_type") val = userData[key].type;
        else val = userData[key];
        divContent += `<div class="field"><span>${key
          .toString()
          .toUpperCase()}:</span><span>${val}</span></div>`;
      });
      userFields.innerHTML = divContent;
    });

    Array.from(navbarUsername).forEach((item) => {
      item.style.cursor = "pointer";
      var htmlEl = `<img src="../../static/images/user.png" alt="user" class="user-img-navbar" /><span style="color: white">${userData?.name}</span>`;
      item.innerHTML = htmlEl;
      item.onclick = (e) => {
        switch (userData?.user_type?.type) {
          case "guest":
            window.location.href = "pages/account/user-account.html";
            break;
          case "desk clerk":
            window.location.href = "pages/account/dc-account.html";
            break;
          case "manager":
            window.location.href = "pages/account/manager-account.html";
            break;
          default:
            break;
        }
      };
    });
  }

  $("#check-in input").datepicker({
    autoclose: true,
  });

  $("#check-in").on("show", function (e) {
    if (e.date) {
      $(this).data("stickyDate", e.date);
    } else {
      $(this).data("stickyDate", null);
    }
  });

  $("#check-in").on("hide", function (e) {
    var stickyDate = $(this).data("stickyDate");

    if (!e.date && stickyDate) {
      console.debug("restore stickyDate", stickyDate);
      $(this).datepicker("setDate", stickyDate);
      $(this).data("stickyDate", null);
    }
  });

  $("#check-out input").datepicker({
    autoclose: true,
  });

  $("#check-out").on("show", function (e) {
    if (e.date) {
      $(this).data("stickyDate", e.date);
    } else {
      $(this).data("stickyDate", null);
    }
  });

  $("#check-out").on("hide", function (e) {
    var stickyDate = $(this).data("stickyDate");

    if (!e.date && stickyDate) {
      console.debug("restore stickyDate", stickyDate);
      $(this).datepicker("setDate", stickyDate);
      $(this).data("stickyDate", null);
    }
  });
});
