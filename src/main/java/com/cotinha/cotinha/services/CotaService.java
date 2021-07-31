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

    public Cota cotaSave(Cota cota) {
        cotaRepository.save(cota);
        return cota;
    }

    public Cota cotaUpdate(Cota cota) throws CotaNotFound {
        cotaFind(cota.getId());
        cotaRepository.save(cota);
        return cota;
    }

    public Cota cotaFind(Long id) throws CotaNotFound {
        Optional<Cota> cota = cotaRepository.findById(id);
        return cota.orElseThrow(() -> new CotaNotFound("Id não encontrado"));
    }

    public void cotaDelete(Long id) throws CotaNotFound {
        cotaFind(id);
        cotaRepository.deleteById(id);
    }
}
