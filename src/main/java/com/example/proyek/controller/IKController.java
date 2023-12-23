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
import com.example.proyek.model.IK;
import com.example.proyek.service.IKService;

@RestController
@RequestMapping("/izinKeluar")
public class IKController {
	
	@Autowired
    private IKService ibService;
    @GetMapping("admin/listIk")
    public List<IK> list() {
        return ibService.listAllIK();
    }

    @GetMapping("/mahasiswa")
    public ResponseEntity<List<IK>> mahasiswalist(HttpSession session) {
    	Integer userId = (Integer) session.getAttribute("idUser");
        try {
            List<IK> ibList = ibService.getIKByUserId(userId);

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
    public void add(@RequestBody IK ruangan) {
    	ibService.saveIK(ruangan);
    }

    @PostMapping("/mahasiswa/update/{id}")
    public RedirectView update(@ModelAttribute IK ib, @PathVariable Integer id, HttpSession session) {
            IK editib = ibService.getIK(id);
            
            editib.setKeperluan(ib.getKeperluan());
            editib.setTanggal(ib.getTanggal());
            editib.setJam(ib.getJam());
            editib.setJamKembali(ib.getJamKembali());
            
            if (editib.getCreatedAt() == null) {
            	editib.setCreatedAt(new Timestamp(System.currentTimeMillis()));
            }
            
            ibService.saveIK(editib);
            return new RedirectView("/mahasiswa/izin_keluar/index");   
    }
    

    @GetMapping("/mahasiswa/delete/{id}")
    public RedirectView delete(@PathVariable Integer id, HttpSession session) {
        Integer userId = (Integer) session.getAttribute("idUser");
        if (userId != null) {
            ibService.deleteIK(id);
            return new RedirectView("/mahasiswa/izin_keluar/index");
        } else {
            // Handle the case where userId is not found in the session
            return new RedirectView("/view-login"); // Redirect to login page or handle it accordingly
        }
    }
    
    @PostMapping("/admin/detail/{id}")
    public RedirectView handleAction(@PathVariable Integer id, @RequestParam String action) {
        IK editib = ibService.getIK(id);
        if ("approve".equals(action)) {
            editib.setStatus(1);
        } else if ("reject".equals(action)) {
            editib.setStatus(2);
        }
        // Save the updated IB entity
        ibService.saveIK(editib);
        // Redirect to a suitable URL after handling the action
        return new RedirectView("/admin/izinKeluar/index"); // Replace with the actual URL
    }
    
    @GetMapping("/admin/delete/{id}")
    public RedirectView deleteAdmin(@PathVariable Integer id, HttpSession session) {
            ibService.deleteIK(id);
            return new RedirectView("/admin/izinKeluar/index");
    }
    
//    @GetMapping("/search")
//    public ResponseEntity<List<Ruangan>> searchBarang(@RequestParam("keyword") String keyword) {
//        List<Ruangan> hasilPencarian = (List<Ruangan>) ruanganService.getRuanganByKeyWord(keyword);
//        return new ResponseEntity<>(hasilPencarian, HttpStatus.OK);
//    }
}
