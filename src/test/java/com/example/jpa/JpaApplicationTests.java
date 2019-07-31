package com.example.jpa;

import com.example.jpa.dao.MemberRepository;
import com.example.jpa.model.Member;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
public class JpaApplicationTests {

    @Autowired
    private MemberRepository memberRepository;


    @Test
    public void test1() {
       memberRepository.save(
               Member.builder()
                       .userName("userName")
                       .build()
       );
    }
}
