
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
	], {color: '#470000'}).addTo(map);
	square.push(polygon);
	squareGroup.addLayer(polygon);
	// Celula 2
	var polygon = L.polygon([
		[-22.915, -43.255],
		[-22.905, -43.255],
		[-22.905, -43.245],
		[-22.915, -43.245]
	], {color: '#470000'}).addTo(map);
	square.push(polygon);
	squareGroup.addLayer(polygon);
	// Celula 3
	var polygon = L.polygon([
		[-22.915, -43.245],
		[-22.905, -43.245],
		[-22.905, -43.235],
		[-22.915, -43.235]
	], {color: '#730000'}).addTo(map);
	square.push(polygon);
	squareGroup.addLayer(polygon);
	// Celula 4
	var polygon = L.polygon([
		[-22.905, -43.265],
		[-22.895, -43.265],
		[-22.895, -43.255],
		[-22.905, -43.255]
	], {color: '#470000'}).addTo(map);
	square.push(polygon);
	squareGroup.addLayer(polygon);
	// Celula 5
	var polygon = L.polygon([
		[-22.905, -43.255],
		[-22.895, -43.255],
		[-22.895, -43.245],
		[-22.905, -43.245]
	], {color: '#470000'}).addTo(map);
	square.push(polygon);
	squareGroup.addLayer(polygon);
	// Celula 6
	var polygon = L.polygon([
		[-22.905, -43.245],
		[-22.895, -43.245],
		[-22.895, -43.235],
		[-22.905, -43.235]
	], {color: '#4f0000'}).addTo(map);
	square.push(polygon);
	squareGroup.addLayer(polygon);
	// Celula 9
	var polygon = L.polygon([
		[-22.895, -43.245],
		[-22.885, -43.245],
		[-22.885, -43.235],
		[-22.895, -43.235]
	], {color: '#3f0000'}).addTo(map);
	square.push(polygon);
	squareGroup.addLayer(polygon);
}

function loadTaxi() {
	var taxi = L.marker([-22.90968323, -43.23690277]).addTo(map);
	srcTaxi.push(taxi);
	srcTaxiGroup.addLayer(taxi);
	var taxi = L.marker([-22.90422191, -43.24498761]).addTo(map);
	srcTaxi.push(taxi);
	srcTaxiGroup.addLayer(taxi);
	var taxi = L.marker([-22.89900863, -43.24390963]).addTo(map);
	srcTaxi.push(taxi);
	srcTaxiGroup.addLayer(taxi);
	var taxi = L.marker([-22.90074641, -43.25468941]).addTo(map);
	srcTaxi.push(taxi);
	srcTaxiGroup.addLayer(taxi);
	var taxi = L.marker([-22.91315850, -43.24983851]).addTo(map);
	srcTaxi.push(taxi);
	srcTaxiGroup.addLayer(taxi);
	var taxi = L.marker([-22.91489610, -43.24013671]).addTo(map);
	srcTaxi.push(taxi);
	srcTaxiGroup.addLayer(taxi);
	var taxi = L.marker([-22.89106420, -43.23501631]).addTo(map);
	srcTaxi.push(taxi);
	srcTaxiGroup.addLayer(taxi);
	var taxi = L.marker([-22.89553300, -43.23744176]).addTo(map);
	srcTaxi.push(taxi);
	srcTaxiGroup.addLayer(taxi);
	var taxi = L.marker([-22.90844204, -43.23582479]).addTo(map);
	srcTaxi.push(taxi);
	srcTaxiGroup.addLayer(taxi);
	var taxi = L.marker([-22.90819380, -43.23878923]).addTo(map);
	srcTaxi.push(taxi);
	srcTaxiGroup.addLayer(taxi);
	var taxi = L.marker([-22.89528473, -43.23744176]).addTo(map);
	srcTaxi.push(taxi);
	srcTaxiGroup.addLayer(taxi);
	var taxi = L.marker([-22.91166911, -43.23636378]).addTo(map);
	srcTaxi.push(taxi);
	srcTaxiGroup.addLayer(taxi);
	var taxi = L.marker([-22.90496665, -43.24013671]).addTo(map);
	srcTaxi.push(taxi);
	srcTaxiGroup.addLayer(taxi);
	var taxi = L.marker([-22.90819380, -43.23878923]).addTo(map);
	srcTaxi.push(taxi);
	srcTaxiGroup.addLayer(taxi);
	var taxi = L.marker([-22.91092441, -43.23771126]).addTo(map);
	srcTaxi.push(taxi);
	srcTaxiGroup.addLayer(taxi);
	var taxi = L.marker([-22.90397366, -43.26196577]).addTo(map);
	srcTaxi.push(taxi);
	srcTaxiGroup.addLayer(taxi);
	var taxi = L.marker([-22.90298067, -43.25091649]).addTo(map);
	srcTaxi.push(taxi);
	srcTaxiGroup.addLayer(taxi);
	var taxi = L.marker([-22.91291027, -43.24633508]).addTo(map);
	srcTaxi.push(taxi);
	srcTaxiGroup.addLayer(taxi);
	var taxi = L.marker([-22.91489610, -43.26412172]).addTo(map);
	srcTaxi.push(taxi);
	srcTaxiGroup.addLayer(taxi);
	var taxi = L.marker([-22.91117264, -43.23798075]).addTo(map);
	srcTaxi.push(taxi);
	srcTaxiGroup.addLayer(taxi);
	var taxi = L.marker([-22.90993147, -43.23825024]).addTo(map);
	srcTaxi.push(taxi);
	srcTaxiGroup.addLayer(taxi);
	var taxi = L.marker([-22.90670436, -43.23878923]).addTo(map);
	srcTaxi.push(taxi);
	srcTaxiGroup.addLayer(taxi);
	var taxi = L.marker([-22.88585041, -43.23501631]).addTo(map);
	srcTaxi.push(taxi);
	srcTaxiGroup.addLayer(taxi);
	var taxi = L.marker([-22.90844204, -43.23825024]).addTo(map);
	srcTaxi.push(taxi);
	srcTaxiGroup.addLayer(taxi);
	var taxi = L.marker([-22.91390319, -43.25199447]).addTo(map);
	srcTaxi.push(taxi);
	srcTaxiGroup.addLayer(taxi);
	var taxi = L.marker([-22.90173942, -43.24687407]).addTo(map);
	srcTaxi.push(taxi);
	srcTaxiGroup.addLayer(taxi);
	var taxi = L.marker([-22.91390319, -43.26385223]).addTo(map);
	srcTaxi.push(taxi);
	srcTaxiGroup.addLayer(taxi);
	var taxi = L.marker([-22.90422191, -43.26358274]).addTo(map);
	srcTaxi.push(taxi);
	srcTaxiGroup.addLayer(taxi);
	var taxi = L.marker([-22.90844204, -43.23878923]).addTo(map);
	srcTaxi.push(taxi);
	srcTaxiGroup.addLayer(taxi);
	var taxi = L.marker([-22.90844204, -43.23878923]).addTo(map);
	srcTaxi.push(taxi);
	srcTaxiGroup.addLayer(taxi);
	var taxi = L.marker([-22.91166911, -43.24175367]).addTo(map);
	srcTaxi.push(taxi);
	srcTaxiGroup.addLayer(taxi);
	var taxi = L.marker([-22.91390319, -43.25199447]).addTo(map);
	srcTaxi.push(taxi);
	srcTaxiGroup.addLayer(taxi);
	var taxi = L.marker([-22.90422191, -43.26223526]).addTo(map);
	srcTaxi.push(taxi);
	srcTaxiGroup.addLayer(taxi);
	var taxi = L.marker([-22.90049816, -43.24579609]).addTo(map);
	srcTaxi.push(taxi);
	srcTaxiGroup.addLayer(taxi);
	var taxi = L.marker([-22.89727082, -43.23878923]).addTo(map);
	srcTaxi.push(taxi);
	srcTaxiGroup.addLayer(taxi);
	var taxi = L.marker([-22.90372542, -43.25684537]).addTo(map);
	srcTaxi.push(taxi);
	srcTaxiGroup.addLayer(taxi);
	var taxi = L.marker([-22.91415142, -43.26385223]).addTo(map);
	srcTaxi.push(taxi);
	srcTaxiGroup.addLayer(taxi);
	var taxi = L.marker([-22.91415142, -43.26385223]).addTo(map);
	srcTaxi.push(taxi);
	srcTaxiGroup.addLayer(taxi);
	var taxi = L.marker([-22.91415142, -43.23717227]).addTo(map);
	srcTaxi.push(taxi);
	srcTaxiGroup.addLayer(taxi);
}

function loadArrow() {
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
		[-22.90150000, -43.25950000],
		[-22.90150000, -43.26050000],
		[-22.90250000, -43.26050000],
		[-22.90250000, -43.26100000],
		[-22.90350000, -43.26000000],
		[-22.90250000, -43.25900000],
		[-22.90250000, -43.25950000],
		[-22.90150000, -43.25950000],
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
		[-22.89150000, -43.23950000],
		[-22.89150000, -43.24050000],
		[-22.89250000, -43.24050000],
		[-22.89250000, -43.24100000],
		[-22.89350000, -43.24000000],
		[-22.89250000, -43.23900000],
		[-22.89250000, -43.23950000],
		[-22.89150000, -43.23950000],
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
		.bindPopup('UMax: 0.74107')
		.openPopup();
	circleUMax.push(circle);
	circleUMaxGroup.addLayer(circle);
	var circle = L.circle([-22.890, -43.260], {
		color: 'blue',
		fillColor: 'blue',
		fillOpacity: 0.5,
		radius: 100
	}).addTo(map)
		.bindPopup('UMin: -0.59821')
		.openPopup();
	circleUMin.push(circle);
	circleUMinGroup.addLayer(circle);
	var circle = L.circle([-22.900, -43.240], {
		color: 'orange',
		fillColor: 'orange',
		fillOpacity: 0.5,
		radius: 100
	}).addTo(map)
		.bindPopup('SMax: 0.36607')
		.openPopup();
	circleSMax.push(circle);
	circleSMaxGroup.addLayer(circle);
	var circle = L.circle([-22.890, -43.250], {
		color: 'yellow',
		fillColor: 'yellow',
		fillOpacity: 0.5,
		radius: 100
	}).addTo(map)
		.bindPopup('SMin: -0.16964')
		.openPopup();
	circleSMin.push(circle);
	circleSMinGroup.addLayer(circle);
}

