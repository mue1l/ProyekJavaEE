package com.example.proyek.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.example.proyek.model.BookingRuangan;

import java.util.List;

public interface BookingRuanganRepository extends JpaRepository<BookingRuangan, Integer> {

	@Query("SELECT bookingRuangan FROM BookingRuangan bookingRuangan WHERE bookingRuangan.idUser = :idUser ORDER BY id")
	List<BookingRuangan> findByUserId(@Param("idUser") Integer idUser);
}
