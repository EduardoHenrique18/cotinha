package com.cotinha.cotinha.controlers;

import com.cotinha.cotinha.exceptions.CotaNotFound;
import com.cotinha.cotinha.models.Cota;
import com.cotinha.cotinha.services.CotaService;
import java.net.URI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping(value = "/cota")
public class CotaControler {

    @Autowired
    CotaService cotaService;

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public ResponseEntity<Void> save(@RequestBody Cota cota){
        cota = cotaService.save(cota);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(cota.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> find(@PathVariable Long id) throws CotaNotFound {
        Cota cota = cotaService.find(id);
        return ResponseEntity.ok().body(cota);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PATCH)
    public ResponseEntity<Void> update(@RequestBody Cota cota, @PathVariable Long id) throws CotaNotFound {
        cota.setId(id);
        cota = cotaService.update(cota);
        return ResponseEntity.noContent().build();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> delete(@PathVariable Long id) throws CotaNotFound {
        cotaService.delete(id);
        return  ResponseEntity.noContent().build();
    }
}
