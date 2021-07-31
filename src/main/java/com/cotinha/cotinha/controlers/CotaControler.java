package com.cotinha.cotinha.controlers;

import com.cotinha.cotinha.exceptions.cotaNotFound;
import com.cotinha.cotinha.models.Cota;
import com.cotinha.cotinha.services.CotaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import java.net.URI;

@RestController
@RequestMapping(value = "/cotas")
public class CotaControler {

    @Autowired
    CotaService cotaService;

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public ResponseEntity<Void> emailSave(@RequestBody Cota cota){
        cota = cotaService.cotaSave(cota);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(cota.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> findCota(@PathVariable Long id) throws cotaNotFound {
        Cota obj = cotaService.cotaFind(id);
        return ResponseEntity.ok().body(obj);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PATCH)
    public ResponseEntity<Void> update(@RequestBody Cota cota, @PathVariable Long id) throws cotaNotFound {
        cota.setId(id);
        cota = cotaService.cotaUpdate(cota);
        return ResponseEntity.noContent().build();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> cotaDelete(@PathVariable Long id) throws cotaNotFound {
        cotaService.cotaDelete(id);
        return  ResponseEntity.noContent().build();
    }
}
