
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
	// Celula 2
	var polygon = L.polygon([
		[-22.915, -43.255],
		[-22.905, -43.255],
		[-22.905, -43.245],
		[-22.915, -43.245]
	], {color: '#3f0000'});
	polygon.addTo(map);
	square.matriz.push(polygon);
	square.group.addLayer(polygon);
	// Celula 3
	var polygon = L.polygon([
		[-22.915, -43.245],
		[-22.905, -43.245],
		[-22.905, -43.235],
		[-22.915, -43.235]
	], {color: '#6f0000'});
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
	], {color: '#3f0000'});
	polygon.addTo(map);
	square.matriz.push(polygon);
	square.group.addLayer(polygon);
	// Celula 9
	var polygon = L.polygon([
		[-22.895, -43.245],
		[-22.885, -43.245],
		[-22.885, -43.235],
		[-22.895, -43.235]
	], {color: '#470000'});
	polygon.addTo(map);
	square.matriz.push(polygon);
	square.group.addLayer(polygon);
}

function loadTaxi() {
	var taxi = L.marker([-22.90471840, -43.24283165], {icon: srcIcon});
	taxi.addTo(map);
	srcTaxi.matriz.push(taxi);
	srcTaxi.group.addLayer(taxi);
	var taxi = L.marker([-22.89578126, -43.25253346], {icon: srcIcon});
	taxi.addTo(map);
	srcTaxi.matriz.push(taxi);
	srcTaxi.group.addLayer(taxi);
	var taxi = L.marker([-22.90099467, -43.24444862], {icon: srcIcon});
	taxi.addTo(map);
	srcTaxi.matriz.push(taxi);
	srcTaxi.group.addLayer(taxi);
	var taxi = L.marker([-22.91291027, -43.24849104], {icon: srcIcon});
	taxi.addTo(map);
	srcTaxi.matriz.push(taxi);
	srcTaxi.group.addLayer(taxi);
	var taxi = L.marker([-22.89602952, -43.24094519], {icon: srcIcon});
	taxi.addTo(map);
	srcTaxi.matriz.push(taxi);
	srcTaxi.group.addLayer(taxi);
	var taxi = L.marker([-22.91365496, -43.24256216], {icon: srcIcon});
	taxi.addTo(map);
	srcTaxi.matriz.push(taxi);
	srcTaxi.group.addLayer(taxi);
	var taxi = L.marker([-22.91315850, -43.24552660], {icon: srcIcon});
	taxi.addTo(map);
	srcTaxi.matriz.push(taxi);
	srcTaxi.group.addLayer(taxi);
	var taxi = L.marker([-22.90844204, -43.23582479], {icon: srcIcon});
	taxi.addTo(map);
	srcTaxi.matriz.push(taxi);
	srcTaxi.group.addLayer(taxi);
	var taxi = L.marker([-22.90298067, -43.25064700], {icon: srcIcon});
	taxi.addTo(map);
	srcTaxi.matriz.push(taxi);
	srcTaxi.group.addLayer(taxi);
	var taxi = L.marker([-22.90074641, -43.25468941], {icon: srcIcon});
	taxi.addTo(map);
	srcTaxi.matriz.push(taxi);
	srcTaxi.group.addLayer(taxi);
	var taxi = L.marker([-22.89528473, -43.26277425], {icon: srcIcon});
	taxi.addTo(map);
	srcTaxi.matriz.push(taxi);
	srcTaxi.group.addLayer(taxi);
	var taxi = L.marker([-22.90099467, -43.24444862], {icon: srcIcon});
	taxi.addTo(map);
	srcTaxi.matriz.push(taxi);
	srcTaxi.group.addLayer(taxi);
	var taxi = L.marker([-22.89925689, -43.24390963], {icon: srcIcon});
	taxi.addTo(map);
	srcTaxi.matriz.push(taxi);
	srcTaxi.group.addLayer(taxi);
	var taxi = L.marker([-22.90298067, -43.25037750], {icon: srcIcon});
	taxi.addTo(map);
	srcTaxi.matriz.push(taxi);
	srcTaxi.group.addLayer(taxi);
	var taxi = L.marker([-22.89379515, -43.25900133], {icon: srcIcon});
	taxi.addTo(map);
	srcTaxi.matriz.push(taxi);
	srcTaxi.group.addLayer(taxi);
	var taxi = L.marker([-22.91315850, -43.23555530], {icon: srcIcon});
	taxi.addTo(map);
	srcTaxi.matriz.push(taxi);
	srcTaxi.group.addLayer(taxi);
	var taxi = L.marker([-22.89776734, -43.24310115], {icon: srcIcon});
	taxi.addTo(map);
	srcTaxi.matriz.push(taxi);
	srcTaxi.group.addLayer(taxi);
	var taxi = L.marker([-22.91439965, -43.23582479], {icon: srcIcon});
	taxi.addTo(map);
	srcTaxi.matriz.push(taxi);
	srcTaxi.group.addLayer(taxi);
	var taxi = L.marker([-22.91464787, -43.26466071], {icon: srcIcon});
	taxi.addTo(map);
	srcTaxi.matriz.push(taxi);
	srcTaxi.group.addLayer(taxi);
	var taxi = L.marker([-22.89478821, -43.23825024], {icon: srcIcon});
	taxi.addTo(map);
	srcTaxi.matriz.push(taxi);
	srcTaxi.group.addLayer(taxi);
	var taxi = L.marker([-22.90397366, -43.26088779]);
	taxi.addTo(map);
	dstTaxi.matriz.push(taxi);
	dstTaxi.group.addLayer(taxi);
	var taxi = L.marker([-22.90695260, -43.23825024]);
	taxi.addTo(map);
	dstTaxi.matriz.push(taxi);
	dstTaxi.group.addLayer(taxi);
	var taxi = L.marker([-22.90074641, -43.25468941]);
	taxi.addTo(map);
	dstTaxi.matriz.push(taxi);
	dstTaxi.group.addLayer(taxi);
	var taxi = L.marker([-22.89652604, -43.24202317]);
	taxi.addTo(map);
	dstTaxi.matriz.push(taxi);
	dstTaxi.group.addLayer(taxi);
	var taxi = L.marker([-22.91117264, -43.23771126]);
	taxi.addTo(map);
	dstTaxi.matriz.push(taxi);
	dstTaxi.group.addLayer(taxi);
	var taxi = L.marker([-22.91191734, -43.23717227]);
	taxi.addTo(map);
	dstTaxi.matriz.push(taxi);
	dstTaxi.group.addLayer(taxi);
	var taxi = L.marker([-22.91291027, -43.24714357]);
	taxi.addTo(map);
	dstTaxi.matriz.push(taxi);
	dstTaxi.group.addLayer(taxi);
	var taxi = L.marker([-22.90471840, -43.24175367]);
	taxi.addTo(map);
	dstTaxi.matriz.push(taxi);
	dstTaxi.group.addLayer(taxi);
	var taxi = L.marker([-22.91241381, -43.24067570]);
	taxi.addTo(map);
	dstTaxi.matriz.push(taxi);
	dstTaxi.group.addLayer(taxi);
	var taxi = L.marker([-22.91241381, -43.24067570]);
	taxi.addTo(map);
	dstTaxi.matriz.push(taxi);
	dstTaxi.group.addLayer(taxi);
	var taxi = L.marker([-22.91315850, -43.24525710]);
	taxi.addTo(map);
	dstTaxi.matriz.push(taxi);
	dstTaxi.group.addLayer(taxi);
	var taxi = L.marker([-22.90496665, -43.26034880]);
	taxi.addTo(map);
	dstTaxi.matriz.push(taxi);
	dstTaxi.group.addLayer(taxi);
	var taxi = L.marker([-22.89379515, -43.23932822]);
	taxi.addTo(map);
	dstTaxi.matriz.push(taxi);
	dstTaxi.group.addLayer(taxi);
	var taxi = L.marker([-22.89478821, -43.23959772]);
	taxi.addTo(map);
	dstTaxi.matriz.push(taxi);
	dstTaxi.group.addLayer(taxi);
	var taxi = L.marker([-22.90869028, -43.23851974]);
	taxi.addTo(map);
	dstTaxi.matriz.push(taxi);
	dstTaxi.group.addLayer(taxi);
	var taxi = L.marker([-22.91464787, -43.23932822]);
	taxi.addTo(map);
	dstTaxi.matriz.push(taxi);
	dstTaxi.group.addLayer(taxi);
	var taxi = L.marker([-22.91092441, -43.23825024]);
	taxi.addTo(map);
	dstTaxi.matriz.push(taxi);
	dstTaxi.group.addLayer(taxi);
	var taxi = L.marker([-22.91092441, -43.23825024]);
	taxi.addTo(map);
	dstTaxi.matriz.push(taxi);
	dstTaxi.group.addLayer(taxi);
	var taxi = L.marker([-22.89702256, -43.25441992]);
	taxi.addTo(map);
	dstTaxi.matriz.push(taxi);
	dstTaxi.group.addLayer(taxi);
	var taxi = L.marker([-22.90869028, -43.23851974]);
	taxi.addTo(map);
	dstTaxi.matriz.push(taxi);
	dstTaxi.group.addLayer(taxi);
	var taxi = L.marker([-22.89354688, -43.23932822]);
	taxi.addTo(map);
	dstTaxi.matriz.push(taxi);
	dstTaxi.group.addLayer(taxi);
	var taxi = L.marker([-22.89453994, -43.23878923]);
	taxi.addTo(map);
	dstTaxi.matriz.push(taxi);
	dstTaxi.group.addLayer(taxi);
	var taxi = L.marker([-22.90968323, -43.23986721]);
	taxi.addTo(map);
	dstTaxi.matriz.push(taxi);
	dstTaxi.group.addLayer(taxi);
	var taxi = L.marker([-22.91415142, -43.24229266]);
	taxi.addTo(map);
	dstTaxi.matriz.push(taxi);
	dstTaxi.group.addLayer(taxi);
	var taxi = L.marker([-22.91415142, -43.24229266]);
	taxi.addTo(map);
	dstTaxi.matriz.push(taxi);
	dstTaxi.group.addLayer(taxi);
	var taxi = L.marker([-22.90645611, -43.24013671]);
	taxi.addTo(map);
	dstTaxi.matriz.push(taxi);
	dstTaxi.group.addLayer(taxi);
	var taxi = L.marker([-22.90298067, -43.25064700]);
	taxi.addTo(map);
	dstTaxi.matriz.push(taxi);
	dstTaxi.group.addLayer(taxi);
}

function loadArrow() {
	var polygon = L.polygon([
		[-22.90858579, -43.25929289],
		[-22.90929289, -43.25858579],
		[-22.90858579, -43.25787868],
		[-22.90893934, -43.25752513],
		[-22.90752513, -43.25752513],
		[-22.90752513, -43.25893934],
		[-22.90787868, -43.25858579],
		[-22.90858579, -43.25929289],
	], {color: 'green'});
	polygon.addTo(map);
	arrow.matriz.push(polygon);
	arrow.group.addLayer(polygon);
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
}

function loadCircle() {
	var circle = L.circle([-22.890, -43.260], {
		color: 'blue',
		fillColor: 'blue',
		fillOpacity: 0.5,
		radius: 100
	}).addTo(map)
		.bindPopup('UMin: -0.03125')
		.openPopup();
	circleUMin.matriz.push(circle);
	circleUMin.group.addLayer(circle);
	var circle = L.circle([-22.910, -43.250], {
		color: 'red',
		fillColor: 'red',
		fillOpacity: 0.5,
		radius: 100
	}).addTo(map)
		.bindPopup('UMax: 0.875')
		.openPopup();
	circleUMax.matriz.push(circle);
	circleUMax.group.addLayer(circle);
	var circle = L.circle([-22.900, -43.240], {
		color: 'blue',
		fillColor: 'blue',
		fillOpacity: 0.5,
		radius: 100
	}).addTo(map)
		.bindPopup('UMin: 0.0')
		.openPopup();
	circleUMin.matriz.push(circle);
	circleUMin.group.addLayer(circle);
	var circle = L.circle([-22.890, -43.260], {
		color: 'yellow',
		fillColor: 'yellow',
		fillOpacity: 0.5,
		radius: 100
	}).addTo(map)
		.bindPopup('SMin: -0.20089')
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
	var circle = L.circle([-22.900, -43.240], {
		color: 'yellow',
		fillColor: 'yellow',
		fillOpacity: 0.5,
		radius: 100
	}).addTo(map)
		.bindPopup('SMin: 0.19643')
		.openPopup();
	circleSMin.matriz.push(circle);
	circleSMin.group.addLayer(circle);
}

