package com.vzs.mysampleproject.controller.cassandra;

import com.google.common.collect.Lists;
import com.vzs.mysampleproject.entity.cassandra.Greeting;
import com.vzs.mysampleproject.repository.cassandra.GreetingsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.cassandra.core.query.CassandraPageRequest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Slice;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/cassandra")
public class GreetingController {

    private final GreetingsRepository greetRepository;

    @GetMapping(value = "/greeting")
    public List<Greeting> greeting() {
        List<Greeting> greetings = Lists.newArrayList();
        greetRepository.findAll().forEach(e -> greetings.add(e));
        return greetings;
    }

    @GetMapping(value = "/greeting/{user}")
    public Slice<Greeting> greetingUserLimit(@PathVariable("user") String user,
                                             @RequestParam(defaultValue = "100") Integer limit) {
//        return greetRepository.findByUser(user, limit);
        return greetRepository.findByUser(user, CassandraPageRequest.of(0,limit));

    }

    @PostMapping(value = "/greeting")
    public String saveGreeting(@RequestBody Greeting greeting) {

        greeting.setCreationDate(new Date());
        greetRepository.save(greeting);

        return "OK";

    }

    @PutMapping(value = "/greeting")
    public Greeting changeById(@RequestParam String id, @RequestParam String user, @RequestParam String greet) {
        Greeting greeting  = greetRepository.findByIdAndUser(UUID.fromString(id), user);
        greeting.setGreet(greet);
        return greetRepository.save(greeting);
    }
}