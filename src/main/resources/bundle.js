(() => {
  function r(e, n, t) {
    function o(i, f) {
      if (!n[i]) {
        if (!e[i]) {
          var c = "function" == typeof require && require;
          if (!f && c) return c(i, !0);
          if (u) return u(i, !0);
          var a = new Error(`Cannot find module '${i}'`);
          throw ((a.code = "MODULE_NOT_FOUND"), a);
        }
        var p = (n[i] = { exports: {} });
        e[i][0].call(
          p.exports,
          (r) => {
            var n = e[i][1][r];
            return o(n || r);
          },
          p,
          p.exports,
          r,
          e,
          n,
          t
        );
      }
      return n[i].exports;
    }
    for (
      var u = "function" == typeof require && require, i = 0;
      i < t.length;
      i++
    )
      o(t[i]);
    return o;
  }
  return r;
})()(


  {
    1: [
      (require, module, exports) => {
        require("./map");
      },
      { "./map": 2 },
    ],
    2: [
      (require, module, exports) => {
        var polyline = require("google-polyline");

        let waypoints = [];
        let map;
        let service;

        function initMap() {
          var directionsService = new window.google.maps.DirectionsService();
          var directionsRenderer = new window.google.maps.DirectionsRenderer();

          var mapOptions = {
            zoom: 7,
            center: { lat: 6.823280515241895, lng: 79.87182369100309 },
          };

          map = new google.maps.Map(document.getElementById("map"), mapOptions);

          var request = {
            // origin: "Softlogic GLOMARK - Mount Lavinia",
            // destination: "Belek Kade Junction Bus Stop, A2, Dehiwala-Mount Lavinia",
            origin: new google.maps.LatLng(
              6.837444813747016,
              79.86660219828892
            ),
            destination: new google.maps.LatLng(
              6.788674896885934,
              79.88499887039595
            ),
            travelMode: "DRIVING",
          };

          directionsService.route(request, (result, status) => {
            if (status == "OK") {
              directionsRenderer.setDirections(result);
              waypoints = polyline.decode(result.routes[0].overview_polyline);
            }
            var PolygonCoords = PolygonPoints();
            var PolygonBound = new google.maps.Polygon({
              paths: PolygonCoords,
              strokeColor: "#FF0000",
              strokeOpacity: 0.8,
              strokeWeight: 2,
              fillColor: "#e74c3c",
              fillOpacity: 0.35,
            });

            PolygonBound.setMap(map);

            var myMarker1 = new google.maps.Marker({
              position: new google.maps.LatLng(
                6.825079430530723,
                79.86993538753862
              ),
              map,
              title: "Busmapper Point 1",
            });

            var myMarker2 = new google.maps.Marker({
              position: new google.maps.LatLng(
                6.828706067612937,
                79.87221939449927
              ),
              map,
              title: "Busmapper Point 2",
            });

            var myMarker3 = new google.maps.Marker({
              position: new google.maps.LatLng(
                6.8288339003096254,
                79.86930115131645
              ),
              map,
              title: "Busmapper Point 3",
            });

            if (
              google.maps.geometry.poly.isLocationOnEdge(
                myMarker1.position,
                new google.maps.Polyline(PolygonBound),
                0.001
              )
            ) {
              alert("Busmapper Point 1 near edge");
            } else {
              alert("Busmapper Point 1 NOT near edge");
            }

            if (
              google.maps.geometry.poly.isLocationOnEdge(
                myMarker2.position,
                new google.maps.Polyline(PolygonBound),
                0.001
              )
            ) {
              alert("Busmapper Point 2 near edge");
            } else {
              alert("Busmapper Point 2 NOT near edge");
            }

            if (
              google.maps.geometry.poly.isLocationOnEdge(
                myMarker3.position,
                new google.maps.Polyline(PolygonBound),
                0.001
              )
            ) {
              alert("Busmapper Point 3 near edge");
            } else {
              alert("Busmapper Point 3 NOT near edge");
            }

            // if (google.maps.geometry.poly.isLocationOnEdge(myMarker1.position, new google.maps.Polyline(
            //   {path:new Array(new google.maps.LatLng(6.814741909691731, 79.87878999973012),
            //   new google.maps.LatLng(6.837032529710086, 79.86665515574238))
            // }), 0.001)) {
            //   alert("test 1 near edge");
            //   } else {
            //       alert("test 1 NOT near edge");
            //   }

            service = new google.maps.places.PlacesService(map);
            for (let j = 0; j < waypoints.length; j += 40) {
              service.nearbySearch(
                {
                  location: { lat: waypoints[j][0], lng: waypoints[j][1] },
                  radius: "20000",
                  type: ["restaurant"],
                },
                callback
              );

              function callback(results, status) {
                if (status == google.maps.places.PlacesServiceStatus.OK) {
                  for (let i = 0; i < results.length; i++) {
                    if (
                      google.maps.geometry.poly.containsLocation(
                        results[i].geometry.location,
                        PolygonBound
                      ) == true
                    ) {
                      new google.maps.Marker({
                        position: results[i].geometry.location,
                        map,
                        title: "Hello World!",
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
          let polypoints = waypoints;
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
          var R = 6378137;
          var pi = 3.14;
          //distance in meters
          var upper_offset = 300;
          var lower_offset = -300;

          Lat_up = upper_offset / R;
          Lat_down = lower_offset / R;
          //OffsetPosition, decimal degrees
          lat_upper = latitude + (Lat_up * 180) / pi;
          lat_lower = latitude + (Lat_down * 180) / pi;

          return [lat_upper, lat_lower];
        }

        var script = document.createElement("script");
        script.src =
          "https://maps.googleapis.com/maps/api/js?key=AIzaSyDP3V4_sogsaHcONLPS9d59Ccq_IQhDygQ&libraries=geometry,places&callback=initMap";

        // script.src =
        // "https://maps.googleapis.com/maps/api/js?key=&callback=initMap&libraries=places";

        script.defer = true;
        window.initMap = () => {
          initMap();
        };
        document.head.appendChild(script);
      },
      { "google-polyline": 5 },
    ],
    3: [
      (require, module, exports) => {
        var PRECISION = 1e5;

        function decode(value) {
          var points = [];
          let lat = 0;
          let lon = 0;

          var values = decode.integers(value, (x, y) => {
            lat += x;
            lon += y;
            points.push([lat / PRECISION, lon / PRECISION]);
          });

          return points;
        }

        decode.sign = (value) => (value & 1 ? ~(value >>> 1) : value >>> 1);

        decode.integers = (value, callback) => {
          let values = 0;
          let x = 0;
          let y = 0;

          let byte = 0;
          let current = 0;
          let bits = 0;

          for (let i = 0; i < value.length; i++) {
            byte = value.charCodeAt(i) - 63;
            current = current | ((byte & 0x1f) << bits);
            bits = bits + 5;

            if (byte < 0x20) {
              if (++values & 1) {
                x = decode.sign(current);
              } else {
                y = decode.sign(current);
                callback(x, y);
              }
              current = 0;
              bits = 0;
            }
          }

          return values;
        };

        module.exports = decode;
      },
      {},
    ],
    4: [
      (require, module, exports) => {
        var PRECISION = 1e5;
        var CHARCODE_OFFSET = 63;
        var CHARMAP = {};

        for (let i = 0x20; i < 0x7f; i++) {
          CHARMAP[i] = String.fromCharCode(i);
        }

        function encode(points) {
          // px, py, x and y store rounded exponentiated versions of the values
          // they represent to compute the actual desired differences. This helps
          // with finer than 5 decimals floating point numbers.
          let px = 0;

          let py = 0;

          return reduce(points, (str, lat, lon) => {
            var x = Math.round(lat * 1e5);
            var y = Math.round(lon * 1e5);

            str += chars(sign(x - px)) + chars(sign(y - py));

            px = x;
            py = y;

            return str;
          });
        }

        function reduce(points, callback) {
          let point = null;

          let lat = 0;
          let lon = 0;
          let str = "";

          for (let i = 0; i < points.length; i++) {
            point = points[i];
            lat = point.lat || point.x || point[0];
            lon = point.lng || point.y || point[1];
            str = callback(str, lat, lon);
          }

          return str;
        }

        function sign(value) {
          return value < 0 ? ~(value << 1) : value << 1;
        }

        function charCode(value) {
          return ((value & 0x1f) | 0x20) + 63;
        }

        function chars(value) {
          let str = "";

          while (value >= 0x20) {
            str += CHARMAP[charCode(value)];
            value = value >> 5;
          }

          str += CHARMAP[value + 63];

          return str;
        }

        module.exports = encode;
      },
      {},
    ],
    5: [
      (require, module, exports) => {
        module.exports = {
          encode: require("./encode"),
          decode: require("./decode"),
        };
      },
      { "./decode": 3, "./encode": 4 },
    ],
  },
  {},
  [1]
);


function functionDemo3(message){  
  print("Hello this is in bundle.js " + message);  
  return "success in bundle.js"; 
}  

