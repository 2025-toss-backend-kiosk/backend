package com.study.jskkiosk.domain.menu_ljy.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class MenuCategoryEntity {
    @Id
    UUID categoryId;
    String name;
}
