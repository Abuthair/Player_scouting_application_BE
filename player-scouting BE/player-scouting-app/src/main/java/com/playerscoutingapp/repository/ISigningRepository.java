package com.playerscoutingapp.repository;

import com.playerscoutingapp.model.Signing;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

/**
 * @author Sheika Abuthair
 * @Date : 17-05-2022
 * @Project : assignmentProject
 */

@Repository
public interface ISigningRepository extends JpaRepository<Signing,Integer> {
    /**
     * getByPrice this method helps us to get signing using price
     * @param price
     */
    List<Signing> findByPrice(double price);


}
