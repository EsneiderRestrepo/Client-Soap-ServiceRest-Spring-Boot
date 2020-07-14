//
// Este archivo ha sido generado por la arquitectura JavaTM para la implantación de la referencia de enlace (JAXB) XML v2.3.0 
// Visite <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Todas las modificaciones realizadas en este archivo se perderán si se vuelve a compilar el esquema de origen. 
// Generado el: 2020.07.13 a las 10:02:05 AM COT 
//


package com.pruebajava.consumingwscalculator.wsdl;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para operacion.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * <p>
 * <pre>
 * &lt;simpleType name="operacion"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="SUMAR"/&gt;
 *     &lt;enumeration value="RESTAR"/&gt;
 *     &lt;enumeration value="MULTIPLICAR"/&gt;
 *     &lt;enumeration value="DIVIDIR"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "operacion")
@XmlEnum
public enum Operacion {

    SUMAR,
    RESTAR,
    MULTIPLICAR,
    DIVIDIR;

    public String value() {
        return name();
    }

    public static Operacion fromValue(String v) {
        return valueOf(v);
    }

}
