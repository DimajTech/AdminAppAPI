package com.api.service;

import com.api.DTO.AdvisementDTO;
import com.api.repository.AdvisementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AdvisementService {

    @Autowired
    private AdvisementRepository advisementRepository;

    public List<AdvisementDTO> getPublicAdvisements() {
        return advisementRepository.getPublicAdvisementsRaw().stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    public List<AdvisementDTO> getPrivateAdvisements() {
        return advisementRepository.getPrivateAdvisementsRaw().stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    public AdvisementDTO getAdvisementById(String id) {
        Optional<Object[]> advisementRaw = advisementRepository.getAdvisementByIdRaw(id);
        return advisementRaw.map(this::mapToDTO)
                .orElseThrow(() -> new RuntimeException("Advisement no encontrado con ID: " + id));
    }

    private AdvisementDTO mapToDTO(Object[] row) {
        if (row.length < 6) { // Antes era 7, ahora ignoramos la fecha
            throw new IllegalArgumentException("El array no contiene suficientes elementos: " + row.length);
        }

        return new AdvisementDTO(
                (String) row[0],  // id
                (String) row[1],  // courseName
                (String) row[2],  // studentName
                (String) row[3],  // content
                (String) row[4],  // status
                (Boolean) row[5]  // isPublic
        );
    }
}
