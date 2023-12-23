package com.example.proyek.controller;

import com.example.proyek.model.Ruangan;
import com.example.proyek.service.RuanganService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.sql.Timestamp;
import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/ruangan")
public class RuanganController {
    @Autowired
    private RuanganService ruanganService;

    @GetMapping("")
    public List<Ruangan> list() {
        return ruanganService.listAllRuangan();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Ruangan> get(@PathVariable Integer id) {
        try {
        	Ruangan ruangan = ruanganService.getRuangan(id);
            return new ResponseEntity<>(ruangan, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/")
    public void add(@RequestBody Ruangan ruangan) {
    	ruanganService.saveRuangan(ruangan);
    }

    @PostMapping("/update/{id}")
    public RedirectView update(@ModelAttribute Ruangan ruangan, @PathVariable Integer id) {
            Ruangan editruangan = ruanganService.getRuangan(id);
            
            editruangan.setNamaRuangan(ruangan.getNamaRuangan());
            editruangan.setDeskripsiRuangan(ruangan.getDeskripsiRuangan());
            
            if (editruangan.getCreatedAt() == null) {
            	editruangan.setCreatedAt(new Timestamp(System.currentTimeMillis()));
            }
            ruanganService.saveRuangan(editruangan);
            return new RedirectView("/admin/ruangan/index");   
    }
    

    @GetMapping("/delete/{id}")
    public RedirectView delete(@PathVariable Integer id) {
    	ruanganService.deleteRuangan(id);
        return new RedirectView("/admin/ruangan/index");
    }
    
    @GetMapping("/search")
    public ResponseEntity<List<Ruangan>> searchBarang(@RequestParam("keyword") String keyword) {
        List<Ruangan> hasilPencarian = (List<Ruangan>) ruanganService.getRuanganByKeyWord(keyword);
        return new ResponseEntity<>(hasilPencarian, HttpStatus.OK);
    }
}
