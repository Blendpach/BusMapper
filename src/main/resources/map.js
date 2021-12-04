import polyline from "google-polyline";

let waypoints = [];
let map;
let service;


function initMap() {
  const directionsService = new window.google.maps.DirectionsService();
  const directionsRenderer = new window.google.maps.DirectionsRenderer();

  const mapOptions = {
    zoom: 10,
    center:  { lat: 6.823280515241895, lng: 79.87182369100309},
  };

  map = new google.maps.Map(document.getElementById("map"), mapOptions);

  const request = {
    origin: "Softlogic GLOMARK - Mount Lavinia",
    // destination: "Belek Kade Junction Bus Stop, A2, Dehiwala-Mount Lavinia",
    destination: new google.maps.LatLng(6.788674896885934, 79.88499887039595), 
    travelMode: "DRIVING",
  };

  directionsService.route(request, (result, status) => {
    if (status == "OK") {
      directionsRenderer.setDirections(result);
      waypoints = polyline.decode(result.routes[0].overview_polyline);
    }
    const PolygonCoords = PolygonPoints();
    const PolygonBound = new google.maps.Polygon({
    paths: PolygonCoords,
    strokeColor: "#FF0000",
    strokeOpacity: 0.8,
    strokeWeight: 2,
    fillColor: "#FF0000",
    fillOpacity: 0.35,
    });

    PolygonBound.setMap(map);

    service = new google.maps.places.PlacesService(map);
    for(let j = 0;j< waypoints.length;j+=40){
      service.nearbySearch({
        location: { lat:waypoints[j][0], lng:waypoints[j][1] },
        radius: '20000',
        type: ['restaurant']
      }, callback);

      function callback(results, status) {
        if (status == google.maps.places.PlacesServiceStatus.OK) {
          for (let i = 0; i < results.length; i++) {
            if(google.maps.geometry.poly.containsLocation(results[i].geometry.location,PolygonBound) == true) {
              new google.maps.Marker({
                position: results[i].geometry.location,
                map,
                title: "Hello World!"
              });
             }
          }
        }
      }
    }
  });
   directionsRenderer.setMap(map);
 
}


function PolygonPoints() {

  let polypoints = waypoints
  let PolyLength = polypoints.length;
 

  let UpperBound = [];
  let LowerBound = [];

  for (let j = 0; j <= PolyLength - 1; j++) {
    let NewPoints = PolygonArray(polypoints[j][0]);
    UpperBound.push({ lat: NewPoints[0], lng: polypoints[j][1] });
    LowerBound.push({ lat: NewPoints[1], lng: polypoints[j][1] });
  }
   let reversebound = LowerBound.reverse();
 
  let FullPoly = UpperBound.concat(reversebound);
 
  return FullPoly;
}

function PolygonArray(latitude) {
  const R = 6378137;
  const pi = 3.14;
  //distance in meters
  const upper_offset = 300;
  const lower_offset = -300;
 
  Lat_up = upper_offset / R;
  Lat_down = lower_offset / R;
  //OffsetPosition, decimal degrees
  lat_upper = latitude + (Lat_up * 180) / pi;
  lat_lower = latitude + (Lat_down * 180) / pi;

   return [lat_upper, lat_lower];
}

const script = document.createElement("script");

script.src = "https://maps.googleapis.com/maps/api/js?key=AIzaSyDP3V4_sogsaHcONLPS9d59Ccq_IQhDygQ&libraries=geometry,places&callback=initMap";

// script.src = "https://maps.googleapis.com/maps/api/js?key=&callback=initMap&libraries=places";

script.defer = true;
window.initMap = () => {
  initMap();
};
document.head.appendChild(script);
