package com.example.demo.model;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
@Entity
@Table(name="Users",
    uniqueConstraints={@UniqueConstraint(columnNames="email")})
public class User {
     @Id
     @GeneratedValue(strategy=GenerationType.IDENTITY)
     private int id;
     @Column(nullable=false)
     private String name;
     @Column(nullable=false,unique=true)
     private String email;
     @Column(nullable=false)
     private String password;
     @Column(nullable=false)
     private String role="ANALYST";
     public int getId() {
         return id;
     }
     public void setId(int id) {
         this.id = id;
     }
     public String getName() {
         return name;
     }
     public void setName(String name) {
         this.name = name;
     }
     public String getEmail() {
         return email;
     }
     public void setEmail(String email) {
         this.email = email;
     }
     public String getPassword() {
         return password;
     }
     public void setPassword(String password) {
         this.password = password;
     }
     public User(int id, String name, String email, String password, String role) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.role = role;
    }
     public String getRole() {
         return role;
     }
     public void setRole(String role) {
         this.role = role;
     }
     public User() {
     }
}
