package org.example.integrationapp.repository;

import org.example.integrationapp.entity.Channel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChannelRepository extends JpaRepository<Channel, Long> {

    Channel findByClientId(String clientId);
}
