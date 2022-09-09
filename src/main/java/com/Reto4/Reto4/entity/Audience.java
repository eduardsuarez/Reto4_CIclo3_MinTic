/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Reto4.Reto4.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author eduard suarez Reto3
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "audience")
public class Audience implements Serializable {

    /**
     * estos son loa atributos para la clase Audience
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String owner;
    private int capacity;
    private String description;

    /**
     * relación uno a muchos entre tablas
     */
    @ManyToOne
    @JoinColumn(name = "category_id")
    @JsonIgnoreProperties("audiences")
    private Category category;

    /**
     * relación muchos a uno entre tablas
     */
    @OneToMany(cascade = {CascadeType.PERSIST}, mappedBy = "audience")
    @JsonIgnoreProperties({"audience", "client"})
    private List<Message> messages;

    /**
     * relación uno a muchos entre tablas
     */
    @OneToMany(cascade = {CascadeType.PERSIST}, mappedBy = "audience")
    @JsonIgnoreProperties({"audience", "client"})
    private List<Reservation> reservations;

}
