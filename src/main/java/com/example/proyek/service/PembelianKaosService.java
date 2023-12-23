package com.example.proyek.service;

import com.example.proyek.model.PembelianKaos;
import com.example.proyek.repository.PembelianKaosRepository;
import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class PembelianKaosService {
	@Autowired
	private PembelianKaosRepository ibRepository;
	
	public List<PembelianKaos> listAllPembelianKaos() {
		return ibRepository.findAll();
	}
	public void savePembelianKaos(PembelianKaos ib) {
		ibRepository.save(ib);
	}
	public PembelianKaos getPembelianKaos(Integer id) {
		return ibRepository.findById(id).get();
	}
	public List<PembelianKaos> getPembelianKaosByUserId(Integer idUser) {
	    return ibRepository.findByUserId(idUser);
	}

	public void deletePembelianKaos(Integer id) {
		ibRepository.deleteById(id);
	}
	
//	public IB getRuanganByKeyWord(String keyword) {
//		return (IB) ibRepository.findByContainingIgnoreCase(keyword);
//	}
}