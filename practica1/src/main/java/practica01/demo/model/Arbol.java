/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package practica01.demo;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Arbol {
  private Integer id;              // autoincremental (en memoria)
  private String  nombre;
  private String  nombreCientifico;
  private String  tipoFlor;
  private Integer durezaMadera;    // 1..10 recomendado
  private Double  alturaPromedio;  // metros
  private String  imagenRuta;      // /uploads/archivo.jpg
}
