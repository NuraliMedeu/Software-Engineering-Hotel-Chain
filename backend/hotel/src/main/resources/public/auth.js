$(document).ready(function () {
  $("#signup-btn").on("click", function (e) {
    e.preventDefault();
    var form = document.getElementById("signup-form");
    let select = document.getElementById("#select-user");

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

    const newFormData = {
      name: formData.name,
      surname: formData.surname,
      email: formData.email,
      password: formData.password,
      id_typeNum: formData.id_type,
      id_number: formData.id_number,
      user_type: {
        type: formData.user_type.toString().toLowerCase(),
      },
    };

    console.log("new form = ", JSON.stringify(newFormData));

    $.ajax({
      url: "http://localhost:8080/api/user",
      type: "POST",
      dataType: "json",
      contentType: "application/json",
      data: JSON.stringify(newFormData),
      success: function (res) {
        console.log("res = ", res);
        window.location.href = "../signin/signin.html";
      },
    });
  });

  $("#signin-btn").on("click", function (e) {
    e.preventDefault();
    var form = document.getElementById("signin-form");
    var elements = form.elements;
    var formData = {};
    for (var i = 0; i < elements.length; i++) {
      var item = elements.item(i);
      formData[item.name] = item.value;
    }

    const newFormData = {
      email: formData.email,
      password: formData.password,
    };

    console.log("new form = ", JSON.stringify(newFormData));

    $.ajax({
      url: "http://localhost:8080/api/user/login",
      type: "POST",
      dataType: "json",
      contentType: "application/json",
      data: JSON.stringify(newFormData),
      success: function (res) {
        localStorage.setItem("user_data", JSON.stringify(res));
        window.location.href = "../../index.html";
      },
    });
  });
});
