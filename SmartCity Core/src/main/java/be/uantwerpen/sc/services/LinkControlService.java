package be.uantwerpen.sc.services;

import be.uantwerpen.sc.models.BotEntity;
import be.uantwerpen.sc.models.LinkEntity;
import be.uantwerpen.sc.repositories.LinkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Niels on 30/03/2016.
 */
@Service
public class LinkControlService {

    @Autowired
    private LinkRepository linkRepository;

    public List<LinkEntity> getAllLinks(){return linkRepository.findAll();}

    public LinkEntity getLink(int id){
        return linkRepository.findOne(id);
    }
}