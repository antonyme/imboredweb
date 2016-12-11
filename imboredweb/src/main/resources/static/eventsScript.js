var map;
var markers;

function initMap() {
	map = new google.maps.Map(document.getElementById('map'), {
		center : {
			lat : 43.524360,
			lng : 5.445613
		},
		zoom : 13,
		mapTypeId : google.maps.MapTypeId.ROADMAP
	});
	$.get("events-info", createEventMarkers);
}

function createEventMarkers(data) {
	markers = new Array();
	var bounds = new google.maps.LatLngBounds();
	data.forEach(function(eventInfo) {
		if(!isMarked(eventInfo.lat, eventInfo.lng)) {
			// Create a marker for each event.
			var marker = new google.maps.Marker({
				map : map,
				title : eventInfo.title,
				position : {
					lat : eventInfo.lat,
					lng : eventInfo.lng
				}
			});
			bounds.extend(marker.position);
			google.maps.event.addListener(marker, 'click', function() {
				markerClicked(eventInfo);
			});
			markers.push(marker);
		}
	});
	map.fitBounds(bounds)
}

function markerClicked(eventInfo) {
	document.getElementById("detail").style.display="block";
	document.getElementById("title").innerHTML = eventInfo.title;
	document.getElementById("image").src = eventInfo.image;
	document.getElementById("placename").innerHTML = eventInfo.placeName;
	document.getElementById("description").innerHTML = eventInfo.description;
	document.getElementById("eventuid").value = eventInfo.eventUid;
}

function isMarked(lat, lng) {
	var result = false;
	markers.forEach(function(marker) {
		if(lat == marker.position.lat()) {
			result = true;
		}
	});
	return result;
}