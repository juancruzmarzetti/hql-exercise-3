package com.veterinaria.veterinaria.service;

import com.veterinaria.veterinaria.dto.MascotaDTO;
import com.veterinaria.veterinaria.dto.VeterinariaDTO;
import com.veterinaria.veterinaria.entity.Mascota;

import java.util.Optional;
import java.util.Set;

public interface IVeterinariaService {

    VeterinariaDTO crearVeterinaria(VeterinariaDTO veterinariaDTO);
    boolean agregarMascota(MascotaDTO mascotaDTO, Long id);
    Optional<Set<Mascota>> buscarMascotasPorIdVeterinaria(Long id);
    Optional<Set<Mascota>> buscarMascotasPerroPorIdVeterinaria(Long id);
}
