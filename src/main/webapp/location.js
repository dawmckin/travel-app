function getLocations(e) {

    e.preventDefault();

    let countryName = document.querySelector("#inputCountryName").value;

    let xhr = new XMLHttpRequest();
    xhr.open("GET", `http://localhost:8080/TouristApp/locations?countryName=${countryName}`);
    xhr.onreadystatechange = function() {
        if(xhr.readyState === 4) {
            let locationList = JSON.parse(xhr.responseText);
            console.log(locationList);

            let table = document.querySelector("table");
            locationList.forEach(location => {
                table.insertAdjacentHTML("beforeend", `<tr>
                    <td>${location.locationId}</td>
                    <td>${location.locationName}</td>
                    <td>${location.cityName}</td>
                    <td>${location.address}</td>
                    <td>${location.country.countryName}</td>
                </tr>`)
            });


        }
    }
    xhr.send();
}


window.onload = function() {
    let form = document.querySelector("form");
    
    form.addEventListener("submit", getLocations);
}


