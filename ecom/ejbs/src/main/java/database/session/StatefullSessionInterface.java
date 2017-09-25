package database.session;

import database.entities.CartsEntity;
import database.entities.FeedbackEntity;
import database.entities.RolesEntity;
import database.entities.articles.PokemonsArticlesEntity;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;
import javax.ejb.Remote;

@Remote
public interface StatefullSessionInterface {
    int getId();
    void setFirstname(String n);
    String getFirstname();
    void setGender(String n);
    String getGender();
    void setMail(String n);
    String getMail();
    void setPassword(String n);
    String getPassword();
    void setLastname(String n);
    String getLastname();
    void setHandle(String n);
    String getHandle();
    void setHandle(LocalDate n);
    LocalDate getBirthday();
    Set<RolesEntity> getRoles();
    void setRoles(Set<RolesEntity> n);
    Set<CartsEntity> getCarts();
    void setCarts(Set<CartsEntity> n);
    Set<PokemonsArticlesEntity> getPokemons();
    void setPokemons(Set<PokemonsArticlesEntity> n);
    Set<FeedbackEntity> getFeedbacks();
    void setFeedbacks(Set<FeedbackEntity> n);
}
