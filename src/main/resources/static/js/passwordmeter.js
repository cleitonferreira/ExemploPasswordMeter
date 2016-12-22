document.getElementById("senha").onkeyup = function() {
	var password = document.getElementById("senha").value;
	var httpRequest = new XMLHttpRequest();
	httpRequest.onreadystatechange = function(data) {
		if (httpRequest.readyState === 4 && httpRequest.status === 200) {
			var response = JSON.parse(httpRequest.responseText);
			setValue('pontuacao', (response.pontuacao + '%'));
			setValue('complexidade', response.complexidade);
			
			// Adições
			setValue('quantNumeroCaracter', response.quantNumeroCaracter);
			setValue('valorNumeroCaracter', response.valorNumeroCaracter);
			setValue('quantMaiuscula', response.quantMaiuscula);
			setValue('valorMaiuscula', response.valorMaiuscula);
			setValue('quantMinuscula', response.quantMinuscula);
			setValue('valorMinuscula', response.valorMinuscula);
			setValue('quantNumero', response.quantNumero);
			setValue('valorNumero', response.valorNumero);
			setValue('quantSimbolo', response.quantSimbolo);
			setValue('valorSimbolo', response.valorSimbolo);
			setValue('numeroSimbolo', response.numeroSimbolo);
			setValue('valorNumeroSimbolo', response.valorNumeroSimbolo);
			setValue('quantRequisito', response.quantRequisito);
			setValue('valorRequisito', response.valorRequisito);
			// Deduções
			setValue('quantLetra', response.quantLetra);
			setValue('valorLetra', response.valorLetra);
			setValue('quantApenasNumero', response.quantApenasNumero);
			setValue('valorApenasNumero', response.valorApenasNumero);
			
			setValue('quantCaractereRepetido', response.quantCaractereRepetido);
			
			setValue('quantMaiusculaConsecutiva', response.quantMaiusculaConsecutiva);
			setValue('valorMaiusculaConsecutiva', response.valorMaiusculaConsecutiva);
			setValue('quantMinusculaConsecutiva', response.quantMinusculaConsecutiva);
			setValue('valorMinusculaConsecutiva', response.valorMinusculaConsecutiva);
			setValue('quantNumeroConsecutivo', response.quantNumeroConsecutivo);
			setValue('valorNumeroConsecutivo', response.valorNumeroConsecutivo);
			setValue('quantLetraSequencial', response.quantLetraSequencial);
			setValue('valorLetraSequencial', response.valorLetraSequencial);
			setValue('quantNumeroSequencial', response.quantNumeroSequencial);
			setValue('valorNumeroSequencial', response.valorNumeroSequencial);
			setValue('quantSimboloSequencial', response.quantSimboloSequencial);
			setValue('valorSimboloSequencial', response.valorSimboloSequencial)
		}
	}
	httpRequest.open('POST', '/passwordmeter/verifica');
	httpRequest.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
	httpRequest.send('password=' + encodeURIComponent(password));
}

function setValue(id, value) {
	document.getElementById(id).innerHTML = value;
}
