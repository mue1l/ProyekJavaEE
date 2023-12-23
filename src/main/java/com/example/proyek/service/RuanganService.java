package com.example.proyek.service;

import com.example.proyek.model.Ruangan;
import com.example.proyek.repository.RuanganRepository;
import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class RuanganService {
	@Autowired
	private RuanganRepository ruanganRepository;
	
	public List<Ruangan> listAllRuangan() {
		return ruanganRepository.findAll();
	}
	public void saveRuangan(Ruangan ruangan) {
		ruanganRepository.save(ruangan);
	}
	public Ruangan getRuangan(Integer id) {
		return ruanganRepository.findById(id).get();
	}
	public void deleteRuangan(Integer id) {
		ruanganRepository.deleteById(id);
	}
	
	public Ruangan getRuanganByKeyWord(String keyword) {
		return (Ruangan) ruanganRepository.findByNamaRuanganContainingIgnoreCase(keyword);
	}
}