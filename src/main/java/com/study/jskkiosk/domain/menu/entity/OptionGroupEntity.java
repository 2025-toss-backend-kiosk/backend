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
@Table(name = "option_group")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OptionGroupEntity {

    @Id
    @Column(name = "group_id")
    private UUID groupId;

    @Column(name = "menu_item_id", nullable = false)
    private UUID menuItemId;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "min_sel", nullable = false)
    private int minSel;

    @Column(name = "max_sel", nullable = false)
    private int maxSel;
}