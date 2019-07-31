package com.example.jpa.controller;

import com.example.jpa.dao.MemberRepository;
import com.example.jpa.dao.TeamRepository;
import com.example.jpa.model.Member;
import com.example.jpa.model.Team;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class Controller {
    @Autowired
    MemberRepository memberRepository;

    @Autowired
    TeamRepository teamRepository;

    @GetMapping("/ping")
    public String pong(){
        return "pong";
    }

    @GetMapping("/test")
    public String saveTest(){
        memberRepository.save(new Member(0L,"userName"));
        System.out.println("DEBUG MESSAGE");
        return "done";
    }

    @GetMapping("/test1")
    public String saveTeam(){
        Member member1 = Member.builder().userName("member1").build();
        Member member2 = Member.builder().userName("member2").build();

        Team team1 = new Team(0L, "team1", new ArrayList<>());
        team1.getMembers().add(member1);
        team1.getMembers().add(member2);

        memberRepository.save(member1);
        memberRepository.save(member2);

        teamRepository.save(team1);



        return "done";


    }

    @GetMapping("/members/{id}")
    public Member getMember(@PathVariable Long id){
        return memberRepository.findById(id).get();

    }
}
