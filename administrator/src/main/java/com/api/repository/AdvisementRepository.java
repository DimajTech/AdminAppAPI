package com.api.repository;

import com.api.model.Advisement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

@Repository
public interface AdvisementRepository extends JpaRepository<Advisement, String> {

    @Query(value = "EXEC GetPublicAdvisements", nativeQuery = true)
    List<Advisement> getPublicAdvisements();


    @Query(value = "EXEC GetPrivateAdvisements", nativeQuery = true)
    List<Advisement> getPrivateAdvisements();


    @Query(value = "EXEC GetAdvisementById @id = :id", nativeQuery = true)
    Optional<Advisement> getAdvisementById(@Param("id") String id);
}
