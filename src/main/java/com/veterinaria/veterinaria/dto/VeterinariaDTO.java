package com.veterinaria.veterinaria.dto;

import com.veterinaria.veterinaria.entity.Mascota;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class VeterinariaDTO {
    private Long id;
    private String nombre;
    private int costo;
    private Set<Mascota> mascotas;
}
