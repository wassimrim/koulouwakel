package com.projetb32.koulouwakel.service;


import com.projetb32.koulouwakel.entity.ConstraintUser;
import com.projetb32.koulouwakel.entity.ConstraintUserPk;
import com.projetb32.koulouwakel.repository.CategoryRepository;
import com.projetb32.koulouwakel.repository.RestrictionRepository;
import com.projetb32.koulouwakel.repository.RestrictionUserRepository;
import com.projetb32.koulouwakel.repository.UserRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class RestrictionUserService {


    private final RestrictionRepository restrictionRepository;

    private final RestrictionUserRepository restrictionUserRepository;

    private final UserRepository userRepository;

    public RestrictionUserService(RestrictionRepository restrictionRepository, RestrictionUserRepository restrictionUserRepository,   UserRepository userRepository) {
        this.restrictionRepository = restrictionRepository;
        this.restrictionUserRepository = restrictionUserRepository;
        this.userRepository = userRepository;
     }


    public ConstraintUser addRestrictionUser(ConstraintUser constraintUser, long restriction_id , long user_id) {

        ConstraintUser p =new ConstraintUser();
        ConstraintUserPk pp = new ConstraintUserPk();
        pp.setRestriction(restrictionRepository.findById(restriction_id).get());
        pp.setUser(userRepository.findById(user_id).get());
        p.setConstraintUserPk(pp);

        return restrictionUserRepository.save(p);
    }

    public List<ConstraintUser> getAllRestrictionUser() {


        return restrictionUserRepository.findAll();
    }

    public Optional<ConstraintUser> getRestrictionUserById(Long id) {

        return restrictionUserRepository.findById(id);

    }



    public void deleteRestrictionUser(Long user_id,Long restrictiontId) {

        restrictionUserRepository.delete(new ConstraintUser
                (new ConstraintUserPk(userRepository.findById(user_id).get(),
                        restrictionRepository.findById(restrictiontId).get())));
    }

}
