
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
	], {color: '#3f0000'});
	polygon.addTo(map);
	square.matriz.push(polygon);
	square.group.addLayer(polygon);
	// Celula 2
	var polygon = L.polygon([
		[-22.915, -43.255],
		[-22.905, -43.255],
		[-22.905, -43.245],
		[-22.915, -43.245]
	], {color: '#3b0000'});
	polygon.addTo(map);
	square.matriz.push(polygon);
	square.group.addLayer(polygon);
	// Celula 3
	var polygon = L.polygon([
		[-22.915, -43.245],
		[-22.905, -43.245],
		[-22.905, -43.235],
		[-22.915, -43.235]
	], {color: '#570000'});
	polygon.addTo(map);
	square.matriz.push(polygon);
	square.group.addLayer(polygon);
	// Celula 4
	var polygon = L.polygon([
		[-22.905, -43.265],
		[-22.895, -43.265],
		[-22.895, -43.255],
		[-22.905, -43.255]
	], {color: '#3f0000'});
	polygon.addTo(map);
	square.matriz.push(polygon);
	square.group.addLayer(polygon);
	// Celula 5
	var polygon = L.polygon([
		[-22.905, -43.255],
		[-22.895, -43.255],
		[-22.895, -43.245],
		[-22.905, -43.245]
	], {color: '#430000'});
	polygon.addTo(map);
	square.matriz.push(polygon);
	square.group.addLayer(polygon);
	// Celula 6
	var polygon = L.polygon([
		[-22.905, -43.245],
		[-22.895, -43.245],
		[-22.895, -43.235],
		[-22.905, -43.235]
	], {color: '#4f0000'});
	polygon.addTo(map);
	square.matriz.push(polygon);
	square.group.addLayer(polygon);
	// Celula 9
	var polygon = L.polygon([
		[-22.895, -43.245],
		[-22.885, -43.245],
		[-22.885, -43.235],
		[-22.895, -43.235]
	], {color: '#3b0000'});
	polygon.addTo(map);
	square.matriz.push(polygon);
	square.group.addLayer(polygon);
}

function loadTaxi() {
	var taxi = L.marker([-22.89702256, -43.24929952], {icon: srcIcon});
	taxi.addTo(map);
	srcTaxi.matriz.push(taxi);
	srcTaxi.group.addLayer(taxi);
	var taxi = L.marker([-22.90322892, -43.26007931], {icon: srcIcon});
	taxi.addTo(map);
	srcTaxi.matriz.push(taxi);
	srcTaxi.group.addLayer(taxi);
	var taxi = L.marker([-22.89478821, -43.26169627], {icon: srcIcon});
	taxi.addTo(map);
	srcTaxi.matriz.push(taxi);
	srcTaxi.group.addLayer(taxi);
	var taxi = L.marker([-22.89478821, -43.26169627], {icon: srcIcon});
	taxi.addTo(map);
	srcTaxi.matriz.push(taxi);
	srcTaxi.group.addLayer(taxi);
	var taxi = L.marker([-22.89503647, -43.26223526], {icon: srcIcon});
	taxi.addTo(map);
	srcTaxi.matriz.push(taxi);
	srcTaxi.group.addLayer(taxi);
	var taxi = L.marker([-22.90819380, -43.23878923], {icon: srcIcon});
	taxi.addTo(map);
	srcTaxi.matriz.push(taxi);
	srcTaxi.group.addLayer(taxi);
	var taxi = L.marker([-22.89851212, -43.24364014], {icon: srcIcon});
	taxi.addTo(map);
	srcTaxi.matriz.push(taxi);
	srcTaxi.group.addLayer(taxi);
	var taxi = L.marker([-22.90074641, -43.25468941], {icon: srcIcon});
	taxi.addTo(map);
	srcTaxi.matriz.push(taxi);
	srcTaxi.group.addLayer(taxi);
	var taxi = L.marker([-22.89602952, -43.25253346], {icon: srcIcon});
	taxi.addTo(map);
	srcTaxi.matriz.push(taxi);
	srcTaxi.group.addLayer(taxi);
	var taxi = L.marker([-22.90322892, -43.24687407], {icon: srcIcon});
	taxi.addTo(map);
	srcTaxi.matriz.push(taxi);
	srcTaxi.group.addLayer(taxi);
	var taxi = L.marker([-22.91464787, -43.24040620], {icon: srcIcon});
	taxi.addTo(map);
	srcTaxi.matriz.push(taxi);
	srcTaxi.group.addLayer(taxi);
	var taxi = L.marker([-22.89503647, -43.23986721], {icon: srcIcon});
	taxi.addTo(map);
	srcTaxi.matriz.push(taxi);
	srcTaxi.group.addLayer(taxi);
	var taxi = L.marker([-22.91266204, -43.24121468], {icon: srcIcon});
	taxi.addTo(map);
	srcTaxi.matriz.push(taxi);
	srcTaxi.group.addLayer(taxi);
	var taxi = L.marker([-22.90521489, -43.24040620], {icon: srcIcon});
	taxi.addTo(map);
	srcTaxi.matriz.push(taxi);
	srcTaxi.group.addLayer(taxi);
	var taxi = L.marker([-22.89851212, -43.24337064], {icon: srcIcon});
	taxi.addTo(map);
	srcTaxi.matriz.push(taxi);
	srcTaxi.group.addLayer(taxi);
	var taxi = L.marker([-22.89602952, -43.24067570], {icon: srcIcon});
	taxi.addTo(map);
	srcTaxi.matriz.push(taxi);
	srcTaxi.group.addLayer(taxi);
	var taxi = L.marker([-22.88982284, -43.24687407], {icon: srcIcon});
	taxi.addTo(map);
	srcTaxi.matriz.push(taxi);
	srcTaxi.group.addLayer(taxi);
	var taxi = L.marker([-22.91315850, -43.24903003], {icon: srcIcon});
	taxi.addTo(map);
	srcTaxi.matriz.push(taxi);
	srcTaxi.group.addLayer(taxi);
	var taxi = L.marker([-22.89528473, -43.23744176], {icon: srcIcon});
	taxi.addTo(map);
	srcTaxi.matriz.push(taxi);
	srcTaxi.group.addLayer(taxi);
	var taxi = L.marker([-22.89156074, -43.24067570], {icon: srcIcon});
	taxi.addTo(map);
	srcTaxi.matriz.push(taxi);
	srcTaxi.group.addLayer(taxi);
	var taxi = L.marker([-22.90149117, -43.25064700], {icon: srcIcon});
	taxi.addTo(map);
	srcTaxi.matriz.push(taxi);
	srcTaxi.group.addLayer(taxi);
	var taxi = L.marker([-22.91166911, -43.23959772], {icon: srcIcon});
	taxi.addTo(map);
	srcTaxi.matriz.push(taxi);
	srcTaxi.group.addLayer(taxi);
	var taxi = L.marker([-22.91241381, -43.23501631], {icon: srcIcon});
	taxi.addTo(map);
	srcTaxi.matriz.push(taxi);
	srcTaxi.group.addLayer(taxi);
	var taxi = L.marker([-22.89950514, -43.24417913], {icon: srcIcon});
	taxi.addTo(map);
	srcTaxi.matriz.push(taxi);
	srcTaxi.group.addLayer(taxi);
	var taxi = L.marker([-22.90397366, -43.24525710], {icon: srcIcon});
	taxi.addTo(map);
	srcTaxi.matriz.push(taxi);
	srcTaxi.group.addLayer(taxi);
	var taxi = L.marker([-22.89602952, -43.24040620], {icon: srcIcon});
	taxi.addTo(map);
	srcTaxi.matriz.push(taxi);
	srcTaxi.group.addLayer(taxi);
	var taxi = L.marker([-22.90347717, -43.25603689], {icon: srcIcon});
	taxi.addTo(map);
	srcTaxi.matriz.push(taxi);
	srcTaxi.group.addLayer(taxi);
	var taxi = L.marker([-22.91092441, -43.23825024], {icon: srcIcon});
	taxi.addTo(map);
	srcTaxi.matriz.push(taxi);
	srcTaxi.group.addLayer(taxi);
	var taxi = L.marker([-22.90993147, -43.24067570], {icon: srcIcon});
	taxi.addTo(map);
	srcTaxi.matriz.push(taxi);
	srcTaxi.group.addLayer(taxi);
	var taxi = L.marker([-22.90471840, -43.25495891], {icon: srcIcon});
	taxi.addTo(map);
	srcTaxi.matriz.push(taxi);
	srcTaxi.group.addLayer(taxi);
	var taxi = L.marker([-22.90298067, -43.25010801], {icon: srcIcon});
	taxi.addTo(map);
	srcTaxi.matriz.push(taxi);
	srcTaxi.group.addLayer(taxi);
	var taxi = L.marker([-22.90422191, -43.25980981], {icon: srcIcon});
	taxi.addTo(map);
	srcTaxi.matriz.push(taxi);
	srcTaxi.group.addLayer(taxi);
	var taxi = L.marker([-22.89553300, -43.23771126], {icon: srcIcon});
	taxi.addTo(map);
	srcTaxi.matriz.push(taxi);
	srcTaxi.group.addLayer(taxi);
	var taxi = L.marker([-22.90347717, -43.24552660], {icon: srcIcon});
	taxi.addTo(map);
	srcTaxi.matriz.push(taxi);
	srcTaxi.group.addLayer(taxi);
	var taxi = L.marker([-22.91390319, -43.23663328], {icon: srcIcon});
	taxi.addTo(map);
	srcTaxi.matriz.push(taxi);
	srcTaxi.group.addLayer(taxi);
	var taxi = L.marker([-22.91315850, -43.24633508], {icon: srcIcon});
	taxi.addTo(map);
	srcTaxi.matriz.push(taxi);
	srcTaxi.group.addLayer(taxi);
	var taxi = L.marker([-22.90024991, -43.25226396], {icon: srcIcon});
	taxi.addTo(map);
	srcTaxi.matriz.push(taxi);
	srcTaxi.group.addLayer(taxi);
	var taxi = L.marker([-22.90049816, -43.26007931], {icon: srcIcon});
	taxi.addTo(map);
	srcTaxi.matriz.push(taxi);
	srcTaxi.group.addLayer(taxi);
	var taxi = L.marker([-22.91340673, -43.23501631], {icon: srcIcon});
	taxi.addTo(map);
	srcTaxi.matriz.push(taxi);
	srcTaxi.group.addLayer(taxi);
	var taxi = L.marker([-22.89702256, -43.24929952]);
	taxi.addTo(map);
	dstTaxi.matriz.push(taxi);
	dstTaxi.group.addLayer(taxi);
	var taxi = L.marker([-22.91241381, -43.23636378]);
	taxi.addTo(map);
	dstTaxi.matriz.push(taxi);
	dstTaxi.group.addLayer(taxi);
	var taxi = L.marker([-22.90372542, -43.25873183]);
	taxi.addTo(map);
	dstTaxi.matriz.push(taxi);
	dstTaxi.group.addLayer(taxi);
	var taxi = L.marker([-22.90571138, -43.24121468]);
	taxi.addTo(map);
	dstTaxi.matriz.push(taxi);
	dstTaxi.group.addLayer(taxi);
	var taxi = L.marker([-22.90074641, -43.25468941]);
	taxi.addTo(map);
	dstTaxi.matriz.push(taxi);
	dstTaxi.group.addLayer(taxi);
	var taxi = L.marker([-22.89528473, -43.23744176]);
	taxi.addTo(map);
	dstTaxi.matriz.push(taxi);
	dstTaxi.group.addLayer(taxi);
	var taxi = L.marker([-22.91291027, -43.24849104]);
	taxi.addTo(map);
	dstTaxi.matriz.push(taxi);
	dstTaxi.group.addLayer(taxi);
	var taxi = L.marker([-22.91390319, -43.24444862]);
	taxi.addTo(map);
	dstTaxi.matriz.push(taxi);
	dstTaxi.group.addLayer(taxi);
	var taxi = L.marker([-22.90844204, -43.23878923]);
	taxi.addTo(map);
	dstTaxi.matriz.push(taxi);
	dstTaxi.group.addLayer(taxi);
	var taxi = L.marker([-22.90471840, -43.24364014]);
	taxi.addTo(map);
	dstTaxi.matriz.push(taxi);
	dstTaxi.group.addLayer(taxi);
	var taxi = L.marker([-22.90000165, -43.25010801]);
	taxi.addTo(map);
	dstTaxi.matriz.push(taxi);
	dstTaxi.group.addLayer(taxi);
	var taxi = L.marker([-22.91365496, -43.26385223]);
	taxi.addTo(map);
	dstTaxi.matriz.push(taxi);
	dstTaxi.group.addLayer(taxi);
	var taxi = L.marker([-22.91266204, -43.26250476]);
	taxi.addTo(map);
	dstTaxi.matriz.push(taxi);
	dstTaxi.group.addLayer(taxi);
	var taxi = L.marker([-22.88982284, -43.24337064]);
	taxi.addTo(map);
	dstTaxi.matriz.push(taxi);
	dstTaxi.group.addLayer(taxi);
	var taxi = L.marker([-22.90248417, -43.24390963]);
	taxi.addTo(map);
	dstTaxi.matriz.push(taxi);
	dstTaxi.group.addLayer(taxi);
	var taxi = L.marker([-22.90546314, -43.24148418]);
	taxi.addTo(map);
	dstTaxi.matriz.push(taxi);
	dstTaxi.group.addLayer(taxi);
	var taxi = L.marker([-22.90248417, -43.25900133]);
	taxi.addTo(map);
	dstTaxi.matriz.push(taxi);
	dstTaxi.group.addLayer(taxi);
	var taxi = L.marker([-22.90869028, -43.23878923]);
	taxi.addTo(map);
	dstTaxi.matriz.push(taxi);
	dstTaxi.group.addLayer(taxi);
	var taxi = L.marker([-22.90447016, -43.24471811]);
	taxi.addTo(map);
	dstTaxi.matriz.push(taxi);
	dstTaxi.group.addLayer(taxi);
	var taxi = L.marker([-22.90149117, -43.24471811]);
	taxi.addTo(map);
	dstTaxi.matriz.push(taxi);
	dstTaxi.group.addLayer(taxi);
	var taxi = L.marker([-22.91241381, -43.24094519]);
	taxi.addTo(map);
	dstTaxi.matriz.push(taxi);
	dstTaxi.group.addLayer(taxi);
	var taxi = L.marker([-22.89553300, -43.23798075]);
	taxi.addTo(map);
	dstTaxi.matriz.push(taxi);
	dstTaxi.group.addLayer(taxi);
	var taxi = L.marker([-22.90943499, -43.23825024]);
	taxi.addTo(map);
	dstTaxi.matriz.push(taxi);
	dstTaxi.group.addLayer(taxi);
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
	], {color: 'green'});
	polygon.addTo(map);
	arrow.matriz.push(polygon);
	arrow.group.addLayer(polygon);
	var polygon = L.polygon([
		[-22.89950000, -43.25850000],
		[-22.90050000, -43.25850000],
		[-22.90050000, -43.25750000],
		[-22.90100000, -43.25750000],
		[-22.90000000, -43.25650000],
		[-22.89900000, -43.25750000],
		[-22.89950000, -43.25750000],
		[-22.89950000, -43.25850000],
	], {color: 'green'});
	polygon.addTo(map);
	arrow.matriz.push(polygon);
	arrow.group.addLayer(polygon);
	var polygon = L.polygon([
		[-22.90070711, -43.24858579],
		[-22.90141421, -43.24929289],
		[-22.90212132, -43.24858579],
		[-22.90247487, -43.24893934],
		[-22.90247487, -43.24752513],
		[-22.90106066, -43.24752513],
		[-22.90141421, -43.24787868],
		[-22.90070711, -43.24858579],
	], {color: 'green'});
	polygon.addTo(map);
	arrow.matriz.push(polygon);
	arrow.group.addLayer(polygon);
	var polygon = L.polygon([
		[-22.90150000, -43.23950000],
		[-22.90150000, -43.24050000],
		[-22.90250000, -43.24050000],
		[-22.90250000, -43.24100000],
		[-22.90350000, -43.24000000],
		[-22.90250000, -43.23900000],
		[-22.90250000, -43.23950000],
		[-22.90150000, -43.23950000],
	], {color: 'green'});
	polygon.addTo(map);
	arrow.matriz.push(polygon);
	arrow.group.addLayer(polygon);
	var polygon = L.polygon([
		[-22.89070711, -43.25858579],
		[-22.89141421, -43.25929289],
		[-22.89212132, -43.25858579],
		[-22.89247487, -43.25893934],
		[-22.89247487, -43.25752513],
		[-22.89106066, -43.25752513],
		[-22.89141421, -43.25787868],
		[-22.89070711, -43.25858579],
	], {color: 'green'});
	polygon.addTo(map);
	arrow.matriz.push(polygon);
	arrow.group.addLayer(polygon);
	var polygon = L.polygon([
		[-22.89070711, -43.24858579],
		[-22.89141421, -43.24929289],
		[-22.89212132, -43.24858579],
		[-22.89247487, -43.24893934],
		[-22.89247487, -43.24752513],
		[-22.89106066, -43.24752513],
		[-22.89141421, -43.24787868],
		[-22.89070711, -43.24858579],
	], {color: 'green'});
	polygon.addTo(map);
	arrow.matriz.push(polygon);
	arrow.group.addLayer(polygon);
	var polygon = L.polygon([
		[-22.89150000, -43.23950000],
		[-22.89150000, -43.24050000],
		[-22.89250000, -43.24050000],
		[-22.89250000, -43.24100000],
		[-22.89350000, -43.24000000],
		[-22.89250000, -43.23900000],
		[-22.89250000, -43.23950000],
		[-22.89150000, -43.23950000],
	], {color: 'green'});
	polygon.addTo(map);
	arrow.matriz.push(polygon);
	arrow.group.addLayer(polygon);
}

function loadCircle() {
	var circle = L.circle([-22.890, -43.260], {
		color: 'blue',
		fillColor: 'blue',
		fillOpacity: 0.5,
		radius: 100
	}).addTo(map)
		.bindPopup('UMin: -0.07143')
		.openPopup();
	circleUMin.matriz.push(circle);
	circleUMin.group.addLayer(circle);
	var circle = L.circle([-22.910, -43.250], {
		color: 'red',
		fillColor: 'red',
		fillOpacity: 0.5,
		radius: 100
	}).addTo(map)
		.bindPopup('UMax: 0.99107')
		.openPopup();
	circleUMax.matriz.push(circle);
	circleUMax.group.addLayer(circle);
	var circle = L.circle([-22.890, -43.240], {
		color: 'blue',
		fillColor: 'blue',
		fillOpacity: 0.5,
		radius: 100
	}).addTo(map)
		.bindPopup('UMin: -0.14286')
		.openPopup();
	circleUMin.matriz.push(circle);
	circleUMin.group.addLayer(circle);
	var circle = L.circle([-22.890, -43.260], {
		color: 'yellow',
		fillColor: 'yellow',
		fillOpacity: 0.5,
		radius: 100
	}).addTo(map)
		.bindPopup('SMin: -0.46875')
		.openPopup();
	circleSMin.matriz.push(circle);
	circleSMin.group.addLayer(circle);
	var circle = L.circle([-22.910, -43.250], {
		color: 'orange',
		fillColor: 'orange',
		fillOpacity: 0.5,
		radius: 100
	}).addTo(map)
		.bindPopup('SMax: -0.14286')
		.openPopup();
	circleSMax.matriz.push(circle);
	circleSMax.group.addLayer(circle);
	var circle = L.circle([-22.890, -43.240], {
		color: 'yellow',
		fillColor: 'yellow',
		fillOpacity: 0.5,
		radius: 100
	}).addTo(map)
		.bindPopup('SMin: 0.22768')
		.openPopup();
	circleSMin.matriz.push(circle);
	circleSMin.group.addLayer(circle);
}

