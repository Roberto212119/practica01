/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package practica01.demo.controller;



import com.esteban.practica01.model.Arbol;
import com.esteban.practica01.service.ArbolService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.*;

@Controller
@RequestMapping("/arboles")
public class ArbolController {

  private final ArbolService service;

  public ArbolController(ArbolService service) {
    this.service = service;
  }

  @GetMapping
  public String listar(Model model) {
    model.addAttribute("lista", service.listar());
    return "arbol/lista";
  }

  @GetMapping("/nuevo")
  public String nuevo(Model model) {
    model.addAttribute("arbol", new Arbol());
    return "arbol/form";
  }

  @GetMapping("/editar/{id}")
  public String editar(@PathVariable Integer id, Model model) {
    Arbol a = service.buscar(id);
    if (a == null) return "redirect:/arboles";
    model.addAttribute("arbol", a);
    return "arbol/form";
  }

  @PostMapping("/guardar")
  public String guardar(Arbol arbol, @RequestParam("archivoImagen") MultipartFile archivo) throws IOException {
    // Guardar imagen si viene
    if (archivo != null && !archivo.isEmpty()) {
      Path uploads = Paths.get("uploads");
      if (!Files.exists(uploads)) Files.createDirectories(uploads);
      Path destino = uploads.resolve(archivo.getOriginalFilename());
      Files.copy(archivo.getInputStream(), destino, StandardCopyOption.REPLACE_EXISTING);
      arbol.setImagenRuta("/uploads/" + archivo.getOriginalFilename());
    }
    service.guardar(arbol);
    return "redirect:/arboles";
  }

  @GetMapping("/eliminar/{id}")
  public String eliminar(@PathVariable Integer id) {
    service.eliminar(id);
    return "redirect:/arboles";
  }
}
