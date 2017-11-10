/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bootcamp.enums;

/**
 *
 * @author Iso-Doss
 */
public enum EtatProjet {
    pre_etude,
    financement,
    recrutement_fournisseurs,
    execution,
    abandonne,
    suspendu,
    acheve;

    private String etatProjet;

    private EtatProjet() {
    }

    private EtatProjet(String etatProjet) {
        this.etatProjet = etatProjet;
    }

    /**
     * @return the etatProjet
     */
    public String getEtatProjet() {
        return etatProjet;
    }

    /**
     * @param etatProjet the etatProjet to set
     */
    public void setEtatProjet(String etatProjet) {
        this.etatProjet = etatProjet;
    }

}
