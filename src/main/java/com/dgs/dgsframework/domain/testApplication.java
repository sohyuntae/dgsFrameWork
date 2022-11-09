package com.dgs.dgsframework.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Getter
@Setter
@Table(name = "testApplication")
public class testApplication {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="appKey")
    private Integer appKey;
    @Column(name="appName")
    private String appName;
}
