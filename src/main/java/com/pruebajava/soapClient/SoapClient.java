package com.pruebajava.soapClient;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;

import com.pruebajava.consumingwscalculator.wsdl.Calculadora;
import com.pruebajava.consumingwscalculator.wsdl.GetCalculadoraRequest;
import com.pruebajava.consumingwscalculator.wsdl.GetCalculadoraResponse;
import com.pruebajava.consumingwscalculator.wsdl.Operacion;

@Service
@Component("Calculadora")
public class SoapClient extends WebServiceGatewaySupport {

	private static final Logger LOG = LoggerFactory.getLogger(SoapClient.class);

	private GetCalculadoraRequest request = new GetCalculadoraRequest();

	private GetCalculadoraResponse response = null;

	public Calculadora calcular(Double numero1, Double numero2, Operacion operacion) {

		request.setNum1(numero1);
		request.setNum2(numero2);
		request.setOperacion(operacion);

		try {
			response = (GetCalculadoraResponse) getWebServiceTemplate()
					.marshalSendAndReceive("http://localhost:8585/ws/calculadora.wsdl", request);
			LOG.info("Solicitud realizada " + response);
		} catch (Exception e) {
			LOG.error("El servicio SOAP no responde ", e);
		}

		return response != null ? response.getCalculadora() : null;
	}

}