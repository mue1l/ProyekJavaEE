package com.example.proyek.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.example.proyek.model.IB;

import java.util.List;
import java.util.Optional;

public interface IBRepository extends JpaRepository<IB, Integer> {

	@Query("SELECT ib FROM IB ib WHERE ib.idUser = :idUser ORDER BY id")
	List<IB> findByUserId(@Param("idUser") Integer idUser);
}
