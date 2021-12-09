$(document).ready(function () {
  if (localStorage.getItem("search_results")) {
    var searchContainerForList = document.getElementById("search-container");
    var searchResults = JSON.parse(localStorage.getItem("search_results"));

    console.log("searchContainerForList = ", searchContainerForList);
    if (searchResults?.length > 0 && searchContainerForList)
      searchResults.forEach((item) => {
        let searchBox = `<div class="card my-3" style="border-radius: 8px !important; grid-column: 1; grid-row: 1"><div class="card-body" style="display: grid; grid-template-columns: 33% 50% 17%" > <img style="grid-column: 1; grid-row: 1/4; width: 90%" src="../../static/images/Одноместный номер СПА-отель Мелоот 1 1 (1).png" alt="Single room" /> <h2 style="grid-column: 2; grid-row: 1" class="card-title"> Name: ${item.name} </h2> <div style="grid-column: 2; grid-row: 2" class="card-text"> <p>Phone number:</p> <p>${item.phones[0]?.phone_number}</p> <p>Rooms:</p>`;
        for (let i = 0; i < item.rooms.length; i++) {
          searchBox += `<p>Room #${i + 1}, floor #${
            item.rooms[i].floor
          }, availability: ${item.rooms[i].availableNow}, cleaned: ${
            item.rooms[i].cleaned
          }</p>`;
        }
        searchBox +=
          '</div><button style="grid-column: 3; grid-row: 3; width: 150px" class="btn btn-secondary" data-toggle="modal" data-target="#orderModal">Order</button></div></div>';
        searchContainerForList.innerHTML = searchBox;
        var div = document.createElement("div");
        div.innerHTML = searchBox;
      });
  }

  $("#order-button").on("click", function (e) {
    $.ajax({
      url: "http://localhost:8080/api/hotel/search" + query,
      type: "POST",
      contentType: "application/json",
      success: function (res) {
        localStorage.setItem("search_results", JSON.stringify(res));
        window.location.replace(
          "http://localhost:8080/pages/search/search.html"
        );
      },
    });
  });

  $("#search-button").on("click", function (e) {
    e.preventDefault();
    var form = document.getElementById("search-form").elements;

    var formData = {};
    for (var i = 0; i < form.length; i++) {
      var item = form.item(i);
      formData[item.name] = item.value;
    }
    var query = `?city=${formData.destination}&capacity=${formData.guests}`;
    console.log("query = ", query);
    console.log("form = ", formData);
    localStorage.setItem("check_in", JSON.stringify(formData.check_in));
    localStorage.setItem("check_out", JSON.stringify(formData.check_out));

    $.ajax({
      url: "http://localhost:8080/api/hotel/search" + query,
      type: "GET",
      contentType: "application/json",
      success: function (res) {
        localStorage.setItem("search_results", JSON.stringify(res));
        window.location.replace(
          "http://localhost:8080/pages/search/search.html"
        );
      },
    });
  });

  var destionationCities = document.querySelectorAll(
    ".destination-modal-body div"
  );

  var guestsAll = document.querySelectorAll(".guests-modal-body div");

  console.log("destionationCities = ", destionationCities);
  Array.from(destionationCities).forEach(function (item) {
    item.onclick = (e) => {
      document.getElementById("destination").value = e.target.textContent;
    };
  });

  console.log("guestsAll = ", guestsAll);

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
