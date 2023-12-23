package com.example.proyek.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.example.proyek.model.PembelianKaos;

import java.util.List;

public interface PembelianKaosRepository extends JpaRepository<PembelianKaos, Integer> {

	@Query("SELECT pembelianKaos FROM PembelianKaos pembelianKaos WHERE pembelianKaos.idUser = :idUser ORDER BY id")
	List<PembelianKaos> findByUserId(@Param("idUser") Integer idUser);
}
