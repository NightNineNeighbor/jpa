package com.example.jpa.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Primary;

import javax.persistence.*;

@Entity
@Table(name = "MEMBER")
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Member {
    @Id
    @Column(name = "ID")
    @GeneratedValue
    private Long id;

    @Column(name = "NAME")
    private String userName;

//    public Member(){}
}
