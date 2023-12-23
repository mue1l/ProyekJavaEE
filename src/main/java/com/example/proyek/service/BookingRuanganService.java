package com.example.proyek.service;

import com.example.proyek.model.BookingRuangan;
import com.example.proyek.repository.BookingRuanganRepository;

import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class BookingRuanganService {
	@Autowired
	private BookingRuanganRepository ikRepository;
	
	public List<BookingRuangan> listAllBookingRuangan() {
		return ikRepository.findAll();
	}
	public void saveBookingRuangan(BookingRuangan ik) {
		ikRepository.save(ik);
	}
	public BookingRuangan getBookingRuangan(Integer id) {
		return ikRepository.findById(id).get();
	}
	public List<BookingRuangan> getBookingRuanganByUserId(Integer idUser) {
	    return ikRepository.findByUserId(idUser);
	}

	public void deleteBookingRuangan(Integer id) {
		ikRepository.deleteById(id);
	}
	
//	public IB getRuanganByKeyWord(String keyword) {
//		return (IB) ibRepository.findByContainingIgnoreCase(keyword);
//	}
}