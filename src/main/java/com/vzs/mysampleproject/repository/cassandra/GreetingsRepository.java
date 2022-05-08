package com.vzs.mysampleproject.repository.cassandra;

import com.vzs.mysampleproject.entity.cassandra.Greeting;
//import org.springframework.data.cassandra.repository.CassandraRepository;
//import org.springframework.data.cassandra.repository.Query;
//import org.springframework.data.domain.Pageable;
//import org.springframework.data.domain.Slice;

import java.util.UUID;

public interface GreetingsRepository
//        extends CassandraRepository<Greeting, UUID>
{
 
//    Slice<Greeting> findByUser(String user, Pageable pageable) ;
//
//    @Query("SELECT*FROM greetings WHERE user=?0 AND id<?1 LIMIT ?2")
//    Iterable<Greeting> findByUserFrom(String user, UUID from, Integer limit);
//
//    Greeting findByIdAndUser(UUID id, String user);
}
