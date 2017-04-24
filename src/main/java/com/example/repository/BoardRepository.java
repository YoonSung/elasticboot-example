package com.example.repository;

import com.example.model.FreeBoard;
import org.springframework.data.elasticsearch.repository.ElasticsearchCrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by jins on 2017-04-25.
 */
@Repository
public interface BoardRepository extends ElasticsearchCrudRepository<FreeBoard, Long>{
}
