package com.example.GuesthouseWebpage.service;

import com.example.GuesthouseWebpage.repository.RoomTypeRepository;
import com.example.GuesthouseWebpage.util.DBUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;

@Service
public class RoomTypeService {
    private RoomTypeRepository roomTypeRepository;
    private EntityManager em;
    public RoomTypeService() {
        em = DBUtil.getEntityManager();
    }

    @Autowired
    public RoomTypeService(RoomTypeRepository roomTypeRepository) {
        this.roomTypeRepository = roomTypeRepository;
    }
}
