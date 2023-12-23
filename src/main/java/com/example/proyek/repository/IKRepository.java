package com.example.proyek.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.example.proyek.model.IK;

import java.util.List;

public interface IKRepository extends JpaRepository<IK, Integer> {

	@Query("SELECT ik FROM IK ik WHERE ik.idUser = :idUser ORDER BY id")
	List<IK> findByUserId(@Param("idUser") Integer idUser);
}
