package com.majorkeytech.mktprode.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.NaturalId;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity(name = "teams")
public class Team {
    @Id
    @GeneratedValue
    private Integer id;

    @NaturalId
    private Integer fdId;

    @Column
    private String name;

    @Column
    private String crest;
}
