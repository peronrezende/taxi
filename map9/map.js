
function loadMap() {
	map = L.map('map').setView([-22.90, -43.25], 15);
	L.tileLayer('https://api.tiles.mapbox.com/v4/{id}/{z}/{x}/{y}.png?access_token=pk.eyJ1IjoibWFwYm94IiwiYSI6ImNpandmbXliNDBjZWd2M2x6bDk3c2ZtOTkifQ._QA7i5Mpkd_m30IGElHziw', {
		maxZoom: 18,
		attribution: 'Map data &copy; <a href="http://openstreetmap.org">OpenStreetMap</a> contributors, ' +
			'<a href="http://creativecommons.org/licenses/by-sa/2.0/">CC-BY-SA</a>, ' +
			'Imagery © <a href="http://mapbox.com">Mapbox</a>',
		id: 'mapbox.streets'
	}).addTo(map);
}

function loadSquare() {
	// Celula 4
	var polygon = L.polygon([
		[-22.905, -43.265],
		[-22.895, -43.265],
		[-22.895, -43.255],
		[-22.905, -43.255]
	], {color: '#3b0000'}).addTo(map);
	square.push(polygon);
	squareGroup.addLayer(polygon);
	// Celula 5
	var polygon = L.polygon([
		[-22.905, -43.255],
		[-22.895, -43.255],
		[-22.895, -43.245],
		[-22.905, -43.245]
	], {color: '#4f0000'}).addTo(map);
	square.push(polygon);
	squareGroup.addLayer(polygon);
	// Celula 6
	var polygon = L.polygon([
		[-22.905, -43.245],
		[-22.895, -43.245],
		[-22.895, -43.235],
		[-22.905, -43.235]
	], {color: '#430000'}).addTo(map);
	square.push(polygon);
	squareGroup.addLayer(polygon);
	// Celula 7
	var polygon = L.polygon([
		[-22.895, -43.265],
		[-22.885, -43.265],
		[-22.885, -43.255],
		[-22.895, -43.255]
	], {color: '#3b0000'}).addTo(map);
	square.push(polygon);
	squareGroup.addLayer(polygon);
	// Celula 9
	var polygon = L.polygon([
		[-22.895, -43.245],
		[-22.885, -43.245],
		[-22.885, -43.235],
		[-22.895, -43.235]
	], {color: '#430000'}).addTo(map);
	square.push(polygon);
	squareGroup.addLayer(polygon);
}

function loadTaxi() {
	var taxi = L.marker([-22.89578126, -43.25253346]).addTo(map);
	srcTaxi.push(taxi);
	srcTaxiGroup.addLayer(taxi);
	var taxi = L.marker([-22.89503647, -43.24013671]).addTo(map);
	srcTaxi.push(taxi);
	srcTaxiGroup.addLayer(taxi);
	var taxi = L.marker([-22.90298067, -43.24741306]).addTo(map);
	srcTaxi.push(taxi);
	srcTaxiGroup.addLayer(taxi);
	var taxi = L.marker([-22.90074641, -43.25468941]).addTo(map);
	srcTaxi.push(taxi);
	srcTaxiGroup.addLayer(taxi);
	var taxi = L.marker([-22.90298067, -43.25037750]).addTo(map);
	srcTaxi.push(taxi);
	srcTaxiGroup.addLayer(taxi);
	var taxi = L.marker([-22.90024991, -43.24417913]).addTo(map);
	srcTaxi.push(taxi);
	srcTaxiGroup.addLayer(taxi);
	var taxi = L.marker([-22.90198767, -43.24471811]).addTo(map);
	srcTaxi.push(taxi);
	srcTaxiGroup.addLayer(taxi);
	var taxi = L.marker([-22.89429168, -43.24202317]).addTo(map);
	srcTaxi.push(taxi);
	srcTaxiGroup.addLayer(taxi);
	var taxi = L.marker([-22.89007111, -43.24364014]).addTo(map);
	srcTaxi.push(taxi);
	srcTaxiGroup.addLayer(taxi);
	var taxi = L.marker([-22.90074641, -43.24687407]).addTo(map);
	srcTaxi.push(taxi);
	srcTaxiGroup.addLayer(taxi);
	var taxi = L.marker([-22.90322892, -43.25280295]).addTo(map);
	srcTaxi.push(taxi);
	srcTaxiGroup.addLayer(taxi);
	var taxi = L.marker([-22.90422191, -43.26385223]).addTo(map);
	srcTaxi.push(taxi);
	srcTaxiGroup.addLayer(taxi);
	var taxi = L.marker([-22.89329861, -43.23932822]).addTo(map);
	srcTaxi.push(taxi);
	srcTaxiGroup.addLayer(taxi);
	var taxi = L.marker([-22.89131247, -43.26196577]).addTo(map);
	srcTaxi.push(taxi);
	srcTaxiGroup.addLayer(taxi);
}

function loadArrow() {
	var polygon = L.polygon([
		[-22.89950000, -43.25850000],
		[-22.90050000, -43.25850000],
		[-22.90050000, -43.25750000],
		[-22.90100000, -43.25750000],
		[-22.90000000, -43.25650000],
		[-22.89900000, -43.25750000],
		[-22.89950000, -43.25750000],
		[-22.89950000, -43.25850000],
	], {color: 'green'}).addTo(map);
	arrow.push(polygon);
	arrowGroup.addLayer(polygon);
	var polygon = L.polygon([
		[-22.90050000, -43.24150000],
		[-22.89950000, -43.24150000],
		[-22.89950000, -43.24250000],
		[-22.89900000, -43.24250000],
		[-22.90000000, -43.24350000],
		[-22.90100000, -43.24250000],
		[-22.90050000, -43.24250000],
		[-22.90050000, -43.24150000],
	], {color: 'green'}).addTo(map);
	arrow.push(polygon);
	arrowGroup.addLayer(polygon);
	var polygon = L.polygon([
		[-22.89070711, -43.25858579],
		[-22.89141421, -43.25929289],
		[-22.89212132, -43.25858579],
		[-22.89247487, -43.25893934],
		[-22.89247487, -43.25752513],
		[-22.89106066, -43.25752513],
		[-22.89141421, -43.25787868],
		[-22.89070711, -43.25858579],
	], {color: 'green'}).addTo(map);
	arrow.push(polygon);
	arrowGroup.addLayer(polygon);
	var polygon = L.polygon([
		[-22.89141421, -43.24070711],
		[-22.89070711, -43.24141421],
		[-22.89141421, -43.24212132],
		[-22.89106066, -43.24247487],
		[-22.89247487, -43.24247487],
		[-22.89247487, -43.24106066],
		[-22.89212132, -43.24141421],
		[-22.89141421, -43.24070711],
	], {color: 'green'}).addTo(map);
	arrow.push(polygon);
	arrowGroup.addLayer(polygon);
}

function loadCircle() {
	var circle = L.circle([-22.900, -43.250], {
		color: 'red',
		fillColor: 'red',
		fillOpacity: 0.5,
		radius: 100
	}).addTo(map)
		.bindPopup('UMax: 1.25')
		.openPopup();
	circleUMax.push(circle);
	circleUMaxGroup.addLayer(circle);
	var circle = L.circle([-22.890, -43.240], {
		color: 'blue',
		fillColor: 'blue',
		fillOpacity: 0.5,
		radius: 100
	}).addTo(map)
		.bindPopup('UMin: -0.33929')
		.openPopup();
	circleUMin.push(circle);
	circleUMinGroup.addLayer(circle);
	var circle = L.circle([-22.890, -43.240], {
		color: 'orange',
		fillColor: 'orange',
		fillOpacity: 0.5,
		radius: 100
	}).addTo(map)
		.bindPopup('SMax: 0.53571')
		.openPopup();
	circleSMax.push(circle);
	circleSMaxGroup.addLayer(circle);
	var circle = L.circle([-22.910, -43.240], {
		color: 'yellow',
		fillColor: 'yellow',
		fillOpacity: 0.5,
		radius: 100
	}).addTo(map)
		.bindPopup('SMin: -0.25')
		.openPopup();
	circleSMin.push(circle);
	circleSMinGroup.addLayer(circle);
}

