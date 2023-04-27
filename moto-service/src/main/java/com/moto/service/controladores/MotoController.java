package com.moto.service.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.moto.service.entidades.Moto;
import com.moto.service.servicios.MotoService;

@RestController
@RequestMapping("/moto")
public class MotoController {

    @Autowired
    private MotoService motoService;

    @GetMapping
    public List<Moto> listarMotos(){
        return motoService.getAll();
    }

    @GetMapping("/{id}")
    public Moto obtenerMoto(@PathVariable("id") int id){
        return motoService.getMotoById(id);
    }

    @PostMapping
    public Moto guardarMoto(@RequestBody Moto moto){
        return motoService.save(moto);
    }
    
    @GetMapping("/usuario/{usuarioId}")
	public List<Moto> listarMotosPorUsuarioId(@PathVariable("usuarioId") int id){
		return motoService.byUsuarioId(id);
	}
}
