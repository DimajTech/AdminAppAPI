package com.api.service;

import com.api.DTO.NewsDTO;
import com.api.model.PieceOfNews;
import com.api.repository.PieceOfNewsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.Base64;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PieceOfNewsService {

    @Autowired
    private PieceOfNewsRepository pieceOfNewsRepository;

    public List<NewsDTO> getAllPieceOfNews() {
        List<Object[]> results = pieceOfNewsRepository.getAllNews();

        return results.stream().map(row -> new NewsDTO(
                (String) row[0],  // Id
                (String) row[1],  // Title
                (String) row[2],  // Description
                (byte[]) row[3],  // Picture (Base64)
                (Date) row[4],  // Date
                (String) row[5],  // AuthorId
                (String) row[6],  // AuthorName
                (String) row[7]   // AuthorRole
        )).collect(Collectors.toList());
    }
    public void savePieceOfNews(NewsDTO news) throws SQLException {

        byte[] pictureBytes = null;

        if (news.getPicture() != null && news.getPicture().startsWith("data:image")) {
            // Extrae el contenido después de "base64,"
            String base64Image = news.getPicture().split(",")[1];
            pictureBytes = Base64.getDecoder().decode(base64Image);
        }
        pieceOfNewsRepository.addPieceOfNews(news.getId(), news.getTitle(), pictureBytes, news.getAuthorId(), news.getDescription());
    }

    public NewsDTO getPieceOfNewsById(String id) throws SQLException {
        Optional<NewsDTO> optionalUser = pieceOfNewsRepository.getPieceOfNewsById(id);
        return optionalUser.orElseThrow(() -> new RuntimeException("PieceOfNews not found for id :: " + id));
    }

    public void deleteById(String id) throws SQLException {
        pieceOfNewsRepository.deleteById(id);
    }

}
