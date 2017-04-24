package com.example.repository;

import com.example.model.Member;
import org.springframework.data.elasticsearch.repository.ElasticsearchCrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by jins on 2017-04-25.
 */
@Repository
public interface MemberRepository extends ElasticsearchCrudRepository<Member, Long>{
    List<Member> findByusername(String username);
}
