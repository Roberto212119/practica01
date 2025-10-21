/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package practica01.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import com.tuempresa.practica01.model.Arbol;

public interface ArbolRepo extends JpaRepository<Arbol, Integer> {}
