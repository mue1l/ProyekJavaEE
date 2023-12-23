package com.example.proyek.service;

import com.example.proyek.model.IB;
import com.example.proyek.model.IK;
import com.example.proyek.repository.IBRepository;
import com.example.proyek.repository.IKRepository;

import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class IKService {
	@Autowired
	private IKRepository ikRepository;
	
	public List<IK> listAllIK() {
		return ikRepository.findAll();
	}
	public void saveIK(IK ik) {
		ikRepository.save(ik);
	}
	public IK getIK(Integer id) {
		return ikRepository.findById(id).get();
	}
	public List<IK> getIKByUserId(Integer idUser) {
	    return ikRepository.findByUserId(idUser);
	}

	public void deleteIK(Integer id) {
		ikRepository.deleteById(id);
	}
	
//	public IB getRuanganByKeyWord(String keyword) {
//		return (IB) ibRepository.findByContainingIgnoreCase(keyword);
//	}
}