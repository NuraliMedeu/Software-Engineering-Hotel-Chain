$(document).ready(function () {
  var inputs = document.getElementsByClassName("hided-input-2");
  $("#search-button").on("click", function (e) {
    e.preventDefault();
    var form = document.getElementById("search-form").elements;
    console.log("form = ", form);

    var formData = {};
    for (var i = 0; i < form.length; i++) {
      var item = form.item(i);
      formData[item.name] = item.value;
    }

    console.log("formdata = ", formData);
  });

  var destionationCities = document.querySelectorAll(
    ".destination-modal-body div"
  );

  var guestsAll = document.querySelectorAll(".guests-modal-body div");

  Array.from(destionationCities).forEach(function (item) {
    item.onclick = (e) => {
      document.getElementById("destination").value = e.target.textContent;
    };
  });

  Array.from(guestsAll).forEach(function (item) {
    item.onclick = (e) => {
      document.getElementById("guests").value = e.target.textContent;
    };
  });

  //   $.ajax({
  //     url: "http://localhost:8080/api/user/login",
  //     type: "GET",
  //     dataType: "json",
  //     contentType: "application/json",
  //     data: JSON.stringify(newFormData),
  //     success: function (res) {
  //       localStorage.setItem("user_data", JSON.stringify(res));
  //     },
  //   });
});
