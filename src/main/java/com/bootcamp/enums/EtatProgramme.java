/**
 * une enumeration des differents etats possibles d'un programme, avec les possibilites
 * Etat Pre etude
 * Etat de financement
 * Execution
 * Acheve
 */
package com.bootcamp.enums;

/**
 *
 * @author soul
 */
public enum EtatProgramme {
PREETUDE("Etat de pre Etude"),
FINANCEMENT("Etape de financement"),
EXECUTION("Etat d'execution"),
ACHEVE("Projet acheve");

 private String etatProgramme;

    EtatProgramme(String etatProgramme) {
        this.etatProgramme = etatProgramme;
    }

    public String EtatProgramme() {
        return etatProgramme;
    }


}
