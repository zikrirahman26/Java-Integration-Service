package org.example.integrationapp.service;

import org.example.integrationapp.entity.Channel;
import org.example.integrationapp.entity.MetaData;
import org.example.integrationapp.model.ChannelRequest;
import org.example.integrationapp.repository.ChannelRepository;
import org.example.integrationapp.repository.MetaDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class ValidationService {

    private final ChannelRepository channelRepository;
    private final MetaDataRepository metaDataRepository;

    @Autowired
    public ValidationService(ChannelRepository channelRepository, MetaDataRepository metaDataRepository) {
        this.channelRepository = channelRepository;
        this.metaDataRepository = metaDataRepository;
    }

    public void validateRequest(ChannelRequest channelRequest) {
        try {
            Channel channelId = channelRepository.findByClientId(channelRequest.getClientId());
            if (channelId == null) {
                throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "clientId not found");
            }

            MetaData providerId = metaDataRepository.findByProviderId(channelRequest.getContentRequest().getProviderId());
            if (providerId == null) {
                throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "providerId not found");
            }
        } catch (Exception e){
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
        }
    }
}

