package com.example.proyek.controller;
import java.sql.Time;
import java.sql.Timestamp;
import java.time.LocalTime;
import java.util.List;
import java.util.NoSuchElementException;
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
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

import com.example.proyek.model.Surat;
import com.example.proyek.model.IB;
import com.example.proyek.model.RequestSurat;
import com.example.proyek.service.RequestSuratService;
import com.example.proyek.service.SuratService;

@RestController
@RequestMapping("/requestSurat")
public class RequestSuratController {
	
	@Autowired
    private SuratService ruanganService;
	
	@Autowired
    private RequestSuratService ibService;
    @GetMapping("")
    public List<Surat> list() {
        return ruanganService.listAllSurat();
    }

    @GetMapping("/mahasiswa")
    public ResponseEntity<List<RequestSurat>> mahasiswalist(HttpSession session) {
    	Integer userId = (Integer) session.getAttribute("idUser");
        try {
            List<RequestSurat> ibList = ibService.getRequestSuratByUserId(userId);

            if (!ibList.isEmpty()) {
                return new ResponseEntity<>(ibList, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    @PostMapping("/mahasiswa/request")
    public void add(@RequestBody RequestSurat ruangan) {
    	ibService.saveRequestSurat(ruangan);
    }


    @PostMapping("/mahasiswa/update/{id}")
    public RedirectView update(@ModelAttribute RequestSurat ib, @PathVariable Integer id, HttpSession session) {
    		RequestSurat editib = ibService.getRequestSurat(id);
            
    		editib.setIdSurat(ib.getIdSurat());
            editib.setKeperluan(ib.getKeperluan());
            
            if (editib.getCreatedAt() == null) {
            	editib.setCreatedAt(new Timestamp(System.currentTimeMillis()));
            }
            ibService.saveRequestSurat(editib);
            return new RedirectView("/mahasiswa/requestSurat/index");   
    }
    

    @GetMapping("/mahasiswa/delete/{id}")
    public RedirectView delete(@PathVariable Integer id, HttpSession session) {
        Integer userId = (Integer) session.getAttribute("idUser");
        if (userId != null) {
            ibService.deleteRequestSurat(id);
            return new RedirectView("/mahasiswa/requestSurat/index");
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
