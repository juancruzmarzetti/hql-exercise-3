package com.veterinaria.veterinaria.service.implementation;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.veterinaria.veterinaria.dto.MascotaDTO;
import com.veterinaria.veterinaria.dto.VeterinariaDTO;
import com.veterinaria.veterinaria.entity.Mascota;
import com.veterinaria.veterinaria.entity.Veterinaria;
import com.veterinaria.veterinaria.repository.IVeterinariaRepository;
import com.veterinaria.veterinaria.service.IVeterinariaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;

@Service
public class VeterinariaService implements IVeterinariaService {

    @Autowired
    IVeterinariaRepository veterinariaRepository;

    @Autowired
    ObjectMapper mapper;
    @Override
    public VeterinariaDTO crearVeterinaria(VeterinariaDTO veterinariaDTO){
        Veterinaria veterinaria = mapper.convertValue(veterinariaDTO, Veterinaria.class);
        Veterinaria veterinariaGuardada = veterinariaRepository.save(veterinaria);
        return mapper.convertValue(veterinariaGuardada, VeterinariaDTO.class);
    }
    @Override
    public boolean agregarMascota(MascotaDTO mascotaDTO, Long id){
        boolean response = false;
        Optional<Veterinaria> veterinaria = veterinariaRepository.findById(id);
        Mascota mascota = mapper.convertValue(mascotaDTO, Mascota.class);
        if(veterinaria.isPresent()){
            Set<Mascota> mascotas = veterinaria.get().getMascotas();
            mascotas.add(mascota);
            veterinariaRepository.addMascotaWhereIdEquals(mascotas, id);
            response = true;
        }
        return response;
    }
    @Override
    public Optional<Set<Mascota>> buscarMascotasPorIdVeterinaria(Long id){
        Optional<Set<Mascota>> mascotas = veterinariaRepository.findAllMascotasWhereIdEquals(id);
        if (mascotas.isPresent()){
            return mascotas;
        }else{
            return null;
        }
    }
    @Override
    public Optional<Set<Mascota>> buscarMascotasPerroPorIdVeterinaria(Long id){
        Optional<Set<Mascota>> perros = veterinariaRepository.findAllMascotasPerroWhereIdEquals(id);
        if (perros.isPresent()){
            return perros;
        }else{
            return null;
        }
    }

}
