package com.example.proyek.service;

import com.example.proyek.model.Surat;
import com.example.proyek.repository.RuanganRepository;
import com.example.proyek.repository.SuratRepository;

import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class SuratService {
	@Autowired
	private SuratRepository ruanganRepository;
	
	public List<Surat> listAllSurat() {
		return ruanganRepository.findAll();
	}
	public void saveSurat(Surat ruangan) {
		ruanganRepository.save(ruangan);
	}
	public Surat getSurat(Integer id) {
		return ruanganRepository.findById(id).get();
	}
	public void deleteSurat(Integer id) {
		ruanganRepository.deleteById(id);
	}
	
	public Surat getSuratByKeyWord(String keyword) {
		return (Surat) ruanganRepository.findByNamaSuratContainingIgnoreCase(keyword);
	}
}