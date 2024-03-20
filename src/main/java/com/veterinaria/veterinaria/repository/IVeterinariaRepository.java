package com.veterinaria.veterinaria.repository;

import com.veterinaria.veterinaria.entity.Mascota;
import com.veterinaria.veterinaria.entity.Veterinaria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.Optional;
import java.util.Set;
@Repository
public interface IVeterinariaRepository extends JpaRepository<Veterinaria, Long> {

    @Query("SELECT mascotas FROM Veterinaria v WHERE v.id = ?1")
    Optional<Set<Mascota>> findAllMascotasWhereIdEquals(Long id);

    @Query("SELECT m FROM Veterinaria v JOIN v.mascotas m WHERE m.tipo = 'perro' AND v.id = ?1")
    Optional<Set<Mascota>> findAllMascotasPerroWhereIdEquals(Long id);

    @Modifying
    @Query("UPDATE Veterinaria v SET v.mascotas = ?1 WHERE v.id = ?2")
    void addMascotaWhereIdEquals(Set<Mascota> mascotas, Long id);
}
