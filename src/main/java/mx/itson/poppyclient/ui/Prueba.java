/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.itson.poppyclient.ui;

import mx.itson.poppyclient.client.ApiClient;
import mx.itson.poppyclient.entities.Empleado;

public class Prueba {
    public static void main(String[] args) throws Exception {
        ApiClient api = new ApiClient();
        for (Empleado e : api.listar()) {
            System.out.println(e.getId() + " - " + e.getNombre() + " - " + e.getPuesto());
        }
    }
}