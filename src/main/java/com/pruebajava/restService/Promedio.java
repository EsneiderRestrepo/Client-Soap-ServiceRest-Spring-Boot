package com.pruebajava.restService;


import com.pruebajava.consumingwscalculator.wsdl.Operacion;
import com.pruebajava.soapClient.SoapClient;

public class Promedio implements IMedida{
	
	private double a;
	private double b;
	private double resultadoPromedio;
	

	public double getA() {
		return a;
	}
	public void setA(double a) {
		this.a = a;
	}
	public double getB() {
		return b;
	}
	public void setB(double b) {
		this.b = b;
	}
	public double getResultadoPromedio() {
		return resultadoPromedio;
	}
	public void setResultadoPromedio(double resultadoPromedio) {
		this.resultadoPromedio = resultadoPromedio;
	}
	@Override
	public void calcularFormula(SoapClient soapClient) {
		resultadoPromedio=soapClient.calcular(soapClient.calcular(a, b, Operacion.SUMAR).getResultado(),2D,Operacion.DIVIDIR).getResultado();
	}
	
	

}
