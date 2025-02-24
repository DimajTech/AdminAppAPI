package com.api.service;

import com.api.model.Advisement;
import com.api.repository.AdvisementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Service
public class AdvisementService {

    @Autowired
    private AdvisementRepository advisementRepository;

    public List<Advisement> getPublicAdvisements() throws SQLException {
        return advisementRepository.getPublicAdvisements();
    }

    public List<Advisement> getPrivateAdvisements() throws SQLException {
        return advisementRepository.getPrivateAdvisements();
    }

    public Advisement getAdvisementById(String id) throws SQLException {
        return advisementRepository.getAdvisementById(id)
                .orElseThrow(() -> new SQLException("Advisement no encontrado con ID: " + id));
    }
}
