package com.cotinha.cotinha.models;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cota implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column
    private Long Id;

    @Column
    private String item;

    @Column
    private String users;

    @Column
    private String creator;

    @Column
    private String cotaName;

    @Column
    private String date;


}
