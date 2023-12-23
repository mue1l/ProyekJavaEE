package com.example.proyek.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.example.proyek.model.RequestSurat;

import java.util.List;

public interface RequestSuratRepository extends JpaRepository<RequestSurat, Integer> {

	@Query("SELECT requestSurat FROM RequestSurat requestSurat WHERE requestSurat.idUser = :idUser ORDER BY id")
	List<RequestSurat> findByUserId(@Param("idUser") Integer idUser);
}
