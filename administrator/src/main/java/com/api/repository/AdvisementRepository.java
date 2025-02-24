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
    List<Object[]> getPublicAdvisementsRaw();

    @Query(value = "EXEC GetPrivateAdvisements", nativeQuery = true)
    List<Object[]> getPrivateAdvisementsRaw();

    @Query(value = "EXEC GetAdvisementById @id = :id", nativeQuery = true)
    Optional<Object[]> getAdvisementByIdRaw(@Param("id") String id);
}
