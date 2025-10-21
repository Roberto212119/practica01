/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package practica01.demo.service;

import com.esteban.practica01.model.Arbol;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class ArbolService {
  private final Map<Integer, Arbol> data = new ConcurrentHashMap<>();
  private final AtomicInteger seq = new AtomicInteger(0);

  public List<Arbol> listar() { return new ArrayList<>(data.values()); }

  public Arbol guardar(Arbol a) {
    if (a.getId() == null) a.setId(seq.incrementAndGet());
    data.put(a.getId(), a);
    return a;
  }

  public Arbol buscar(Integer id) { return data.get(id); }

  public void eliminar(Integer id) { data.remove(id); }
}