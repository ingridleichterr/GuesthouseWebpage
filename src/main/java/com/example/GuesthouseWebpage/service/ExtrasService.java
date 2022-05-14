package com.example.GuesthouseWebpage.service;

import com.example.GuesthouseWebpage.model.Booking;
import com.example.GuesthouseWebpage.model.Extras;
import com.example.GuesthouseWebpage.repository.ExtrasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public class ExtrasService {

    @Autowired
    private ExtrasRepository extrasRepository;

    //method to create extra
    public void createExtra(Extras extra){
        extra.setActive(true);
        extrasRepository.save(extra);
    }
    //method to find extras by id
    public Optional<Extras> findExtraById(Long id) {
        return extrasRepository.findById(id);
    }

    //method to update extra by id
    public void updateExtra(Extras extra) {
        extrasRepository.saveAndFlush(extra);
    }

    //method to "delete" extra by id - set active false so no one can see the extra
    public void deleteExtraById(Long id) {
        findExtraById(id).ifPresent(extra -> {
            extra.setActive(false);
            updateExtra(extra);
        });
    }

    //method to restore extra
    public void restoreExtraById(Long id){
        findExtraById(id).ifPresent(extra -> {
            extra.setActive(true);
            updateExtra(extra);
        });
    }

    //method to really fully delete extra by id
    public void fullDeleteExtraById(Long id) {
        extrasRepository.deleteById(id);
    }

    //list all extras
    public List<Extras> getAllExtras(){
        return extrasRepository.findAll();
    }

    //list all active extras
    public List<Extras> getActiveExtras(){
        return getAllExtras().stream()
                .filter(Extras::isActive)
                .collect(Collectors.toList());
    }

}
