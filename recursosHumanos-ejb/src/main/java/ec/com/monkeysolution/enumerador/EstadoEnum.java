/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.com.monkeysolution.enumerador;

/**
 *
 * @author luisp.araujo
 */
public enum EstadoEnum {
    ACTIVO("A"),
    INACTIVO("I");

    private String valor;

    EstadoEnum(String valor) {
        this.valor = valor;
    }

    public String getValor() {
        return valor;
    }

}
