package com.cotinha.cotinha.repository;

import com.cotinha.cotinha.models.Cota;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CotaRepository extends JpaRepository<Cota, Long> {
}
