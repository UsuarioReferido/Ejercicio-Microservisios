package com.carro.service.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.carro.service.entidades.Carro;
import com.carro.service.servicios.CarroService;

@RestController
@RequestMapping("/carro")
public class CarroController {

    @Autowired
    private CarroService carroService;

    @GetMapping
    public List<Carro> listarCarros(){
        return carroService.getAll();
    }

    @GetMapping("/{id}")
    public Carro obtenerCarro(@PathVariable("id") int id){
        return carroService.getCarroById(id);
    }

    @PostMapping
    public Carro guardarCarro(@RequestBody Carro carro){
        return carroService.save(carro);
    }
    
    @GetMapping("/usuario/{usuarioId}")
	public List<Carro> listarCarrosPorUsuarioId(@PathVariable("usuarioId") int id){
		return carroService.byUsuarioId(id);
	}
}
