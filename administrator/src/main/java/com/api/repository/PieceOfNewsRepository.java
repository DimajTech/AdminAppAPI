package com.api.repository;

import com.api.DTO.NewsDTO;
import com.api.model.PieceOfNews;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

public interface PieceOfNewsRepository  extends JpaRepository<PieceOfNews, String> {

    @Query(value = "EXEC GetAllNews", nativeQuery = true)
    List<Object[]> getAllNews();

    @Query(value = "EXEC GetNewsById :id", nativeQuery = true)
    Optional<NewsDTO> getPieceOfNewsById(String id);

    @Modifying
    @Transactional
    @Query(value = "EXEC InsertNews @Id = ?1, @Title = ?2, @Picture = ?3, @AuthorId = ?4, @Description = ?5", nativeQuery = true)
    void addPieceOfNews(String id, String title, byte[] picture, String authorId, String description);
}
