package com.example.proyek.service;

import com.example.proyek.model.IB;
import com.example.proyek.repository.IBRepository;
import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class IBService {
	@Autowired
	private IBRepository ibRepository;
	
	public List<IB> listAllIB() {
		return ibRepository.findAll();
	}
	public void saveIB(IB ib) {
		ibRepository.save(ib);
	}
	public IB getIB(Integer id) {
		return ibRepository.findById(id).get();
	}
	public List<IB> getIBByUserId(Integer idUser) {
	    return ibRepository.findByUserId(idUser);
	}

	public void deleteIB(Integer id) {
		ibRepository.deleteById(id);
	}
	
//	public IB getRuanganByKeyWord(String keyword) {
//		return (IB) ibRepository.findByContainingIgnoreCase(keyword);
//	}
}