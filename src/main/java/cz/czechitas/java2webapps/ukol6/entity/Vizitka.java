package cz.czechitas.java2webapps.ukol6.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import org.hibernate.validator.constraints.Length;

@Entity
public class Vizitka {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @Length(max = 100)
  @NotBlank
  private String celeJmeno;

  @Length(max = 100)
  @NotBlank
  private String firma;

  @Length(max = 100)
  @NotBlank
  private String ulice;

  @Length(max = 100)
  @NotBlank
  private String obec;

  @Length(min = 5, max = 5)
  @NotBlank
  private String psc;

  @Length(max = 100)
  @Email
  private String email;

  @Length(min = 9, max = 13)
  @Pattern(regexp = "\\+?\\d+")
  private String telefon;

  @Length(max = 100)
  private String web;

  //class constructor
  public Vizitka() {}

  public Vizitka(Integer id, String celeJmeno, String firma, String ulice, String obec, String psc, String email, String telefon, String web) {
    this.id = id;
    this.celeJmeno = celeJmeno;
    this.firma = firma;
    this.ulice = ulice;
    this.obec = obec;
    this.psc = psc;
    this.email = email;
    this.telefon = telefon;
    this.web = web;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getCeleJmeno() {
    return celeJmeno;
  }

  public String getFirma() {
    return firma;
  }

  public String getUlice() {
    return ulice;
  }

  public String getObec() {
    return obec;
  }

  public String getEmail() {
    return email;
  }

  public String getTelefon() {
    return telefon;
  }

  public String getWeb() {
    return web;
  }

  public String getPsc() {
    return psc;
  }

  public String getCelaAdresa() {
    return ulice + ", " + psc + " " +  obec;
  }

}
