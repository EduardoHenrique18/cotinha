package com.cotinha.cotinha.services;


import com.cotinha.cotinha.exceptions.cotaNotFound;
import com.cotinha.cotinha.models.Cota;
import com.cotinha.cotinha.repository.CotaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class CotaService {

    @Autowired
    CotaRepository cotaRepository;

    public Cota cotaSave(Cota cota){
        cota.setId(null);
        cotaRepository.save(cota);
        return cota;

    }

    public Cota cotaUpdate(Cota cota) throws cotaNotFound {
        cotaFind(cota.getId());
        cotaRepository.save(cota);
        return cota;
    }



    public Cota cotaFind(Long id) throws cotaNotFound {
        Optional<Cota> obj = cotaRepository.findById(id);
        return obj.orElseThrow(() -> new cotaNotFound("Id não encontrado"));
    }

    public void cotaDelete(Long id) throws cotaNotFound {
        cotaFind(id);
        cotaRepository.deleteById(id);
    }


}
