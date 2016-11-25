
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
	// Celula 1
	var polygon = L.polygon([
		[-22.915, -43.265],
		[-22.905, -43.265],
		[-22.905, -43.255],
		[-22.915, -43.255]
	], {color: '#3b0000'}).addTo(map);
	square.push(polygon);
	squareGroup.addLayer(polygon);
	// Celula 2
	var polygon = L.polygon([
		[-22.915, -43.255],
		[-22.905, -43.255],
		[-22.905, -43.245],
		[-22.915, -43.245]
	], {color: '#430000'}).addTo(map);
	square.push(polygon);
	squareGroup.addLayer(polygon);
	// Celula 3
	var polygon = L.polygon([
		[-22.915, -43.245],
		[-22.905, -43.245],
		[-22.905, -43.235],
		[-22.915, -43.235]
	], {color: '#5b0000'}).addTo(map);
	square.push(polygon);
	squareGroup.addLayer(polygon);
	// Celula 4
	var polygon = L.polygon([
		[-22.905, -43.265],
		[-22.895, -43.265],
		[-22.895, -43.255],
		[-22.905, -43.255]
	], {color: '#4f0000'}).addTo(map);
	square.push(polygon);
	squareGroup.addLayer(polygon);
	// Celula 5
	var polygon = L.polygon([
		[-22.905, -43.255],
		[-22.895, -43.255],
		[-22.895, -43.245],
		[-22.905, -43.245]
	], {color: '#4b0000'}).addTo(map);
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
	// Celula 8
	var polygon = L.polygon([
		[-22.895, -43.255],
		[-22.885, -43.255],
		[-22.885, -43.245],
		[-22.895, -43.245]
	], {color: '#3f0000'}).addTo(map);
	square.push(polygon);
	squareGroup.addLayer(polygon);
	// Celula 9
	var polygon = L.polygon([
		[-22.895, -43.245],
		[-22.885, -43.245],
		[-22.885, -43.235],
		[-22.895, -43.235]
	], {color: '#3b0000'}).addTo(map);
	square.push(polygon);
	squareGroup.addLayer(polygon);
}

function loadTaxi() {
	var taxi = L.marker([-22.91291027, -43.24364014]).addTo(map);
	srcTaxi.push(taxi);
	srcTaxiGroup.addLayer(taxi);
	var taxi = L.marker([-22.91365496, -43.23582479]).addTo(map);
	srcTaxi.push(taxi);
	srcTaxiGroup.addLayer(taxi);
	var taxi = L.marker([-22.91415142, -43.25199447]).addTo(map);
	srcTaxi.push(taxi);
	srcTaxiGroup.addLayer(taxi);
	var taxi = L.marker([-22.90149117, -43.25765385]).addTo(map);
	srcTaxi.push(taxi);
	srcTaxiGroup.addLayer(taxi);
	var taxi = L.marker([-22.90372542, -43.25846234]).addTo(map);
	srcTaxi.push(taxi);
	srcTaxiGroup.addLayer(taxi);
	var taxi = L.marker([-22.89503647, -43.26250476]).addTo(map);
	srcTaxi.push(taxi);
	srcTaxiGroup.addLayer(taxi);
	var taxi = L.marker([-22.90273242, -43.24364014]).addTo(map);
	srcTaxi.push(taxi);
	srcTaxiGroup.addLayer(taxi);
	var taxi = L.marker([-22.89553300, -43.23744176]).addTo(map);
	srcTaxi.push(taxi);
	srcTaxiGroup.addLayer(taxi);
	var taxi = L.marker([-22.91315850, -43.24983851]).addTo(map);
	srcTaxi.push(taxi);
	srcTaxiGroup.addLayer(taxi);
	var taxi = L.marker([-22.89528473, -43.23744176]).addTo(map);
	srcTaxi.push(taxi);
	srcTaxiGroup.addLayer(taxi);
	var taxi = L.marker([-22.90397366, -43.25954032]).addTo(map);
	srcTaxi.push(taxi);
	srcTaxiGroup.addLayer(taxi);
	var taxi = L.marker([-22.90074641, -43.25468941]).addTo(map);
	srcTaxi.push(taxi);
	srcTaxiGroup.addLayer(taxi);
	var taxi = L.marker([-22.88659525, -43.25118598]).addTo(map);
	srcTaxi.push(taxi);
	srcTaxiGroup.addLayer(taxi);
	var taxi = L.marker([-22.91017970, -43.24471811]).addTo(map);
	srcTaxi.push(taxi);
	srcTaxiGroup.addLayer(taxi);
	var taxi = L.marker([-22.91241381, -43.24121468]).addTo(map);
	srcTaxi.push(taxi);
	srcTaxiGroup.addLayer(taxi);
	var taxi = L.marker([-22.91489610, -43.24175367]).addTo(map);
	srcTaxi.push(taxi);
	srcTaxiGroup.addLayer(taxi);
	var taxi = L.marker([-22.90124292, -43.24876053]).addTo(map);
	srcTaxi.push(taxi);
	srcTaxiGroup.addLayer(taxi);
	var taxi = L.marker([-22.90422191, -43.26412172]).addTo(map);
	srcTaxi.push(taxi);
	srcTaxiGroup.addLayer(taxi);
	var taxi = L.marker([-22.91365496, -43.26412172]).addTo(map);
	srcTaxi.push(taxi);
	srcTaxiGroup.addLayer(taxi);
	var taxi = L.marker([-22.89081592, -43.24229266]).addTo(map);
	srcTaxi.push(taxi);
	srcTaxiGroup.addLayer(taxi);
	var taxi = L.marker([-22.90124292, -43.25415042]).addTo(map);
	srcTaxi.push(taxi);
	srcTaxiGroup.addLayer(taxi);
	var taxi = L.marker([-22.91191734, -43.23986721]).addTo(map);
	srcTaxi.push(taxi);
	srcTaxiGroup.addLayer(taxi);
	var taxi = L.marker([-22.90322892, -43.24687407]).addTo(map);
	srcTaxi.push(taxi);
	srcTaxiGroup.addLayer(taxi);
	var taxi = L.marker([-22.91291027, -43.24256216]).addTo(map);
	srcTaxi.push(taxi);
	srcTaxiGroup.addLayer(taxi);
	var taxi = L.marker([-22.91142088, -43.23905873]).addTo(map);
	srcTaxi.push(taxi);
	srcTaxiGroup.addLayer(taxi);
	var taxi = L.marker([-22.89453994, -43.25118598]).addTo(map);
	srcTaxi.push(taxi);
	srcTaxiGroup.addLayer(taxi);
	var taxi = L.marker([-22.89503647, -43.26304375]).addTo(map);
	srcTaxi.push(taxi);
	srcTaxiGroup.addLayer(taxi);
	var taxi = L.marker([-22.91365496, -43.23555530]).addTo(map);
	srcTaxi.push(taxi);
	srcTaxiGroup.addLayer(taxi);
	var taxi = L.marker([-22.90024991, -43.24552660]).addTo(map);
	srcTaxi.push(taxi);
	srcTaxiGroup.addLayer(taxi);
	var taxi = L.marker([-22.91464787, -43.25010801]).addTo(map);
	srcTaxi.push(taxi);
	srcTaxiGroup.addLayer(taxi);
}

function loadArrow() {
	var polygon = L.polygon([
		[-22.9085, -43.2605],
		[-22.9085, -43.2595],
		[-22.9075, -43.2595],
		[-22.9075, -43.2590],
		[-22.9065, -43.2600],
		[-22.9075, -43.2610],
		[-22.9075, -43.2605],
		[-22.9085, -43.2605],
	], {color: 'green'}).addTo(map);
	arrow.push(polygon);
	arrowGroup.addLayer(polygon);
	var polygon = L.polygon([
		[-22.90950000, -43.24850000],
		[-22.91050000, -43.24850000],
		[-22.91050000, -43.24750000],
		[-22.91100000, -43.24750000],
		[-22.91000000, -43.24650000],
		[-22.90900000, -43.24750000],
		[-22.90950000, -43.24750000],
		[-22.90950000, -43.24850000],
	], {color: 'green'}).addTo(map);
	arrow.push(polygon);
	arrowGroup.addLayer(polygon);
	var polygon = L.polygon([
		[-22.90070711, -43.24858579],
		[-22.90141421, -43.24929289],
		[-22.90212132, -43.24858579],
		[-22.90247487, -43.24893934],
		[-22.90247487, -43.24752513],
		[-22.90106066, -43.24752513],
		[-22.90141421, -43.24787868],
		[-22.90070711, -43.24858579],
	], {color: 'green'}).addTo(map);
	arrow.push(polygon);
	arrowGroup.addLayer(polygon);
	var polygon = L.polygon([
		[-22.90150000, -43.23950000],
		[-22.90150000, -43.24050000],
		[-22.90250000, -43.24050000],
		[-22.90250000, -43.24100000],
		[-22.90350000, -43.24000000],
		[-22.90250000, -43.23900000],
		[-22.90250000, -43.23950000],
		[-22.90150000, -43.23950000],
	], {color: 'green'}).addTo(map);
	arrow.push(polygon);
	arrowGroup.addLayer(polygon);
	var polygon = L.polygon([
		[-22.89141421, -43.25070711],
		[-22.89070711, -43.25141421],
		[-22.89141421, -43.25212132],
		[-22.89106066, -43.25247487],
		[-22.89247487, -43.25247487],
		[-22.89247487, -43.25106066],
		[-22.89212132, -43.25141421],
		[-22.89141421, -43.25070711],
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
	var circle = L.circle([-22.910, -43.250], {
		color: 'red',
		fillColor: 'red',
		fillOpacity: 0.5,
		radius: 100
	}).addTo(map)
		.bindPopup('UMax: 0.78571')
		.openPopup();
	circleUMax.push(circle);
	circleUMaxGroup.addLayer(circle);
	var circle = L.circle([-22.890, -43.240], {
		color: 'blue',
		fillColor: 'blue',
		fillOpacity: 0.5,
		radius: 100
	}).addTo(map)
		.bindPopup('UMin: -0.54911')
		.openPopup();
	circleUMin.push(circle);
	circleUMinGroup.addLayer(circle);
	var circle = L.circle([-22.890, -43.240], {
		color: 'orange',
		fillColor: 'orange',
		fillOpacity: 0.5,
		radius: 100
	}).addTo(map)
		.bindPopup('SMax: 0.53125')
		.openPopup();
	circleSMax.push(circle);
	circleSMaxGroup.addLayer(circle);
	var circle = L.circle([-22.900, -43.250], {
		color: 'yellow',
		fillColor: 'yellow',
		fillOpacity: 0.5,
		radius: 100
	}).addTo(map)
		.bindPopup('SMin: -0.6875')
		.openPopup();
	circleSMin.push(circle);
	circleSMinGroup.addLayer(circle);
}

