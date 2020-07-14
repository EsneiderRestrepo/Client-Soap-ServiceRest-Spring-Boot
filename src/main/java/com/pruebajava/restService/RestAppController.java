package com.pruebajava.restService;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.pruebajava.consumingwscalculator.wsdl.Calculadora;
import com.pruebajava.consumingwscalculator.wsdl.Operacion;
import com.pruebajava.soapClient.SoapClient;

@RestController
@RequestMapping("/apiRest")
public class RestAppController {

	@Autowired
	private SoapClient soapClient;
	
	private static final Logger log = LoggerFactory.getLogger(RestAppController.class);

	
	@RequestMapping(value = "sumar/{num1}/{num2}", method = RequestMethod.GET)
	public ResponseEntity<Calculadora> sumar(@PathVariable("num1") Double num1, @PathVariable("num2") Double num2) {
		log.info("Solicitud REST-> Sumar", num1, num2);
		return ResponseEntity.ok(soapClient.calcular(num1, num2, Operacion.SUMAR));

	}

	@RequestMapping(value = "restar/{num1}/{num2}", method = RequestMethod.GET)
	public ResponseEntity<Calculadora> restar(@PathVariable("num1") Double num1, @PathVariable("num2") Double num2) {
		log.info("Solicitud REST-> Restar", num1, num2);
		return ResponseEntity.ok(soapClient.calcular(num1, num2, Operacion.RESTAR));
	}

	@RequestMapping(value = "multiplicar/{num1}/{num2}", method = RequestMethod.GET)
	public ResponseEntity<Calculadora> multiplicar(@PathVariable("num1") Double num1,
			@PathVariable("num2") Double num2) {
		log.info("Solicitud REST-> Multiplicar", num1, num2);
		return ResponseEntity.ok(soapClient.calcular(num1, num2, Operacion.MULTIPLICAR));
	}

	@RequestMapping(value = "dividir/{num1}/{num2}", method = RequestMethod.GET)
	public ResponseEntity<Calculadora> dividir(@PathVariable("num1") Double num1, @PathVariable("num2") Double num2) {
		log.info("Solicitud REST-> Dividir", num1, num2);
		return ResponseEntity.ok(soapClient.calcular(num1, num2, Operacion.DIVIDIR));
	}

	@PostMapping("/pendiente")
	public ResponseEntity<Pendiente> pendiente(@RequestBody Pendiente pendiente) {
		
		pendiente.calcularFormula(soapClient);
		log.info("Solicitud REST-> Pendiente", pendiente);
		return ResponseEntity.ok(pendiente);
	}
	
	@PostMapping("/promedio")
	public ResponseEntity<Promedio> promedio(@RequestBody Promedio promedio) {
		
		promedio.calcularFormula(soapClient);
		log.info("Solicitud REST-> Promedio", promedio);
		return ResponseEntity.ok(promedio);
	}
	
	@PostMapping("/triangulo")
	public ResponseEntity<Triangulo> triangulo(@RequestBody Triangulo triangulo) {
		
		triangulo.calcularArea(soapClient);
		log.info("Solicitud REST-> Triangulo",triangulo);
		return ResponseEntity.ok(triangulo);
	}
	@PostMapping("/circulo")
	public ResponseEntity<Circulo> circulo(@RequestBody Circulo circulo) {
		log.info("Solicitud REST-> Circulo",circulo);
		circulo.calcularArea(soapClient);
		return ResponseEntity.ok(circulo);
	}

	

}