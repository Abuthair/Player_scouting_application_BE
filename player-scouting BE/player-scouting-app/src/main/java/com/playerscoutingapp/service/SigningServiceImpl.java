package com.playerscoutingapp.service;

import com.playerscoutingapp.exception.SigningNotFoundException;
import com.playerscoutingapp.model.Player;
import com.playerscoutingapp.model.Signing;
import com.playerscoutingapp.repository.IPlayerRepository;
import com.playerscoutingapp.repository.ISigningRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

/**
 * @author Sheika Abuthair
 * @Date : 17-05-2022
 * @Project : assignmentProject
 */
@Service
public class SigningServiceImpl implements  ISigningService{
    /**
     * The @Autowired annotation can be used to autowire bean on the setter method
     */
    ISigningRepository iSigningRepository;
    @Autowired
    public void setiSigningRepository(ISigningRepository iSigningRepository) {
        this.iSigningRepository = iSigningRepository;
    }
    IPlayerRepository iPlayerRepository;
     @Autowired
    public void setiPlayerRepository(IPlayerRepository iPlayerRepository) {
        this.iPlayerRepository = iPlayerRepository;
    }

    /**
     * addSigning this method implementation will allow us to add Signing
     * @param signing
     */
    @Override
    public void addSigning(Signing signing,int playerId) {
       Player player = iPlayerRepository.getById(playerId);
       signing.setPlayer(player);
        iSigningRepository.save(signing);
    }
//    @Override
//    public void addSigning(Signing signing) {
//        iSigningRepository.save(signing);
//    }

    /**
     *updateSigning this method implementation will allow us to update signing
     * @param signing
     */
    @Override
    public void updateSigning(Signing signing) {
        iSigningRepository.save(signing);
    }

    /**
     * deleteSigning this method implementation will allow us to delete signing
     * @param signingId
     */
    @Override
    public void deleteSigning(int signingId) {
        iSigningRepository.deleteById(signingId);
    }

    /**
     * getById this method implementation will allow us to get Signing using Id
     * @param signingId
     * @return signing
     */
    @Override
    public Signing getById(int signingId) throws SigningNotFoundException {
        Signing signing= iSigningRepository.findById(signingId).get();
      if (signing==null){
          throw new SigningNotFoundException("signing not found ");
      }
        return signing;
    }

    /**
     * getAll this method implementation will allow us to get all signing
     * @return All signing
     */
    @Override
    public List<Signing> getAll() {
        return iSigningRepository.findAll();
    }

    /**
     * getByPrice this method implementation will allow us to get signing by price
     * @param price
     * @return signing
     * @throws SigningNotFoundException
     */
    @Override
    public List<Signing> getByPrice(double price) throws SigningNotFoundException {
      List<Signing> signing =iSigningRepository.findByPrice(price);
      if (signing==null){
          throw new SigningNotFoundException("signing not found");
      }
        return signing;
    }


    }

