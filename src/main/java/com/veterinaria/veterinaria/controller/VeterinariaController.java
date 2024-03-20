package com.veterinaria.veterinaria.controller;

import com.veterinaria.veterinaria.dto.MascotaDTO;
import com.veterinaria.veterinaria.dto.VeterinariaDTO;
import com.veterinaria.veterinaria.entity.Mascota;
import com.veterinaria.veterinaria.service.IVeterinariaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.Set;

@RestController
@RequestMapping("/veterinarias")
public class VeterinariaController {
    @Autowired
    IVeterinariaService veterinariaService;

    @PostMapping("/crear")
    ResponseEntity<VeterinariaDTO> crearVeterinaria(
            @RequestBody VeterinariaDTO veterinariaDTO){
        ResponseEntity<VeterinariaDTO> response;
        VeterinariaDTO veterinaria = veterinariaService.crearVeterinaria(veterinariaDTO);
        if(veterinaria != null){
            response = ResponseEntity.ok(veterinaria);
        }else{
            response = ResponseEntity.badRequest().build();
        }
        return response;
    }

    @PostMapping("/agregarmascota/{id}")
    ResponseEntity agregarMascota(@RequestBody MascotaDTO mascotaDTO,
                                  @PathVariable Long id){
        ResponseEntity response;
        boolean siSeAgrego = veterinariaService.agregarMascota(mascotaDTO, id);
        if(siSeAgrego){
            response = ResponseEntity.ok().build();
        }else {
            response = ResponseEntity.badRequest().build();
        }
        return response;
    }

    @GetMapping("{id}/buscarmascotas")
    ResponseEntity<Optional<Set<Mascota>>> buscarMascotasPorIdVeterinaria(Long id){
        ResponseEntity<Optional<Set<Mascota>>> response;
        Optional<Set<Mascota>> mascotas =
                veterinariaService.buscarMascotasPorIdVeterinaria(id);
        if (mascotas.isPresent()){
            response = ResponseEntity.ok(mascotas);
        }else{
            response = ResponseEntity.badRequest().build();
        }
        return response;
    }

    @GetMapping("{id}/buscarperros")
    ResponseEntity<Optional<Set<Mascota>>> buscarPerrosPorIdVeterinaria(Long id){
        ResponseEntity<Optional<Set<Mascota>>> response;
        Optional<Set<Mascota>> perros =
                veterinariaService.buscarMascotasPerroPorIdVeterinaria(id);
        if (perros.isPresent()){
            response = ResponseEntity.ok(perros);
        }else{
            response = ResponseEntity.noContent().build();
        }
        return response;
    }
}
