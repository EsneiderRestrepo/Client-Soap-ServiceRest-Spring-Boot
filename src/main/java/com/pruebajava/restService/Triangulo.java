package com.pruebajava.restService;


import com.pruebajava.consumingwscalculator.wsdl.Operacion;
import com.pruebajava.soapClient.SoapClient;

public class Triangulo implements IFiguraGeometrica{

	private double base;
	
	private double altura;
	
	private double areaTriangulo;
	
	
	public double getBase() {
		return base;
	}

	public void setBase(double base) {
		this.base = base;
	}

	public double getAltura() {
		return altura;
	}

	public void setAltura(double altura) {
		this.altura = altura;
	}

	public double getAreaTriangulo() {
		return areaTriangulo;
	}

	public void setAreaTriangulo(double areaTriangulo) {
		this.areaTriangulo = areaTriangulo;
	}

	@Override
	public void calcularArea(SoapClient soapClient) {
		areaTriangulo=soapClient.calcular(soapClient.calcular(base, altura, Operacion.MULTIPLICAR).getResultado(),2D,Operacion.DIVIDIR).getResultado();
	}
	
	
}
