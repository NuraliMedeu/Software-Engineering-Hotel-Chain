$(document).ready(function () {
  $("#signup-btn").on("click", function (e) {
    e.preventDefault();
    var form = document.getElementById("signup-form");
    var elements = form.elements;
    var formData = {};
    for (var i = 0; i < elements.length; i++) {
      var item = elements.item(i);
      if (item.name === "agree") {
        formData[item.name] = item.checked;
        if (!item.checked) {
          form.reportValidity();
          return;
        }
      } else formData[item.name] = item.value;
    }

    if (formData.password !== formData.password_confirmation)
      return alert("Passwords must be the same");

    $.post(
      "http://localhost:8080/api/guest",
      {
        name: formData.name,
        surname: formData.surname,
        email: formData.email,
        password: formData.password,
        id_typeNum: formData.id_type,
        id_number: formData.id_number,
      },
      function (result) {
        console.log("res = ", result);
      }
    );
  });

  $("#signin-btn").on("click", function (e) {
    let select = document.getElementById("#select-user");

    e.preventDefault();
    var form = document.getElementById("signin-form");
    var elements = form.elements;
    var formData = {};
    for (var i = 0; i < elements.length; i++) {
      var item = elements.item(i);
      formData[item.name] = item.value;
    }

    $.post(
      "http://localhost:8080/api/guest",
      {
        email: formData.email,
        password: formData.password,
      },
      function (result) {
        console.log("res = ", result);
      }
    );

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

  const onSignup = (e) => {
    console.log("e = ", e.target);
  };
});
