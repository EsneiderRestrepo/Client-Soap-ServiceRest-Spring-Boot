package com.pruebajava.restService;


import com.pruebajava.consumingwscalculator.wsdl.Operacion;
import com.pruebajava.soapClient.SoapClient;

public class Circulo implements IFiguraGeometrica{

	private double radio;
	private  static final double PI=Math.PI;
	private double areaCirculo;
	

	public double getRadio() {
		return radio;
	}

	public void setRadio(double radio) {
		this.radio = radio;
	}
	

	public double getAreaCirculo() {
		return areaCirculo;
	}

	public void setAreaCirculo(double areaCirculo) {
		this.areaCirculo = areaCirculo;
	}

	@Override
	public void calcularArea(SoapClient soapClient) {
		areaCirculo=soapClient.calcular(soapClient.calcular(radio, radio,Operacion.MULTIPLICAR).getResultado(),PI,Operacion.MULTIPLICAR).getResultado();
	}
	
	
}
