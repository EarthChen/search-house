package com.earthchen.spring.boot.searchhouse.service.search.impl;

import com.earthchen.spring.boot.searchhouse.service.search.ISearchService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author: EarthChen
 * @date: 2018/03/17
 */
@Service
@Slf4j
public class SearchServiceImpl implements ISearchService {


    @Override
    public void index(Long houseId) {
        this.index(houseId, 0);
    }

    private void index(Long houseId, int retry) {
//        if (retry > HouseIndexMessage.MAX_RETRY) {
//            log.error("Retry index times over 3 for house: " + houseId + " Please check it!");
//            return;
//        }
//
//        HouseIndexMessage message = new HouseIndexMessage(houseId, HouseIndexMessage.INDEX, retry);
//        try {
//            kafkaTemplate.send(INDEX_TOPIC, objectMapper.writeValueAsString(message));
//        } catch (JsonProcessingException e) {
//            log.error("Json encode error for " + message);
//        }
//
//    }
    }
}