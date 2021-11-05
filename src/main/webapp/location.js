function getLocations(e) {

    e.preventDefault();

    let countryName = document.querySelector("#inputCountryName").value;

    let xhr = new XMLHttpRequest();
    xhr.open("GET", `http://localhost:8080/TouristApp/locations?countryName=${countryName}`);
    xhr.onreadystatechange = function() {
        if(xhr.readyState === 4) {
            let locationList = JSON.parse(xhr.responseText);
            console.log(locationList);
            appendTableData(locationList);
        }
    }
    xhr.send();
}

function appendTableData (locations) {
    let table = document.querySelector("table");
    table.innerHTML = "";

    let html = `<tr>
            <th>Location ID</th>
            <th>Location Name</th>
            <th>City Name</th>
            <th>Location Address</th>
            <th>Country</th>
        </tr>`;

    locations.forEach(location => {
        html += `<tr>
            <td>${location.locationId}</td>
            <td>${location.locationName}</td>
            <td>${location.cityName}</td>
            <td>${location.address}</td>
            <td>${location.country.countryName}</td>
        </tr>`
    });

    table.insertAdjacentHTML('beforeend', html);
} 


window.onload = function() {
    let form = document.querySelector("form");
    
    form.addEventListener("submit", getLocations);
}


