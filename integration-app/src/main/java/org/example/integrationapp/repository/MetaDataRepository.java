package org.example.integrationapp.repository;

import org.example.integrationapp.entity.MetaData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MetaDataRepository extends JpaRepository<MetaData, Long> {

    MetaData findByProviderId(String providerId);
}
