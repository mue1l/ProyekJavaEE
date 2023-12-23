package com.example.proyek.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.proyek.model.Ruangan;
import com.example.proyek.model.Surat;

public interface SuratRepository extends JpaRepository<Surat, Integer>{
	List<Surat> findByNamaSuratContainingIgnoreCase(String keyword);

}
