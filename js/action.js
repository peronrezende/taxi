/*******************************************************************************
INFORMAÇÕES DE IDENTIFICAÇÃO DA VERSÃO
Versão: 1.0					Data: 19/11/2016 20:43
Objetivo/Manutenção: Adicionar funcionalidades ao mapa
Autor: Peron Rezende
*******************************************************************************/

/*******************************************************************************
' Nome........: changeSrcTaxiState
' Objetivo....: 
' 
' Entrada.....: user (marker), demoState (False = original user state or True = 
'               demo user state)
' Observação..:
' Atualizações: [01]   Data: 27/06/2016 13:10   Autor: Paulo Mann
*******************************************************************************/

function changeSrcTaxiState(taxi, demoState)
{
	if(hideSrcMarkers)
	{
		if(demoState)
			map.removeLayer(taxi);
		else
			map.addLayer(taxi);
	}
}

/*******************************************************************************
' Nome........: changeDstTaxiState
' Objetivo....: 
' 
' Entrada.....: user (marker), demoState (False = original user state or True = 
'               demo user state)
' Observação..:
' Atualizações: [01]   Data: 27/06/2016 13:10   Autor: Paulo Mann
*******************************************************************************/

function changeDstTaxiState(taxi, demoState)
{
	if(hideDstMarkers)
	{
		if(demoState)
			map.removeLayer(taxi);
		else
			map.addLayer(taxi);
	}
}

/*******************************************************************************
' Nome........: changeArrowState
' Objetivo....: 
' 
' Entrada.....: user (marker), demoState (False = original user state or True = 
'               demo user state)
' Observação..:
' Atualizações: [01]   Data: 27/06/2016 13:10   Autor: Paulo Mann
*******************************************************************************/

function changeArrowState(arrow, demoState)
{
	if(hideArrowMarkers)
	{
		if(demoState)
			map.removeLayer(arrow);
		else
			map.addLayer(arrow);
	}
}

/*******************************************************************************
' Nome........: changeSquareState
' Objetivo....: 
' 
' Entrada.....: user (marker), demoState (False = original user state or True = 
'               demo user state)
' Observação..:
' Atualizações: [01]   Data: 27/06/2016 13:10   Autor: Paulo Mann
*******************************************************************************/

function changeSquareState(square, demoState)
{
	if(hideSquareMarkers)
	{
		if(demoState)
			map.removeLayer(square);
		else
			map.addLayer(square);
	}
}

/*******************************************************************************
' Nome........: changeCircleUMaxState
' Objetivo....: 
' 
' Entrada.....: user (marker), demoState (False = original user state or True = 
'               demo user state)
' Observação..:
' Atualizações: [01]   Data: 27/06/2016 13:10   Autor: Paulo Mann
*******************************************************************************/

function changeCircleUMaxState(circleUMax, demoState)
{
	if(hideCircleUMaxMarkers)
	{
		if(demoState)
			map.removeLayer(circleUMax);
		else
			map.addLayer(circleUMax);
	}
}

/*******************************************************************************
' Nome........: changeCircleUMinState
' Objetivo....: 
' 
' Entrada.....: user (marker), demoState (False = original user state or True = 
'               demo user state)
' Observação..:
' Atualizações: [01]   Data: 27/06/2016 13:10   Autor: Paulo Mann
*******************************************************************************/

function changeCircleUMinState(circleUMin, demoState)
{
	if(hideCircleUMinMarkers)
	{
		if(demoState)
			map.removeLayer(circleUMin);
		else
			map.addLayer(circleUMin);
	}
}

/*******************************************************************************
' Nome........: changeCircleSMaxState
' Objetivo....: 
' 
' Entrada.....: user (marker), demoState (False = original user state or True = 
'               demo user state)
' Observação..:
' Atualizações: [01]   Data: 27/06/2016 13:10   Autor: Paulo Mann
*******************************************************************************/

function changeCircleSMaxState(circleSMax, demoState)
{
	if(hideCircleSMaxMarkers)
	{
		if(demoState)
			map.removeLayer(circleSMax);
		else
			map.addLayer(circleSMax);
	}
}

/*******************************************************************************
' Nome........: changeCircleSMinState
' Objetivo....: 
' 
' Entrada.....: user (marker), demoState (False = original user state or True = 
'               demo user state)
' Observação..:
' Atualizações: [01]   Data: 27/06/2016 13:10   Autor: Paulo Mann
*******************************************************************************/

function changeCircleSMinState(circleSMin, demoState)
{
	if(hideCircleSMinMarkers)
	{
		if(demoState)
			map.removeLayer(circleSMin);
		else
			map.addLayer(circleSMin);
	}
}

/*******************************************************************************
' Nome........: hideSrcTaxis
' Objetivo....: 
' 
' Entrada.....: 
' Observação..:
' Atualizações: [01]   Data: 27/06/2016 13:10   Autor: Paulo Mann
*******************************************************************************/

function hideSrcTaxis()
{
	if(!hideSrcMarkers)
	{
		hideSrcMarkers = true;
		srcTaxiGroup.eachLayer(function (layer) 
		{
			changeSrcTaxiState(layer, true);
		});
	}
	else
	{
		srcTaxiGroup.eachLayer(function (layer)
		{
			changeSrcTaxiState(layer, false);
		});
		hideSrcMarkers = false;
	}
}

var hideSrcTaxisButton = L.easyButton({
	states: [{
		stateName: 'hide-src-taxis',   // name the state
		icon:      'glyphicon glyphicon-star-empty',          // and define its properties
		title:     'Hide src taxis demo', // like its title
		onClick: function(control) 
		{  
			hideSrcTaxis();
			control.state('show-src-taxis');
		}
	}, {
		stateName: 'show-src-taxis',
		icon:      'glyphicon glyphicon-star-empty',
		title:     'Hide src taxis demo',
		onClick: function(control) 
		{
			hideSrcTaxis();
			control.state('hide-src-taxis');
		}
	}]
});

/*******************************************************************************
' Nome........: hideDstTaxis
' Objetivo....: 
' 
' Entrada.....: 
' Observação..:
' Atualizações: [01]   Data: 27/06/2016 13:10   Autor: Paulo Mann
*******************************************************************************/

function hideDstTaxis()
{
	if(!hideDstMarkers)
	{
		hideDstMarkers = true;
		dstTaxiGroup.eachLayer(function (layer) 
		{
			changeDstTaxiState(layer, true);
		});
	}
	else
	{
		dstTaxiGroup.eachLayer(function (layer)
		{
			changeDstTaxiState(layer, false);
		});
		hideDstMarkers = false;
	}
}

var hideDstTaxisButton = L.easyButton({
	states: [{
		stateName: 'hide-dst-taxis',   // name the state
		icon:      'glyphicon glyphicon-star',          // and define its properties
		title:     'Hide dst taxis demo', // like its title
		onClick: function(control) 
		{  
			hideDstTaxis();
			control.state('show-dst-taxis');
		}
	}, {
		stateName: 'show-dst-taxis',
		icon:      'glyphicon glyphicon-star',
		title:     'Hide dst taxis demo',
		onClick: function(control) 
		{
			hideDstTaxis();
			control.state('hide-dst-taxis');
		}
	}]
});

/*******************************************************************************
' Nome........: hideArrows
' Objetivo....: 
' 
' Entrada.....: 
' Observação..:
' Atualizações: [01]   Data: 27/06/2016 13:10   Autor: Paulo Mann
*******************************************************************************/

function hideArrows()
{
	if(!hideArrowMarkers)
	{
		hideArrowMarkers = true;
		arrowGroup.eachLayer(function (layer) 
		{
			changeArrowState(layer, true);
		});
	}
	else
	{
		arrowGroup.eachLayer(function (layer)
		{
			changeArrowState(layer, false);
		});
		hideArrowMarkers = false;
	}
}

var hideArrowsButton = L.easyButton({
	states: [{
		stateName: 'hide-arrows',   // name the state
		icon:      'glyphicon glyphicon-arrow-up',          // and define its properties
		title:     'Hide arrows demo', // like its title
		onClick: function(control) 
		{  
			hideArrows();
			control.state('show-arrows');
		}
	}, {
		stateName: 'show-arrows',
		icon:      'glyphicon glyphicon-arrow-up',
		title:     'Hide arrows demo',
		onClick: function(control) 
		{
			hideArrows();
			control.state('hide-arrows');
		}
	}]
});

/*******************************************************************************
' Nome........: hideSquares
' Objetivo....: 
' 
' Entrada.....: 
' Observação..:
' Atualizações: [01]   Data: 27/06/2016 13:10   Autor: Paulo Mann
*******************************************************************************/

function hideSquares()
{
	if(!hideSquareMarkers)
	{
		hideSquareMarkers = true;
		squareGroup.eachLayer(function (layer) 
		{
			changeSquareState(layer, true);
		});
	}
	else
	{
		squareGroup.eachLayer(function (layer)
		{
			changeSquareState(layer, false);
		});
		hideSquareMarkers = false;
	}
}

var hideSquaresButton = L.easyButton({
	states: [{
		stateName: 'hide-squares',   // name the state
		icon:      'glyphicon glyphicon-th-large',          // and define its properties
		title:     'Hide squares demo', // like its title
		onClick: function(control) 
		{  
			hideSquares();
			control.state('show-squares');
		}
	}, {
		stateName: 'show-squares',
		icon:      'glyphicon glyphicon-th-large',
		title:     'Hide squares demo',
		onClick: function(control) 
		{
			hideSquares();
			control.state('hide-squares');
		}
	}]
});

/*******************************************************************************
' Nome........: hideCircleUMax
' Objetivo....: 
' 
' Entrada.....: 
' Observação..:
' Atualizações: [01]   Data: 27/06/2016 13:10   Autor: Paulo Mann
*******************************************************************************/

function hideCircleUMax()
{
	if(!hideCircleUMaxMarkers)
	{
		hideCircleUMaxMarkers = true;
		circleUMaxGroup.eachLayer(function (layer) 
		{
			changeCircleUMaxState(layer, true);
		});
	}
	else
	{
		circleUMaxGroup.eachLayer(function (layer)
		{
			changeCircleUMaxState(layer, false);
		});
		hideCircleUMaxMarkers = false;
	}
}

var hideCircleUMaxButton = L.easyButton({
	states: [{
		stateName: 'hide-circle-u-max',   // name the state
		icon:      'glyphicon glyphicon-th-large',          // and define its properties
		title:     'Hide circle u max demo', // like its title
		onClick: function(control) 
		{  
			hideCircleUMax();
			control.state('show-circle-u-max');
		}
	}, {
		stateName: 'show-circle-u-max',
		icon:      'glyphicon glyphicon-th-large',
		title:     'Hide circle u max demo',
		onClick: function(control) 
		{
			hideCircleUMax();
			control.state('hide-circle-u-max');
		}
	}]
});

/*******************************************************************************
' Nome........: hideCircleUMin
' Objetivo....: 
' 
' Entrada.....: 
' Observação..:
' Atualizações: [01]   Data: 27/06/2016 13:10   Autor: Paulo Mann
*******************************************************************************/

function hideCircleUMin()
{
	if(!hideCircleUMinMarkers)
	{
		hideCircleUMinMarkers = true;
		circleUMinGroup.eachLayer(function (layer) 
		{
			changeCircleUMinState(layer, true);
		});
	}
	else
	{
		circleUMinGroup.eachLayer(function (layer)
		{
			changeCircleUMinState(layer, false);
		});
		hideCircleUMinMarkers = false;
	}
}

var hideCircleUMinButton = L.easyButton({
	states: [{
		stateName: 'hide-circle-u-min',   // name the state
		icon:      'glyphicon glyphicon-th-large',          // and define its properties
		title:     'Hide circle u min demo', // like its title
		onClick: function(control) 
		{  
			hideCircleUMin();
			control.state('show-circle-u-min');
		}
	}, {
		stateName: 'show-circle-u-min',
		icon:      'glyphicon glyphicon-th-large',
		title:     'Hide circle u min demo',
		onClick: function(control) 
		{
			hideCircleUMax();
			control.state('hide-circle-u-min');
		}
	}]
});


/*******************************************************************************
' Nome........: hideCircleSMax
' Objetivo....: 
' 
' Entrada.....: 
' Observação..:
' Atualizações: [01]   Data: 27/06/2016 13:10   Autor: Paulo Mann
*******************************************************************************/

function hideCircleSMax()
{
	if(!hideCircleSMaxMarkers)
	{
		hideCircleSMaxMarkers = true;
		circleSMaxGroup.eachLayer(function (layer) 
		{
			changeCircleSMaxState(layer, true);
		});
	}
	else
	{
		circleSMaxGroup.eachLayer(function (layer)
		{
			changeCircleSMaxState(layer, false);
		});
		hideCircleSMaxMarkers = false;
	}
}

var hideCircleSMaxButton = L.easyButton({
	states: [{
		stateName: 'hide-circle-s-max',   // name the state
		icon:      'glyphicon glyphicon-th-large',          // and define its properties
		title:     'Hide circle s max demo', // like its title
		onClick: function(control) 
		{  
			hideCircleSMax();
			control.state('show-circle-s-max');
		}
	}, {
		stateName: 'show-circle-s-max',
		icon:      'glyphicon glyphicon-th-large',
		title:     'Hide circle s max demo',
		onClick: function(control) 
		{
			hideCircleSMax();
			control.state('hide-circle-s-max');
		}
	}]
});

/*******************************************************************************
' Nome........: hideCircleSMin
' Objetivo....: 
' 
' Entrada.....: 
' Observação..:
' Atualizações: [01]   Data: 27/06/2016 13:10   Autor: Paulo Mann
*******************************************************************************/

function hideCircleSMin()
{
	if(!hideCircleSMinMarkers)
	{
		hideCircleSMinMarkers = true;
		circleSMinGroup.eachLayer(function (layer) 
		{
			changeCircleSMinState(layer, true);
		});
	}
	else
	{
		circleSMinGroup.eachLayer(function (layer)
		{
			changeCircleSMinState(layer, false);
		});
		hideCircleSMinMarkers = false;
	}
}

var hideCircleSMinButton = L.easyButton({
	states: [{
		stateName: 'hide-circle-s-min',   // name the state
		icon:      'glyphicon glyphicon-th-large',          // and define its properties
		title:     'Hide circle s min demo', // like its title
		onClick: function(control) 
		{  
			hideCircleSMin();
			control.state('show-circle-s-min');
		}
	}, {
		stateName: 'show-circle-s-min',
		icon:      'glyphicon glyphicon-th-large',
		title:     'Hide circle s min demo',
		onClick: function(control) 
		{
			hideCircleSMax();
			control.state('hide-circle-s-min');
		}
	}]
});

/*******************************************************************************
' Nome........: setupButtons
' Objetivo....: 
' 
' Entrada.....:
' Observação..:
' Atualizações: [01]   Data: 27/06/2016 13:10   Autor: Paulo Mann
*******************************************************************************/

function setupButtons()
{
	hideSrcTaxisButton.setPosition('bottomright');
	hideSrcTaxisButton.addTo(map);
	hideDstTaxisButton.setPosition('bottomright');
	hideDstTaxisButton.addTo(map);
	hideArrowsButton.setPosition('bottomright');
	hideArrowsButton.addTo(map);
	hideSquaresButton.setPosition('bottomright');
	hideSquaresButton.addTo(map);
	hideCircleUMaxButton.setPosition('bottomright');
	hideCircleUMaxButton.addTo(map);
	hideCircleUMinButton.setPosition('bottomright');
	hideCircleUMinButton.addTo(map);
	hideCircleSMaxButton.setPosition('bottomright');
	hideCircleSMaxButton.addTo(map);
	hideCircleSMinButton.setPosition('bottomright');
	hideCircleSMinButton.addTo(map);
}

/*******************************************************************************
' Nome........: actionInit
' Objetivo....: Atribui ações aos botões do mapa
' 
' Entrada.....:
' Observação..:
' Atualizações: [01]   Data: 19/11/2016 20:43   Autor: Peron Rezende 
*******************************************************************************/

function actionInit() {
	srcTaxiGroup = L.layerGroup();
	dstTaxiGroup = L.layerGroup();
	arrowGroup = L.layerGroup();
	squareGroup = L.layerGroup();
	circleUMaxGroup = L.layerGroup();
	circleUMinGroup = L.layerGroup();
	circleSMaxGroup = L.layerGroup();
	circleSMinGroup = L.layerGroup();

	loadMap();
		
	loadSquare();
	loadTaxi();
	loadArrow();
	loadCircle();
	
	setupButtons();
}