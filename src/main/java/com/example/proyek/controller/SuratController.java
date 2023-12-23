package com.example.proyek.controller;

import com.example.proyek.model.Surat;
import com.example.proyek.service.SuratService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.sql.Timestamp;
import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/surat")
public class SuratController {
    @Autowired
    private SuratService ruanganService;

    @GetMapping("")
    public List<Surat> list() {
        return ruanganService.listAllSurat();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Surat> get(@PathVariable Integer id) {
        try {
        	Surat ruangan = ruanganService.getSurat(id);
            return new ResponseEntity<>(ruangan, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/")
    public void add(@RequestBody Surat ruangan) {
    	ruanganService.saveSurat(ruangan);
    }

    @PostMapping("/update/{id}")
    public RedirectView update(@ModelAttribute Surat ruangan, @PathVariable Integer id) {
    	Surat editruangan = ruanganService.getSurat(id);
            
            editruangan.setNamaSurat(ruangan.getNamaSurat());
            editruangan.setDeskripsi(ruangan.getDeskripsi());
            
            if (editruangan.getCreatedAt() == null) {
            	editruangan.setCreatedAt(new Timestamp(System.currentTimeMillis()));
            }
            ruanganService.saveSurat(editruangan);
            return new RedirectView("/admin/surat/index");   
    }
    

    @GetMapping("/delete/{id}")
    public RedirectView delete(@PathVariable Integer id) {
    	ruanganService.deleteSurat(id);
        return new RedirectView("/admin/surat/index");
    }
    
    @GetMapping("/search")
    public ResponseEntity<List<Surat>> searchBarang(@RequestParam("keyword") String keyword) {
        List<Surat> hasilPencarian = (List<Surat>) ruanganService.getSuratByKeyWord(keyword);
        return new ResponseEntity<>(hasilPencarian, HttpStatus.OK);
    }
}
