package com.cotinha.cotinha.services;

import com.cotinha.cotinha.exceptions.CotaNotFound;
import com.cotinha.cotinha.models.Cota;
import com.cotinha.cotinha.repository.CotaRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CotaService {

    @Autowired
    CotaRepository cotaRepository;

    public Cota save(Cota cota) {
        cotaRepository.save(cota);
        return cota;
    }

    public Cota update(Cota cota) throws CotaNotFound {
        find(cota.getId());
        cotaRepository.save(cota);
        return cota;
    }

    public Cota find(Long id) throws CotaNotFound {
        Optional<Cota> cota = cotaRepository.findById(id);
        return cota.orElseThrow(() -> new CotaNotFound());
    }

    public void delete(Long id) throws CotaNotFound {
        cotaRepository.deleteById(id);
    }
}