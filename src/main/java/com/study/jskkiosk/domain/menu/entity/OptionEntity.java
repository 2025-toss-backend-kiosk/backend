package com.study.jskkiosk.domain.menu.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Table(name = "option")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OptionEntity {

    @Id
    @Column(name = "option_id")
    private UUID optionId;

    @Column(name = "group_id", nullable = false)
    private UUID groupId;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "add_price", nullable = false)
    private int addPrice;
}

