package com.example.proyek.service;

import com.example.proyek.model.RequestSurat;
import com.example.proyek.repository.RequestSuratRepository;

import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class RequestSuratService {
	@Autowired
	private RequestSuratRepository ikRepository;
	
	public List<RequestSurat> listAllRequestSurat() {
		return ikRepository.findAll();
	}
	public void saveRequestSurat(RequestSurat ik) {
		ikRepository.save(ik);
	}
	public RequestSurat getRequestSurat(Integer id) {
		return ikRepository.findById(id).get();
	}
	public List<RequestSurat> getRequestSuratByUserId(Integer idUser) {
	    return ikRepository.findByUserId(idUser);
	}

	public void deleteRequestSurat(Integer id) {
		ikRepository.deleteById(id);
	}
	
//	public IB getRuanganByKeyWord(String keyword) {
//		return (IB) ibRepository.findByContainingIgnoreCase(keyword);
//	}
}