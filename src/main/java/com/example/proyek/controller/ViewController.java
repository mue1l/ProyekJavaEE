package com.example.proyek.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.proyek.model.Ruangan;
import com.example.proyek.model.SessionData;
import com.example.proyek.model.Surat;
import com.example.proyek.model.BookingRuangan;
import com.example.proyek.model.IB;
import com.example.proyek.model.IK;
import com.example.proyek.model.PembelianKaos;
import com.example.proyek.model.RequestSurat;
import com.example.proyek.model.User;
import com.example.proyek.repository.BookingRuanganRepository;
import com.example.proyek.model.SessionData;
import com.example.proyek.service.RuanganService;
import com.example.proyek.service.SuratService;
import com.example.proyek.service.UserService;
import com.example.proyek.service.BookingRuanganService;
import com.example.proyek.service.IBService;
import com.example.proyek.service.IKService;
import com.example.proyek.service.PembelianKaosService;
import com.example.proyek.service.RequestSuratService;

@Controller
public class ViewController {
	@Autowired
	private RuanganService ruanganService;	
	@Autowired
	private IBService ibService;
	@Autowired
	private IKService ikService;
	@Autowired
	private UserService userService;
	@Autowired
	private PembelianKaosService pembelianKaosService;
	@Autowired
	private SuratService suratService;
	@Autowired
	private RequestSuratService requestSuratService;
	
	@Autowired
	private BookingRuanganService bookingRuanganService;
	
	@RequestMapping("/view-login")
	public String showLoginForm(Model model) {
        model.addAttribute("user", new User());
        return "login";
    }

	@RequestMapping("/view-register")
    public String addUsers() {
        return "register";
    }
	
	@RequestMapping("/admin-index")
    public String adminIndex() {
        return "admin/index";
    }
	
	@RequestMapping("/mahasiswa-index")
	public String showMahasiswaIndex(Model model, HttpSession session) {
        User loggedInUser = (User) session.getAttribute("user");
        model.addAttribute("user", loggedInUser);
        return "mahasiswa/index";
    }

	
	@RequestMapping("/admin/ruangan/index")
    public String adminRuanganIndex() {
        return "admin/ruangan/index";
    }
	@RequestMapping("/admin/ruangan/edit/{id}")
    public String editRuangan(@PathVariable Integer id, Model model) {
    	Ruangan ruangan = (Ruangan) ruanganService.getRuangan(id);
        model.addAttribute("ruangan", ruangan);
        return "/admin/ruangan/edit";
    }
	
	@RequestMapping("/admin/ruangan/add")
    public String addRuangan() {
        return "/admin/ruangan/add";
    }
	
	//izinBermalam Mahasiswa
	@RequestMapping("/mahasiswa/ib/index")
	public String ListIb() {
	    return "/mahasiswa/izin_bermalam/index";
	}
	@RequestMapping("/mahasiswa/ib/add")
    public String addIB() {
        return "/mahasiswa/izin_bermalam/add";
    }
	@RequestMapping("/mahasiswa/izinBermalam/edit/{id}")
    public String editIB(@PathVariable Integer id, Model model) {
    	IB ruangan = (IB) ibService.getIB(id);
        model.addAttribute("izinBermalam", ruangan);
        return "/mahasiswa/izin_bermalam/edit";
    }
	
	//izinBermalam Admin
	@RequestMapping("/admin/izinBermalam/index")
	public String ListIbAdmin() {
	    return "/admin/izin_bermalam/index";
	}
	@RequestMapping("/admin/izinBermalam/detail/{id}")
	public String detailIB(@PathVariable Integer id, Model model) {
	    IB ruangan = ibService.getIB(id);
	    Integer userId = ruangan.getIdUser();
	    User user = userService.getUser(userId);
	    String nama = user.getNama();

	    model.addAttribute("izinBermalam", ruangan);
	    model.addAttribute("nama", nama);
	    return "/admin/izin_bermalam/detail";
	}

	
	//izinKeluar
	@RequestMapping("/mahasiswa/izin_keluar/index")
	public String ListIk() {
	    return "/mahasiswa/izin_keluar/index";
	}
	@RequestMapping("/mahasiswa/ik/add")
    public String addIK() {
        return "/mahasiswa/izin_keluar/add";
    }
	@RequestMapping("/mahasiswa/izinKeluar/edit/{id}")
    public String editIK(@PathVariable Integer id, Model model) {
    	IK ruangan = (IK) ikService.getIK(id);
        model.addAttribute("izinKeluar", ruangan);
        return "/mahasiswa/izin_keluar/edit";
    }
	//izinKeluar Admin
	@RequestMapping("/admin/izinKeluar/index")
	public String ListIkAdmin() {
	    return "/admin/izin_keluar/index";
	}
	@RequestMapping("/admin/izinKeluar/detail/{id}")
	public String detailIK(@PathVariable Integer id, Model model) {
	    IK ruangan = ikService.getIK(id);
	    Integer userId = ruangan.getIdUser();
	    User user = userService.getUser(userId);
	    String nama = user.getNama();

	    model.addAttribute("izinKeluar", ruangan);
	    model.addAttribute("nama", nama);
	    return "/admin/izin_keluar/detail";
	}
	
	//pembelian kaos
	@RequestMapping("/mahasiswa/pembelianKaos/index")
	public String ListPembelian() {
	    return "/mahasiswa/pembelian_kaos/index";
	}
	@RequestMapping("/mahasiswa/pembelianKaos/add")
    public String addPembelian() {
        return "/mahasiswa/pembelian_kaos/add";
    }
	@RequestMapping("/mahasiswa/pembelianKaos/edit/{id}")
    public String editPembelian(@PathVariable Integer id, Model model) {
    	PembelianKaos ruangan = (PembelianKaos) pembelianKaosService.getPembelianKaos(id);
        model.addAttribute("pembelianKaos", ruangan);
        return "/mahasiswa/pembelian_kaos/edit";
    }
	@RequestMapping("/mahasiswa/pembelianKaos/bayar/{id}")
    public String bayarPembelian(@PathVariable Integer id, Model model) {
    	PembelianKaos ruangan = (PembelianKaos) pembelianKaosService.getPembelianKaos(id);
        model.addAttribute("pembelianKaos", ruangan);
        return "/mahasiswa/pembelian_kaos/bayar";
    }
	@RequestMapping("/admin/pembelianKaos/index")
	public String ListPembelianAdmin() {
	    return "/admin/pembelian_kaos/index";
	}
	
	
	//booking ruangan
	@RequestMapping("/mahasiswa/bookingRuangan/index")
	public String ListRuangan() {
	    return "/mahasiswa/booking_ruangan/index";
	}
	@RequestMapping("/mahasiswa/bookingRuangan/indexBooking")
	public String ListRuanganBooking() {
	    return "/mahasiswa/booking_ruangan/booking_index";
	}
	@RequestMapping("/mahasiswa/bookingRuangan/add/{id}")
    public String addBookingRuangan(@PathVariable Integer id, Model model) {
    	Ruangan ruangan = (Ruangan) ruanganService.getRuangan(id);
        model.addAttribute("ruangan", ruangan);
        return "/mahasiswa/booking_ruangan/add";
    }
	@RequestMapping("/mahasiswa/bookingRuangan/edit/{id}")
    public String editBookingRuangan(@PathVariable Integer id, Model model) {
		List<Ruangan> ruanganList = ruanganService.listAllRuangan();
		BookingRuangan ruangan = bookingRuanganService.getBookingRuangan(id);
        model.addAttribute("bookingRuangan", ruangan);
        model.addAttribute("ruangan", ruanganList);
        return "/mahasiswa/booking_ruangan/edit";
    }
	
	@RequestMapping("/mahasiswa/bookingRuangan/request")
    public String yourMapping(Model model) {
        List<Ruangan> ruanganList = ruanganService.listAllRuangan();
        BookingRuangan ruangan = new BookingRuangan();
        model.addAttribute("ruanganList", ruanganList);
        model.addAttribute("bookingRuangan", ruangan);
        return "/mahasiswa/booking_ruangan/request";
    }
	
	
	@RequestMapping("/admin/surat/index")
    public String adminSuratIndex() {
        return "admin/surat/index";
    }
	@RequestMapping("/admin/surat/edit/{id}")
    public String editSurat(@PathVariable Integer id, Model model) {
    	Surat ruangan = (Surat) suratService.getSurat(id);
        model.addAttribute("surat", ruangan);
        return "/admin/surat/edit";
    }
	
	@RequestMapping("/admin/surat/add")
    public String addSurat() {
        return "/admin/surat/add";
    }
	
	@RequestMapping("/mahasiswa/requestSurat/index")
	public String LisRequestSurat() {
	    return "/mahasiswa/request_surat/index";
	}
	@RequestMapping("/mahasiswa/requestSurat/request")
	public String Lists(Model model) {
		List<Surat> ruanganList = suratService.listAllSurat();
		RequestSurat ruangan = new RequestSurat();
        model.addAttribute("requestSurat", ruangan);
        model.addAttribute("surat", ruanganList);
	    return "/mahasiswa/request_surat/request";
	}
	@RequestMapping("/mahasiswa/requestSurat/edit/{id}")
    public String editrequestSurat(@PathVariable Integer id, Model model) {
		List<Surat> ruanganList = suratService.listAllSurat();
		RequestSurat ruangan = requestSuratService.getRequestSurat(id);
        model.addAttribute("requestSurat", ruangan);
        model.addAttribute("surat", ruanganList);
        return "/mahasiswa/request_surat/edit";
    }
	
	
	
}
