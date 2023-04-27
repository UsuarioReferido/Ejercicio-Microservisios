package com.usuario.service.controlador;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.usuario.service.entidades.Usuario;
import com.usuario.service.modelos.Carro;
import com.usuario.service.modelos.Moto;
import com.usuario.service.servicio.UsuarioService;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

	@Autowired
	private UsuarioService usuarioService;

	@GetMapping
	public List<Usuario> listarUsuarios() {
		return usuarioService.getAll();
	}

	@GetMapping("/{id}")
	public Usuario obtenerUsuario(@PathVariable("id") int id) {
		return usuarioService.getUsuarioById(id);
	}

	@PostMapping
	public Usuario guardarUsuario(@RequestBody Usuario usuario) {
		return usuarioService.save(usuario);
	}

	@GetMapping("/carros/{usuarioId}")
	public List<Carro> listarCarros(@PathVariable("usuarioId") int id) {
		return usuarioService.getCarros(id);
	}

	@GetMapping("/motos/{usuarioId}")
	public List<Moto> listarMotos(@PathVariable("usuarioId") int id) {
		return usuarioService.getMotos(id);
	}
	
	@PostMapping("/carro/{usuarioId}")
	public Carro guardarCarro(@PathVariable("usuarioId") int id, @RequestBody Carro carro) {
		return usuarioService.saveCarro(id, carro);
	}
	
	@GetMapping("/todos/{usuarioId}")
	public Map<String, Object> listarTodosLosVehiculos(@PathVariable("usuarioId") int usuarioId){
		return usuarioService.getUsuarioAndVehiculos(usuarioId);
	}

}