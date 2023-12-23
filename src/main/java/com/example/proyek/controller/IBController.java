package com.example.proyek.controller;
import java.sql.Timestamp;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

import com.example.proyek.model.IB;
import com.example.proyek.service.IBService;

@RestController
@RequestMapping("/izinBermalam")
public class IBController {
	
	@Autowired
    private IBService ibService;
    @GetMapping("/admin/listIb")
    public List<IB> list() {
        return ibService.listAllIB();
    }

    @GetMapping("/mahasiswa")
    public ResponseEntity<List<IB>> mahasiswalist(HttpSession session) {
    	Integer userId = (Integer) session.getAttribute("idUser");
        try {
            List<IB> ibList = ibService.getIBByUserId(userId);

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
    public void add(@RequestBody IB ruangan) {
    	ibService.saveIB(ruangan);
    }

    @PostMapping("/mahasiswa/update/{id}")
    public RedirectView update(@ModelAttribute IB ib, @PathVariable Integer id, HttpSession session) {
            IB editib = ibService.getIB(id);
            
            editib.setKeperluan(ib.getKeperluan());
            editib.setTanggal(ib.getTanggal());
            editib.setKembali(ib.getKembali());
            editib.setJam(ib.getJam());
            
            if (editib.getCreatedAt() == null) {
            	editib.setCreatedAt(new Timestamp(System.currentTimeMillis()));
            }
            ibService.saveIB(editib);
            return new RedirectView("/mahasiswa/ib/index");   
    }
    

    @GetMapping("/mahasiswa/delete/{id}")
    public RedirectView delete(@PathVariable Integer id, HttpSession session) {
        Integer userId = (Integer) session.getAttribute("idUser");
        if (userId != null) {
            ibService.deleteIB(id);
            return new RedirectView("/mahasiswa/ib/index");
        } else {
            // Handle the case where userId is not found in the session
            return new RedirectView("/login"); // Redirect to login page or handle it accordingly
        }
    }
    
    @PostMapping("/admin/detail/{id}")
    public RedirectView handleAction(@PathVariable Integer id, @RequestParam String action) {
        IB editib = ibService.getIB(id);
        if ("approve".equals(action)) {
            editib.setStatus(1);
        } else if ("reject".equals(action)) {
            editib.setStatus(2);
        }
        // Save the updated IB entity
        ibService.saveIB(editib);
        // Redirect to a suitable URL after handling the action
        return new RedirectView("/admin/izinBermalam/index"); // Replace with the actual URL
    }
    
    @GetMapping("/admin/delete/{id}")
    public RedirectView deleteAdmin(@PathVariable Integer id, HttpSession session) {
            ibService.deleteIB(id);
            return new RedirectView("/admin/izinBermalam/index");
    }
    
//    @GetMapping("/search")
//    public ResponseEntity<List<Ruangan>> searchBarang(@RequestParam("keyword") String keyword) {
//        List<Ruangan> hasilPencarian = (List<Ruangan>) ruanganService.getRuanganByKeyWord(keyword);
//        return new ResponseEntity<>(hasilPencarian, HttpStatus.OK);
//    }
}
