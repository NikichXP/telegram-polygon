package com.polygon.repo;

import com.polygon.entity.SubscriberInfo;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SubscriberInfoRepo extends MongoRepository<SubscriberInfo, String>{
}
