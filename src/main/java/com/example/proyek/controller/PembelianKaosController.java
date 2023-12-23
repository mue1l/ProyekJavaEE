package com.example.proyek.controller;
import java.sql.Timestamp;
import java.util.List;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import com.example.proyek.model.PembelianKaos;
import com.example.proyek.service.PembelianKaosService;

@RestController
@RequestMapping("/pembelianKaos")
public class PembelianKaosController {
	
	@Autowired
    private PembelianKaosService ibService;
    @GetMapping("admin/list")
    public List<PembelianKaos> list() {
        return ibService.listAllPembelianKaos();
    }

    @GetMapping("/mahasiswa")
    public ResponseEntity<List<PembelianKaos>> mahasiswalist(HttpSession session) {
    	Integer userId = (Integer) session.getAttribute("idUser");
        try {
            List<PembelianKaos> ibList = ibService.getPembelianKaosByUserId(userId);

            if (!ibList.isEmpty()) {
                return new ResponseEntity<>(ibList, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/mahasiswa/add/")
    public void add(@RequestBody PembelianKaos ruangan) {
    	ibService.savePembelianKaos(ruangan);
    }

    @PostMapping("/mahasiswa/update/{id}")
    public RedirectView update(@ModelAttribute PembelianKaos ib, @PathVariable Integer id, HttpSession session) {
    		Integer userId = (Integer) session.getAttribute("idUser");
    		PembelianKaos editib = ibService.getPembelianKaos(id);
            
            editib.setUkuran(ib.getUkuran());
            editib.setJumlah(ib.getJumlah());
            editib.setTotal(ib.getJumlah() * 100000);
            
            if (editib.getCreatedAt() == null) {
            	editib.setCreatedAt(new Timestamp(System.currentTimeMillis()));
            }
            ibService.savePembelianKaos(editib);
            return new RedirectView("/mahasiswa/pembelianKaos/index");   
    }
    
    @PostMapping("/mahasiswa/bayar/{id}")
    public RedirectView bayar(@PathVariable Integer id, @RequestParam("bayar") int bayar, RedirectAttributes attributes) {
        PembelianKaos editib = ibService.getPembelianKaos(id);
        if (bayar < editib.getTotal()) {
            attributes.addAttribute("error", "Uang kurang. Pembayaran harus setara atau lebih dari total.");
            return new RedirectView("/mahasiswa/pembelianKaos/bayar/" + id);
        } else {
            editib.setStatus(1);
        }

        if (editib.getCreatedAt() == null) {
            editib.setCreatedAt(new Timestamp(System.currentTimeMillis()));
        }

        ibService.savePembelianKaos(editib);
        // Redirect to the index page after successful payment
        return new RedirectView("/mahasiswa/pembelianKaos/index");
    }


    

    @GetMapping("/mahasiswa/delete/{id}")
    public RedirectView delete(@PathVariable Integer id, HttpSession session) {
        Integer userId = (Integer) session.getAttribute("idUser");
        if (userId != null) {
            ibService.deletePembelianKaos(id);
            return new RedirectView("/mahasiswa/pembelianKaos/index");
        } else {
            // Handle the case where userId is not found in the session
            return new RedirectView("/view-login"); // Redirect to login page or handle it accordingly
        }
    }
    
//    @GetMapping("/search")
//    public ResponseEntity<List<Ruangan>> searchBarang(@RequestParam("keyword") String keyword) {
//        List<Ruangan> hasilPencarian = (List<Ruangan>) ruanganService.getRuanganByKeyWord(keyword);
//        return new ResponseEntity<>(hasilPencarian, HttpStatus.OK);
//    }
}
