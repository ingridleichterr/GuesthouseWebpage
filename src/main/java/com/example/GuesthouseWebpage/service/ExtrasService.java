package com.example.GuesthouseWebpage.service;

import com.example.GuesthouseWebpage.exceptions.ExtraNotFoundException;
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
    public void createExtra(Extras extras){
        extras.setActive(true);
        extrasRepository.save(extras);
    }
    //method to find extras by id
    public Extras findExtraById(Long id) throws ExtraNotFoundException {
        Optional<Extras> optionalExtras = extrasRepository.findById(id);

        if(optionalExtras.isEmpty()) {
            throw new ExtraNotFoundException(id);
        } else {
            return optionalExtras.get();
        }
    }

    //method to update extra by id
    public void updateExtra(Extras extras) {
        extrasRepository.saveAndFlush(extras);
    }

    //method to "delete" extra by id - set active false so no one can see the extra
    public void deleteExtraById(Long id) throws ExtraNotFoundException {
        Extras extras = findExtraById(id);
        extras.setActive(false);
        updateExtra(extras);
    }

    //method to restore extra
    public void restoreExtraById(Long id)throws ExtraNotFoundException {
        Extras extras = findExtraById(id);
        extras.setActive(true);
        updateExtra(extras);
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
