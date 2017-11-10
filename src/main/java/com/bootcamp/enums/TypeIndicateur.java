/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bootcamp.enums;

/**
 *
 * @author root
 */
public enum TypeIndicateur {
    QUALITATIF("Indicateur de Performance Qualititatif"),
    QUANTITATIF("Indicateur de Performance Quantitatif");
    
    private String typeIndicateur;

    private TypeIndicateur() {
    }

    TypeIndicateur(String typeIndicateur) {
        this.typeIndicateur = typeIndicateur;
    }
    
    public String TypeIndicateur() {
        return typeIndicateur;
    }

    @Override
    public String toString() {
        return "TypeIndicateur{" + "typeIndicateur=" + typeIndicateur + '}';
    }
    
    
    
}
