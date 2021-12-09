$(document).ready(function () {
  if (localStorage.getItem("search_results")) {
    var searchBox = ```<div class="card my-3" style="border-radius: 8px !important; grid-column: 1; grid-row: 1">
    <div
      class="card-body"
      style="display: grid; grid-template-columns: 33% 50% 17%"
    >
      <img
        style="grid-column: 1; grid-row: 1/4; width: 90%"
        src="../../static/images/Одноместный номер СПА-отель Мелоот 1 1 (1).png"
        alt="Single room"
      />
      <h2 style="grid-column: 2; grid-row: 1" class="card-title">
        "Single", "Room number", "Floor"
      </h2>
      <p style="grid-column: 2; grid-row: 2" class="card-text">
        Other info, size, furniture, etc.
      </p>
      <button
        style="grid-column: 3; grid-row: 3; width: 150px"
        class="btn btn-secondary"
      >
        View
      </button>
    </div>
  </div>```;
  }
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

    //   $.ajax({
    //     url: "http://localhost:8080/api/search",
    //     type: "POST",
    //     dataType: "json",
    //     contentType: "application/json",
    //     data: JSON.stringify(newFormData),
    //     success: function (res) {
    //        localStorage.setItem('search_results', JSON.stringify(res));
    //        window.location.href = "pages/search/search.html";
    //
    //     },
    //   });
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
