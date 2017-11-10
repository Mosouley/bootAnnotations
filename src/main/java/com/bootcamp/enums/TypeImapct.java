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
public enum TypeImapct {
    social,
    economique,
    climatique,
    environnemental,
    institutionnel;

    private String typeImpact;

    private TypeImapct() {
    }

    private TypeImapct(String typeImpact) {
        this.typeImpact = typeImpact;
    }

    /**
     * @return the typeImpact
     */
    public String getTypeImpact() {
        return typeImpact;
    }

    /**
     * @param typeImpact the typeImpact to set
     */
    public void setTypeImpact(String typeImpact) {
        this.typeImpact = typeImpact;
    }

}
