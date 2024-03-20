package com.veterinaria.veterinaria.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Entity
@Table(name = "veterinarias")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Veterinaria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private int costo;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "veterinaria_id")
    private Set<Mascota> mascotas;

    public Set<Mascota> getMascotas(){
        return this.mascotas;
    }
}
