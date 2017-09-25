package database.session;

<<<<<<< HEAD
import database.entities.CartsEntity;
import database.entities.FeedbackEntity;
import database.entities.RolesEntity;
import database.entities.UsersEntity;
import database.entities.articles.PokemonsArticlesEntity;
import database.session.StatefullSessionInterface;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.lang.String;
import java.util.Set;
=======
import database.session.StatefullSessionInterface;

import java.util.ArrayList;
import java.util.List;
import java.lang.String;
>>>>>>> af37c76d6a2809ae232d36ad076b52a4e958dfe4
import javax.ejb.Stateful;

@Stateful
public class StatefullSession implements StatefullSessionInterface {

<<<<<<< HEAD
    UsersEntity user;


    private LocalDate birthday;

    public StatefullSession(){
    }

    public int getId(){
        return user.getId();
    }

    //firstname
    public void setFirstname(String n) {
        user.setFirstname(n);
    }

    public String getFirstname() {
        return user.getFirstname();
    }

    //gender
    public void setGender(String n) {
        user.setGender(n);
    }

    public String getGender() {
        return user.getGender();
    }

    //email
    public void setMail(String n) {
        user.setEmail(n);
    }

    public String getMail() {
        return user.getEmail();
    }

    //password
    public void setPassword(String n) {
        user.setPassword(n);
    }

    public String getPassword() {
        return user.getPassword();
    }

    //lastname
    public void setLastname(String n) {
        user.setLastname(n);
    }

    public String getLastname() {
        return user.getLastname();
    }

    //handle
    public void setHandle(String n) {
        user.setHandle(n);
    }

    public String getHandle() {
        return user.getHandle();
    }

    //birthday
    public void setHandle(LocalDate n) {
        user.setBirthday(n);
    }

    public LocalDate getBirthday() {
        return user.getBirthday();
    }

    //roles
    public Set<RolesEntity> getRoles(){
        return user.getRoles();
    }

    public void setRoles(Set<RolesEntity> n) {
        user.setRoles(n);
    }

    //carts
    public Set<CartsEntity> getCarts(){
        return user.getCarts();
    }

    public void setCarts(Set<CartsEntity> n) {
        user.setCarts(n);
    }

    //pokemons
    public Set<PokemonsArticlesEntity> getPokemons(){
        return user.getPokemons();
    }

    public void setPokemons(Set<PokemonsArticlesEntity> n) {
        user.setPokemons(n);
    }

    //feedbacks
    public Set<FeedbackEntity> getFeedbacks(){
        return user.getFeedbacks();
    }

    public void setFeedbacks(Set<FeedbackEntity> n) {
        user.setFeedbacks(n);
    }

=======
    String user;

    public StatefullSession(){
        user = new String();
    }

    public void addUser(String u) {
        user=u;
    }

    public String getUser() {
        return user;
    }
>>>>>>> af37c76d6a2809ae232d36ad076b52a4e958dfe4
}