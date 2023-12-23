package com.example.proyek.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.proyek.model.Ruangan;

public interface RuanganRepository extends JpaRepository<Ruangan, Integer>{
	List<Ruangan> findByNamaRuanganContainingIgnoreCase(String keyword);
}
