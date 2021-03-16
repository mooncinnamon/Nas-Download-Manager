package com.moon.pinnamon.downloadmanager.repository;

import com.moon.pinnamon.downloadmanager.model.Config;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConfigRepository extends R2dbcRepository<Config, Integer> {
    Config getConfigByType(String type);
}
