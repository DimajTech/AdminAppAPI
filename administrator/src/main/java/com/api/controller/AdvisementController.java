package com.api.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import java.sql.SQLException;
import java.util.List;
import com.api.service.AdvisementService;
import com.api.DTO.AdvisementDTO;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(path = "/api/advisements")
public class AdvisementController {

    @Autowired
    private AdvisementService advisementService;


    @GetMapping("/getAdvisementById/{id}")
    public AdvisementDTO getAdvisementById(@PathVariable(value = "id") String id) throws SQLException {
        return advisementService.getAdvisementById(id);
    }


    @GetMapping("/getPublicAdvisements")
    public List<AdvisementDTO> getPublicAdvisements() throws SQLException {
        return advisementService.getPublicAdvisements();
    }


    @GetMapping("/getPrivateAdvisements")
    public List<AdvisementDTO> getPrivateAdvisements() throws SQLException {
        return advisementService.getPrivateAdvisements();
    }
}
